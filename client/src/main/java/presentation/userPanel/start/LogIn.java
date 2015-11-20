package presentation.userPanel.start;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import State.LoginState;
import businesslogic.Impl.User.LoginImpl;
import presentation.frame.MainFrame;
import presentation.main.ColorPallet;
import presentation.main.FontSet;
import presentation.panel.components.ButtonCancel;
import presentation.panel.components.ButtonOk;
import presentation.panel.components.TextField;

public class LogIn{

	private JDialog logIn= new JDialog();
	private JLabel idLabel = new JLabel("用户名：");
	private JLabel passwordLabel = new JLabel("密   码：");
	private TextField id = new TextField();
	private TextField password = new TextField();
	private ButtonOk confirm = new ButtonOk("登录");
	private ButtonCancel cancel = new ButtonCancel();
	private Listener listener = new Listener();
	private InputListener focusListener = new InputListener();
	private JPanel container = new JPanel();
	private JLabel line = new JLabel();
	
	private JLabel feedback= new JLabel();
	private JLabel success = new JLabel("登录成功，请等待跳转");
	
	private LoginImpl loginService = new LoginImpl();
	
	public LogIn(){
		initComponents();
	}
	
	private void initComponents(){
		logIn.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		logIn.setUndecorated(true); 
//		AWTUtilities.setWindowOpaque(logIn, false); 
//		logIn.setBackground(Color.blue);
		logIn.setSize(320,200);
		logIn.setLocation(MainFrame.FRAME_X+750,MainFrame.FRAME_Y);
		logIn.setAlwaysOnTop(true); 
		logIn.setLayout(null);
		logIn.setModal(true);
		
		container.setLayout(null);
		container.setBackground(Color.white);
		logIn.setContentPane(container);
//		System.out.println("logInDalogInit");
		
		idLabel.setFont(FontSet.fontTipsBig);
		idLabel.setForeground(ColorPallet.GrayLight);
		idLabel.setHorizontalAlignment(JLabel.LEFT);
		idLabel.setBounds(35,35,80,30);
		passwordLabel.setFont(FontSet.fontTipsBig);
		passwordLabel.setForeground(ColorPallet.GrayLight);
		passwordLabel.setHorizontalAlignment(JLabel.LEFT);
		passwordLabel.setBounds(35,80,80,30);
		
		id.setBounds(110,35,180,30);
		password.setBounds(110, 80, 180, 30);
		cancel.setBounds(35,135,100,40);
		confirm.setBounds(190,135,100,40);
		
		id.addFocusListener(focusListener);
		password.addFocusListener(focusListener);
		
		cancel.addMouseListener(listener);
		confirm.addMouseListener(listener);
		
		line.setBackground(ColorPallet.Purple);
		line.setOpaque(true);
		line.setBounds(0,194,320,6);
		
		feedback.setForeground(ColorPallet.Pink);
		feedback.setFont(FontSet.fontTipsBig);
		feedback.setHorizontalAlignment(JLabel.LEFT);
		feedback.setBounds(110, 10, 180, 20);
		
		success.setForeground(Color.green);
		success.setFont(FontSet.fontTipsBig);
		success.setHorizontalAlignment(JLabel.LEFT);
		success.setBounds(110, 10, 180, 20);
		
		container.add(idLabel);
		container.add(passwordLabel);
		container.add(id);
		container.add(password);
		container.add(cancel);
		container.add(confirm);
		container.add(line);
	}
	
	public JDialog getDialog(){
		return logIn;
	}
	
	public void logIn(){
		LoginState state = loginService.login(id.getText(), password.getText());
		if(state.equals(LoginState.SUCCESS)){
			container.add(success);
		}
		if(state.equals(LoginState.WRONGID)){
			id.setError();
			feedback.setText("用户名不存在");
			container.add(feedback);
		}
		if(state.equals(LoginState.WRONGPW)){
			password.setError();
			feedback.setText("密码错误");
			container.add(feedback);
		}
		if(state.equals(LoginState.CONNECTERROR)){
			feedback.setText("链接错误，请稍后再试");
			container.add(feedback);
		}

		container.repaint();
	}
	
	public void wrongId(){
		id.setError();
		feedback.setText("用户名不存在");
		container.add(feedback);
		container.repaint();
	}
	
	public void wrongPW(){
		password.setError();
		feedback.setText("密码错误");
		container.add(feedback);
		container.repaint();
	}
	
	public class Listener implements MouseListener{


		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource().equals(confirm)){
				logIn();
//				wrongId();
//				wrongPW();
			}
			if(e.getSource().equals(cancel)){
				logIn.dispose();
			}
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
		
	}
	
	public class InputListener implements FocusListener{

		@Override
		public void focusGained(FocusEvent e) {
			container.remove(success);
			container.remove(feedback);
			container.repaint();
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
