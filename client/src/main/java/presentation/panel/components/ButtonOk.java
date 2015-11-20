package presentation.panel.components;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import presentation.main.ColorPallet;
import presentation.main.FontSet;

public class ButtonOk extends JButton {

	public ButtonOk(String s){
		setContentAreaFilled(false);
		setFocusPainted(false);
		setText(s);
		setForeground(ColorPallet.Pink);
		setHorizontalAlignment(CENTER);
		setBorder(BorderFactory.createLineBorder(ColorPallet.Pink));

		setFont(FontSet.fontOk);
		setSize(s.length()*25+30,40);
		
		
	}
}
