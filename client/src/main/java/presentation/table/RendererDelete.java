package presentation.table;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class RendererDelete implements TableCellRenderer{

	private ButtonDelete delete = new ButtonDelete();
	
	public RendererDelete(){
		
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
//		System.out.println("in renderer delete:"+row+"  "+column);
			return delete;

	}
	public class ButtonDelete extends JButton{
		public ButtonDelete(){
			this.setBorderPainted(false);
			this.setFocusPainted(false);
			this.setContentAreaFilled(false);
			setIcon(new ImageIcon("src/graphics/Button/delete.png"));
			setSize(30,30);
			setHorizontalAlignment(CENTER); 
		}
	}

}
