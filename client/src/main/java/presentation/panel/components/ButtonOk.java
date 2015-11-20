package presentation.panel.components;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;

import presentation.listener.RollListener;
import presentation.main.ColorPallet;
import presentation.main.FontSet;

public class ButtonOk extends ButtonTotal {

	private RollListener listener;
	
	public ButtonOk(String s){
		setText(s);
		setForeground(ColorPallet.Pink);
		setHorizontalAlignment(CENTER);
		setBorder(BorderFactory.createLineBorder(ColorPallet.Pink));

		setFont(FontSet.fontOk);
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
		setOpaque(false);

	}
	
	public void click(){
		setOpaque(true);
		setForeground(Color.white);
		setBackground(ColorPallet.Pink);
		System.out.println("button Ok ");
	}
}
