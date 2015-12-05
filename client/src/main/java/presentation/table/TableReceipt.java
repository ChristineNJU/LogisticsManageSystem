package presentation.table;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import presentation.components.EditorGeneral;
import presentation.main.ColorPallet;

public class TableReceipt extends JTable{

	private EditorGeneral editor = new EditorGeneral();
	private EditorCheck editorCheck = new EditorCheck();
	TableModelReceipt model;
	
	public TableReceipt(TableModelReceipt model){
		super(model);
		this.model = model;
		this.setRowHeight(30);
		this.setOpaque(false);
		this.setGridColor(ColorPallet.GrayLight);
		this.setShowVerticalLines(false);
		this.setForeground(ColorPallet.GrayDark);
		this.setDefaultRenderer(getColumnClass(0), new RendererGeneral());
		this.setDefaultEditor(getColumnClass(0), new DefaultCellEditor(editor));
		this.getColumnModel().getColumn(0).setCellRenderer(new RendererCheck());
		this.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(editorCheck));
	}
	
	private class RendererCheck extends JCheckBox implements TableCellRenderer{
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			
			this.setSize(20,20);
			return this;
		}
	}
	
	private class EditorCheck extends JCheckBox{
		public EditorCheck(){
			
		}
	}
}
