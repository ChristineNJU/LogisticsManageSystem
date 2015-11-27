package presentation.components;

import java.awt.Color;

import javax.swing.BorderFactory;

import presentation.main.ColorPallet;
import presentation.main.FontSet;

public class ButtonSearch extends ButtonTotal{
	
	public ButtonSearch(){
		this.setText("搜索");
		this.setHorizontalAlignment(CENTER);
		this.setBorder(BorderFactory.createLineBorder(ColorPallet.GrayDark));
		this.setFont(FontSet.eighteen);
		this.setForeground(ColorPallet.GrayDark);
		this.setBackground(ColorPallet.GrayDark);
	}
	public void rolled(){
		setOpaque(true);
		setForeground(Color.white);
		setBackground(ColorPallet.GrayDark);
	}
	public void unRolled(){
		this.setForeground(ColorPallet.GrayDark);
		this.setOpaque(false);
		this.repaint();
	}
	public void click(){
		setOpaque(true);
		setForeground(Color.white);
		setBackground(ColorPallet.GrayDark);
	}
}
