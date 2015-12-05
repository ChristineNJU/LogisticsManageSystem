package presentation.main;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import presentation.components.ButtonCancel;
import presentation.components.ButtonConfirm;
import presentation.components.ButtonNew;
import presentation.components.ButtonSearch;
import presentation.components.ButtonTotal;
import presentation.components.PanelContent;
import presentation.components.TextField;
import presentation.table.RendererDelete;
import presentation.table.ScrollPaneTable;
import presentation.table.TableADUS;
import presentation.table.TableModelADUS;
import VO.VO;


public abstract class FunctionADUS {

	protected Translater trans = new Translater();
	
	protected PanelContent panel;

	protected TextField input;
	protected ButtonSearch search;
	protected ButtonNew buttonNew;
	protected ButtonConfirm confirm = new ButtonConfirm("提交修改");
	protected ButtonCancel cancel = new ButtonCancel();
	protected AttentionLabel attention  = new AttentionLabel();;
//	protected String[] tableH;
//	boolean[] isCellEditable;
	protected ScrollPaneTable sPanel;
	protected TableListener tableListener = new TableListener();
	protected FuncionListener functionListener = new FuncionListener();
	
	protected Vector<Vector<String>> tableV = new Vector<Vector<String>>();
	protected TableModelADUS model;
	protected TableADUS table;
	
	
	public FunctionADUS(){
	}
	
	protected void initUI(String s){
		panel = new PanelContent(s);
		panel.setLayout(null);

		input = new TextField();
		search = new ButtonSearch();
		input.setBounds(120,110,160,30);
		panel.add(input);
		search.setBounds(280,110,60,30);
		search.addMouseListener(functionListener);
		panel.add(search);
		
		buttonNew.addMouseListener(functionListener);
		panel.add(buttonNew);
		
		initTable();
		
		confirm.setLocation(120,175+sPanel.getHeight());
		confirm.addMouseListener(functionListener);
		panel.add(confirm);
		cancel.setBounds(confirm.getWidth()+130,175+sPanel.getHeight(),110,30);
		cancel.addMouseListener(functionListener);
		panel.add(cancel);
//		System.out.println("button height:"+this.getHeight());
	}
	
	protected abstract void initTable();
	
	protected void addDeleteColumn(){
		TableColumnModel tcm = table.getColumnModel(); 
		tcm.addColumn(new TableColumn());
		tcm.getColumn(tcm.getColumnCount()-1).setCellRenderer(new RendererDelete());
	    tcm.getColumn(tcm.getColumnCount()-1).setPreferredWidth(40);
	}
	
	protected abstract void showSearchResult(String s);
	
	protected abstract void confirmRevise();
	
	protected void removeError(){
		panel.remove(attention);
	}
	
	protected void showError(String s){
		attention = new AttentionLabel(s);
		panel.add(attention);
	}
	
	protected void solveDelete(int rowUnderMouse){
		model.delete(rowUnderMouse);
		table.repaint();
	}
	
	protected void newItem() {
		model.addEmptyRow();
		int lastIndex = table.getRowCount() - 1;
		table.changeSelection(lastIndex, 0, false, false);
	}
	
	
//	protected abstract Vector<Vector<String>> getVector(ArrayList<VO> voList);
	
	protected abstract VO getVO(Vector<String> vector);
	
	public PanelContent getPanel(){
		return panel;
	}
	
	public class FuncionListener implements MouseListener{


		@Override
		public void mouseClicked(MouseEvent e) {
			ButtonTotal source = (ButtonTotal)e.getSource();
			if(source.equals(buttonNew)){
				newItem();
			}
			if(source.equals(confirm)){
				confirmRevise();
			}
			if(source.equals(search)){
				showSearchResult(input.getText());
			}
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
	
	public class AttentionLabel extends JLabel{
		public AttentionLabel(String s){
			super(s);
			setBorder(BorderFactory.createLineBorder(Color.red));
			setHorizontalAlignment(JLabel.CENTER);
			setFont(FontSet.twenty);
			setForeground(Color.red);
			setSize(s.length()+50,40);
			setLocation(873-this.getWidth(),0);
		}
		
		public AttentionLabel(){
			this("");
		}
	}
	
	public class TableListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			Point p = table.getMousePosition();
			int row = table.rowAtPoint(p);
			int column = table.columnAtPoint(p);
//			System.out.println("position clicked :   row"+row+"   column"+column);
			if(column == table.getColumnCount() -1){
				solveDelete(row);
			}
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


}
