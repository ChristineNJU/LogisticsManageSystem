package presentation.components;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import presentation.listener.RollListener;

public class ButtonNav  extends JLabel{

	private Icon icon1 ;
	private Icon icon2 ;
	public ButtonNav(String type,String detail){
		
		
		setSize(220,30);
		icon1 = new ImageIcon("src/graphics/NavButton/"+type+"/"+detail+"1.png");
		icon2 = new ImageIcon("src/graphics/NavButton/"+type+"/"+detail+"2.png");
		setIcon(icon1);

	}
	
	public void setPressed(){
		setIcon(icon2);
	}
	
	public void setUnPressed(){
		setIcon(icon1);	
	}
}
