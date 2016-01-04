package presentation.userPanel.Manager;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.TableColumnModel;

import presentation.components.ButtonConfirm;
import presentation.components.ButtonTotal;
import presentation.components.FlatScrollPane;
import presentation.components.PanelContent;
import presentation.frame.MainFrame;
import presentation.main.ColorPallet;
import presentation.main.FontSet;
import presentation.main.FunctionADUS.AttentionFrame;
import presentation.table.RendererGeneral;
import presentation.table.TableADUS;
import presentation.table.TableModelADUS;
import State.AddState;
import State.ErrorState;
import State.UpdateState;
import VO.ConstVO;
import VO.DistanceVO;
import businesslogic.Impl.Manage.ManageController;
import businesslogic.Service.Manage.ManageService;

public class ManagerConst {
	
	ManageService ms = new ManageController();
	
	ButtonConfirm confirm;
	
	ArrayList<ConstVO> updateConst = new ArrayList<ConstVO>();
	ArrayList<DistanceVO> updateDistance = new ArrayList<DistanceVO>();
	ArrayList<DistanceVO> addDistance = new ArrayList<DistanceVO>();
	ArrayList<DistanceVO> deleteDistance = new ArrayList<DistanceVO>();
	
	AttentionFrame att;
	
	NavigationManager nav;
	
	private PanelContent panel = new PanelContent("常量制定");
	private OtherConstPanel other;
	private DistanceConstPanel distance;
	public ManagerConst(NavigationManager navigationManager) {
		init();
		
		nav = navigationManager;
	}
	
