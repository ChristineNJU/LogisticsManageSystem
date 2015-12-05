package presentation.userPanel.Manager;

import presentation.components.ButtonNav;
import presentation.frame.MainFrame;
import presentation.main.Navigation;
import VO.UserVO;

public class NavigationManager extends Navigation{

	private ButtonNav home = new ButtonNav("home","home");
	private ButtonNav judge = new ButtonNav("manager","judge");
	private ButtonNav staff = new ButtonNav("manager","staff");
	private ButtonNav institution = new ButtonNav("manager","institution");
	private ButtonNav salary = new ButtonNav("manager","salary");
	private ButtonNav account = new ButtonNav("manager","account");
	private ButtonNav incomeAndOutcome = new ButtonNav("manager","incomeAndOutcome");
	private ButtonNav benefit = new ButtonNav("manager","benefit");
	private ButtonNav consts = new ButtonNav("manager","consts");
	private ButtonNav system = new ButtonNav("manager","system");
	
	private ManagerConst con = new ManagerConst();
	private ManagerStaffMgt staffM=new ManagerStaffMgt();
	public NavigationManager(UserVO user) {
		super(user);
		initNavButtonArray();
		addNavButtons();
	}

	protected void initNavButtonArray(){
		home.setPressed();
		buttonList.add(home);
		buttonList.add(judge);
		buttonList.add(staff);
		buttonList.add(institution);
		buttonList.add(salary);
		buttonList.add(account);
		buttonList.add(incomeAndOutcome);
		buttonList.add(benefit);
		buttonList.add(consts);
		buttonList.add(system);
	}

	protected void changeTask(int index){
		if(index == 1){
			changeToJudge();
		}else if(index == 2){
			changeToStaff();
		}else if(index == 3){
			changeToInstitution();
		}else if(index == 4){
			changeToSalary();
		}else if(index == 5){
			changeToAccount();
		}else if(index == 6){
			changeToIncomeAndOutcome();
		}else if(index == 7){
			changeToBenefit();
		}else if(index == 8){
			changeToConsts();
		}else if(index == 9){
			changeToSystem();
		}else{
			changeToHome();
		}
	}
	private void changeToHome(){
		
	}
	private void changeToJudge(){
		
	}
	private void changeToStaff(){
		staffM = new ManagerStaffMgt();
		MainFrame.changeContentPanel(staffM.getPanel());
		MainFrame.getMainPanel().repaint();
	}
	private void changeToInstitution(){
		
	}
	private void changeToSalary(){
		
	}
	private void changeToAccount(){
		
	}
	private void changeToIncomeAndOutcome(){
		
	}
	private void changeToBenefit(){
		
	}
	private void changeToConsts(){
		con = new ManagerConst();
		MainFrame.changeContentPanel(con.getPanel());
		MainFrame.getMainPanel().repaint();
	}
	private void changeToSystem(){
		
	}
}
