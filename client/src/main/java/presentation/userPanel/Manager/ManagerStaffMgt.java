package presentation.userPanel.Manager;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.TableColumnModel;

import presentation.components.ButtonNew;
import presentation.components.FlatComboBox;
import presentation.frame.MainFrame;
import presentation.main.FunctionADUS;
import presentation.main.Translater;
import presentation.table.ScrollPaneTable;
import presentation.table.TableADUS;
import presentation.table.TableModelADUS;
import presentation.userPanel.BusinessLb.BusinessLbCarMgt;
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
	
	String[] tableH = {"员工ID","员工姓名","员工性别","员工年龄","员工机构","员工职责","员工所在地","员工密码"};
	boolean[] isCellEditable = {false,true,true,true,true,true,true,true};
	
	ArrayList<StaffVO> addItems=new ArrayList<StaffVO>();
	ArrayList<StaffVO> deleteItems=new ArrayList<StaffVO>();
	ArrayList<StaffVO> searchItems=new ArrayList<StaffVO>();
	ArrayList<StaffVO> updateItems=new ArrayList<StaffVO>();
			
	NavigationManager nav;
	
	public ManagerStaffMgt(){
//		nav = navigationManager;
		buttonNew = new ButtonNew("新增员工");
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
        model = new TableModelADUS(tableV, tableH,isCellEditable);
		table = new TableADUS(model);
		
		TableColumnModel tcm = table.getColumnModel(); 
	    String[] gender = {"男","女"}; 
	    JComboBox  genderC = new FlatComboBox(gender); 
	    tcm.getColumn(2).setCellEditor(new DefaultCellEditor(genderC));
	    
	    String[] age = new String[42];
		 for(int i = 0;i < age.length;i++)
	        	age[i] = i+18+"";
       JComboBox ageC = new FlatComboBox(age);  
       tcm.getColumn(3).setCellEditor(new DefaultCellEditor(ageC));
       
       String[] institution = {"营业厅","中转中心","仓库","总部"};
		JComboBox institutionC = new FlatComboBox(institution);  
       tcm.getColumn(4).setCellEditor(new DefaultCellEditor(institutionC));
       
       String[] position = {"管理员","营业厅业务员","快递员","财务人员","总经理","中转中心业务员","仓库管理员"}; 
		JComboBox positionC = new FlatComboBox(position);  
       tcm.getColumn(5).setCellEditor(new DefaultCellEditor(positionC)); 

		String[] city = {"南京","北京","上海","广州"};
	   JComboBox  cityC = new FlatComboBox(city);  
       tcm.getColumn(6).setCellEditor(new DefaultCellEditor(cityC));
       
       table.addMouseListener(tableListener);
		sPanel = new ScrollPaneTable(table);
		panel.add(sPanel);
		
       addDeleteColumn();
		
		
//		if(staffs.isEmpty()){
//			showError("Connect Error");
//		}
	}

	
	@Override
	protected void showSearchResult(String s) {
		// TODO Auto-generated method stub
		staffs=new ArrayList<StaffVO>();
		searchItems=service.searchStaff(s);
		model = new TableModelADUS(getVector(searchItems),tableH,isCellEditable);
		table.setModel(model);
		table.repaint();
	}

	@Override
	public void performConfirm() {
		// TODO Auto-generated method stub
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
		MainFrame.changeContentPanel(new ManagerStaffMgt().getPanel());
		
	}

}
