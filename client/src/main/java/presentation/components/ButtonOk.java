package presentation.components;

import java.awt.Color;

import javax.swing.BorderFactory;

import presentation.listener.RollListener;
import presentation.main.ColorPallet;
import presentation.main.FontSet;

public class ButtonOk extends ButtonTotal {

	private RollListener listener;
	
	public ButtonOk(String s){
		super();
		setText(s);
		setForeground(ColorPallet.Pink);
		setHorizontalAlignment(CENTER);
		setBorder(BorderFactory.createLineBorder(ColorPallet.Pink));

		setFont(FontSet.twenty);
		setSize(s.length()*25+30,40);
		
		listener = new RollListener(this);
		this.addMouseListener(listener);
	}
	
	public void rolled(){
		setOpaque(true);
		setForeground(Color.white);
		setBackground(ColorPallet.Pink);
	}
	
	public void unRolled(){
		setForeground(ColorPallet.Pink);
//		setBackground(Color.black);
		setOpaque(false);
		this.repaint();
	}
	
	public void click(){
		setOpaque(true);
		setForeground(Color.white);
		setBackground(ColorPallet.Pink);
	}
}
