package presentation.panel.components;

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

public class FlatComboBox extends JComboBox {
	public FlatComboBox() {
		super();
		init();
	}
	public FlatComboBox(ComboBoxModel model) {
		super(model);
		init();
	}
	public FlatComboBox(Object[] items) {
		super(items);
		init();
	}
	public FlatComboBox(Vector<?> items) {
		super(items);
		init();
	}
	
	public void init() {
		setFont(FontSet.twelve);
		setForeground(ColorPallet.GrayDark);
		setOpaque(false);
		setUI(new FlatComboBoxUI());
		setRenderer(new FlatComboBoxRenderer());
		setBorder(new LineBorder(Color.gray, 1));
//		setBackground(Color.GRAY);
	}
	
	public Dimension getPreferredSize() {
		return super.getPreferredSize();
	}
}
