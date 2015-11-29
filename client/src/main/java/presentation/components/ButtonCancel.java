package presentation.components;

import java.awt.Color;

import presentation.listener.RollListener;
import presentation.main.ColorPallet;
import presentation.main.FontSet;

public class ButtonCancel extends ButtonTotal {

	private RollListener listener;
	
	public ButtonCancel(){
//		setFocusPainted(false);
		setOpaque(true);
		setText("取 消");
		setForeground(Color.white);
		setBackground(ColorPallet.GrayLight);
		setHorizontalAlignment(CENTER);
//		setBorderPainted(false);

		setFont(FontSet.twenty);
		setSize(135,40);
		
		listener = new RollListener(this);
		this.addMouseListener(listener);
	}
	
	public void rolled(){
		setBackground(ColorPallet.GrayMedium);
	}
	
	public void unRolled(){
		setBackground(ColorPallet.GrayLight);
	}
	
	public void click(){
		setBackground(ColorPallet.GrayMedium);
	}
}
