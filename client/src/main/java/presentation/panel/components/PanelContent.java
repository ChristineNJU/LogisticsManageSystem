package presentation.panel.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.main.ColorPallet;
import presentation.main.FontSet;

public class PanelContent extends JPanel {

	Image image = new ImageIcon("src/graphics/functionBackgroung.png").getImage();
	LabelTitle title;
	
	public PanelContent(String s){
		super();
//		setBounds(220,0,980,800);
		setBounds(220,0,980,1200);
		setPreferredSize(new Dimension(980,800));
		title = new LabelTitle(s);
		add(title);
	}
	
	public void paintComponent(Graphics g)  
	{  
	    super.paintComponent(g);    
	    g.drawImage(image,0,0,this);  
	} 
	
	public class LabelTitle extends JLabel{

		private JLabel block = new JLabel();
		private JLabel title;
		
		public LabelTitle(String s){
			block.setOpaque(true);
			block.setBackground(ColorPallet.Purple);
			block.setBounds(0,0,30,63);
			
			title = new JLabel(s);
			title.setForeground(ColorPallet.Purple);
			title.setFont(FontSet.fontTitle);
			title.setBounds(40,33,500,30);
			this.setBounds(87,0,800,63);
			this.add(block);
			this.add(title);
		}

	}
}
