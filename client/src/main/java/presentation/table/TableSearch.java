package presentation.table;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.DefaultCellEditor;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import presentation.components.EditorGeneral;
import presentation.main.ColorPallet;

public class TableSearch extends JTable{
	private EditorGeneral editor = new EditorGeneral();
	TableModelSearch model;
	
	public TableSearch(TableModelSearch model){
		super(model);
		this.model = model;
		this.setRowHeight(30); 
        this. setOpaque(false);
        this.setGridColor(ColorPallet.GrayLight);
        this.setShowVerticalLines(false);
        this.setForeground(ColorPallet.GrayDark);
        this.setDefaultRenderer(getColumnClass(0), new RendererGeneral());
        this.setDefaultEditor(getColumnClass(0), new DefaultCellEditor(editor));
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column){
		JComponent comp = (JComponent)super.prepareRenderer(renderer,row,column);
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
