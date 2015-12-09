package presentation.userPanel.Admin;

import presentation.components.ButtonNav;
import presentation.frame.MainFrame;
import presentation.main.Navigation;
import State.ErrorState;
import VO.UserVO;

public class NavigationAdmin extends Navigation{
	
	private ButtonNav home = new ButtonNav("home","home");
	private ButtonNav userAccount = new ButtonNav("admin","userAccount");
	
	private AdminUserAccount userAccountP;
	
	public NavigationAdmin(UserVO user) {
		super(user);
		initNavButtonArray();
		addNavButtons();
		changeToUserAccount();
	}
	
	protected void initNavButtonArray(){
		home.setPressed();
		buttonList.add(home);
		buttonList.add(userAccount);
	}
	
	protected void changeTask(int index){
		if(index == 1){
			changeToUserAccount();
		}else{
			changeToHome();
		}
	}
	
	protected void changeToHome(){
		
	}
	protected void changeToUserAccount(){
		userAccountP = new AdminUserAccount();
		MainFrame.getMainPanel().add(userAccountP.getPanel());
		MainFrame.getMainPanel().repaint();
		if(userAccountP.isConnectError()){
			userAccountP.showError(ErrorState.CONNECTERROR);
		}
	}
}
