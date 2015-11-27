package presentation.components;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ButtonDelete extends JButton{
	
	public ButtonDelete(){
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);
		setIcon(new ImageIcon("src/graphics/Button/delete.png"));
		setSize(30,30);
		setHorizontalAlignment(CENTER); 
	}
	public void rolled(){
		
	}
	public void setUnRolled(){
		
	}
	public void click(){
		
	}
}
