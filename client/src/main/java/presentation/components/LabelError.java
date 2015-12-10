package presentation.components;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import presentation.main.FontSet;

public class LabelError extends JLabel {

	
	public LabelError(String s){
		super(s);
		this.setBorder(BorderFactory.createLineBorder(Color.red));
		this.setFont(FontSet.eighteen);
		this.setSize(s.length()*18+20,30);
	}
}
