package presentation.components;

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import presentation.main.ColorPallet;
import presentation.main.FontSet;

public class RenderHaveDelete implements TableCellRenderer{


	private ButtonHaveDelete haveDelete = new ButtonHaveDelete();
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		return haveDelete;
	}
	
	public class ButtonHaveDelete extends JButton{
		public ButtonHaveDelete(){
//			this.setBorderPainted(false);
			this.setFocusPainted(false);
			this.setContentAreaFilled(false);
			setText("取消删除");
			setSize(50,30);
			setFont(FontSet.fourteen);
			setForeground(ColorPallet.Purple);
			setHorizontalAlignment(CENTER); 
			setBorder(BorderFactory.createLineBorder(ColorPallet.Purple));
		}
	}

}
