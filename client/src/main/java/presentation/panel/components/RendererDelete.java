package presentation.panel.components;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class RendererDelete extends JLabel implements TableCellRenderer{

	public RendererDelete(){
		setIcon(new ImageIcon("src/graphics/Button/delete.png"));
		setSize(30,30);
		setHorizontalAlignment(JLabel.CENTER); 
	}
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		return this;
	}

}
