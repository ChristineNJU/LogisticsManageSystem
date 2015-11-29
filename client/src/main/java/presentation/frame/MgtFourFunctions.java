package presentation.frame;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import VO.UserVO;
import VO.VO;
import presentation.components.PanelContent;
import presentation.components.ScrollPaneTable;
import presentation.components.Table;
import presentation.components.TableModel;
import presentation.main.Translater;

public abstract class MgtFourFunctions {

//	Translater trans = new Translater();
//	
//	protected PanelContent panel;
//	
//	protected String[] tableH;
//	boolean[] isCellEditable;
//	Vector<Vector<String>> tableV;
//	protected TableModel model;
//	protected Table table;
//	protected ScrollPaneTable sPanel;
//	protected TableListener tableListener = new TableListener();
//	
	public MgtFourFunctions(){

	}
	
	protected abstract void initUI();
	
	protected abstract void initTable();
	
	protected abstract void showSearchResult();
	
	protected abstract void confirmRevise();
	
	protected abstract void showError();
	
	protected abstract void solveDelete(int i);
	
	protected abstract void newItem();
	
//	public PanelContent getPanel(){
////		return this.panel;
//	}
	
//	protected abstract Vector<Vector<String>> getVector(ArrayList<VO> voList);
	
	protected abstract VO getVO(Vector<String> vector);
	
	
	
//	public class TableListener implements MouseListener{
//
//		@Override
//		public void mouseClicked(MouseEvent e) {
//			Point p = table.getMousePosition();
//			int row = table.rowAtPoint(p);
//			int column = table.columnAtPoint(p);
//			System.out.println("position clicked :   row"+row+"   column"+column);
//			if(column == table.getColumnCount() -1){
//				solveDelete(row);
//			}
//		}
//
//		@Override
//		public void mousePressed(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void mouseReleased(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void mouseEntered(MouseEvent e) {
//			
//		}
//
//		@Override
//		public void mouseExited(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//	}


}