	private void init() {
		panel.setLayout(null);
		
		confirm = new ButtonConfirm("提交修改");
		confirm.setBounds(587, 50, 100, 30);
		confirm.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				for(int i=0;i<distance.table.getRowCount();i++){
					if(distance.tableModel.isUpdate(i)){
						updateDistance.add(distance.getVO(distance.tableModel.getRow(i)));
					}
					if(distance.tableModel.isNew(i)){
						addDistance.add(distance.getVO(distance.tableModel.getRow(i)));
					}
					if(distance.tableModel.isDelete(i)){
						deleteDistance.add(distance.getVO(distance.tableModel.getRow(i)));
					}
				}
//				System.out.println(updateDistance.size());
				for(int i=0;i<other.table.getRowCount();i++){
					if(other.tableModel.isUpdate(i)){
						updateConst.add(other.getVO(other.tableModel.getRow(i)));
					}
				}
//				System.out.println(updateConst.size());
				
				UpdateState state = UpdateState.SUCCESS;
				for(int i=0;i<updateConst.size();i++){
					state = ms.updateConst(updateConst.get(i));
					if(state==UpdateState.CONNECTERROR){
						
						break;
					}
					
				}
				for(int i=0;i<updateDistance.size();i++){
					state = ms.updateDistance(updateDistance.get(i));
				}
				
				AddState addS = AddState.SUCCESS;
				for(int i=0;i<addDistance.size();i++){
					addS = ms.addDistance(addDistance.get(i));
				}
				
				if(state==UpdateState.SUCCESS&&addS==AddState.SUCCESS){
					nav.changeTask(8);
				}else{
					showError(ErrorState.UPDATEERROR);					
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
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		other = new OtherConstPanel();
		distance = new DistanceConstPanel();
		panel.add(other);
		panel.add(distance);
		panel.add(confirm);
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	public void showError(ErrorState state){
		
		att=new AttentionFrame(state);
//		panel.add(attention);
	}
		
	class OtherConstPanel extends JPanel {
		
		ArrayList<ConstVO> update = new ArrayList<ConstVO>();
		ArrayList<ConstVO> add = new ArrayList<ConstVO>();
		
		TableADUS table;
		TableModelADUS tableModel;
		FlatScrollPane scrollPane;
		
		JLabel label = new JLabel("其他常量", JLabel.LEFT);
		
		String[] title = {"常量名", "常量值"};
		boolean[] isCellEditable = {false, true};
		
		public OtherConstPanel() {
			init();
			initListener();
		}
		
		private void init() {
			setBounds(87, 400, 600, 240);
			setLayout(null);
			
			label.setBounds(0, 0, 100, 30);
			label.setFont(FontSet.twenty);
			label.setForeground(Color.white);
			label.setOpaque(true);
			label.setBackground(ColorPallet.Purple);
			add(label);
			
			ArrayList<ConstVO> con = ms.showConst();
			if(con.isEmpty()){
				
			}else{				
				tableModel = new TableModelADUS(getVector(con), title, isCellEditable);
				table = new TableADUS(tableModel);
				TableColumnModel tcm = table.getColumnModel();
				tcm.getColumn(tcm.getColumnCount()-1).setCellRenderer(new RendererGeneral());
				scrollPane = new FlatScrollPane(table);
				scrollPane.setBounds(0, 30, 600, 210);
				add(scrollPane);
			}
		}
		
		private void initListener() {
			
		}
		
		public void paint(Graphics g) {
			Color old = g.getColor();
			
			g.setColor(ColorPallet.Purple);
			g.fillRect(0, 0, 600, 30);
			
			g.setColor(old);			
			super.paintComponents(g);
		}
		
		Vector<Vector<String>> getVector(ArrayList<ConstVO> voList){
			Vector<Vector<String>> result=new Vector<Vector<String>>();
			for(ConstVO co: voList){
				Vector<String> vRow=new Vector<String>();
				vRow.add(co.getName());
				vRow.add(co.getValue()+"");
				
				result.add(vRow);
			}
			return result;
		}
		
		ConstVO getVO(Vector<String> vector) {
			ConstVO co = new ConstVO(vector.get(0), Double.parseDouble(vector.get(1)));
			return co;
		}	
	}

	class DistanceConstPanel extends JPanel {
		
		TableADUS table;
		TableModelADUS tableModel;
		
		JLabel title = new JLabel("城市距离", JLabel.LEFT);
		FlatScrollPane scrollPane;
		
		String[] header = {"城市1", "城市2", "距离", " "};
		boolean[] isCellEditable = {false, false, true, false};
		
		ButtonConfirm addCity = new ButtonConfirm("新增城市");
		
		public DistanceConstPanel() {
			// TODO Auto-generated constructor stub
			init();
			
			addCity.addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
//					tableModel.addEmptyRow();
					newItem();
//					table.repaint();
//					scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum()+1);
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
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
		}
		
		private void init() {
			setLayout(null);
			setBounds(87, 100, 600, 240);
			
			title.setBounds(0, 0, 100, 30);
			title.setFont(FontSet.twenty);
			title.setForeground(Color.white);
			add(title);
			
			ArrayList<DistanceVO> distance = ms.getDistance();
			
			if(distance.isEmpty()){
				
			}else{				
				tableModel = new TableModelADUS(getVector(distance), header, isCellEditable);
				table = new TableADUS(tableModel);
//				TableColumnModel tcm = table.getColumnModel();
//				tcm.getColumn(tcm.getColumnCount()-1).setCellRenderer(new RendererGeneral());
				
				table.addMouseListener(new TableListener());
				
				scrollPane = new FlatScrollPane(table);
				scrollPane.setBounds(0, 30, 600, 210);
				
				add(scrollPane);
			}
			
			addCity.setBounds(450, 0, addCity.getWidth(), addCity.getHeight());
//			addCity.setLocation(x, y);
			add(addCity);
		}
		
		protected void newItem() {
			tableModel.addEmptyRow();
			 int lastIndex = table.getRowCount()-1;
	         table.changeSelection(lastIndex, 0,false,false);
		}
		
		public void paint(Graphics g) {
			Color old = g.getColor();
			
			g.setColor(ColorPallet.Purple);
			g.fillRect(0, 0, 600, 30);
			
			g.setColor(old);	
			super.paintComponents(g);;
		}
		
		Vector<Vector<String>> getVector(ArrayList<DistanceVO> voList){
			Vector<Vector<String>> result=new Vector<Vector<String>>();
			for(DistanceVO di: voList){
				Vector<String> vRow=new Vector<String>();
				vRow.add(di.getCity_1());
				vRow.add(di.getCity_2());
				vRow.add(di.getDistance()+"");
				vRow.add("");
				result.add(vRow);
			}
			return result;
		}
		
		DistanceVO getVO(Vector<String> vector) {
			DistanceVO di = new DistanceVO(vector.get(0), vector.get(1), Double.parseDouble(vector.get(2)));
			return di;
		}
		
		protected void solveDelete(int rowUnderMouse){
			tableModel.delete(rowUnderMouse);
			table.repaint();
		}
		
		public class TableListener implements MouseListener{

			@Override
			public void mouseClicked(MouseEvent e) {
				Point p = table.getMousePosition();
				int row = table.rowAtPoint(p);
				int column = table.columnAtPoint(p);
//				System.out.println("position clicked :   row"+row+"   column"+column);
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
			try {
//				System.out.println("staff error thread");
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
}
