package presentation.panel.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import presentation.main.ColorPallet;
import presentation.main.FontSet;

public class FlatComboBoxRenderer implements ListCellRenderer {

	private DefaultListCellRenderer defaultCellRender = new DefaultListCellRenderer();
	
	private Font font = FontSet.fourteen;
	
	private Color background_select = ColorPallet.GrayMedium;
	private Color background_unselect = Color.white;
	private Color foreground_select = Color.white;
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
		
		renderer.setHorizontalAlignment(JLabel.LEFT);
		
		list.setSelectionBackground(list_select);
		list.setBorder(null);
		renderer.setFont(font);
		
		return renderer;
	}
	
	public void setFont(Font font) {
		this.font = font;
	}
	
}
