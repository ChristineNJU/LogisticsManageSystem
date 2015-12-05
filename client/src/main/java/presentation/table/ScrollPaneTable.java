package presentation.table;

import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import presentation.components.FlatScrollBarUI;

public class ScrollPaneTable extends JScrollPane{

	Image image = new ImageIcon("src/graphics/tableBackgroung.png").getImage();
	JTable table;
//	JButton addRow;
	public ScrollPaneTable(JTable table){
		super(table);
		table = table;
		setBorder(null);
		setOpaque(false);		
		getViewport().setOpaque(false);
		int row = table.getRowCount();
//		if(row > 18){
			setBounds(120,150,770,400);
//		}else{
//			setBounds(120,150,770,(row+1)*30);
//		}
//		System.out.println("------------------"+this.getHeight());
		setBorder(BorderFactory.createEmptyBorder());
		setViewportBorder(null);
		getVerticalScrollBar().setUI(new FlatScrollBarUI());
		getHorizontalScrollBar().setUI(new FlatScrollBarUI());
		getVerticalScrollBar().setUI(new FlatScrollBarUI());
		getHorizontalScrollBar().setUI(new FlatScrollBarUI());
	}
	
	@Override
//	public void repaint(){
//		int row = table.getRowCount();
//		if(row > 18){
//			setBounds(120,150,770,400);
//		}else{
//			setBounds(120,150,770,(row+1)*30);
//		}
//	}
	
	public void setSize(){
		int num = table.getRowCount();
		if(num < 30){
			setSize(770,num*30);
			System.out.println(num+"     size < 30");
		}else{
			setSize(770,540);
		}
	}
}
