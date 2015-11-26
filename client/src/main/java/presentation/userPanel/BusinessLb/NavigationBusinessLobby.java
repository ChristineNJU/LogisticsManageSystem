package presentation.userPanel.BusinessLb;

import VO.UserVO;
import presentation.main.Navigation;
import presentation.panel.components.ButtonNav;

public class NavigationBusinessLobby extends Navigation{

	private ButtonNav home = new ButtonNav("home","home");
	private ButtonNav arrival = new ButtonNav("businesslobby","arrival");
	private ButtonNav entrucking = new ButtonNav("businesslobby","entrucking");
	private ButtonNav delivery = new ButtonNav("businesslobby","delivery");
	private ButtonNav driverMgt = new ButtonNav("businesslobby","driverMgt");
	private ButtonNav carMgt = new ButtonNav("businesslobby","carMgt");
	
	public NavigationBusinessLobby(UserVO user) {
		super(user);
		initNavButtonArray();
		addNavButtons();
	}

	protected void initNavButtonArray(){
		home.setPressed();
		buttonList.add(home);
		buttonList.add(arrival);
		buttonList.add(entrucking);
		buttonList.add(delivery);
		buttonList.add(driverMgt);
		buttonList.add(carMgt);
	}
	
	protected void changeTask(int index){
		if(index == 1){
			changeToArrival();
		}else if(index == 2){
			changeToEntrucking();
		}else if(index == 3){
			changeToDelivery();
		}else if(index == 4){
			changeToDriverMgt();
		}else if(index == 5){
			changeToCarMgt();
		}else{
			changeToHome();
		}
	}

	private void changeToHome(){
		
	}
	private void changeToArrival(){
		
	}
	private void changeToEntrucking(){
		
	}
	private void changeToDelivery(){
		
	}
	private void changeToDriverMgt(){
		
	}
	private void changeToCarMgt(){
		
	}
}
