package presentation.userPanel.Medium;

import presentation.components.ButtonNav;
import presentation.frame.MainFrame;
import presentation.main.Navigation;
import State.ErrorState;
import VO.UserVO;

public class NavigationMediumCenter extends Navigation{

	private ButtonNav home = new ButtonNav("home","home");
	private ButtonNav arrival = new ButtonNav("mediumCenter","arrival");
	private ButtonNav entrucking = new ButtonNav("mediumCenter","entrucking");
	private ButtonNav transfer = new ButtonNav("mediumCenter","transfer");
	
	private MediumCtArrival mediumCtArrival;
	private MediumCtEntrucking mediumCtEntrucking;
	private MediumCtTransfer mediumCtTransfer;
	
	public NavigationMediumCenter(UserVO user) {
		super(user);
		initNavButtonArray();
		addNavButtons();
	}

	protected void initNavButtonArray(){
		home.setPressed();
		buttonList.add(home);
		buttonList.add(arrival);
		buttonList.add(entrucking);
		buttonList.add(transfer);
	}
	
	protected void changeTask(int index){
		if(index == 1){
			changeToArrival();
		}else if(index == 2){
			changeToEntrucking();
		}else if(index == 3){
			changeToTransfer();
		}else{
			changeToHome();
		}
	}
	
	private void changeToHome(){
		
	}
	private void changeToArrival(){
		mediumCtArrival = new MediumCtArrival(this);
		MainFrame.changeContentPanel(mediumCtArrival.getPanel());
		if(mediumCtArrival.isConnectError()){
			System.out.println("manager initiate null");
			mediumCtArrival.showError(ErrorState.CONNECTERROR);
		}
	}
	private void changeToEntrucking(){
		mediumCtEntrucking = new MediumCtEntrucking(this);
		MainFrame.changeContentPanel(mediumCtEntrucking.getPanel());
		if(mediumCtEntrucking.isConnectError()){
			System.out.println("manager initiate null");
			mediumCtEntrucking.showError(ErrorState.CONNECTERROR);
		}
	}
	private void changeToTransfer(){
		mediumCtTransfer = new MediumCtTransfer(this);
		MainFrame.changeContentPanel(mediumCtTransfer.getPanel());
		if(mediumCtTransfer.isConnectError()){
			System.out.println("manager initiate null");
			mediumCtTransfer.showError(ErrorState.CONNECTERROR);
		}
	}
}
