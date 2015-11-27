package presentation.components;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class RendererDelete implements TableCellRenderer{

	ButtonDelete delete = new ButtonDelete();
	public RendererDelete(){
	}
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		return delete;
	}

}
