package presentation.panel.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import presentation.main.ColorPallet;
import presentation.main.FontSet;

public class Table extends JTable {

	RendererGeneral render = new RendererGeneral();
	CellEditor editor = new CellEditor();
	public Table(MyTableModel model){
		super(model);
		this.setRowHeight(30); 
        this. setOpaque(false);
        this.setGridColor(ColorPallet.GrayLight);
        this.setShowVerticalLines(false);
        this.setForeground(ColorPallet.GrayDark);
        this.setDefaultRenderer(getColumnClass(0), render);
        this.setDefaultEditor(getColumnClass(0), new DefaultCellEditor(editor));
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (c instanceof JComponent) {
			((JComponent) c).setOpaque(false);
		}
		return c;
	}

	@Override
	public JTableHeader getTableHeader() {
		// TODO Auto-generated method stub
		JTableHeader tableHeader = super.getTableHeader();

		tableHeader.setReorderingAllowed(false);

		tableHeader.setPreferredSize(new Dimension(this.getWidth(), 30));
		tableHeader.setDefaultRenderer(new RendererHeader());

		RendererHeader hr = (RendererHeader) tableHeader.getDefaultRenderer();
		// 列名居中
		hr.setHorizontalAlignment(DefaultTableCellRenderer.LEFT);
		hr.setBorder(null);
		// hr.setBorder(BorderFactory.createLineBorder(Color.red));
		return tableHeader;
	}
	
	public class CellEditor extends JTextField{
		public CellEditor(){
			this.setFont(FontSet.fourteen);
			this.setOpaque(false);
			this.setForeground(ColorPallet.GrayDark);
			this.setBorder(new DownBorder(1));
		}
	}
	
	public class DownBorder extends SoftBevelBorder {

	

		public DownBorder(int bevelType) {
			super(bevelType);
		}

		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			Color oldColor = g.getColor();
			g.translate(x, y);

			g.setColor(getShadowOuterColor(c));
			g.drawLine(0, 0, width - 2, 0);
			g.drawLine(0, 0, 0, height - 2);
			g.drawLine(1, 1, 1, 1);

			g.setColor(getShadowInnerColor(c));
			g.drawLine(2, 1, width - 2, 1);
			g.drawLine(1, 2, 1, height - 2);
			g.drawLine(2, 2, 2, 2);
			g.drawLine(0, height - 1, 0, height - 2);
			g.drawLine(width - 1, 0, width - 1, 0);

			g.setColor(getHighlightOuterColor(c));
			g.drawLine(2, height - 1, width - 1, height - 1);
			g.drawLine(width - 1, 2, width - 1, height - 1);

			g.setColor(getHighlightInnerColor(c));
			g.drawLine(width - 2, height - 2, width - 2, height - 2);

			g.translate(-x, -y);
			g.setColor(oldColor);
		}

	}
}
