package presentation.components;

import javax.swing.JLabel;

import presentation.listener.RollListener;

public abstract class ButtonTotal extends JLabel {
	private RollListener listener;
	
	public ButtonTotal(){
		listener = new RollListener(this);
		this.addMouseListener(listener);
	}
	abstract public void rolled();
	abstract public void unRolled();
	abstract public void click();
}
