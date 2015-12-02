package presentation.userPanel.Courier;

import VO.UserVO;
import presentation.components.ButtonNav;
import presentation.frame.MainFrame;
import presentation.main.Navigation;

public class NavigationCourier extends Navigation{

	
//	UserVO user = new UserVO("141250174","尹子越",UserRole.courier);
//	private PanelNavigation navPanel = new PanelNavigation(user);
	
	private ButtonNav home = new ButtonNav("home","home");
	private ButtonNav newLogistics = new ButtonNav("courier","newLogistics");
	private ButtonNav receive = new ButtonNav("courier","receive");
	private ButtonNav inquiry = new ButtonNav("courier","inquiry");

	private CourierNewOrderList courierNewOrder;
	private CourierReceive courierReceive;
	private CourierLogisticsInfoSearch courierLogisticsInfoSearch;


	
	public NavigationCourier(UserVO user) {
		super(user);
		initNavButtonArray();
		addNavButtons();
	
	}
	
	protected void initNavButtonArray(){
		home.setPressed();
		buttonList.add(home);
		buttonList.add(newLogistics);
		buttonList.add(receive);
		buttonList.add(inquiry);
	}

	protected void changeTask(int index){
		if(index == 1){
			changeToNewLogistics();
		}else if(index == 2){
			changeToReceive();
		}else if(index == 3){
			changeToInquiry();
		}else{
			changeToHome();
		}
	}
	
	private void changeToHome(){
		
	}
	
	private void changeToNewLogistics(){
		courierNewOrder = new CourierNewOrderList();
		MainFrame.getMainPanel().add(courierNewOrder.getPanel());
		MainFrame.getMainPanel().repaint();
		MainFrame.getMainFrame().repaint();
	}
	
	private void changeToReceive(){
		courierReceive = new CourierReceive();
//		MainFrame.getMainPanel().add(courierReceive.getPanel());
		MainFrame.getMainPanel().repaint();
	}
	
	private void changeToInquiry(){
		courierLogisticsInfoSearch = new CourierLogisticsInfoSearch();
//		MainFrame.getMainPanel().add(courierLogisticsInfoSearch.getPanel());
		MainFrame.getMainPanel().repaint();
	}
	
//	public PanelNavigation getNavPanel(){
//		return navPanel;
//	}
}
