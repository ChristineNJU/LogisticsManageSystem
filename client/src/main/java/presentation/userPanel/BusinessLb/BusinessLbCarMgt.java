package presentation.userPanel.BusinessLb;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JLabel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import VO.CarInfoVO;
import businesslogic.Impl.Businesslobby.CarMgt;
import presentation.components.ButtonCancel;
import presentation.components.ButtonNew;
import presentation.components.ButtonOk;
import presentation.components.ButtonSearch;
import presentation.components.ButtonTotal;
import presentation.components.PanelContent;
import presentation.components.TextField;
import presentation.main.ColorPallet;
import presentation.main.FontSet;
import presentation.main.FunctionADUS;
import presentation.main.Translater;
import presentation.table.RendererDelete;
import presentation.table.ScrollPaneTable;
import presentation.table.TableADUS;
import presentation.table.TableModelADUS;

public class BusinessLbCarMgt  extends FunctionADUS{
	CarMgt service=new CarMgt();
	Translater trans = new Translater();
	ArrayList<CarInfoVO> cars;
	
	private PanelContent panel = new PanelContent("车辆管理");
	private TextField input = new TextField();
	private ButtonSearch search = new ButtonSearch();
	private ButtonNew buttonNew = new ButtonNew("新增车辆");
	private ButtonOk confirmUp = new ButtonOk("提交修改");
	
	String[] tableH = {"车辆编号","车辆牌照","运营时间"};
	boolean[] isCellEditable = {true,true,true};
	Vector<Vector<String>> tableV = new Vector<Vector<String>>();
	
	private TableModelADUS model;
	private TableADUS table;
	private ScrollPaneTable sPanel;
	
	private ButtonOk confirmDown = new ButtonOk("提交修改");
	private ButtonCancel cancel = new ButtonCancel();
	TextField Number=new TextField();
	TextField certification=new TextField();
	TextField Time=new TextField();
	
	private ArrayList<CarInfoVO> addCar=new ArrayList<CarInfoVO>();
	private ArrayList<CarInfoVO> deleteCar=new ArrayList<CarInfoVO>();
	private ArrayList<CarInfoVO> searchCar=new ArrayList<CarInfoVO>();
	private ArrayList<CarInfoVO> updateCar=new ArrayList<CarInfoVO>();
	
	
	private TableListener tableListener = new TableListener();
	private FuncionListener functionListener = new FuncionListener();
	
	public BusinessLbCarMgt(){
		buttonNew = new ButtonNew("新增车辆");
		initUI("账号管理");
	}
	
//	@Override
//	protected void initUI() {
//		// TODO Auto-generated method stub
//		panel.setLayout(null);
//		input.setBounds(120,110,160,30);
//		panel.add(input);
//		search.setBounds(280,110,60,30);
//		search.addMouseListener(functionListener);
//		panel.add(search);
//		
//		initTable();
//		
//		buttonNew.setFont(FontSet.eighteen);
//		buttonNew.setBounds(762,110,110,30);
//		buttonNew.addMouseListener(functionListener);
//		panel.add(buttonNew);
//		confirmUp.setFont(FontSet.eighteen);
//		confirmUp.setBounds(120,175+sPanel.getHeight(),110,30);
//		confirmUp.addMouseListener(functionListener);
//		panel.add(confirmUp);
//
//	}
	
	@Override
	protected void initTable() {
		//VO Arraylist的初始化（调用search方法）
		

				//初始化model
				//初始化table
				
		//设置编辑器
		
				//增加最后一列删除按钮
				
				//table增加监听
				//新建panel
				//panel。add（jscrollpanel）
	}

	@Override
	protected void showSearchResult(String s) {
		

		cars=new ArrayList<CarInfoVO>();
		
		CarInfoVO car1=new CarInfoVO("025001001", "苏A 025E2", 2);
		CarInfoVO car2=new CarInfoVO("025001001", "苏A 025F2", 1);
		CarInfoVO car3=new CarInfoVO("025001001", "苏A 025C4", 3);
		
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		
		tableV = getVector(cars);
        
        model = new TableModelADUS(tableV, tableH,isCellEditable);
		table = new TableADUS(model);
		
		TableColumnModel tcm = table.getColumnModel(); 
		
		tcm.getColumn(2).setCellEditor(new DefaultCellEditor(Number));
		tcm.getColumn(3).setCellEditor(new DefaultCellEditor(certification));
		tcm.getColumn(4).setCellEditor(new DefaultCellEditor(Time));
		
		tcm.addColumn(new TableColumn());
		tcm.getColumn(5).setCellRenderer(new RendererDelete());
	    tcm.getColumn(5).setPreferredWidth(40);
	    
	    table.addMouseListener(tableListener);
		sPanel = new ScrollPaneTable(table);
		panel.add(sPanel);
		
	}

	

	@Override
	protected void confirmRevise() {
		deleteCar=new ArrayList<CarInfoVO>();
		for(int i=0;i<tableV.size();i++){
			if(model.isDelete(i)){
				deleteCar.add((CarInfoVO) getVO(tableV.get(i)));
			}
		}
		System.out.println("Delete CarInfo confirm");
		
		updateCar=new ArrayList<CarInfoVO>();
		for(int i=0;i<tableV.size();i++){
			if(model.isUpdate(i)){
				updateCar.add((CarInfoVO) getVO(tableV.get(i)));
			}
		}
	}


	@Override
	protected void solveDelete(int rowUnderMouse) {
		model.delete(rowUnderMouse);
		table.repaint();
	}


	@Override
	protected void newItem() {
		model.addEmptyRow();
		 int lastIndex = table.getRowCount()-1;
         table.changeSelection(lastIndex, 0,false,false);
	}
	
	protected Vector<Vector<String>> getVector(ArrayList<CarInfoVO> voList){
		Vector<Vector<String>> result=new Vector<Vector<String>>();
		for(CarInfoVO temp:cars){
			Vector<String> vRow=new Vector<String>();
			vRow.add(temp.getCarNumber());
			vRow.add(temp.getCarLicense());
			vRow.add(String.valueOf(temp.getUseTime()));
			
			result.add(vRow);
		}
		return result;
	}


	@Override
	protected CarInfoVO getVO(Vector<String> vector) {
		CarInfoVO carInfo=new CarInfoVO(vector.get(0),vector.get(1),Integer.parseInt(vector.get(2)));
		return carInfo;
	}
	
	public PanelContent getPanel(){
		return this.panel;
	}
	
	public class FuncionListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			ButtonTotal source = (ButtonTotal)e.getSource();
			if(source.equals(buttonNew)){
				newItem();
			}
			if(source.equals(confirmUp)){
				confirmRevise();
			}
			if(source.equals(search)){
				showSearchResult(input.getText());
			}
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class TableListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			Point p = table.getMousePosition();
			int row = table.rowAtPoint(p);
			int column = table.columnAtPoint(p);
			System.out.println("position clicked :   row"+row+"   column"+column);
			if(column == table.getColumnCount() -1){
				solveDelete(row);
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class Label extends JLabel{
		public Label(String s){
			super(s);
			this.setFont(FontSet.fourteen);
			this.setForeground(ColorPallet.GrayMedium);
			this.setSize(60,30);
		}
	}

}
