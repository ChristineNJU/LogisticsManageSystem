package presentation.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import presentation.components.ButtonTotal;

public class RollListener implements MouseListener {

	ButtonTotal source;
	public RollListener(ButtonTotal button){
		source = button;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(source.isEnabled()){
			source.click();
		}

	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(source.isEnabled()){			
			source.rolled();
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if(source.isEnabled()){			
			source.unRolled();
		}
	}

}
