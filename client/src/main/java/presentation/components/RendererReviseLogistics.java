package presentation.components;

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import presentation.main.ColorPallet;
import presentation.main.FontSet;

public class RendererReviseLogistics extends JLabel implements TableCellRenderer{

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		this.setText("修改信息");
		this.setOpaque(false);
		this.setForeground(ColorPallet.Purple);
		this.setFont(FontSet.fourteen);
		this.setBorder(BorderFactory.createLineBorder(ColorPallet.Purple));
		return this;
	}

}
