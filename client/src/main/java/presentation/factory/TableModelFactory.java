package presentation.factory;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;
import presentation.table.TableModelAddOnly;

public class TableModelFactory {

	public static AbstractTableModel getEntruckingModel(Vector<Vector<String>> tableV){
		String[] tableH = {"快递单号","   "};
		boolean[] isCellEditable = {false};
		TableModelAddOnly model = new TableModelAddOnly(tableV,tableH,isCellEditable);
		return model;
	}
}
