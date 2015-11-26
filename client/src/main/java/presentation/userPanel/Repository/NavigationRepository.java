package presentation.userPanel.Repository;

import VO.UserVO;
import presentation.main.Navigation;
import presentation.panel.components.ButtonNav;

public class NavigationRepository extends Navigation{

	private ButtonNav home = new ButtonNav("home","home");
	private ButtonNav storage = new ButtonNav("repository","storage");
	private ButtonNav removal = new ButtonNav("repository","removal");
	private ButtonNav balance = new ButtonNav("repository","balance");
	private ButtonNav stockTaking = new ButtonNav("repository","stockTaking");
	private ButtonNav see = new ButtonNav("repository","see");
	
	
	public NavigationRepository(UserVO user) {
		super(user);
		initNavButtonArray();
		addNavButtons();
	}

	protected void initNavButtonArray(){
		home.setPressed();
		buttonList.add(home);
		buttonList.add(storage);
		buttonList.add(removal);
		buttonList.add(balance);
		buttonList.add(stockTaking);
		buttonList.add(see);
	}
	
	protected void changeTask(int index){
		if(index == 1){
			changeToStorage();
		}else if(index == 2){
			changeToRemoval();
		}else if(index == 3){
			changeToBalance();
		}else if(index == 4){
			changeToStockTaking();
		}else if(index == 5){
			changeToSee();
		}else{
			changeToHome();
		}
	}
	private void changeToHome(){
		
	}
	private void changeToStorage(){
		
	}
	private void changeToRemoval(){
		
	}
	private void changeToBalance(){
		
	}
	private void changeToStockTaking(){
		
	}
	private void changeToSee(){
		
	}
}
