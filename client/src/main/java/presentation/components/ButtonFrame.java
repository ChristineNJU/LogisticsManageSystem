package presentation.components;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonFrame extends JButton {

	public ButtonFrame(String type){
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setIcon(new ImageIcon("src/graphics/Button/"+type+"1.png"));
		setRolloverIcon(new ImageIcon("src/graphics/Button/"+type+"2.png"));
		setPressedIcon(new ImageIcon("src/graphics/Button/"+type+"2.png"));
		if(type.equals("mini"))
			this.setBounds(64,0,37,23);
		else
			this.setBounds(108,0,37,23);;
	}
	
}
