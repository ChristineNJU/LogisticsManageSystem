package presentation.panel.components;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {

	Vector<Vector<String>> tableValues;
	Vector<String> head;

	public MyTableModel(Vector<Vector<String>> value, Vector<String> head) {
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
	
	public Vector<String> getRow(int i){
		return tableValues.get(i);
	}
	
	public void addEmptyRow(){
		Vector<String> element = new Vector<String>();
		for(int i = 0;i < tableValues.get(0).size();i++){
			element.add(" ");
		}
		tableValues.add(0, element);
		System.out.println("2");
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
		if(columnIndex == 0)
			return false;
		if(columnIndex == getColumnCount()-1)
			return false;
		return true;
	}

	@Override
	public void setValueAt(Object value, int row, int column) {
		if(value.equals(null))
			tableValues.get(row).setElementAt("",column);
		tableValues.get(row).setElementAt((String) value,column);
	}
}
