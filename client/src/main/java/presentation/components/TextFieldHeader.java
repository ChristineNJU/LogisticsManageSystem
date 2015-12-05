package presentation.components;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import presentation.main.ColorPallet;

public class TextFieldHeader extends JTextField{

	public TextFieldHeader(){
//		setBorder(BorderFactory.createEmptyBorder());
		setBorder(BorderFactory.createLineBorder(ColorPallet.GrayLight));
		setOpaque(false);
		setForeground(ColorPallet.Purple);;
	}
}
