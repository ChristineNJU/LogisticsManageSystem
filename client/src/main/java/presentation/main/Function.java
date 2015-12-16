package presentation.main;

import presentation.components.DialogCheckCancel;
import presentation.components.DialogCheckConfirm;

public class Function {

	protected void checkCancel(){
		System.out.println("in function father");
		DialogCheckCancel checkCancel = new DialogCheckCancel(this);
	}
	
	public void performCancel(){
		System.out.println("in function perform cancel");
	}
	
	protected void checkConfirm(){
		DialogCheckConfirm checkConfirm = new DialogCheckConfirm(this);
	}
	
	public void performConfirm(){
		
	}
}
