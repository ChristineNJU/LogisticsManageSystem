package presentation.userPanel.Manager;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.components.FlatScrollPane;
import presentation.components.PanelContent;
import presentation.main.ColorPallet;
import presentation.main.FontSet;
import presentation.table.TableADUS;
import presentation.table.TableModelADUS;
import VO.ConstVO;
import VO.DistanceVO;
import businesslogic.Impl.Manage.ManageController;
import businesslogic.Service.Manage.ManageService;

public class ManagerConst {
	
	ManageService ms = new ManageController();
	
	private PanelContent panel = new PanelContent("常量制定");
	private OtherConstPanel other;
	private DistanceConstPanel distance;
	public ManagerConst() {
		init();
	}
	
	private void init() {
		panel.setLayout(null);
		
		other = new OtherConstPanel();
		distance = new DistanceConstPanel();
		panel.add(other);
		panel.add(distance);
	}
	
	public JPanel getPanel() {
		return panel;
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
		
		String[] header = {"城市1", "城市2", "距离"};
		boolean[] isCellEditable = {false, false, true};
		
		public DistanceConstPanel() {
			// TODO Auto-generated constructor stub
			init();
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
				
				scrollPane = new FlatScrollPane(table);
				scrollPane.setBounds(0, 30, 600, 210);
				
				add(scrollPane);
			}
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
				result.add(vRow);
			}
			return result;
		}
		
		DistanceVO getVO(Vector<String> vector) {
			DistanceVO di = new DistanceVO(vector.get(0), vector.get(1), Double.parseDouble(vector.get(2)));
			return di;
		}
	}
}
