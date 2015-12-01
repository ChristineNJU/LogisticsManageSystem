package presentation.userPanel.Courier;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import State.LogisticsType;
import State.PackingCharge;
import VO.LogisticsInputVO;
import VO.UserVO;
import businesslogic.Impl.Courier.CourierController;
import businesslogic.Service.Courier.CourierService;
import presentation.components.ButtonCancel;
import presentation.components.ButtonNew;
import presentation.components.ButtonOk;
import presentation.components.ButtonTotal;
import presentation.components.PanelContent;
import presentation.components.RendererDelete;
import presentation.components.RendererReviseLogistics;
import presentation.components.ScrollPaneTable;
import presentation.components.TableAddOnly;
import presentation.components.TableModelAddOnly;
import presentation.main.Translater;

/**
 * 快递员新建快递单的列表
 * 
 * @author 张馨中
 * @version 1.0.0
 * */
public class CourierNewOrder{

	CourierService service = new CourierController();
	Translater trans = new Translater();
	ArrayList<LogisticsInputVO> logistics = new ArrayList<LogisticsInputVO>();
	
	private PanelContent panel = new PanelContent("创建快递单");
	
	private ButtonNew buttonNew = new ButtonNew("添加新订单");
	
	private TableListener tableListener = new TableListener();
	private FuncionListener functionListener = new FuncionListener();
	
	String[] tableH = {"快递单号","出发地","目的地","内件品名","体积","重量","费用合计"};
	boolean[] isCellEditable = {false,false,false,false,false,false,false};
	Vector<Vector<String>> tableV = new Vector<Vector<String>>();
	private TableModelAddOnly model;
	private TableAddOnly table;
	private ScrollPaneTable sPanel;
	
	private ButtonOk confirm = new ButtonOk("提交所有订单");
	private ButtonCancel cancel = new ButtonCancel();
//	String[] city = {"南京","北京","上海","广州"};
	
	
	public CourierNewOrder(){
		initUI();
	}
	
	protected void initUI() {
		panel.setLayout(null);
		
		buttonNew.setBounds(762,110,110,30);
		buttonNew.addMouseListener(functionListener);
		panel.add(buttonNew);
		
		initTable();
		
		confirm.setBounds(120,175+sPanel.getHeight(),160,30);
		confirm.addMouseListener(tableListener);
		panel.add(confirm);
		
		cancel.setBounds(295,175+sPanel.getHeight(),110,30);
		cancel.addMouseListener(tableListener);
		panel.add(cancel);
	}
	
	ArrayList<UserVO> users;
	protected void initTable() {
		Date sendDate = new Date();
		LogisticsInputVO temp = new LogisticsInputVO("黄勇","南京大学仙林校区","南京大学保卫处","13954565789","13984562125",
				"女朋友","南航江宁校区","南航","12345678936","12345678936",
				"0000000001",1,1,1,"台灯",LogisticsType.ECONOMIC,PackingCharge.COURISE_BAG,7.6,"南京","南京",
				new Date(),new Date(),"张斯栋");
		logistics.add(temp);
		logistics.add(temp);
		logistics.add(temp);
		tableV = getVector(logistics);
		
		model = new TableModelAddOnly(tableV,tableH,isCellEditable);
		table = new TableAddOnly(model);
		
		TableColumnModel tcm = table.getColumnModel();
		tcm.addColumn(new TableColumn());
		tcm.getColumn(tcm.getColumnCount()-1).setCellRenderer(new RendererDelete());
		tcm.getColumn(tcm.getColumnCount()-1).setPreferredWidth(40);
		
//		tcm.getColumn(tcm.getColumnCount()).setCellRenderer(new RendererReviseLogistics());
		
		table.addMouseListener(tableListener);
		
		sPanel = new ScrollPaneTable(table);
		
		panel.add(sPanel);
	}
	


	private Vector<Vector<String>> getVector(ArrayList<LogisticsInputVO> logistics) {
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		for(LogisticsInputVO temp:logistics){
//			System.out.println("int GetVector method");
			Vector<String> vRow = new Vector<String>();
			vRow.add(temp.getBar_code());
			vRow.add(temp.getStarting());
			vRow.add(temp.getDestination());
			vRow.add(temp.getInternal_name());
			vRow.add(temp.getSize()+"");
			vRow.add(temp.getWeight()+"");
			vRow.add(temp.getTotal_cost()+"");
			result.add(vRow);
			
		}
		return result;
	}
	
	
	protected void confirm() {
		// TODO 提交所有的快递信息
		
	}
	
	
	protected void solveDelete(int i) {
		model.delete(i);
		logistics.remove(i);
	}
	
	protected void solveRevise(int i){
		//TODO 修改已填的快递信息
	}

	protected void newItem() {
		// TODO 新增快递，弹出dialog，返回值可为VO
		
	}


//	protected VO getVO(Vector<String> vector) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	public class TableListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			Point p = table.getMousePosition();
			int row = table.rowAtPoint(p);
			int column = table.columnAtPoint(p);
			System.out.println("position clicked :   row"+row+"   column"+column);
			if(column == table.getColumnCount() -2){
				solveDelete(row);
			}
			if(column == table.getColumnCount() -1){
				solveRevise(row);
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
	
	public class FuncionListener implements MouseListener{


		@Override
		public void mouseClicked(MouseEvent e) {
			ButtonTotal source = (ButtonTotal)e.getSource();
			if(source.equals(buttonNew)){
				newItem();
			}
			if(source.equals(confirm)){
				confirm();
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

	public JPanel getPanel() {
		return panel;
	}

}
