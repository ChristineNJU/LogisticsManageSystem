package presentation.components;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import presentation.main.ColorPallet;
import presentation.main.FontSet;
import presentation.components.RendererDelete;

public class Table extends JTable {

	private RendererGeneral render = new RendererGeneral();
	private CellEditor editor = new CellEditor();
	TableModel model;

	public Table(TableModel model){
		super(model);
		this.model = model;
		this.setRowHeight(30); 
        this. setOpaque(false);
        this.setGridColor(ColorPallet.GrayLight);
        this.setShowVerticalLines(false);
        this.setForeground(ColorPallet.GrayDark);
        this.setDefaultRenderer(getColumnClass(0), new colorTableRender());
        this.setDefaultEditor(getColumnClass(0), new DefaultCellEditor(editor));
        
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column){
        JComponent comp = (JComponent)super.prepareRenderer(renderer,row,column);
        if(model.isNew(row)){
        	comp.setOpaque(true);
        	comp.setBackground(ColorPallet.Green);
        	if(column == getColumnCount() - 1){
//        		System.out.println("empty renderer "+row);
        		return (JComponent)super.prepareRenderer(new RendererCancelNew(), row, column);
        	}
//        	System.out.println("!!!!!Not empty renderer "+row);
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
	
	
	
	public class CellEditor extends JTextField{
		public CellEditor(){
			this.setFont(FontSet.fourteen);
			this.setOpaque(false);
			this.setForeground(ColorPallet.GrayDark);
			this.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		}
	}
	
	public class colorTableRender extends DefaultTableCellRenderer {
		 
        public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus, int row,
                int column) {
            Component cell = super.getTableCellRendererComponent(table, value,
                    isSelected, hasFocus, row, column);
            
            setOpaque(false);
            setForeground(ColorPallet.GrayDark);
    		setFont(FontSet.fourteen);
    		setBorder(null);
            return cell;
 
        }
    }
	
	
//	class MyTableMouseMotionListener extends MouseMotionAdapter{
//
//        private int rowUnderMouse = -1;
//        @Override
//		public void mouseMoved(MouseEvent e) {
//			JTable table = (JTable) e.getSource();
//			Point p = table.getMousePosition();
//			if (p != null) {
//				rowUnderMouse = table.rowAtPoint(p);
//				if (rowUnderMouse >= 0) {
//					for (int i = 0; i < table.getColumnCount(); i++) {
//							prepareRenderer(table.getCellRenderer(rowUnderMouse, i), rowUnderMouse, i);
//						if (rowUnderMouse != 0) {
//							prepareRenderer(table.getCellRenderer(rowUnderMouse - 1, i), rowUnderMouse - 1, i);
//						}
//						if (rowUnderMouse != table.getRowCount() - 1) {
//							prepareRenderer(table.getCellRenderer(rowUnderMouse + 1, i), rowUnderMouse + 1, i);
//						}
//					}
//					table.repaint(table.getVisibleRect());
//				}
//			}
//		}
//	}
}
