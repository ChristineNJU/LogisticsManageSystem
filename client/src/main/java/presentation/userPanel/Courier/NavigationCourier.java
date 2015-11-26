package presentation.userPanel.Courier;

import java.util.ArrayList;

import State.UserRole;
import VO.UserVO;
import presentation.main.Navigation;
import presentation.panel.components.ButtonNav;
import presentation.panel.components.PanelNavigation;

public class NavigationCourier extends Navigation{

	
//	UserVO user = new UserVO("141250174","尹子越",UserRole.courier);
//	private PanelNavigation navPanel = new PanelNavigation(user);
	
	private ButtonNav home = new ButtonNav("home","home");
	private ButtonNav newLogistics = new ButtonNav("courier","newLogistics");
	private ButtonNav receive = new ButtonNav("courier","receive");
	private ButtonNav inquiry = new ButtonNav("courier","inquiry");
	
//	private ArrayList<ButtonNav> buttonList = new ArrayList<ButtonNav>();
	
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
		
	}
	
	private void changeToReceive(){
		
	}
	
	private void changeToInquiry(){
		
	}
	
//	public PanelNavigation getNavPanel(){
//		return navPanel;
//	}
}
