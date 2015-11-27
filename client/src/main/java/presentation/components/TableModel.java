package presentation.components;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {

	private Vector<Vector<String>> tableValues;
	private Vector<String> head;
	private ArrayList<Boolean> isDelete;

	public TableModel(Vector<Vector<String>> value, Vector<String> head) {
		super();
		this.tableValues = value;
		this.head = head;
		isDelete = new ArrayList<Boolean>();
		for(int i = 0; i < getRowCount();i++){
			isDelete.add(new Boolean(false));
		}
	}

	public void delete(int i){
		isDelete.set(i, !isDelete.get(i));
		System.out.println("in model "+isDelete.get(i));
	}
	
	public Boolean isDelete(int i){
		return isDelete.get(i);
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
//		if(columnIndex == getColumnCount()-1)
//			return false;
		return true;
	}

	@Override
	public void setValueAt(Object value, int row, int column) {
		if(value.equals(null))
			tableValues.get(row).setElementAt("",column);
		System.out.println(row+"   "+column);
		if(column < getColumnCount())
			tableValues.get(row).setElementAt((String) value,column);
		else
			return;
	}
}
