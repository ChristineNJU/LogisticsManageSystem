package presentation.userPanel.Repository;

import presentation.components.ButtonNav;
import presentation.frame.MainFrame;
import presentation.main.Navigation;
import VO.UserVO;

public class NavigationRepository extends Navigation{

	private ButtonNav home = new ButtonNav("home","home");
	private ButtonNav storage = new ButtonNav("repository","storage");
	private ButtonNav removal = new ButtonNav("repository","removal");
	private ButtonNav balance = new ButtonNav("repository","balance");
	private ButtonNav stockTaking = new ButtonNav("repository","stockTaking");
	private ButtonNav see = new ButtonNav("repository","see");
	
	private RepositoryStorage rs = new RepositoryStorage();
	private RepositoryBalance rb = new RepositoryBalance();
	private RepositoryRemovall rr = new  RepositoryRemovall();
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
		rs = new RepositoryStorage();
//		MainFrame.getMainPanel().remove(comp);
		MainFrame.changeContentPanel(rs.getPanel());
	}
	private void changeToRemoval(){
		rr = new RepositoryRemovall();
		MainFrame.changeContentPanel(rr.getPanel());
	}
	private void changeToBalance(){
		rb = new RepositoryBalance();
		MainFrame.changeContentPanel(rb.getPanel());
	}
	private void changeToStockTaking(){
		
	}
	private void changeToSee(){
		
	}
}
