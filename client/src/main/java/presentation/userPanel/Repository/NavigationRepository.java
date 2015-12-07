package presentation.userPanel.Repository;

import VO.UserVO;
import presentation.components.ButtonNav;
import presentation.frame.MainFrame;
import presentation.main.Navigation;

public class NavigationRepository extends Navigation{

	private ButtonNav home = new ButtonNav("home","home");
	private ButtonNav storage = new ButtonNav("repository","storage");
	private ButtonNav removal = new ButtonNav("repository","removal");
	private ButtonNav balance = new ButtonNav("repository","balance");
	private ButtonNav stockTaking = new ButtonNav("repository","stockTaking");
	private ButtonNav see = new ButtonNav("repository","see");
	
	public RepositoryStorage repositoryStorage;
	public RepositoryBalance repositoryBalance;
	public RepositoryRemoval repositoryRemoval;
	public RepositoryCheck repositoryCheck;
	public RepositoryStockTaking repositoryStockTaking;
	
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
		repositoryStorage = new RepositoryStorage(this);
//		MainFrame.getMainPanel().remove(comp);
		MainFrame.changeContentPanel(repositoryStorage.getPanel());
	}
	private void changeToRemoval(){
		repositoryRemoval = new RepositoryRemoval(this);
		MainFrame.changeContentPanel(repositoryRemoval.getPanel());
	}
	private void changeToBalance(){
		repositoryBalance = new RepositoryBalance(this);
		MainFrame.changeContentPanel(repositoryBalance.getPanel());
	}
	private void changeToStockTaking(){
		repositoryStockTaking = new RepositoryStockTaking();
		MainFrame.changeContentPanel(repositoryStockTaking.getPanel());
	}
	private void changeToSee(){
		repositoryCheck = new RepositoryCheck();
		MainFrame.changeContentPanel(repositoryCheck.getPanel());
	}
}
