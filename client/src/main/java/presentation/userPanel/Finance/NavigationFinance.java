package presentation.userPanel.Finance;

import presentation.components.ButtonNav;
import presentation.frame.MainFrame;
import presentation.main.Navigation;
import State.ErrorState;
import VO.UserVO;

public class NavigationFinance extends Navigation{

	private ButtonNav home = new ButtonNav("home","home");
	private ButtonNav account = new ButtonNav("finance","account");
	private ButtonNav income = new ButtonNav("finance","income");
	private ButtonNav outcome = new ButtonNav("finance","outcome");
	private ButtonNav incomeAndOutcome = new ButtonNav("finance","incomeAndOutcome");
	private ButtonNav benefit = new ButtonNav("finance","benefit");
	private ButtonNav initial = new ButtonNav("finance","initial");
	private ButtonNav system = new ButtonNav("finance","system");
	
	private FinanceAccount financeAccount;
	private FinanceBenefit financeBenefit;
	private FinanceCost financeCost;
	private FinanceIncome financeIncome;
	private FinanceIncomeAndOutcome financeIncomeAndOutcome;
	private FinanceInitial financeInitial;
	private FinanceSystem financeSystem;
	
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
		buttonList.add(incomeAndOutcome);
		buttonList.add(initial);
		buttonList.add(system);
		System.out.println(buttonList.size()+"buttonList .size()");
	}
	
	protected void changeTask(int index){
		if(index == 1){
			changeToAccount();
		}else if(index == 2){
			changeToIncome();
		}else if(index == 3){
			changeToOutcome();
		}else if(index == 4){
			changeToOutcomeAndIncome();
		}else if(index == 5){
			changeToBenefit();
		}else if(index == 6){
			changeToInitial();
		}else if(index == 7){
			changeToSystem();
		}else{
			changeToHome();
		}
	}
	
	private void changeToHome(){
		
	}
	private void changeToAccount(){
		financeAccount = new FinanceAccount();
		MainFrame.changeContentPanel(financeAccount.getPanel());
		if(financeAccount.isConnectError()){
			System.out.println("manager initiate null");
			financeAccount.showError(ErrorState.CONNECTERROR);
		}
	}
	private void changeToIncome(){
		financeIncome = new FinanceIncome();
		MainFrame.changeContentPanel(financeIncome.getPanel());
		if(financeIncome.isConnectError()){
			System.out.println("manager initiate null");
			financeIncome.showError(ErrorState.CONNECTERROR);
		}
	}
	private void changeToOutcome(){
		financeCost = new FinanceCost();
		MainFrame.changeContentPanel(financeCost.getPanel());
		if(financeCost.isConnectError()){
			System.out.println("manager initiate null");
			financeCost.showError(ErrorState.CONNECTERROR);
		}
	}
	private void changeToOutcomeAndIncome(){
		financeIncomeAndOutcome = new FinanceIncomeAndOutcome();
		MainFrame.changeContentPanel(financeIncomeAndOutcome.getPanel());
		if(financeIncomeAndOutcome.isConnectError()){
			System.out.println("manager initiate null");
			financeIncomeAndOutcome.showError(ErrorState.CONNECTERROR);
		}
	}
	private void changeToBenefit(){
		financeBenefit = new FinanceBenefit();
		MainFrame.changeContentPanel(financeBenefit.getPanel());
		if(financeBenefit.isConnectError()){
			System.out.println("manager initiate null");
			financeBenefit.showError(ErrorState.CONNECTERROR);
		}
	}
	private void changeToInitial(){
		financeInitial = new FinanceInitial();
		MainFrame.changeContentPanel(financeInitial.getPanel());
		if(financeSystem.isConnectError()){
			System.out.println("manager initiate null");
			financeSystem.showError(ErrorState.CONNECTERROR);
		}
	}
	private void changeToSystem(){
		financeSystem = new FinanceSystem();
		MainFrame.changeContentPanel(financeSystem.getPanel());
		if(financeSystem.isConnectError()){
			System.out.println("manager initiate null");
			financeSystem.showError(ErrorState.CONNECTERROR);
		}
	}
}
