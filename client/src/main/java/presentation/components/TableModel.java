package presentation.components;

import java.util.Vector;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {

	private Vector<Vector<String>> tableValues;
	private String[] head;
	private boolean[] isCellEditable;
	private boolean[] isDelete;
	private boolean[] isRowUpdate;
	private boolean[][] isCellUpdate;
	private int initialRowCount;
	private int initialColumnCount;
	private ModelListener listener;

	public TableModel(Vector<Vector<String>> value, String[] head,boolean[] isCellEditable) {
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
		if(i < initialRowCount)
			isDelete[i] =  !isDelete[i];
		System.out.println("in model "+isDelete[i]);
	}
	
	public Boolean isDelete(int i){
		return isDelete[i];
	}
	
	public boolean isUpdate(int row,int column){
		if(column < initialColumnCount)
			return isCellUpdate[row][column];
		return false;
	}
	
	public boolean isUpdate(int row){
		return isRowUpdate[row];
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

//		System.out.println("in model ,add empty row");
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
		return head[columnIndex];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if(rowIndex >= initialRowCount){
//			System.out.println(initialColumnCount+"initialColumnCount");
//			if(columnIndex == initialColumnCount){
//				return false;
//			}else{
				return true;
		}
			
		return isCellEditable[columnIndex];
	}

	@Override
	public void setValueAt(Object value, int row, int column) {
//		if(value.equals(null))
//			tableValues.get(row).setElementAt("",column);
//		System.out.println("in table model method setValueAt"+row+"   "+column);
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
