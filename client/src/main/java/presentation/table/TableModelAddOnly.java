package presentation.table;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import presentation.userPanel.Medium.MediumCtTransfer.Header;

public class TableModelAddOnly extends AbstractTableModel{

	private Vector<Vector<String>> tableValues;
	private String[] head;
	private boolean[] isCellEditable;
	public TableModelAddOnly(Vector<Vector<String>> value, String[] head,boolean[] isCellEditable) {
		super();

//		System.out.println("in tableMOdelAddOnly constructor");
		this.tableValues = value;
		this.head = head;
		this.isCellEditable = isCellEditable;
		
	}

	public void delete(int i) {
		tableValues.remove(i);
		fireTableRowsDeleted(i, i);
	}
	
	public void addEmptyRow(){
		Vector<String> element = new Vector<String>();
//		int size = 0;
//		try {
//			size = tableValues.get(0).size();
//		}catch(NullPointerException e){
//			size = 0;
//		}
		for(int i = 0;i < head.length;i++){
			element.add(" ");
		}
		tableValues.add(element);
		fireTableRowsInserted(tableValues.size()-1,tableValues.size()-1);
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
//		return isCellEditable[columnIndex];
		
		System.out.println("in tablemodeladdonly      "+rowIndex+" "+columnIndex+"   "+head.length);
		
		if(columnIndex==head.length-1){
			return false;
		}
		
		return true;
	}
	
	@Override
	public int getRowCount() {
		try{
//		System.out.println("in tablemodel method getRowCount   "+tableValues.size());
			return tableValues.size();
		}catch(NullPointerException e){
			return 0;
		}
	}

	@Override
	public int getColumnCount() {
		return head.length;
	}

	public Vector<String> getRow(int i){
		return tableValues.get(i);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
//		System.out.println("get Value At");
		try {
//			System.out.println(tableValues.get(rowIndex).get(columnIndex));
			return tableValues.get(rowIndex).get(columnIndex);
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}
	
	@Override
	public void setValueAt(Object value, int row, int column) {
//		fireTableCellUpdated(row, column);
		if(column < getColumnCount())
			tableValues.get(row).setElementAt((String) value,column);
		else
			return;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return head[columnIndex];
	}
	

}
