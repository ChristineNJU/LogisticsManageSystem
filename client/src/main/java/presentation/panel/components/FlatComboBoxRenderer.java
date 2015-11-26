package presentation.panel.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class FlatComboBoxRenderer implements ListCellRenderer {

	private DefaultListCellRenderer defaultCellRender = new DefaultListCellRenderer();
	
	private Font font = new Font("微软雅黑", 1, 20);
	
	private Color background_select = new Color(0, 0, 0);
	private Color background_unselect = new Color(255, 255, 255);
	private Color foreground_select = new Color(255, 255, 255);
	private Color list_select = new Color(240, 240, 240);
	
	public FlatComboBoxRenderer() {
		super();
	}
	
	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		// TODO Auto-generated method stub
		
//		System.out.println("get listCellRender component");
		
		JLabel renderer = (JLabel) defaultCellRender.getListCellRendererComponent(list, value, index,
				isSelected, cellHasFocus);
		
		if(isSelected){
			renderer.setBackground(background_select);
			renderer.setForeground(foreground_select);
		}else{
			renderer.setBackground(background_unselect);
		}
		
		renderer.setHorizontalAlignment(JLabel.CENTER);
		
		list.setSelectionBackground(list_select);
		list.setBorder(null);
		renderer.setFont(font);
		
		return renderer;
	}
	
	public void setFont(Font font) {
		this.font = font;
	}
	
}
