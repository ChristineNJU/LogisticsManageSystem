package presentation.panel.components;

import java.awt.Color;

import javax.swing.JLabel;

import presentation.main.ColorPallet;
import presentation.main.FontSet;

public class LabelOnline extends JLabel {

	public LabelOnline(){
		this.setOpaque(true);
		this.setBackground(ColorPallet.Pink);
		this.setForeground(Color.white);
		this.setText("Online");
		this.setFont(FontSet.fourteen);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setBounds(110,140,60,20);
	}
	
	public void setOnline(){
		this.setBackground(ColorPallet.Pink);
		this.setText("Online");
	}
	
	public void setOffline(){
		this.setBackground(Color.red);
		this.setText("Offline");
	}
}
