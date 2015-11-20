package presentation.panel.components;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import presentation.main.ColorPallet;

public class TextField extends JTextField {

	private Border borderCommon = new LineBorder(ColorPallet.GrayLight, 1);
	private Border borderFocus = new LineBorder(ColorPallet.GrayMedium, 1);
	private Border borderError = new LineBorder(Color.red, 1);
	private Listener listener = new Listener();
	
	public TextField(){
		setBorder(borderCommon);
		setForeground(ColorPallet.GrayDark);
		setHorizontalAlignment(JTextField.LEFT);
		addFocusListener(listener);
	}
	
	public void setError(){
		setBorder(borderError);
	}
	
//	public void removeError(){
//		setBorder(borderCommon);
//	}
	
	public class Listener implements FocusListener{

		@Override
		public void focusGained(FocusEvent e) {
			setBorder(borderFocus);

		}

		@Override
		public void focusLost(FocusEvent e) {
			setBorder(borderCommon);
			
		}
		
	}
}
