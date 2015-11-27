package presentation.frame;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import presentation.AnimationEasing.AnimationEasing;
import State.UserRole;
import VO.UserVO;
import presentation.main.Navigation;
import presentation.userPanel.Admin.NavigationAdmin;
import presentation.userPanel.BusinessLb.NavigationBusinessLobby;
import presentation.userPanel.Courier.NavigationCourier;
import presentation.userPanel.Finance.NavigationFinance;
import presentation.userPanel.Manager.NavigationManager;
import presentation.userPanel.Medium.NavigationMediumCenter;
import presentation.userPanel.Repository.NavigationRepository;
import presentation.userPanel.start.Inquiry;


public class MainFrame {
	public static final int FRAME_WIDTH = 1200;
	public static final int FRAME_HEIGHT = 600;
	
	public static final int FRAME_X = (Toolkit.getDefaultToolkit().getScreenSize().width - FRAME_WIDTH) / 2;
	public static final int FRAME_Y = (Toolkit.getDefaultToolkit().getScreenSize().height - FRAME_HEIGHT) / 2 - 32;

	private static JFrame frame = new JFrame();
	private static JPanel panel = new JPanel();
	
	private Inquiry inquiry;
	
	private UserVO user;
	private Navigation nav;
//	private CourierNavigation nav;
	
	public MainFrame(){
		frame.setTitle("Logistics Management System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		frame.setLayout(null);
		frame.setUndecorated(true);
		frame.setLocation(FRAME_X,FRAME_Y);
		

		frame.setContentPane(panel);
		panel.setLayout(null);
		
//		inquiry = new Inquiry(this);
//		frame.add(inquiry.getPanel());
//		changeToCourier();
//		changeToBusinesslobby();
//		changeToFinance();
//		changeToManager();
//		changeToMediumCenter();
//		changeToRepository();
		changeToAdmin();
	}
	
	public JFrame getFrame(){
		return frame;
	}
	

	public void changeToUserPane(UserVO user){
		this.user = user;
		UserRole role = user.getRole();
		frame.remove(frame.getContentPane());
		if(role == UserRole.courier)
			changeToCourier();
		if(role == UserRole.businessAgent)
			changeToBusinesslobby();
		if(role == UserRole.finance)
			changeToFinance();
		if(role == UserRole.manager)
			changeToManager();
		if(role == UserRole.mediumAgent)
			changeToMediumCenter();
		if(role == UserRole.repository)
			changeToRepository();
		if(role == UserRole.admin)
			changeToAdmin();
	}
	
	private void changeToCourier(){
		nav = new NavigationCourier(user);
		panel.add(nav.getNavPanel());
		
		
	}
	
	private void changeToBusinesslobby(){
		nav = new NavigationBusinessLobby(user);
		panel.add(nav.getNavPanel());
	}
	
	private void changeToFinance(){
		nav = new NavigationFinance(user);
		panel.add(nav.getNavPanel());
	}
	
	private void changeToManager(){
		nav = new NavigationManager(user);
		panel.add(nav.getNavPanel());
	}
	
	private void changeToMediumCenter(){
		nav = new NavigationMediumCenter(user);
		panel.add(nav.getNavPanel());
	}
	
	private void changeToRepository(){
		nav = new NavigationRepository(user);
		panel.add(nav.getNavPanel());
	}

	private void changeToAdmin(){
		nav = new NavigationAdmin(user);
		panel.add(nav.getNavPanel());
	}
	
	public static JFrame getMainFrame(){
		return frame;
	}
	public static JPanel getMainPanel(){
		return panel;
	}
	public void frameClose() {
				
		double width = FRAME_WIDTH;
		double height = FRAME_HEIGHT;
		
		int x = Toolkit.getDefaultToolkit().getScreenSize().width;
		int y = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		double tmp = 0;
		
		while(height>5){
//			height = 600.0/62500.0*Math.pow((tmp-250), 2);
			height = height - AnimationEasing.easeInElastic(0, tmp, 3, 5, 2);
			frame.setBounds((int)((x-width)/2), (int)((y-height)/2)-32, (int)width, (int)height);
//			frame.getContentPane().setBounds((int)((x-width)/2), (int)((y-height)/2)-32, (int)width, (int)height);
//			frame.repaint();
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			tmp = tmp + 0.2;
		}
		
		try {
			Thread.sleep(70);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
