package presentation.userPanel.start;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.AnimationEasing.AnimationEasing;
import presentation.components.ButtonCancel;
import presentation.components.ButtonOk;
import presentation.components.TextField;
import presentation.frame.MainFrame;
import presentation.main.ColorPallet;
import presentation.main.FontSet;
import State.LoginState;
import VO.UserVO;
import businesslogic.Impl.Admin.AdminController;
import businesslogic.Impl.User.UserController;
import businesslogic.Service.Admin.AdminService;
import businesslogic.Service.User.LoginService;

public class LogIn{
	
	public static final int login_width = 320;
	public static final int login_height = 200;

	private Inquiry parent = null;
	
//	private JDialog logIn= new JDialog();
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
	
	private LoginService loginService = new UserController();
	private AdminService adminService = new AdminController();
	
	MainFrame frame;
	public LogIn(MainFrame frame){
		initComponents();
		this.frame = frame;
	}
	
	public LogIn(Inquiry parent) {
		this.parent = parent;
		initComponents();
	}
	
	private void initComponents(){
//		logIn.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//		logIn.setUndecorated(true); 
//		AWTUtilities.setWindowOpaque(logIn, false); 
//		logIn.setBackground(Color.blue);
//		logIn.setSize(320,200);
//		logIn.setLocation(MainFrame.FRAME_X+750,MainFrame.FRAME_Y);
//		logIn.setAlwaysOnTop(true); 
//		logIn.setLayout(null);
//		logIn.setModal(true);
		
		container.setLayout(null);
		container.setBackground(Color.white);
//		container.setLocation(MainFrame.FRAME_X+750,MainFrame.FRAME_Y);
		container.setBounds(750, 0, login_width, login_height);
//		logIn.getContentPane().add(container);
//		logIn.setContentPane(container);
//		System.out.println("logInDalogInit");
		
		idLabel.setFont(FontSet.fourteen);
		idLabel.setForeground(ColorPallet.GrayLight);
		idLabel.setHorizontalAlignment(JLabel.LEFT);
		idLabel.setBounds(35,35,80,30);
		passwordLabel.setFont(FontSet.fourteen);
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
		line.setBounds(0,login_height-6,login_width,6);
		
		feedback.setForeground(ColorPallet.Pink);
		feedback.setFont(FontSet.fourteen);
		feedback.setHorizontalAlignment(JLabel.LEFT);
		feedback.setBounds(110, 10, 180, 20);
		
		success.setForeground(Color.green);
		success.setFont(FontSet.fourteen);
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
	
//	public JDialog getDialog(){
//		return logIn;
//	}
	
	public JPanel getPanel() {
		return container;
	}
	
	public JLabel getLine() {
		return line;
	}
	
	public void logIn(){
		String userId = id.getText();
		String userPassword = password.getText();
		LoginState state = loginService.login(userId,userPassword);
		
		if(state.equals(LoginState.SUCCESS)){
			container.add(success);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ArrayList<String> keyword = new ArrayList<String>();
			keyword.add(userId);
			ArrayList<UserVO> user = adminService.searchUser(keyword);
			frame.changeToUserPane(user.get(0));
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
//				logIn.dispose();
				Thread t = new Thread(new MovingFunction());
				t.start();
				
//				container.setVisible(false);
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				parent.getLogin().setVisible(true);
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
	
	class MovingFunction implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			double time = 4;
			while(time>=0){
				int i = (int)AnimationEasing.easeInElastic(0, time, 0, login_height, 10);
//				System.out.println(i);
				getPanel().setSize(login_width, i);
				getLine().setBounds(0, login_height-6, login_width, i-(login_height-6));
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(); 
				}
				time = time - 0.1;
//				parent.getPanel().repaint();
//				System.out.println("in method");
			}
			
			container.setVisible(false);
			parent.getLogin().setVisible(true);
			parent.getPanel().repaint();
		}
	}
}
