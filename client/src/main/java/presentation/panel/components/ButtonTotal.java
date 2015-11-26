package presentation.panel.components;

import javax.swing.JLabel;

import presentation.listener.RollListener;

public class ButtonTotal extends JLabel {
	private RollListener listener;
	
	public ButtonTotal(){
		listener = new RollListener(this);
		this.addMouseListener(listener);
	}
	public void rolled(){
		
	}
	public void setUnRolled(){
		
	}
	public void click(){
		
	}
}
