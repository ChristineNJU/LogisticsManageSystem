package presentation.components;

import javax.swing.DefaultCellEditor;
import javax.swing.JTable;

import presentation.components.Table.CellEditor;
import presentation.main.ColorPallet;

public class TableAddOnly extends JTable{

	private RendererGeneral render = new RendererGeneral();
//	private CellEditor editor = new CellEditor();
	TableModel model;
	
	public TableAddOnly(TableModel model){
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
}
