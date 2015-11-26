package presentation.userPanel.Admin;

import VO.UserVO;
import presentation.frame.MainFrame;
import presentation.main.Navigation;
import presentation.panel.components.ButtonNav;

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
		userAccountP = new AdminUserAccount(this);
		MainFrame.getMainPanel().add(userAccountP.getPanel());
		MainFrame.getMainPanel().repaint();
	}
}
