package presentation.panel.components;

import java.awt.Color;

import javax.swing.BorderFactory;

import presentation.listener.RollListener;
import presentation.main.ColorPallet;
import presentation.main.FontSet;

public class ButtonNew extends ButtonTotal{

private RollListener listener;
	
	public ButtonNew(String s){
		super();
		setText(s);
		setForeground(ColorPallet.Purple);
		setHorizontalAlignment(CENTER);
		setBorder(BorderFactory.createLineBorder(ColorPallet.Purple));

		setFont(FontSet.twenty);
		setSize(s.length()*25+30,40);
		
		listener = new RollListener(this);
		this.addMouseListener(listener);
	}
	
	public void rolled(){
		setOpaque(true);
		setForeground(Color.white);
		setBackground(ColorPallet.Purple);
	}
	
	public void setUnRolled(){
		setForeground(ColorPallet.Purple);
		setOpaque(false);
		this.repaint();
	}
	
	public void click(){
		setOpaque(true);
		setForeground(Color.white);
		setBackground(ColorPallet.Purple);
	}
}
