package presentation.userPanel.BusinessLb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import presentation.components.ButtonNew;
import presentation.factory.TableFactory;
import presentation.factory.TableModelFactory;
import presentation.frame.MainFrame;
import presentation.main.FunctionADUS;
import presentation.table.ScrollPaneTable;
import State.AddState;
import State.DeleteState;
import State.ErrorState;
import State.UpdateState;
import VO.DriverInfoVO;
import businesslogic.Impl.Businesslobby.DriverMgt;
import businesslogic.Service.BusinessLobby.DriverMgtService;

public class BusinessLbDriverMgt extends FunctionADUS{
	DriverMgtService service=new DriverMgt();
	
	ArrayList<DriverInfoVO> drivers;
	
	ArrayList<DriverInfoVO> addItems=new ArrayList<DriverInfoVO>();
	ArrayList<DriverInfoVO> deleteItems=new ArrayList<DriverInfoVO>();
	ArrayList<DriverInfoVO> searchItems=new ArrayList<DriverInfoVO>();
	ArrayList<DriverInfoVO> updateItems=new ArrayList<DriverInfoVO>();
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	public BusinessLbDriverMgt(){
		buttonNew = new ButtonNew("新增司机");
		initUI("司机管理");
	}
	
	@Override
	protected void initTable() {
		// TODO Auto-generated method stub
		drivers=new ArrayList<DriverInfoVO>();
		
		
		drivers=service.searchDriver("%%");
		System.out.println(drivers.size());

	//need to be changed
		if(drivers!=null){
			tableV = getVector(drivers);
		}
		else if(drivers==null){
			tableV=new Vector<Vector<String>>();
			super.isConnectError=true;
		}
        model = TableModelFactory.getDriverMgtModel(tableV);
		table = TableFactory.getDriverMgtTable(model);
		
	    table.addMouseListener(tableListener);
		sPanel = new ScrollPaneTable(table);
		panel.add(sPanel);
		
		ErrorListener errorListener = new ErrorListener();
		model.addTableModelListener(errorListener);
	}

	@Override
	protected void showSearchResult(String s) {
		// TODO Auto-generated method stub
		drivers=new ArrayList<DriverInfoVO>();
		searchItems = service.searchDriver(s);
//		System.out.println("arraylist size"+searchItems.size());
//		System.out.println("   "+getVector(searchItems).size());
		model = TableModelFactory.getDriverMgtModel(getVector(searchItems));
		table.setModel(model);
		table.repaint();
	}

	@Override
	public void performConfirm() {
		// TODO Auto-generated method stub
		deleteItems=new ArrayList<DriverInfoVO>();
		for(int i=0;i<tableV.size();i++){
			if(model.isDelete(i)){
				deleteItems.add((DriverInfoVO) getVO(tableV.get(i)));
			}
		}
		DeleteState deleteState=DeleteState.FAIL;
		for(int i=0;i<deleteItems.size();i++){
			deleteState=service.deleteDriver(deleteItems.get(i));
			if(deleteState==DeleteState.FAIL){
				showError(ErrorState.DELETEERROR);
				break;
			}
			else if(deleteState==DeleteState.CONNECTERROR)
				showError(ErrorState.CONNECTERROR);
				break;
		}
		
		updateItems=new ArrayList<DriverInfoVO>();
		for(int i=0;i<tableV.size();i++){
			if(model.isUpdate(i)){
				updateItems.add((DriverInfoVO) getVO(tableV.get(i)));
			}
		}
		UpdateState updateState=UpdateState.NOTFOUND;
		for(int i=0;i<updateItems.size();i++){
			updateState=service.updateDriver(updateItems.get(i));
			if(updateState==UpdateState.NOTFOUND){
				showError(ErrorState.UPDATEERROR);
				break;
			}
			else if(updateState==UpdateState.CONNECTERROR){
				showError(ErrorState.CONNECTERROR);
				break;
			}
		}
		
		addItems=new ArrayList<DriverInfoVO>();
		for(int i=0;i<tableV.size();i++){
			if(model.isNew(i)){
				addItems.add(getVO(tableV.get(i)));
				}
		}
		AddState addState=AddState.FAIL;
		System.out.println("addList size"+addItems.size());
		for(int i=0;i<addItems.size();i++){
			addState=service.addDriver(addItems.get(i));
			if(addState==AddState.FAIL){
				showError(ErrorState.ADDERROR);
				break;
			}
			else if(addState==AddState.CONNECTERROR){
				showError(ErrorState.CONNECTERROR);
				break;
			}
		}
		
		MainFrame.changeContentPanel(new BusinessLbDriverMgt().getPanel());
	}
	
//	protected void solveDelete(int rowUnderMouse) {
//		model.delete(rowUnderMouse);
//		table.repaint();
//	}
	
	protected void newItem() {
		model.addEmptyRow();
		 int lastIndex = table.getRowCount()-1;
         table.changeSelection(lastIndex, 0,false,false);
	}


	@Override
	protected DriverInfoVO getVO(Vector<String> vector) {
		// TODO Auto-generated method stub
		DriverInfoVO driver=null;
		try {
			driver=new DriverInfoVO(vector.get(0).trim(),vector.get(1).trim(),sdf.parse(vector.get(2).trim()), 
					vector.get(3).trim(),vector.get(4).trim(),vector.get(5).trim(),Integer.parseInt(vector.get(6).trim()));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(driver==null){
			System.out.println("get null VO");
		}
		return driver;
	}

	protected Vector<Vector<String>> getVector(ArrayList<DriverInfoVO> voList){
		Vector<Vector<String>> result=new Vector<Vector<String>>();
		for(DriverInfoVO temp:voList){
			Vector<String> vRow=new Vector<String>();
			vRow.add(temp.getNumber());
			vRow.add(temp.getName());
			vRow.add(sdf.format(temp.getBirthday()));
			vRow.add(temp.getId());
			vRow.add(temp.getMobilephone());
			vRow.add(temp.getSex());
			vRow.add(String.valueOf(temp.getAttendTime()));
			
			result.add(vRow);
		}
		return result;
	}

	@Override
	public void performCancel() {
		MainFrame.changeContentPanel(new BusinessLbDriverMgt().getPanel());
		
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
