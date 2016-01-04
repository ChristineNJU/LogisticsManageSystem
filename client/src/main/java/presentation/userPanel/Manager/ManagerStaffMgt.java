package presentation.userPanel.Manager;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumnModel;

import presentation.components.ButtonNew;
import presentation.components.FlatComboBox;
import presentation.factory.TableFactory;
import presentation.factory.TableModelFactory;
import presentation.frame.MainFrame;
import presentation.main.FunctionADUS;
import presentation.main.Translater;
import presentation.table.ScrollPaneTable;
import presentation.table.TableADUS;
import presentation.table.TableModelADUS;
import presentation.userPanel.Manager.ManagerInstitutionMgt.ErrorListener;
import State.AddState;
import State.DeleteState;
import State.ErrorState;
import State.UpdateState;
import VO.StaffVO;
import businesslogic.Impl.Manage.ManageStaff;
import businesslogic.Service.Manage.ManageStaffService;

public class ManagerStaffMgt extends FunctionADUS{
	ManageStaffService service=new ManageStaff();
	ArrayList<StaffVO> staffs;
	
	
	ArrayList<StaffVO> addItems=new ArrayList<StaffVO>();
	ArrayList<StaffVO> deleteItems=new ArrayList<StaffVO>();
	ArrayList<StaffVO> searchItems=new ArrayList<StaffVO>();
	ArrayList<StaffVO> updateItems=new ArrayList<StaffVO>();
			
	NavigationManager nav;
	
	public ManagerStaffMgt(NavigationManager nav){
//		nav = navigationManager;
		buttonNew = new ButtonNew("新增员工");
		
		this.nav = nav;
		initUI("员工管理");
	}
	
	@Override
	protected void initTable() {
		System.out.println("staff manage");
		staffs=new ArrayList<StaffVO>();
		staffs=service.searchStaff("%%");
		if(staffs!=null){
			
			tableV = getVector(staffs);
		}
		else {
			tableV=new Vector<Vector<String>>();
			super.isConnectError=true;
		}
//      System.out.println(staffs.size());
        model = TableModelFactory.getStaffMgtModel(tableV);
		table = TableFactory.getStaffTable(model);
		
	
       table.addMouseListener(tableListener);
		sPanel = new ScrollPaneTable(table);
		panel.add(sPanel);
		
		ErrorListener errorListener = new ErrorListener();
		model.addTableModelListener(errorListener);
//		if(staffs.isEmpty()){
//			showError("Connect Error");
//		}
	}

	
	@Override
	protected void showSearchResult(String s) {
		// TODO Auto-generated method stub
		staffs=new ArrayList<StaffVO>();
		searchItems=service.searchStaff(s);
		model = TableModelFactory.getStaffMgtModel(tableV);
		table.setModel(model);
		table.repaint();
	}

	@Override
	public void performConfirm() {
		deleteItems=new ArrayList<StaffVO>();
		for(int i=0;i<tableV.size();i++){
			if(model.isDelete(i)){
				deleteItems.add(getVO(tableV.get(i)));
			}
		}
		DeleteState deleteState=DeleteState.SUCCESS;
		for(int i=0;i<deleteItems.size();i++){
			deleteState=service.DeleteStaff(deleteItems.get(i));
			if(deleteState==DeleteState.FAIL){
				showError(ErrorState.DELETEERROR);
			}
			else if(deleteState==DeleteState.CONNECTERROR){
				showError(ErrorState.CONNECTERROR);
				break;
			}
		}
		
		updateItems=new ArrayList<StaffVO>();
		for(int i=0;i<tableV.size();i++){
			if(model.isUpdate(i)){
				updateItems.add(getVO(tableV.get(i)));
			}
		}
		UpdateState updateState=UpdateState.SUCCESS;
		for(int i=0;i<updateItems.size();i++){
			updateState=service.updateStaff(updateItems.get(i));
			if(updateState==UpdateState.NOTFOUND){
				showError(ErrorState.UPDATEERROR);
			}
			else if(updateState==UpdateState.CONNECTERROR){
				showError(ErrorState.CONNECTERROR);
				break;
			}
		}
		
		addItems=new ArrayList<StaffVO>();
		for(int i=0;i<tableV.size();i++){
			if(model.isNew(i)){
				addItems.add(getVO(tableV.get(i)));
			}
		}
		AddState addState=AddState.SUCCESS;
		for(int i=0;i<addItems.size();i++){
			addState=service.addStaff(addItems.get(i));
			if(addState==AddState.FAIL){
				showError(ErrorState.ADDERROR);
			}
			else if(addState==AddState.CONNECTERROR){
				showError(ErrorState.CONNECTERROR);
				break;
			}
		}
		
		if(deleteState==DeleteState.SUCCESS&&updateState==UpdateState.SUCCESS
				&&addState==AddState.SUCCESS){
			nav.changeTask(2);
		}
	}
	
	protected void newItem() {
		model.addEmptyRow();
		 int lastIndex = table.getRowCount()-1;
         table.changeSelection(lastIndex, 0,false,false);
	}

	public boolean isConnectError(){
		return super.isConnectError;
	}

	@Override
	protected StaffVO getVO(Vector<String> vector) {
		// TODO Auto-generated method stub
		StaffVO staff=new StaffVO(vector.get(1).trim(),vector.get(2).trim(),Integer.parseInt(vector.get(3).trim()),Translater.getInstitutionType(vector.get(4).trim())
				,Translater.getUserRole(vector.get(5).trim()),vector.get(0).trim(),vector.get(6).trim(),vector.get(7).trim());
		return staff;
	}
	
	protected Vector<Vector<String>> getVector(ArrayList<StaffVO> voList){
		Vector<Vector<String>> result=new Vector<Vector<String>>();
		for(StaffVO temp:voList){
			System.out.println(temp.getInsitution());
			Vector<String> vRow=new Vector<String>();
			vRow.add(temp.getSystemId());
			vRow.add(temp.getName());
			vRow.add(temp.getSex());
			vRow.add(String.valueOf(temp.getAge()));
//			System.out.println(temp.getInsitution());
			
			vRow.add(Translater.getChineseForInstitution(temp.getInsitution()));
//			vRow.add("businesslobby");
			vRow.add(Translater.getChineseForUserRole(temp.getPosition()));
			vRow.add(temp.getCity());
			vRow.add(temp.getPassword());
			result.add(vRow);
		}
		return result;
	}

	@Override
	public void performCancel() {
		System.out.println("in managerStaffMgt");
		MainFrame.changeContentPanel(new ManagerStaffMgt(nav).getPanel());
		
	}
	
	class ErrorListener implements TableModelListener {

		@Override
		public void tableChanged(TableModelEvent e) {
			int row = e.getLastRow();
			int column = e.getColumn();
			
//			System.out.println("tableChanger"+row+" "+column);
			
			boolean isLeagel = true;
			
			if(column==-1){
				buttonNew.setEnabled(true);
				confirm.setEnabled(true);
			}else{				
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

}
