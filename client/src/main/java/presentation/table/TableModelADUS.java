package presentation.table;

import java.util.Vector;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class TableModelADUS extends AbstractTableModel {

	private Vector<Vector<String>> tableValues;
	
	private Vector<Vector<String>> tableValuesCompare;
	
	private String[] head;
	private boolean[] isCellEditable;
	private boolean[] isDelete;
	private boolean[] isRowUpdate;
	private boolean[][] isCellUpdate;
	private int initialRowCount;
	private int initialColumnCount;
	private ModelListener listener;
	private Vector<Vector<Boolean>> isLeagel;
	
	public TableModelADUS(Vector<Vector<String>> value, String[] head,boolean[] isCellEditable) {
		super();
		this.tableValues = value;
		this.tableValuesCompare = new Vector<Vector<String>>();
		
		for(int i=0;i<value.size();i++){
			Vector<String> tmp = new Vector<String>();
			tmp = (Vector<String>) value.get(i).clone();
			tableValuesCompare.add(tmp);
		}
		
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
		isLeagel = new Vector<Vector<Boolean>>();
		
		listener = new ModelListener();
		this.addTableModelListener(listener);
//		System.out.println("tableValues.size:"+tableValues.size());
	}

	public void delete(int i){
		if(i < initialRowCount){
			isDelete[i] =  !isDelete[i];
		}else{
			tableValues.remove(i);
			isLeagel.remove(i-initialRowCount);
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
	
	public Boolean isLeagel(int row,int column){
		try{
			if(row < initialRowCount || !isCellEditable(row,column))
				return true;
			else
				return isLeagel.get(row-initialRowCount).get(column);
		}catch(ArrayIndexOutOfBoundsException e){
			return true;
		}
	}
	
	public void setLeagel(int row,int column,Boolean isLeagel){
//		System.out.println(row+" "+column);
//		System.out.println(initialRowCount);
//		System.out.println(row-initialRowCount);
//		System.out.println(this.isLeagel.size());
		try{
			this.isLeagel.get(row-initialRowCount).setElementAt(isLeagel,column);
		}catch(ArrayIndexOutOfBoundsException e){
			return;
		}
	}
	
	public boolean allLeagel(){
		for(int i = 0;i < isLeagel.size();i++){
			for(int j = 0;j < initialColumnCount-1;j++){
				if(!isLeagel.get(i).get(j)){
					return false;
				}
			}
		}
		return true;
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
		Vector<Boolean> tempIsLeagel = new Vector<Boolean>();
		for(int i = 0;i < initialColumnCount-1;i++){
			element.add("");
//			if(i != initialColumnCount-1)
				tempIsLeagel.add(new Boolean(false));
//			else
//				tempIsLeagel.add(new Boolean(true));
		}
		isLeagel.add(tempIsLeagel);
		tableValues.add(element);
		fireTableRowsInserted(tableValues.size()-1,tableValues.size()-1);
	}

	@Override
	public String getValueAt(int rowIndex, int columnIndex) {
		try {
//			System.out.println(tableValues.get(rowIndex).get(columnIndex));
			return tableValues.get(rowIndex).get(columnIndex);
		} catch (ArrayIndexOutOfBoundsException e) {
			return "";
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
//		if(row >= initialRowCount){
//			addEmptyRow();
//		}
		if(column < getColumnCount()){
			System.out.println("set value at   "+row+"   "+column);
			tableValues.get(row).setElementAt((String) value,column);
			fireTableCellUpdated(row, column);
		}else
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
                 
                 System.out.println(tableValues.get(row).get(column));
                 System.out.println(tableValuesCompare.get(row).get(column));
                 
                 if(!tableValues.get(row).get(column).equals(tableValuesCompare.get(row).get(column))){   
                	 System.out.println("table change");
                	 isCellUpdate[row][column] = true;
                	 isRowUpdate[row] = true;
                 }else{
                	 isCellUpdate[row][column] = false;
                	 isRowUpdate[row] = false;
                 }
			 }
		}
		
	}
}
