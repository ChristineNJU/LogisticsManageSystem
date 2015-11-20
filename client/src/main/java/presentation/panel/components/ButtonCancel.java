package presentation.panel.components;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import presentation.main.ColorPallet;
import presentation.main.FontSet;

public class ButtonCancel extends JButton {

	private Listener listener;
	
	public ButtonCancel(){
		setFocusPainted(false);
		setText("取 消");
		setForeground(Color.white);
		setBackground(ColorPallet.GrayLight);
		setHorizontalAlignment(CENTER);
		setBorderPainted(false);

		setFont(FontSet.fontOk);
		setSize(135,40);
		
		listener = new Listener();
		this.addMouseListener(listener);
	}
	
	private void rolled(){
		setBackground(ColorPallet.GrayMedium);
	}
	
	private void unRolled(){
		setBackground(ColorPallet.GrayLight);
	}
	
	public class Listener implements MouseListener{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	
		@Override
		public void mousePressed(MouseEvent e) {
			
		}
	
		@Override
		public void mouseReleased(MouseEvent e) {
			
		}
	
		@Override
		public void mouseEntered(MouseEvent e) {
			rolled();
		}
	
		@Override
		public void mouseExited(MouseEvent e) {
			unRolled();
		}
	}
}
