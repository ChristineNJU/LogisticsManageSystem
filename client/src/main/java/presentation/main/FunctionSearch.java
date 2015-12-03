package presentation.main;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JLabel;

import presentation.components.ButtonCancel;
import presentation.components.ButtonConfirm;
import presentation.components.ButtonNew;
import presentation.components.ButtonTotal;
import presentation.components.PanelContent;
import presentation.main.FunctionAdd.AttentionLabel;
import presentation.main.FunctionAdd.FuncionListener;
import presentation.main.FunctionAdd.TableListener;
import presentation.table.ScrollPaneTable;
import presentation.table.TableAddOnly;
import presentation.table.TableModelAddOnly;

public class FunctionSearch {

	protected Translater trans = new Translater();
	
protected PanelContent panel;
	
	protected JLabel header;
	protected ButtonNew buttonNew;
	protected ButtonConfirm confirm;
	protected ButtonCancel cancel = new ButtonCancel();
//	protected AttentionLabel attention = new AttentionLabel();
	
	protected ScrollPaneTable sPanel;
	protected TableListener tableListener = new TableListener();
	protected FuncionListener functionListener = new FuncionListener();
	
	protected Vector<Vector<String>> tableV = new Vector<Vector<String>>();
	protected TableModelAddOnly model;
	protected TableAddOnly table;
	
	private class TableListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
//			Point p = table.getMousePosition();
//			int row = table.rowAtPoint(p);
//			int column = table.columnAtPoint(p);
//			System.out.println("position clicked :   row"+row+"   column"+column);
//			if(column == table.getColumnCount() -1){
//				solveDelete(row);
//			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	private class FuncionListener implements MouseListener{


		@Override
		public void mouseClicked(MouseEvent e) {
			ButtonTotal source = (ButtonTotal)e.getSource();
//			if(source.equals(buttonNew)){
//				newItem();
//			}
//			if(source.equals(confirm)){
//				confirmAll();
//			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}
		
	}
}
