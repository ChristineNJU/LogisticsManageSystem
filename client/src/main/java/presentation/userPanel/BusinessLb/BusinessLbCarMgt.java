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
	ArrayList<CarInfoVO> cars;
	
	String[] tableH = {"车辆编号","车辆牌照","运营时间"};
	boolean[] isCellEditable = {true,true,true};
	
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
	
	
	@Override
	protected void initTable() {
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
		
		addDeleteColumn();
	    
	    table.addMouseListener(tableListener);
		sPanel = new ScrollPaneTable(table);
		panel.add(sPanel);
	}

	
	@Override
	protected void showSearchResult(String s) {
		

		cars=new ArrayList<CarInfoVO>();
		
		CarInfoVO car1=new CarInfoVO("025001001", "苏B 025E2", 2);
		CarInfoVO car2=new CarInfoVO("025001001", "苏B 025F2", 1);
		CarInfoVO car3=new CarInfoVO("025001001", "苏B 025C4", 3);
		
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		
		tableV = getVector(cars);
        
        model = new TableModelADUS(tableV, tableH,isCellEditable);
		table.setModel(model);
		addDeleteColumn();
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

}
