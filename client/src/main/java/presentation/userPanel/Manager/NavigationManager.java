package presentation.userPanel.Manager;

import State.ErrorState;
import VO.UserVO;
import presentation.components.ButtonNav;
import presentation.frame.MainFrame;
import presentation.main.Home;
import presentation.main.Navigation;

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
	
	
	public Home homepage;
	public ManagerConst con;
	public ManagerStaffMgt staffM;
	public ManagerInstitutionMgt institutionM;
	public ManagerAccount acc;
	public ManagerBenefit ben;
	public ManagerIncomeAndOutcome inAndOut;
	public ManagerReceipt rec;
	public ManagerSalary sal;
	public ManagerSystem sys;
	
	public NavigationManager(UserVO user) {
		super(user);
		initNavButtonArray();
		addNavButtons();
		changeToHome();
	}

	protected void initNavButtonArray(){
		home.setPressed();
		buttonList.add(home);
		buttonList.add(judge);
		buttonList.add(staff);
		buttonList.add(institution);
		buttonList.add(salary);
		buttonList.add(account);
		buttonList.add(benefit);
		buttonList.add(incomeAndOutcome);
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
		homepage = new Home(user);
		MainFrame.changeContentPanel(homepage);
	}
	
	private void changeToJudge(){
		rec = new ManagerReceipt(this);
		MainFrame.changeContentPanel(rec.getPanel());
		MainFrame.getMainPanel().repaint();
	}
	
	private void changeToStaff(){

		staffM = new ManagerStaffMgt(this);
		MainFrame.changeContentPanel(staffM.getPanel());
		MainFrame.getMainPanel().repaint();
		if(staffM.isConnectError()){
			System.out.println("manager initiate null");
			staffM.showError(ErrorState.CONNECTERROR);
//			try {
//				Thread.sleep(3000);
//				staffM.removeError();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
		}
	}
	
	private void changeToInstitution(){
		institutionM=new ManagerInstitutionMgt(this);
		MainFrame.changeContentPanel(institutionM.getPanel());
		MainFrame.getMainPanel().repaint();

		if(institutionM.isConnectError()){
			institutionM.showError(ErrorState.CONNECTERROR);
		}
		
		

	}
	
	private void changeToManager(){
		staffM = new ManagerStaffMgt(this);
		MainFrame.changeContentPanel(staffM.getPanel());
		MainFrame.getMainPanel().repaint();

	}
	private void changeToSalary(){
		sal = new ManagerSalary();
		MainFrame.changeContentPanel(sal.getPanel());
		MainFrame.getMainPanel().repaint();
	}
	
	private void changeToAccount(){
		acc = new ManagerAccount();
		MainFrame.changeContentPanel(acc.getPanel());
		MainFrame.getMainPanel().repaint();
	}
	
	private void changeToIncomeAndOutcome(){
		inAndOut = new ManagerIncomeAndOutcome();
		MainFrame.changeContentPanel(inAndOut.getPanel());
		MainFrame.getMainPanel().repaint();
	}
	
	private void changeToBenefit(){
		ben = new ManagerBenefit();
		MainFrame.changeContentPanel(ben.getPanel());
		MainFrame.getMainPanel().repaint();
	}
	
	private void changeToConsts(){
		con = new ManagerConst(this);
		MainFrame.changeContentPanel(con.getPanel());
		MainFrame.getMainPanel().repaint();
	}
	
	private void changeToSystem(){
		sys = new ManagerSystem();
		MainFrame.changeContentPanel(sys.getPanel());
		MainFrame.getMainPanel().repaint();
	}
}
