package presentation.panel.components;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonFrame extends JButton {

	public ButtonFrame(String type){
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setIcon(new ImageIcon("src/graphics/Button/"+type+"1.jpg"));
		setRolloverIcon(new ImageIcon("src/graphics/Button/"+type+"2.jpg"));
		setPressedIcon(new ImageIcon("src/graphics/Button/"+type+"2.jpg"));
		if(type.equals("mini"))
			this.setBounds(66,0,36,23);
		else
			this.setBounds(108,0,36,23);;
	}
	
}
