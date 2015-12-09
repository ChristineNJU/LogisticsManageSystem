package presentation.main;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import State.ErrorState;
import VO.VO;
import presentation.components.ButtonCancel;
import presentation.components.ButtonConfirm;
import presentation.components.ButtonNew;
import presentation.components.ButtonTotal;
import presentation.components.PanelContent;
import presentation.frame.MainFrame;
import presentation.main.FunctionADUS.AttentionFrame;
import presentation.table.ScrollPaneTable;
import presentation.table.TableAddOnly;
import presentation.table.TableModelAddOnly;

public abstract class FunctionAdd {

	protected Translater trans = new Translater();
	
	protected boolean isConnectError = false;
	
	protected PanelContent panel;
	
	protected JLabel header;
	protected ButtonNew buttonNew;
	protected ButtonConfirm confirm;
	protected ButtonCancel cancel = new ButtonCancel();
	protected AttentionLabel attention = new AttentionLabel();
	protected AttentionFrame attentionframe;
	
	protected ScrollPaneTable sPanel;
	protected TableListener tableListener = new TableListener();
	protected FuncionListener functionListener = new FuncionListener();
	
	protected Vector<Vector<String>> tableV = new Vector<Vector<String>>();
	protected TableModelAddOnly model;
	protected TableAddOnly table;
	
	public FunctionAdd(){
		
	}
	
	protected void initUI(String s){
		panel = new PanelContent(s);
		panel.setLayout(null);
		
		initHeader();
		
		buttonNew.setLocation(890-buttonNew.getWidth(),100+header.getHeight()-buttonNew.getHeight());
		buttonNew.addMouseListener(functionListener);
		panel.add(buttonNew);
		
		initTable();
		table.addMouseListener(tableListener);
		
		confirm.setLocation(120,200+sPanel.getHeight());
		confirm.addMouseListener(functionListener);
//		System.out.println("add listener");
		panel.add(confirm);
		cancel.setBounds(confirm.getWidth()+130,200+sPanel.getHeight(),110,30);
		cancel.addMouseListener(functionListener);
		panel.add(cancel);
	}
	
	protected abstract void initHeader();
	
	protected abstract void initTable();
	
	protected abstract void confirmAll();
	
	protected void removeError(){
		panel.remove(attention);
	}
	
	public void showError(ErrorState state){
		
		attentionframe=new AttentionFrame(state);
//		panel.add(attention);
	}
	
	protected void solveDelete(int rowUnderMouse){
		model.delete(rowUnderMouse);
		table.repaint();
	}
	
	protected abstract VO getVO(Vector<String> vector);
	
	public PanelContent getPanel(){
		return panel;
	}
	
	protected void newItem() {
		model.addEmptyRow();
		int lastIndex = table.getRowCount() - 1;
		table.changeSelection(lastIndex, 0, false, false);
	}
	
	public boolean isConnectError(){
		return isConnectError;
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
			System.out.println("position clicked :   row"+row+"   column"+column);
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
	
	public class FuncionListener implements MouseListener{


		@Override
		public void mouseClicked(MouseEvent e) {
			ButtonTotal source = (ButtonTotal)e.getSource();
			if(source.equals(buttonNew)){
				if(buttonNew.isEnabled()){					
					newItem();
				}
			}
			if(source.equals(confirm)){
//				System.out.println("in listener");
				if(confirm.isEnabled()){
					confirmAll();
				}
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
}
