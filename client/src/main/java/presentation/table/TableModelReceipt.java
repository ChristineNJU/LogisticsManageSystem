package presentation.table;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class TableModelReceipt extends AbstractTableModel{

	private Vector<Vector<String>> tableValues;
	private String[] head;

	@Override
	public int getRowCount() {
		try {
			return tableValues.size();
		} catch (NullPointerException e) {
			return 0;
		}
	}

	@Override
	public int getColumnCount() {
		return head.length+1;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex == 0){
			return null;
		}
		try {
			return tableValues.get(rowIndex).get(columnIndex+1);
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}

}
