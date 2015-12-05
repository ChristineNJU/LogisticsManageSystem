package presentation.table;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.DefaultCellEditor;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import presentation.components.EditorGeneral;
import presentation.main.ColorPallet;

public class TableAddOnly extends JTable{

	private EditorGeneral editor = new EditorGeneral();
	TableModelAddOnly model;
	
	public TableAddOnly(TableModelAddOnly model){
		super(model);
//		System.out.println("in tableAddOnly constructor");
		this.model = model;
		this.setRowHeight(30); 
        this. setOpaque(false);
        this.setGridColor(ColorPallet.GrayLight);
        this.setShowVerticalLines(false);
        this.setForeground(ColorPallet.GrayDark);
        this.setDefaultRenderer(getColumnClass(0), new RendererGeneral());
        this.setDefaultEditor(getColumnClass(0), new DefaultCellEditor(editor));
        
        TableColumnModel tcm = this.getColumnModel();
//		tcm.addColumn(new TableColumn());
		tcm.getColumn(tcm.getColumnCount()-1).setCellRenderer(new RendererCancelNew());
		
//		tcm.addColumn(new TableColumn());
//		tcm.getColumn(tcm.getColumnCount() - 1).setCellRenderer(new RendererCancelNew());
//		tcm.getColumn(tcm.getColumnCount()-1).setCellEditor(new EditorDelete(new JTextField()));
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column){
		JComponent comp = (JComponent)super.prepareRenderer(renderer,row,column);
//		System.out.println("in method prepareRenderer");
		return comp;
	}
	
	@Override
	public JTableHeader getTableHeader() {
		// TODO Auto-generated method stub
		JTableHeader tableHeader = super.getTableHeader();

		tableHeader.setReorderingAllowed(false);

		tableHeader.setPreferredSize(new Dimension(this.getWidth(), 30));
		tableHeader.setDefaultRenderer(new RendererHeader());

		RendererHeader hr = (RendererHeader) tableHeader.getDefaultRenderer();
		hr.setHorizontalAlignment(DefaultTableCellRenderer.LEFT);
		hr.setBorder(null);
		return tableHeader;
	}
}
