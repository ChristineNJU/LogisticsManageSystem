package presentation.userPanel.BusinessLb;

import VO.UserVO;
import presentation.components.ButtonNav;
import presentation.frame.MainFrame;
import presentation.main.Navigation;

public class NavigationBusinessLobby extends Navigation{

	private ButtonNav home = new ButtonNav("home","home");
	private ButtonNav arrival = new ButtonNav("businesslobby","arrival");
	private ButtonNav entrucking = new ButtonNav("businesslobby","entrucking");
	private ButtonNav delivery = new ButtonNav("businesslobby","delivery");
	private ButtonNav driverMgt = new ButtonNav("businesslobby","driverMgt");
	private ButtonNav carMgt = new ButtonNav("businesslobby","carMgt");
	private ButtonNav gathering = new ButtonNav("businesslobby","gathering");
	
	
	private BusinessLbArrival businessArrival;
	private BusinessLbCarMgt businessLbCarMgt;
	private BusinessLbDelivery businessLbDelivery;
	private BusinessLbDriverMgt businessLbDriverMgt;
	private BusinessLbEntrucking businessLbEntrucking;
	private BusinessLbGathering businessLbGathering;
	
	public NavigationBusinessLobby(UserVO user) {
		super(user);
		initNavButtonArray();
		addNavButtons();
		//Test
		changeTask(6);
	}

	protected void initNavButtonArray(){
		home.setPressed();
		buttonList.add(home);
		buttonList.add(arrival);
		buttonList.add(entrucking);
		buttonList.add(delivery);
		buttonList.add(driverMgt);
		buttonList.add(carMgt);
		buttonList.add(gathering);
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
		}else if(index == 6){
			changeToGathering();
		}else{
			changeToHome();
		}
	}

	private void changeToHome(){
		
	}
	private void changeToArrival(){
		businessArrival = new BusinessLbArrival();
		MainFrame.changeContentPanel(businessArrival.getPanel());
	}
	private void changeToEntrucking(){
		businessLbEntrucking = new BusinessLbEntrucking();
		MainFrame.changeContentPanel(businessLbEntrucking.getPanel());
	}
	private void changeToDelivery(){
		businessLbDelivery = new BusinessLbDelivery();
		MainFrame.changeContentPanel(businessLbDelivery.getPanel());
	}
	private void changeToDriverMgt(){
		 businessLbDriverMgt = new BusinessLbDriverMgt();
		 MainFrame.changeContentPanel(businessLbDriverMgt.getPanel());
	}
	private void changeToCarMgt(){
		businessLbCarMgt = new BusinessLbCarMgt();
		MainFrame.changeContentPanel(businessLbCarMgt.getPanel());
	}
	private void changeToGathering(){
		businessLbGathering = new BusinessLbGathering();
		MainFrame.changeContentPanel(businessLbGathering.getPanel());
//		MainFrame.getMainPanel().add(businessLbGathering.getPanel());
//		MainFrame.getMainPanel().repaint();
	}
}
