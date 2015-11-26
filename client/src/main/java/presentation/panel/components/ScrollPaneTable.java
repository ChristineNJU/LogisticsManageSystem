package presentation.panel.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ScrollPaneTable extends JScrollPane{

	Image image = new ImageIcon("src/graphics/tableBackgroung.png").getImage();
	JTable content;
	public ScrollPaneTable(JTable table){
		super(table);
		content = table;
		setBorder(null);
		setOpaque(false);
		getViewport().setOpaque(false);
		setBounds(120,150,770,400);
		setBorder(BorderFactory.createEmptyBorder());
		setViewportBorder(null);
		getVerticalScrollBar().setUI(new FlatScrollBarUI());
		getHorizontalScrollBar().setUI(new FlatScrollBarUI());
		getVerticalScrollBar().setUI(new FlatScrollBarUI());
		getHorizontalScrollBar().setUI(new FlatScrollBarUI());
	}
	
//	public void paintComponent(Graphics g)  
//	{  
//	    super.paintComponent(g);    
//	    g.drawImage(image,0,0,this);  
//	} 
	
	public void setSize(){
		int num = content.getRowCount();
		if(num < 30){
			setSize(770,num*30);
			System.out.println(num+"     size < 30");
		}else{
			setSize(770,540);
		}
	}
}
