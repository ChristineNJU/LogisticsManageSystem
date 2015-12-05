package presentation.userPanel.Manager;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.table.TableColumnModel;

import presentation.components.ButtonNew;
import presentation.components.FlatComboBox;
import presentation.main.FunctionADUS;
import presentation.main.Translater;
import presentation.table.ScrollPaneTable;
import presentation.table.TableADUS;
import presentation.table.TableModelADUS;
import State.AddState;
import State.DeleteState;
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
			
	public ManagerStaffMgt(){
		buttonNew = new ButtonNew("新增员工");
		initUI("员工管理");
	}
	
	@Override
	protected void initTable() {
		// TODO Auto-generated method stub
		System.out.println("staff manage");
		staffs=new ArrayList<StaffVO>();
		staffs=service.searchStaff("%%");
		tableV = getVector(staffs);
        System.out.println(staffs.size());
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
       
       addDeleteColumn();
	    
	   table.addMouseListener(tableListener);
	   sPanel = new ScrollPaneTable(table);
	   panel.add(sPanel);
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
	protected void confirmRevise() {
		// TODO Auto-generated method stub
		deleteItems=new ArrayList<StaffVO>();
		for(int i=0;i<tableV.size();i++){
			if(model.isDelete(i)){
				deleteItems.add(getVO(tableV.get(i)));
			}
		}
		DeleteState deleteState=DeleteState.FAIL;
		for(int i=0;i<deleteItems.size();i++){
			deleteState=service.DeleteStaff(deleteItems.get(i));
			if(deleteState==DeleteState.FAIL){
				break;
			}
			else if(deleteState==DeleteState.CONNECTERROR){
				break;
			}
		}
		
		updateItems=new ArrayList<StaffVO>();
		for(int i=0;i<tableV.size();i++){
			if(model.isUpdate(i)){
				updateItems.add(getVO(tableV.get(i)));
			}
		}
		UpdateState updateState=UpdateState.NOTFOUND;
		for(int i=0;i<updateItems.size();i++){
			updateState=service.updateStaff(updateItems.get(i));
			if(updateState==UpdateState.NOTFOUND){
				break;
			}
			else if(updateState==UpdateState.CONNECTERROR){
				break;
			}
		}
		
		addItems=new ArrayList<StaffVO>();
		for(int i=0;i<tableV.size();i++){
			if(model.isNew(i)){
				addItems.add(getVO(tableV.get(i)));
			}
		}
		AddState addState=AddState.FAIL;
		for(int i=0;i<addItems.size();i++){
			addState=service.addStaff(addItems.get(i));
			if(addState==AddState.FAIL){
				break;
			}
			else if(addState==AddState.CONNECTERROR){
				break;
			}
		}
	}
	
	protected void newItem() {
		model.addEmptyRow();
		 int lastIndex = table.getRowCount()-1;
         table.changeSelection(lastIndex, 0,false,false);
	}


	@Override
	protected StaffVO getVO(Vector<String> vector) {
		// TODO Auto-generated method stub
		StaffVO staff=new StaffVO(vector.get(1),vector.get(2),Integer.parseInt(vector.get(3)),Translater.getInstitutionType(vector.get(4))
				,Translater.getUserRole(vector.get(5)),vector.get(0),vector.get(6),vector.get(7));
		return staff;
	}
	
	protected Vector<Vector<String>> getVector(ArrayList<StaffVO> voList){
		Vector<Vector<String>> result=new Vector<Vector<String>>();
		for(StaffVO temp:voList){
			Vector<String> vRow=new Vector<String>();
			vRow.add(temp.getSystemId());
			vRow.add(temp.getName());
			vRow.add(temp.getSex());
			vRow.add(String.valueOf(temp.getAge()));
//			vRow.add(State.StateSwitch.switchToStr(temp.getInsitution()));
			vRow.add("businesslobby");
			vRow.add(State.StateSwitch.switchToStr(temp.getPosition()));
			vRow.add(temp.getCity());
			vRow.add(temp.getPassword());
			result.add(vRow);
		}
		return result;
	}

}
