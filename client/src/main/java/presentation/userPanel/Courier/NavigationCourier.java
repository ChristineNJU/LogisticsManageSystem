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
	
	private CourierNewOrderList courierNewOrder = new CourierNewOrderList();
	private CourierLogisticsInfoSearch courierInquiry = new CourierLogisticsInfoSearch();
//	private ArrayList<ButtonNav> buttonList = new ArrayList<ButtonNav>();

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
		MainFrame.getMainPanel().repaint();
		courierNewOrder = new CourierNewOrderList();
		MainFrame.changeContentPanel(courierNewOrder.getPanel());
	}
	
	private void changeToReceive(){
		courierReceive = new CourierReceive();
		MainFrame.changeContentPanel(courierReceive.getPanel());
	}
	
	private void changeToInquiry(){
		courierInquiry = new CourierLogisticsInfoSearch();
		MainFrame.getMainPanel().remove(courierNewOrder.getPanel());
		MainFrame.getMainPanel().add(courierInquiry.getPanel());
		MainFrame.getMainPanel().repaint();
		courierLogisticsInfoSearch = new CourierLogisticsInfoSearch();
		MainFrame.changeContentPanel(courierLogisticsInfoSearch.getPanel());
	}
	
}
