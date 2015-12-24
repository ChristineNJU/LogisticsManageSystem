package presentation.components;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import presentation.main.FontSet;

public class LabelError extends JLabel {

	
	public LabelError(){
		super();
		setBounds(480, 590, 300, 50);
		setForeground(Color.red);
		setFont(FontSet.twenty);
	}
	public LabelError(String s){
		this();
		this.setText(s);
	}
}
