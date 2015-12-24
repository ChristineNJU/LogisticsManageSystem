package presentation.main;

import presentation.components.DialogCheckCancel;
import presentation.components.DialogCheckConfirm;
import presentation.components.LabelError;
import presentation.components.PanelContent;

public class Function {


	protected PanelContent panel;
	protected LabelError labelError = new LabelError("");
	
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
	
	public void showError(String s){
		labelError = new LabelError(s);
		panel.add(labelError);
	}
	
	public void removeError(String s){
		panel.remove(labelError);
	}
}
