package presentation.userPanel.Medium;

import presentation.components.ButtonNav;
import presentation.main.Navigation;
import VO.UserVO;

public class NavigationMediumCenter extends Navigation{

	private ButtonNav home = new ButtonNav("home","home");
	private ButtonNav arrival = new ButtonNav("mediumCenter","arrival");
	private ButtonNav entrucking = new ButtonNav("mediumCenter","entrucking");
	private ButtonNav transfer = new ButtonNav("mediumCenter","transfer");
	
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
		
	}
	private void changeToEntrucking(){
		
	}
	private void changeToTransfer(){
		
	}
}
