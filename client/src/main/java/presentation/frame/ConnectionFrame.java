package presentation.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import data.RMIHelper.RMIConnectionService;
import data.RMIHelper.RMIHelper;
import presentation.AnimationEasing.AnimationPanel;
import presentation.components.ButtonCancel;
import presentation.main.ColorPallet;
import presentation.main.FontSet;

public class ConnectionFrame extends JFrame implements Runnable {
	
	private boolean isConnected = true;
	
	private AnimationPanel waitingPanel = new AnimationPanel();
	
	private JLabel info = new JLabel("与服务器断开连接,请等待重连");
	
	private JLabel count_label = new JLabel();
	private static final String count_info = "重试次数：";
	private int count = 1;
	
	private ButtonCancel cancel = new ButtonCancel();
	
	private RMIConnectionService service;
	
	public ConnectionFrame() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int w = (int)d.getWidth();
		int h = (int)d.getHeight();
		
		int width = 400;
		int height = 100;
		
		setBounds((w-width)/2, (h-height)/2, width, height);
		setUndecorated(true);
		getContentPane().setBackground(ColorPallet.GrayDark);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setLayout(null);
		
		info.setBounds(110, 13, 270, 40);
		info.setFont(FontSet.twenty);
		info.setForeground(Color.white);
		getContentPane().add(info);
		
		count_label.setBounds(110, 50, 240, 40);
		count_label.setFont(FontSet.eighteen);
		count_label.setForeground(Color.white);
		count_label.setText(count_info+count);
		getContentPane().add(count_label);
		
		cancel.setBounds(270, 55, 100, 30);
		cancel.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				MainFrame.frameClose();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		getContentPane().add(cancel);
		
		waitingPanel.setBounds(0, 0, 100, 100);
		Thread t = new Thread(waitingPanel);
		t.start();
		add(waitingPanel);
		
		setVisible(false);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				service = (RMIConnectionService) Naming.lookup(RMIHelper.RMI_CONNECTION_IMPL);
				count = 1;
				setVisible(false);
			} catch (MalformedURLException | RemoteException
					| NotBoundException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				setVisible(true);
				count_label.setText(count_info+count);
				count++;
			}
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
