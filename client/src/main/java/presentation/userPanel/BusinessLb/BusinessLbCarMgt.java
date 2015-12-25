package presentation.userPanel.BusinessLb;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import presentation.components.ButtonNew;
import presentation.components.PanelContent;
import presentation.factory.TableFactory;
import presentation.factory.TableModelFactory;
import presentation.frame.MainFrame;
import presentation.main.FunctionADUS;
import presentation.table.ScrollPaneTable;
import State.AddState;
import State.DeleteState;
import State.ErrorState;
import State.UpdateState;
import VO.CarInfoVO;
import businesslogic.Impl.Businesslobby.CarMgt;

public class BusinessLbCarMgt  extends FunctionADUS{
	CarMgt service=new CarMgt();
	ArrayList<CarInfoVO> cars;
	
	
	
	private ArrayList<CarInfoVO> addCar=new ArrayList<CarInfoVO>();
	private ArrayList<CarInfoVO> deleteCar=new ArrayList<CarInfoVO>();
	private ArrayList<CarInfoVO> searchCar=new ArrayList<CarInfoVO>();
	private ArrayList<CarInfoVO> updateCar=new ArrayList<CarInfoVO>();
	
	public BusinessLbCarMgt(){
		buttonNew = new ButtonNew("新增车辆");
		initUI("车辆管理");
	}
	
	
	@Override
	protected void initTable() {
		cars=new ArrayList<CarInfoVO>();
		
		cars=service.searchCar("%%");
		
		if(cars!=null){
			tableV = getVector(cars);
		}
		else {
			tableV=new Vector<Vector<String>>();
			super.isConnectError=true;
		}
//		CarInfoVO car1=new CarInfoVO("025001001", "苏A 025E2", 2);
//		CarInfoVO car2=new CarInfoVO("025001001", "苏A 025F2", 1);
//		CarInfoVO car3=new CarInfoVO("025001001", "苏A 025C4", 3);
//		
//		cars.add(car1);
//		cars.add(car2);
//		cars.add(car3);
//		tableV = getVector(cars);
        
        model = TableModelFactory.getCarMgtModel(tableV);
		table = TableFactory.getCarMgtTable(model);
	    
	    table.addMouseListener(tableListener);
		sPanel = new ScrollPaneTable(table);
		panel.add(sPanel);
		
		ErrorListener errorListener = new ErrorListener();
		model.addTableModelListener(errorListener);
	}

	
	@Override
	protected void showSearchResult(String s) {
		
		searchCar = service.searchCar(s);
		if(searchCar!=null){
			model = TableModelFactory.getCarMgtModel(getVector(searchCar));
			table.setModel(model);
		}
		else {
			showError(ErrorState.CONNECTERROR);
			searchCar=new ArrayList<CarInfoVO>();
			model =TableModelFactory.getCarMgtModel(getVector(searchCar));
			table.setModel(model);
		}
	}

	

	@Override
	public void performConfirm() {
		DeleteState deleteState=DeleteState.CONNECTERROR;
		deleteCar=new ArrayList<CarInfoVO>();
		for(int i=0;i<tableV.size();i++){
			if(model.isDelete(i)){
				deleteCar.add((CarInfoVO) getVO(tableV.get(i)));
			}
		}
		for(int i=0;i<deleteCar.size();i++){
			deleteState=service.deleteCar(deleteCar.get(i));
			if(deleteState==DeleteState.CONNECTERROR){
				showError(ErrorState.CONNECTERROR);
				break;
			}
			else if(deleteState==DeleteState.FAIL){
				showError(ErrorState.DELETEERROR);
				break;
			}
		}
		System.out.println("Delete CarInfo confirm");
		
		UpdateState updateState=UpdateState.CONNECTERROR;
		updateCar=new ArrayList<CarInfoVO>();
		for(int i=0;i<tableV.size();i++){
			if(model.isUpdate(i)){
				updateCar.add((CarInfoVO) getVO(tableV.get(i)));
			}
		}
		for(int i=0;i<updateCar.size();i++){
			updateState=service.updateCar(updateCar.get(i));
			if(updateState==UpdateState.CONNECTERROR){
				showError(ErrorState.CONNECTERROR);
				break;
			}
			else if(updateState==UpdateState.NOTFOUND){
				showError(ErrorState.UPDATEERROR);
				break;
			}
		}
		
		AddState addState=AddState.CONNECTERROR;
		addCar=new ArrayList<CarInfoVO>();
		for(int i=0;i<tableV.size();i++){
			if(model.isNew(i)){
				addCar.add(getVO(tableV.get(i)));
			}
		}
		for(int i=0;i<addCar.size();i++){
			addState=service.addCar(addCar.get(i));
			if(addState==AddState.CONNECTERROR){
				showError(ErrorState.CONNECTERROR);
				break;
			}
			else if(addState==AddState.FAIL){
				showError(ErrorState.ADDERROR);
				break;
			}
		}
		
		MainFrame.changeContentPanel(new BusinessLbCarMgt().getPanel());
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


	@Override
	public void performCancel() {
		MainFrame.changeContentPanel(new BusinessLbCarMgt().getPanel());
	}
	
	class ErrorListener implements TableModelListener {

		@Override
		public void tableChanged(TableModelEvent e) {
			int row = e.getLastRow();
			int column = e.getColumn();
			boolean isLeagel = true;
			String content = model.getValueAt(row, column);
			if(content.equals("")){
				model.setLeagel(row, column, false);
				buttonNew.setEnabled(false);
				confirm.setEnabled(false);
				return;
			}else{
				model.setLeagel(row, column, true);
			}
			if(model.allLeagel()){
				buttonNew.setEnabled(true);
				confirm.setEnabled(true);
			}
		}
	}
}
