package presentation.panel.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

import presentation.main.FontSet;

public class FlatComboBoxUI extends BasicComboBoxUI {
	
	private JButton arrow;
	private boolean boundsLight = false;	
	private Font font = FontSet.twelve;
	
	private EditorFocusListener efl = new EditorFocusListener();
	
	private Color popup_border = new Color(255, 255, 255);
	
	private Color background_focusLost = new Color(240, 240, 240);
	
	public FlatComboBoxUI() {
		super();
	}
	
	protected void installListeners() {
		super.installListeners();
		comboBox.addFocusListener(efl);
	}
	
	protected void uninstallListeners() {
		super.uninstallListeners();
		comboBox.removeFocusListener(efl);
	}
	
	protected void configureEditor() {
		super.configureEditor();
		editor.addFocusListener(efl);
	}
	
	protected void unconfigureEditor() {
		super.unconfigureEditor();
		editor.removeFocusListener(efl);
	}

	protected JButton createArrowButton() {
		arrow = new FlatArrowButton(5);
		arrow.setContentAreaFilled(false);
		return arrow;
	}
	
	public void paint(Graphics g, JComponent c) {
//		System.out.println("paint");
				
		hasFocus = comboBox.hasFocus();
		Graphics2D g2 = (Graphics2D) g;
		
//		System.out.println(comboBox.isEditable());
		
		if(!comboBox.isEditable()) {
			Rectangle r = rectangleForCurrentValue();
			paintCurrentValueBackground(g2, r, hasFocus);
			paintCurrentValue(g2, r, hasFocus);
		}	
	}
	
	public void paintCurrentValue(Graphics g, Rectangle bounds, boolean hasFocus) {
//		System.out.println("paint current value");
		
//		System.out.println(editor);
		
		ListCellRenderer renderer = comboBox.getRenderer();
		Component c;
		
		if(hasFocus&&!isPopupVisible(comboBox)){
			c = renderer.getListCellRendererComponent(listBox, 
					comboBox.getSelectedItem(), -1, true, false);
//			comboBox.setBorder(new LineBorder(Color.blue, 2));
		}else{
			c = renderer.getListCellRendererComponent(listBox, 
					comboBox.getSelectedItem(), -1, false, false);
		}
		c.setFont(comboBox.getFont());
		
//		System.out.println(hasFocus);
//		System.out.println(isPopupVisible(comboBox));
//		System.out.println(comboBox.isEnabled());
		
		if(hasFocus&&!isPopupVisible(comboBox)){
			c.setForeground(listBox.getSelectionForeground());
			c.setBackground(listBox.getSelectionBackground());
		}else{
			if(comboBox.isEnabled()){
//				System.out.println(comboBox.getBackground());
				c.setForeground(comboBox.getForeground());
				c.setBackground(comboBox.getBackground());
			}else{
				c.setForeground(comboBox.getForeground());
				c.setBackground(comboBox.getBackground());
			}
		}
		
		boolean shouldValidate = false;
//		if(c instanceof JPanel){
//			shouldValidate = true;
//		}
		
		int x = bounds.x, y = bounds.y, w = bounds.width, h = bounds.height;
		if(padding!=null){
			x = bounds.x+padding.left;
			y = bounds.y+padding.top;
			w = bounds.width-(padding.left+padding.right);
			h = bounds.height-(padding.top+padding.bottom);
		}
		
		currentValuePane.paintComponent(g, c, comboBox, x, y, w, h, shouldValidate);
		super.paintCurrentValue(g, bounds, hasFocus);
	}
		
	public Dimension getPreferredSize(JComponent c) {
		return super.getPreferredSize(c);
	}
	
	public boolean isBoundsLight() {
		return boundsLight;
	}
	
	public void setBoundsLight(boolean boundsLight) {
		this.boundsLight = boundsLight;
	}
	
	public ComboPopup createPopup() {
		System.out.println("create popup");
		
		ComboPopup popup = new BasicComboPopup(comboBox){
			protected JScrollPane createScroller() {
				FlatScrollPane sp = new FlatScrollPane(list,
						ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
						ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				
				sp.setHorizontalScrollBar(null);
				sp.setBorder(null);
				return sp;
			}
		};
				
		return popup;
	}
	
	protected Rectangle rectangleForCurrentValue() {
		int width = comboBox.getWidth();
		int height = comboBox.getHeight();
		Insets insets = getInsets();
		int buttonSize = height-(insets.top+insets.bottom);
		if(arrowButton!=null){
			buttonSize = arrowButton.getWidth();
		}
		return new Rectangle(insets.left, insets.top, width-(insets.left+insets.right
				+buttonSize), height-(insets.top+insets.bottom));
	}
	
	private class EditorFocusListener implements FocusListener {
		
		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub		
			System.out.println("my focus gained");
			ComboBoxEditor comboBoxEditor =comboBox.getEditor();
			JTextField theEditor = (JTextField)comboBoxEditor.getEditorComponent();
			theEditor.setHorizontalAlignment(JTextField.LEFT);
			theEditor.setBackground(Color.white);
			comboBox.setBorder(new LineBorder(Color.blue, 2));
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			System.out.println("my focus lost");
			ComboBoxEditor comboBoxEditor = comboBox.getEditor();
			JTextField theEditor = (JTextField)comboBoxEditor.getEditorComponent();
			theEditor.setHorizontalAlignment(JTextField.CENTER);
			theEditor.setBackground(background_focusLost);
			comboBox.setBorder(new LineBorder(Color.gray, 1));
		}
		
	}
}
