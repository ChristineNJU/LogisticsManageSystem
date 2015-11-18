package presentation.panel.components;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import presentation.main.ColorPallet;

public class ButtonOk extends JButton {

	public ButtonOk(String s){
		setContentAreaFilled(false);
		setFocusPainted(false);
		setText(s);
		setBorder(BorderFactory.createLineBorder(ColorPallet.Pink));
	}
}
