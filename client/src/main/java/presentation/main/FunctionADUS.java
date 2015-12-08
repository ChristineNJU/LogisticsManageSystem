package presentation.main;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
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
import presentation.frame.MainFrame;
import presentation.table.RendererDelete;
import presentation.table.ScrollPaneTable;
import presentation.table.TableADUS;
import presentation.table.TableModelADUS;
import State.ErrorState;
import VO.VO;


public abstract class FunctionADUS {

	protected Translater trans = new Translater();
	
	protected PanelContent panel;

	protected TextField input;
	protected ButtonSearch search;
	protected ButtonNew buttonNew;
	protected ButtonConfirm confirm = new ButtonConfirm("提交修改");
	protected ButtonCancel cancel = new ButtonCancel();
	protected AttentionLabel attention  = new AttentionLabel();
	protected AttentionFrame attentionframe;
//	protected String[] tableH;
//	boolean[] isCellEditable;
	protected ScrollPaneTable sPanel;
	protected TableListener tableListener = new TableListener();
	protected FuncionListener functionListener = new FuncionListener();
	
	protected Vector<Vector<String>> tableV = new Vector<Vector<String>>();
	protected TableModelADUS model;
	protected TableADUS table;
	
	protected boolean isConnectError = false;
	
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
	    tcm.getColumn(tcm.getColumnCount()-1).setWidth(40);
	}
	
	protected abstract void showSearchResult(String s);
	
	protected abstract void confirmRevise();
	
	public void removeError(){
//		panel.remove(attention);
		attentionframe.setVisible(false);
	}
	
	public void showError(ErrorState state){
	
		attentionframe=new AttentionFrame(state);
//		panel.add(attention);
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
	// Do not use this inner class 
	public class AttentionLabel extends JLabel{
		public AttentionLabel(String s){
			super(s);
//			setBorder(BorderFactory.createLineBorder(Color.red));
			setHorizontalAlignment(JLabel.CENTER);
//			setFont(FontSet.twenty);
//			setForeground(Color.red);
//			setSize(s.length()+50,40);
//			setLocation(873-this.getWidth(),0);
//			setLocation()
			
			setVisible(true);
		}
		
		public AttentionLabel(){
			this("");
		}
	}
	
	public class AttentionFrame extends JFrame implements Runnable{
		public AttentionFrame(ErrorState state){
			ImageIcon Image=null;
			if(state==ErrorState.CONNECTERROR){
				Image = new ImageIcon("src/graphics/Tips/connectError.png");
			}
			else if(state==ErrorState.DELETEERROR){
				Image = new ImageIcon("src/graphics/Tips/deleteError.png");
			}
			else if(state==ErrorState.UPDATEERROR){
				Image = new ImageIcon("src/graphics/Tips/updateError.png");
			}
			else if(state==ErrorState.SEARCHERROR){
				Image = new ImageIcon("src/graphics/Tips/searchError.png");
			}
			else if(state==ErrorState.ADDERROR){
				Image = new ImageIcon("src/graphics/Tips/addError.png");
			}
		    JLabel errorNote=new JLabel(Image);
			this.setUndecorated(true);
			this.setSize(150, 50);
			this.setLocation((int)(MainFrame.FRAME_X+MainFrame.FRAME_WIDTH/2),(int) (MainFrame.FRAME_Y+MainFrame.FRAME_HEIGHT/2));
			this.add(errorNote);
			this.setVisible(true);
			System.out.println("Error infomation");
//			run();
			Thread t = new Thread(this);
			t.start();
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				System.out.println("staff error thread");
				Thread.sleep(1000);
				this.setVisible(true);
//				this.repaint();
				Thread.sleep(500);
				this. setVisible(false);
//				this.repaint();
//				System.exit(0);
				} catch (InterruptedException e) {
				 e.printStackTrace();
			}

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
