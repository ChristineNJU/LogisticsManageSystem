package presentation.userPanel.Finance;

import VO.UserVO;
import presentation.main.Navigation;
import presentation.panel.components.ButtonNav;

public class NavigationFinance extends Navigation{

	private ButtonNav home = new ButtonNav("home","home");
	private ButtonNav account = new ButtonNav("finance","account");
	private ButtonNav income = new ButtonNav("finance","income");
	private ButtonNav outcome = new ButtonNav("finance","outcome");
	private ButtonNav benefit = new ButtonNav("finance","benefit");
	private ButtonNav initial = new ButtonNav("finance","initial");
	private ButtonNav system = new ButtonNav("fiance","system");
	
	public NavigationFinance(UserVO user) {
		super(user);
		initNavButtonArray();
		addNavButtons();
	}

	protected void initNavButtonArray(){
		home.setPressed();
		buttonList.add(home);
		buttonList.add(account);
		buttonList.add(income);
		buttonList.add(outcome);
		buttonList.add(benefit);
		buttonList.add(initial);
		buttonList.add(system);
	}
	
	protected void changeTask(int index){
		if(index == 1){
			changeToAccount();
		}else if(index == 2){
			changeToIncome();
		}else if(index == 3){
			changeToOutcome();
		}else if(index == 4){
			changeToBenefit();
		}else if(index == 5){
			changeToInitial();
		}else if(index == 6){
			changeToSystem();
		}else{
			changeToHome();
		}
	}
	
	private void changeToHome(){
		
	}
	private void changeToAccount(){
		
	}
	private void changeToIncome(){
		
	}
	private void changeToOutcome(){
		
	}
	private void changeToBenefit(){
		
	}
	private void changeToInitial(){
		
	}
	private void changeToSystem(){
		
	}
}
