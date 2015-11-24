package presentation.frame;

import java.awt.Toolkit;

import javax.swing.JFrame;

import presentation.userPanel.start.Inquiry;


public class MainFrame {
	public static final int FRAME_WIDTH = 1200;
	public static final int FRAME_HEIGHT = 600;
	
	public static final int FRAME_X = (Toolkit.getDefaultToolkit().getScreenSize().width - FRAME_WIDTH) / 2;
	public static final int FRAME_Y = (Toolkit.getDefaultToolkit().getScreenSize().height - FRAME_HEIGHT) / 2 - 32;

	private JFrame frame = new JFrame();
	private Inquiry inquiry;
	public MainFrame(){
		frame.setTitle("Logistics Management System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		frame.setLayout(null);
		frame.setUndecorated(true);
		frame.setLocation(FRAME_X,FRAME_Y);
		
		inquiry = new Inquiry(this);
		frame.setContentPane(inquiry.getPanel());
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
	public void frameClose() {
				
		double width = FRAME_WIDTH;
		double height = FRAME_HEIGHT;
		
		int x = Toolkit.getDefaultToolkit().getScreenSize().width;
		int y = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		double tmp = 0;
		
		while(height>5){
			height = 600.0/62500.0*Math.pow((tmp-250), 2);
			frame.setBounds((int)((x-width)/2), (int)((y-height)/2)-32, (int)width, (int)height);
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			tmp = tmp + 1;
		}
		
		
		while(width>5){
			width = width - 10;
			frame.setBounds((int)((x-width)/2), (int)((y-height)/2)-32, (int)width, (int)height);
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.exit(0);
	}
}
