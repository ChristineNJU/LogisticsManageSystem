package presentation.factory;

import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import presentation.components.FlatComboBox;
import presentation.table.RendererDelete;
import presentation.table.RendererReviseLogistics;
import presentation.table.TableADUS;
import presentation.table.TableAddOnly;
import presentation.table.TableModelADUS;
import presentation.table.TableModelAddOnly;
import presentation.table.TableModelSearch;
import presentation.table.TableSearch;

public class TableFactory {

	public static TableADUS getUserAccountTable(TableModelADUS model){
		TableADUS table = new TableADUS(model);
		
		TableColumnModel tcm = table.getColumnModel(); 
        tcm.getColumn(2).setCellEditor(new DefaultCellEditor(ComboxFactory.getPositionComboBox()));  
        tcm.getColumn(3).setCellEditor(new DefaultCellEditor(ComboxFactory.getGenderComboBox())); 
        tcm.getColumn(5).setCellEditor(new DefaultCellEditor(ComboxFactory.getCityComboBox()));
        tcm.getColumn(4).setCellEditor(new DefaultCellEditor(ComboxFactory.getAgeComboBox()));
        tcm.getColumn(6).setCellEditor(new DefaultCellEditor(ComboxFactory.getInstitutionComboBox()));        
		
		return table;
	}
	
	public static TableAddOnly getArrivalTable(TableModelAddOnly model){
		TableAddOnly table = new TableAddOnly(model);
		TableColumnModel tcm = table.getColumnModel(); 
		tcm.getColumn(2).setCellEditor(new DefaultCellEditor(ComboxFactory.getLogisticsStateComboBox())); 
		tcm.getColumn(4).setPreferredWidth(80);
		return table;
	}
	
	public static TableADUS getCarMgtTable(TableModelADUS model){
		TableADUS table = new TableADUS(model);
		return table;
	}
	
	public static TableADUS getDriverMgtTable(TableModelADUS model){
		TableADUS table = new TableADUS(model);
		TableColumnModel tcm = table.getColumnModel(); 
	    tcm.getColumn(5).setCellEditor(new DefaultCellEditor(ComboxFactory.getGenderComboBox()));
	    tcm.getColumn(tcm.getColumnCount()-1).setPreferredWidth(40);
		return table;
	}
	
	public static TableAddOnly getDelivery(TableModelAddOnly model){
		TableAddOnly table = new TableAddOnly(model);
		TableColumnModel tcm = table.getColumnModel(); 
		tcm.getColumn(tcm.getColumnCount()-1).setPreferredWidth(80);
		return table;
	}
	
	public static TableAddOnly getEntrucking(TableModelAddOnly model){
		TableAddOnly table = new TableAddOnly(model);
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(690);
		tcm.getColumn(tcm.getColumnCount()-1).setPreferredWidth(80);
		return table;
	}
	
	public static TableAddOnly getGathering(TableModelAddOnly model){
		TableAddOnly table = new TableAddOnly(model);
		TableColumnModel tcm = table.getColumnModel(); 
		tcm.getColumn(tcm.getColumnCount()-1).setPreferredWidth(80);
		return table;
	}
	
	public static TableAddOnly getLogistics(TableModelAddOnly model){
		TableAddOnly table = new TableAddOnly(model);
		TableColumnModel tcm = table.getColumnModel();
		
		tcm.addColumn(new TableColumn());
		tcm.getColumn(tcm.getColumnCount()-1).setCellRenderer(new RendererReviseLogistics());
//		tcm.getColumn(tcm.getColumnCount()-1).setPreferredWidth(40);
		
		tcm.addColumn(new TableColumn());
		tcm.getColumn(tcm.getColumnCount()-1).setCellRenderer(new RendererDelete());
		tcm.getColumn(tcm.getColumnCount()-1).setPreferredWidth(40);

		return table;
	}
	
	public static TableAddOnly getReceive(TableModelAddOnly model){
		TableAddOnly table = new TableAddOnly(model);
		TableColumnModel tcm = table.getColumnModel(); 
		tcm.getColumn(tcm.getColumnCount()-1).setPreferredWidth(80);
		return table;
	}
	
