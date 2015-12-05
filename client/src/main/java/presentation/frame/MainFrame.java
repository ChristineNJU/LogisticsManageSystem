package presentation.frame;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import State.UserRole;
import VO.UserVO;
import presentation.AnimationEasing.AnimationEasing;
import presentation.components.PanelContent;
import presentation.main.Navigation;
import presentation.userPanel.Admin.NavigationAdmin;
import presentation.userPanel.BusinessLb.NavigationBusinessLobby;
import presentation.userPanel.Courier.NavigationCourier;
import presentation.userPanel.Finance.NavigationFinance;
import presentation.userPanel.Manager.NavigationManager;
import presentation.userPanel.Medium.NavigationMediumCenter;
import presentation.userPanel.Repository.NavigationRepository;
import presentation.userPanel.start.Inquiry;

/**
 * client展示模块的窗口容器
 * 
 * @author 张馨中
 * @version 1.0.0
 * */
public class MainFrame {
	public static final int FRAME_WIDTH = 1200;
	public static final int FRAME_HEIGHT = 600;
	
	public static final int FRAME_X = (Toolkit.getDefaultToolkit().getScreenSize().width - FRAME_WIDTH) / 2;
	public static final int FRAME_Y = (Toolkit.getDefaultToolkit().getScreenSize().height - FRAME_HEIGHT) / 2 - 32;

	// ----- member variables ---------------------------------------
	private static JFrame frame = new JFrame();
	private static JPanel panel = new JPanel();
	private static JPanel contentPanel = new PanelContent("");
	
	private Inquiry inquiry;
	
	private UserVO user = new UserVO("141250181", "张晨剑", UserRole.businessAgent);
	private Navigation nav;
//	private CourierNavigation nav;

	
	/**
	 * 创建MainFrame,初始化窗口设置,添加初始Panel
	 * */
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
//		panel.add(inquiry.getPanel());

//		changeToCourier();
//		changeToBusinesslobby();
//		changeToFinance();
//		changeToCourier();
		changeToFinance();
//		changeToManager();
//		changeToMediumCenter();
//		changeToRepository();
//		changeToAdmin();
	}
	
	/**
	 * 获取client主窗口
	 * 
	 * @return frame
	 * */
	public JFrame getFrame(){
		return frame;
	}
	
	/**
	 * 窗口跳转
	 * 
	 * @param user 人员类型,据此跳转不同人员的Panel
	 * */
	public void changeToUserPane(UserVO user){
		this.user = user;
		UserRole role = user.getRole();
		System.out.println(user.getRole());
//		frame.remove(frame.getContentPane());
		panel.remove(inquiry.getPanel());
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
	
	/**
	 * 切换工作区域的panel
	 * */
	public static void changeContentPanel(JPanel p){
		panel.remove(contentPanel);
		contentPanel = p;
		panel.add(p);
		panel.repaint();
	}
	
	/**
	 * 跳转至快递员Panel
	 * */
	private void changeToCourier(){
		nav = new NavigationCourier(user);
		panel.add(nav.getNavPanel());	
	}
	
	/**
	 * 跳转至营业厅业务员Panel
	 * */
	private void changeToBusinesslobby(){
		nav = new NavigationBusinessLobby(user);
		panel.add(nav.getNavPanel());
	}
	
	/**
	 * 跳转至财务人员Panel
	 * */
	private void changeToFinance(){
		nav = new NavigationFinance(user);
		panel.add(nav.getNavPanel());
	}
	
	/**
	 * 跳转至总经理Panel
	 * */
	private void changeToManager(){
		nav = new NavigationManager(user);
		panel.add(nav.getNavPanel());
	}
	
	/**
	 * 跳转至中转中心业务员Panel
	 * */
	private void changeToMediumCenter(){
		nav = new NavigationMediumCenter(user);
		panel.add(nav.getNavPanel());
	}
	
	/**
	 * 跳转至仓库管理人员Panel
	 * */
	private void changeToRepository(){
		nav = new NavigationRepository(user);
		panel.add(nav.getNavPanel());
	}

	/**
	 * 跳转至管理员Panel
	 * */
	private void changeToAdmin(){
		nav = new NavigationAdmin(user);
		panel.add(nav.getNavPanel());
	}
	
	//
	public static JFrame getMainFrame(){
		return frame;
	}
	public static JPanel getMainPanel(){
		return panel;
	}
	
	/**
	 * 关闭窗口动画效果
	 * */
	public static void frameClose() {
				
		double width = FRAME_WIDTH;
		double height = FRAME_HEIGHT;
		
		int x = Toolkit.getDefaultToolkit().getScreenSize().width;
		int y = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		double tmp = 0;
		int total = 200;
		
		while(tmp<=total){
			height = AnimationEasing.easeOutCubic(0, tmp, FRAME_HEIGHT, -FRAME_HEIGHT+5, total);
			frame.setBounds((int)((x-width)/2), (int)((y-height)/2)-32, (int)width, (int)height);
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tmp++;
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
