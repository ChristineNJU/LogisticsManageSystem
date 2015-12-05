package presentation.table;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class EditorDelete extends DefaultCellEditor{

	public EditorDelete(JTextField textField) {
		super(textField);
//		super.get
	}
	
//	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column){
		Component cell = super.getTableCellEditorComponent(table, value, isSelected, row, column);

		cell = (JTextField)cell;
		cell.setEnabled(false);
		return cell;
	}

}
