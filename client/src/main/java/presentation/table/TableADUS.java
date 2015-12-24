package presentation.table;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.DefaultCellEditor;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import presentation.components.EditorGeneral;
import presentation.main.ColorPallet;

public class TableADUS extends JTable {

	private EditorGeneral editor = new EditorGeneral();
	TableModelADUS model;

	public TableADUS(TableModelADUS model){
		super(model);
		this.model = model;
		this.setRowHeight(30); 
        this. setOpaque(false);
        this.setGridColor(ColorPallet.GrayLight);
        this.setShowVerticalLines(false);
        this.setForeground(ColorPallet.GrayDark);
        this.setDefaultRenderer(getColumnClass(0), new RendererGeneral());
        this.setDefaultEditor(getColumnClass(0), new DefaultCellEditor(editor));
        
        TableColumnModel tcm = this.getColumnModel();
		tcm.getColumn(tcm.getColumnCount()-1).setCellRenderer(new RendererDelete());
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column){
        JComponent comp = (JComponent)super.prepareRenderer(renderer,row,column);
        if(model.isNew(row)){
        	comp.setOpaque(true);
        	comp.setBackground(ColorPallet.Green);
        	if(column == getColumnCount() - 1){
        		return (JComponent)super.prepareRenderer(new RendererCancelNew(), row, column);
        	}
        	if(!model.isLeagel(row, column)){
        		comp.setBackground(ColorPallet.error);
        		comp.setForeground(Color.white);
        	}
        	return comp;
        }
        if(model.isDelete(row)){
        	comp.setOpaque(true);
        	comp.setBackground(ColorPallet.Yellow);
        	if(column == getColumnCount() - 1){
        		return (JComponent)super.prepareRenderer(new RenderHaveDelete(), row, column);
        	}
//        	System.out.println("-------------!!!!!Not empty renderer "+row);
        	return comp;
        }
        if(model.isUpdate(row,column)){
        	comp.setOpaque(true);
        	comp.setBackground(ColorPallet.Orange);
        	return comp;
        }
        
        comp.setOpaque(false);
        
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
	
//	@Override
//	public JTableHeader getTableHeader() {
//		// TODO Auto-generated method stub
//		JTableHeader tableHeader = super.getTableHeader();
//
//		tableHeader.setReorderingAllowed(false);
//
//		tableHeader.setPreferredSize(new Dimension(this.getWidth(), 30));
//		tableHeader.setDefaultRenderer(new RendererHeader());
//
//		RendererHeader hr = (RendererHeader) tableHeader.getDefaultRenderer();
//		hr.setHorizontalAlignment(DefaultTableCellRenderer.LEFT);
//		hr.setBorder(null);
//		return tableHeader;
//	}	
}
