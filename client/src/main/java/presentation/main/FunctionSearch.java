package presentation.main;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import VO.VO;
import presentation.components.ButtonConfirm;
import presentation.components.PanelContent;
import presentation.table.ScrollPaneTable;
import presentation.table.TableModelSearch;
import presentation.table.TableSearch;

public abstract class FunctionSearch {

	protected Translater trans = new Translater();
	
	protected PanelContent panel;
	
	protected JLabel header;
//	protected ButtonNew buttonNew;
	protected ButtonConfirm confirmSearch;
//	protected ButtonCancel cancel = new ButtonCancel();
	protected AttentionLabel attention = new AttentionLabel();
	
	protected ScrollPaneTable sPanel;
//	protected TableListener tableListener = new TableListener();
	protected FuncionListener listener = new FuncionListener();
	
	protected Vector<Vector<String>> tableV = new Vector<Vector<String>>();
	protected TableModelSearch model;
	protected TableSearch table;
	
	public FunctionSearch(){
		
	}
	
	protected void initUI(String s){
		panel = new PanelContent(s);
		panel.setLayout(null);
		
		initHeader();
		
		confirmSearch.setLocation(888-confirmSearch.getWidth(),110);
		confirmSearch.addMouseListener(listener);
		panel.add(confirmSearch);
//		buttonNew.setLocation(buttonNew.getX(),130+header.HEIGHT);
//		buttonNew.addMouseListener(functionListener);
//		panel.add(buttonNew);
		
		initTable();
		
		
//		cancel.setBounds(confirm.getWidth()+130,200+sPanel.getHeight(),110,30);
//		cancel.addMouseListener(functionListener);
//		panel.add(cancel);
	}
	
	protected abstract void initHeader();
	
	protected abstract void initTable();
	
	protected abstract void showSearch();
	
	protected void removeError(){
		panel.remove(attention);
	}
	
	protected void showError(String s){
		attention.setText(s);
		panel.add(attention);
	}
	
//	protected abstract VO getVO(Vector<String> vector);
	
	public PanelContent getPanel(){
		return panel;
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
	
	private class FuncionListener implements MouseListener{


		@Override
		public void mouseClicked(MouseEvent e) {
			showSearch();
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
