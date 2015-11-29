package presentation.components;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;

import presentation.main.ColorPallet;
import presentation.main.FontSet;

public class RendererGeneral  extends JTextField implements TableCellRenderer{

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		String text = "";
		if(value != null)
			text = value.toString();
		this.setText(text);
		this.setOpaque(false);
		this.setForeground(ColorPallet.GrayDark);
		this.setFont(FontSet.fourteen);
		this.setBorder(null);
		return this;
	}

}
