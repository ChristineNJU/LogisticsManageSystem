package presentation.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

import presentation.main.ColorPallet;
import presentation.main.FontSet;

public class MyComboBox extends JComboBox {
	public MyComboBox() {
		super();
		init();
	}
	public MyComboBox(ComboBoxModel model) {
		super(model);
		init();
	}
	public MyComboBox(Object[] items) {
		super(items);
		init();
	}
	public MyComboBox(Vector<?> items) {
		super(items);
		init();
	}
	
	public void init() {
		setFont(FontSet.fourteen);
		setForeground(ColorPallet.GrayDark);
		setOpaque(true);
		setBackground(Color.white);
		setUI(new MyComboBoxUI());
		setRenderer(new MyComboBoxRenderer());
		setBorder(new LineBorder(ColorPallet.GrayLight, 1));
		
//		setBackground(Color.GRAY);
	}
	
	public Dimension getPreferredSize() {
		return super.getPreferredSize();
	}
}
