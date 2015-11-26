package presentation.panel.components;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {

	Vector<Vector<Object>> tableValues;
	Vector<String> head;

	public MyTableModel(Vector<Vector<Object>> value, Vector<String> head) {
		super();
		this.tableValues = value;
		this.head = head;

	}

	@Override
	public int getRowCount() {
		return tableValues.size();
	}

	@Override
	public int getColumnCount() {
		return head.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		try {
			return tableValues.get(rowIndex).get(columnIndex);
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}

	@Override
	public String getColumnName(int columnIndex) {
		return head.get(columnIndex);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	@Override
	public void setValueAt(Object value, int row, int column) {
		tableValues.get(row).setElementAt(value,column);// = value;
	}
}
