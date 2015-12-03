package presentation.components;

import java.awt.Color;

import javax.swing.JLabel;

import presentation.main.ColorPallet;
import presentation.main.FontSet;

public class LabelHeader extends javax.swing.JLabel {

	public LabelHeader(String s){
		super(s);
		this.setForeground(ColorPallet.Purple);
		this.setFont(FontSet.eighteen);
	}
	
	public void addInfo(String s){
		setText(getText()+s);
	}
}
