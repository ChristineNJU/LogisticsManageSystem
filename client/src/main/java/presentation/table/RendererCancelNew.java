package presentation.table;

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import presentation.main.ColorPallet;
import presentation.main.FontSet;

public class RendererCancelNew extends DefaultTableCellRenderer{

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		this.setHorizontalAlignment(JLabel.CENTER);
		setOpaque(false);
		setForeground(ColorPallet.Purple);
		setFont(FontSet.fourteen);
		setBorder(BorderFactory.createLineBorder(ColorPallet.Purple));
		setText("取消新增");
		return cell;

	}

}
