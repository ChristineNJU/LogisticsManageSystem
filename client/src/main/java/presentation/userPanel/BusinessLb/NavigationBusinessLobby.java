package presentation.userPanel.BusinessLb;

import presentation.components.ButtonNav;
import presentation.frame.MainFrame;
import presentation.main.Home;
import presentation.main.Navigation;
import State.ErrorState;
import VO.UserVO;

public class NavigationBusinessLobby extends Navigation{

	private ButtonNav home = new ButtonNav("home","home");
	private ButtonNav arrival = new ButtonNav("businesslobby","arrival");
	private ButtonNav entrucking = new ButtonNav("businesslobby","entrucking");
	private ButtonNav delivery = new ButtonNav("businesslobby","delivery");
	private ButtonNav driverMgt = new ButtonNav("businesslobby","driverMgt");
	private ButtonNav carMgt = new ButtonNav("businesslobby","carMgt");
	private ButtonNav gathering = new ButtonNav("businesslobby","gathering");
	
	public Home homepage;
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
//		changeTask(5);
		changeToHome();
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
		homepage = new Home(user);
		MainFrame.changeContentPanel(homepage);
		MainFrame.getMainPanel().repaint();
	}
	private void changeToArrival(){
		businessArrival = new BusinessLbArrival(this);
		MainFrame.changeContentPanel(businessArrival.getPanel());
		if(businessArrival.isConnectError()){
			System.out.println("manager initiate null");
			businessArrival.showError(ErrorState.CONNECTERROR);
		}
	}
	private void changeToEntrucking(){
		businessLbEntrucking = new BusinessLbEntrucking(this);
		MainFrame.changeContentPanel(businessLbEntrucking.getPanel());
		if(businessLbEntrucking.isConnectError()){
			System.out.println("manager initiate null");
			businessLbEntrucking.showError(ErrorState.CONNECTERROR);
		}
	}
	private void changeToDelivery(){
		businessLbDelivery = new BusinessLbDelivery(this);
		MainFrame.changeContentPanel(businessLbDelivery.getPanel());
		if(businessLbDelivery.isConnectError()){
			System.out.println("manager initiate null");
			businessLbDelivery.showError(ErrorState.CONNECTERROR);
		}
	}
	private void changeToDriverMgt(){
		 businessLbDriverMgt = new BusinessLbDriverMgt();
		 MainFrame.changeContentPanel(businessLbDriverMgt.getPanel());
		 if(businessLbDriverMgt.isConnectError()){
				System.out.println("manager initiate null");
				businessLbDriverMgt.showError(ErrorState.CONNECTERROR);
			}
	}
	private void changeToCarMgt(){
		businessLbCarMgt = new BusinessLbCarMgt();
//		System.out.println("in method nav");
		MainFrame.changeContentPanel(businessLbCarMgt.getPanel());
		 if(businessLbCarMgt.isConnectError()){
				System.out.println("manager initiate null");
				businessLbCarMgt.showError(ErrorState.CONNECTERROR);
			}
	}
	private void changeToGathering(){
		businessLbGathering = new BusinessLbGathering(this);
		MainFrame.changeContentPanel(businessLbGathering.getPanel());
		 if(businessLbGathering.isConnectError()){
				System.out.println("manager initiate null");
				businessLbGathering.showError(ErrorState.CONNECTERROR);
			}
//		MainFrame.getMainPanel().add(businessLbGathering.getPanel());
//		MainFrame.getMainPanel().repaint();
	}
}
