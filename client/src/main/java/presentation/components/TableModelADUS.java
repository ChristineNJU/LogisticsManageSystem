package presentation.components;

import java.util.Vector;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class TableModelADUS extends AbstractTableModel {

	private Vector<Vector<String>> tableValues;
	private String[] head;
	private boolean[] isCellEditable;
	private boolean[] isDelete;
	private boolean[] isRowUpdate;
	private boolean[][] isCellUpdate;
	private int initialRowCount;
	private int initialColumnCount;
	private ModelListener listener;

	public TableModelADUS(Vector<Vector<String>> value, String[] head,boolean[] isCellEditable) {
		super();
		this.tableValues = value;
		this.head = head;
		this.isCellEditable = isCellEditable;
		this.initialColumnCount = head.length;
		this.initialRowCount = value.size();
		isDelete = new boolean[initialRowCount];
		isRowUpdate = new boolean[initialRowCount];
		isCellUpdate = new boolean[initialRowCount][initialColumnCount];
		for(int i = 0; i < initialRowCount;i++){
			isDelete[i] = false;
			isRowUpdate[i] = false;
			for(int j = 0;j < initialColumnCount;j++)
				isCellUpdate[i][j] = false;
		}
		
		listener = new ModelListener();
		this.addTableModelListener(listener);
	}

	public void delete(int i){
		if(i < initialRowCount){
			isDelete[i] =  !isDelete[i];
		}else{
			tableValues.remove(i);
			fireTableRowsDeleted(i,i);
		}
	}
	
	public Boolean isDelete(int i){
		try{
			return isDelete[i];
		}catch(ArrayIndexOutOfBoundsException e){
			return false;
		}
	}
	
	public boolean isUpdate(int row,int column){
		if(column < initialColumnCount)
			return isCellUpdate[row][column];
		return false;
	}
	
	public boolean isUpdate(int row){
		try{
			return isRowUpdate[row];
		}catch(ArrayIndexOutOfBoundsException e){
			return false;
		}
	}
	
	public boolean isNew(int row){
		return row >= initialRowCount;
	}
	
	@Override
	public int getRowCount() {
		return tableValues.size();
	}

	@Override
	public int getColumnCount() {
		return head.length;
	}
	
	public Vector<String> getRow(int i){
		return tableValues.get(i);
	}
	
	public void addEmptyRow(){
		Vector<String> element = new Vector<String>();
		for(int i = 0;i < tableValues.get(0).size();i++){
			element.add(" ");
		}
		tableValues.add(element);
		fireTableRowsInserted(tableValues.size()-1,tableValues.size()-1);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		try {
//			System.out.println(tableValues.get(rowIndex).get(columnIndex));
			return tableValues.get(rowIndex).get(columnIndex);
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}

	@Override
	public String getColumnName(int columnIndex) {
		return head[columnIndex];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if(rowIndex >= initialRowCount){
				return true;
		}
		return isCellEditable[columnIndex];
	}

	@Override
	public void setValueAt(Object value, int row, int column) {
		fireTableCellUpdated(row, column);
		if(column < getColumnCount())
			tableValues.get(row).setElementAt((String) value,column);
		else
			return;
	}
	
	public class ModelListener implements  TableModelListener{

		@Override
		public void tableChanged(TableModelEvent evt) {
			 if (evt.getType() == TableModelEvent.UPDATE) {
                 int column = evt.getColumn();
                 int row = evt.getFirstRow();
                 if(row >= initialRowCount)
                	 return;
                 isCellUpdate[row][column] = true;
                 isRowUpdate[row] = true;
			 }
		}
		
	}
}
