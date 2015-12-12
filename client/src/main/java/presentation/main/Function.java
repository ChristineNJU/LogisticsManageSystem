package presentation.main;

import presentation.components.DialogConfirmAgain;

public class Function {

	protected void checkCancel(){
		System.out.println("in function father");
		DialogConfirmAgain checkCancel = new DialogConfirmAgain(this);
	}
	
	public void performCancel(){
		System.out.println("in function perform cancel");
	}
}