	public static TableSearch getIncome(TableModelSearch model){
		TableSearch table = new TableSearch(model);
		TableColumnModel tcm = table.getColumnModel(); 
		tcm.getColumn(tcm.getColumnCount()-1).setPreferredWidth(80);
		return table;
	}
	
	public static TableAddOnly getCost(TableModelAddOnly model){
		TableAddOnly table = new TableAddOnly(model);
		TableColumnModel tcm = table.getColumnModel(); 
		tcm.getColumn(4).setCellEditor(new DefaultCellEditor(ComboxFactory.getCostTypeComboBox())); 
		tcm.getColumn(tcm.getColumnCount()-1).setPreferredWidth(80);
		return table;
	}
	
	public static TableADUS getFinanceTable(TableModelADUS model){
		TableADUS table = new TableADUS(model);
		return table;
	}
	
	public static TableSearch getOutcomeAndIncomeTable(TableModelSearch model){
		TableSearch table = new TableSearch(model);
		return table;
	}
	
	public static TableSearch getSystemTable(TableModelSearch model){
		TableSearch table = new TableSearch(model);
		return table;
	}
	
	public static TableADUS getInstutionTable(TableModelADUS model){
		TableADUS table = new TableADUS(model);
		
		TableColumnModel tcm = table.getColumnModel(); 
		
        tcm.getColumn(2).setCellEditor(new DefaultCellEditor(ComboxFactory.getInstitutionComboBox()));
        tcm.getColumn(3).setCellEditor(new DefaultCellEditor(ComboxFactory.getCityComboBox()));
        
		return table;
	}
	
	public static TableADUS getSalaryTable(TableModelADUS model){
		TableADUS table = new TableADUS(model);
		return table;
	}
	
	public static TableADUS getStaffTable(TableModelADUS model){
		TableADUS table = new TableADUS(model);
		return table;
	}
	
	public static TableAddOnly getBalanceTable(TableModelAddOnly model){
		TableAddOnly table = new TableAddOnly(model);
		
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(0).setCellEditor(new DefaultCellEditor(ComboxFactory.getOldArea()));
		tcm.getColumn(2).setCellEditor(new DefaultCellEditor(ComboxFactory.getNewArea()));
		tcm.getColumn(3).setCellEditor(new DefaultCellEditor(ComboxFactory.getPosition()));
		tcm.getColumn(4).setCellEditor(new DefaultCellEditor(ComboxFactory.getPosition()));
		tcm.getColumn(5).setCellEditor(new DefaultCellEditor(ComboxFactory.getPosition()));
		
		return table;
	}
	
	public static TableSearch getStorageSearchTable(TableModelSearch model){
		TableSearch table = new TableSearch(model);
		return table;
	}
	
	public static TableSearch getRemovalSearchTable(TableModelSearch model){
		TableSearch table = new TableSearch(model);
		return table;
	}
	
	public static TableAddOnly getRemovalTable(TableModelAddOnly model){
		TableAddOnly table = new TableAddOnly(model);
		return table;
	}
	
	public static TableAddOnly getStorageTable(TableModelAddOnly model){
		TableAddOnly table = new TableAddOnly(model);
		
		TableColumnModel tcm = table.getColumnModel();
		
		tcm.getColumn(1).setCellEditor(new DefaultCellEditor(ComboxFactory.getCityComboBox()));
		tcm.getColumn(2).setCellEditor(new DefaultCellEditor(ComboxFactory.getOldArea()));
		
		tcm.getColumn(3).setCellEditor(new DefaultCellEditor(ComboxFactory.getPosition()));
		tcm.getColumn(4).setCellEditor(new DefaultCellEditor(ComboxFactory.getPosition()));
		tcm.getColumn(5).setCellEditor(new DefaultCellEditor(ComboxFactory.getPosition()));
		
		return table;
	}
	
	public static TableSearch getStockTakingAir(TableModelSearch model){
		TableSearch table = new TableSearch(model);
		return table;
	}
	
	public static TableSearch getStockTakingRailway(TableModelSearch model){
		TableSearch table = new TableSearch(model);
		return table;
	}
	
	public static TableSearch getStockTakingBus(TableModelSearch model){
		TableSearch table = new TableSearch(model);
		return table;
	}
	
}
