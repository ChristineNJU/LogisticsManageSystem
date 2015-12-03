package presentation.components;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import presentation.main.ColorPallet;
import presentation.main.FontSet;

public class EditorGeneral extends JTextField {
	public EditorGeneral() {
		this.setFont(FontSet.fourteen);
		this.setOpaque(false);
		this.setForeground(ColorPallet.GrayDark);
		this.setBorder(BorderFactory.createLoweredSoftBevelBorder());
	}
}
