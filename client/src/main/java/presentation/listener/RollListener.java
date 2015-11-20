package presentation.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import presentation.panel.components.ButtonTotal;

public class RollListener implements MouseListener {

	ButtonTotal source;
	public RollListener(ButtonTotal button){
		source = button;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		source.click();
		System.out.println("in listener");

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		source.rolled();

	}

	@Override
	public void mouseExited(MouseEvent e) {
		source.unRolled();

	}

}
