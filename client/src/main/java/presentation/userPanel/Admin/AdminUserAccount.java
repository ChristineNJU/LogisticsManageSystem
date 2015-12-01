package presentation.userPanel.Admin;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;


import State.InstitutionType;
import State.UserRole;
import VO.UserVO;
import businesslogic.Impl.Admin.AdminController;
import businesslogic.Service.Admin.AdminService;

import presentation.components.ButtonCancel;
import presentation.components.ButtonConfirm;
import presentation.components.ButtonNew;
import presentation.components.ButtonSearch;
import presentation.components.ButtonTotal;
import presentation.components.FlatComboBox;
import presentation.components.PanelContent;
import presentation.components.RendererDelete;
import presentation.components.ScrollPaneTable;
import presentation.components.TableADUS;
import presentation.components.TableModelADUS;
import presentation.components.TextField;
import presentation.main.MgtFourFunctions;
import presentation.main.Translater;
/*
 *
 */
public class AdminUserAccount extends MgtFourFunctions{

	AdminService service = new AdminController();
	ArrayList<UserVO> users;
	
	String[] tableH = {"员工编号","姓名","职务","性别","年龄","城市","所属机构"};
	boolean[] isCellEditable = {false,true,true,true,true,true,true};
	
	
	public AdminUserAccount(){
		buttonNew = new ButtonNew("新增账号");
		initUI("账号管理");
	}
	
	protected void initTable(){
		

		users = new ArrayList<UserVO>();
		UserVO u1 = new UserVO("1", "jack", UserRole.manager, "男", 34, InstitutionType.BusinessLobby,"南京");
		UserVO u2 = new UserVO("2", "jack", UserRole.manager, "男", 34, InstitutionType.BusinessLobby,"南京");
		UserVO u3 = new UserVO("3", "jack", UserRole.manager, "男", 34, InstitutionType.BusinessLobby,"南京");
		UserVO u4 = new UserVO("4", "jack", UserRole.manager, "男", 34, InstitutionType.BusinessLobby,"南京");
		UserVO u5 = new UserVO("5", "jack", UserRole.manager, "男", 34, InstitutionType.BusinessLobby,"南京");
		UserVO u6 = new UserVO("6", "jack", UserRole.manager, "男", 34, InstitutionType.BusinessLobby,"南京");
		UserVO u7 = new UserVO("7", "jack", UserRole.manager, "男", 34, InstitutionType.BusinessLobby,"南京");
		UserVO u8 = new UserVO("8", "jack", UserRole.manager, "男", 34, InstitutionType.BusinessLobby,"南京");
		UserVO u9 = new UserVO("9", "jack", UserRole.manager, "男", 34, InstitutionType.BusinessLobby,"南京");
		UserVO u10 = new UserVO("10", "jack", UserRole.manager, "男", 34, InstitutionType.BusinessLobby,"南京");
		
		users.add(u1);
		users.add(u2);
		users.add(u3);
		users.add(u4);
		users.add(u5);
		users.add(u6);
		users.add(u7);
		users.add(u8);
		users.add(u9);
		users.add(u10);
		users.add(u10);
		users.add(u10);
		users.add(u10);
		users.add(u10);
		users.add(u10);
		users.add(u10);
		users.add(u10);
		users.add(u10);
		users.add(u10);
		users.add(u10);		
		users.add(u10);
		
		tableV = getVector(users);
		
		
        
		model = new TableModelADUS(tableV, tableH,isCellEditable);
		table = new TableADUS(model);
        
        

        TableColumnModel tcm = table.getColumnModel(); 
        String[] position = {"管理员","营业厅业务员","快递员","财务人员","总经理","中转中心业务员","仓库管理员"}; 
		JComboBox positionC = new FlatComboBox(position);  
        tcm.getColumn(2).setCellEditor(new DefaultCellEditor(positionC)); 
        
        String[] gender = {"男","女"}; 
        JComboBox  genderC = new FlatComboBox(gender);  
        tcm.getColumn(3).setCellEditor(new DefaultCellEditor(genderC)); 
        
		String[] city = {"南京","北京","上海","广州"};
		JComboBox  cityC = new FlatComboBox(city);  
        tcm.getColumn(5).setCellEditor(new DefaultCellEditor(cityC));
        
		String[] age = new String[42];
		 for(int i = 0;i < age.length;i++)
	        	age[i] = i+18+"";
        JComboBox ageC = new FlatComboBox(age);  
        tcm.getColumn(4).setCellEditor(new DefaultCellEditor(ageC));
	        
		String[] institution = {"营业厅","中转中心","仓库","总部"};
		JComboBox institutionC = new FlatComboBox(institution);  
        tcm.getColumn(6).setCellEditor(new DefaultCellEditor(institutionC));
        
        tcm.addColumn(new TableColumn());
        tcm.getColumn(7).setCellRenderer(new RendererDelete());
        tcm.getColumn(7).setPreferredWidth(40);
        
        
		table.addMouseListener(tableListener);
		sPanel = new ScrollPaneTable(table);
		panel.add(sPanel);
	}
	
	protected void showSearchResult(String s){
		ArrayList<String> require = new ArrayList<String>();
		require.add(s);
		searchItems = service.searchUser(require);
		model = new TableModelADUS(getVector(searchItems),tableH,isCellEditable);
		table.setModel(model);
	}
	
	protected void confirmRevise(){
		removeError();
		
		deleteItems = new ArrayList<UserVO>();
		System.out.println(tableV.size());
		for(int i = 0;i < tableV.size();i++){
			if(model.isDelete(i)){
				deleteItems.add(getVO(tableV.get(i)));
			}
		}
		System.out.println("----------------------------deleted users:");
		for(int i = 0; i < deleteItems.size();i++){
			System.out.println(deleteItems.get(i).getId());
		}
		updateItems = new ArrayList<UserVO>();
		for(int i = 0;i < tableV.size();i++){
			if(model.isUpdate(i)){
				updateItems.add(getVO(tableV.get(i)));
			}
		}
		System.out.println("----------------------------updated users:");
		for(int i = 0; i < updateItems.size();i++){
			System.out.println(updateItems.get(i).getId());
		}
		//TODO 全部提交之后更新界面
//		for(UserVO temp:addUsers){
//			AddState state = service.addUser(temp);
//			
//			if(state != AddState.SUCCESS){
//				//TODO 
//				showError()
//			}
//			
//		}
//		for(UserVO temp:deleteUsers){
//			DeleteState state = service.deleteUser(temp);
//			if(state != DeleteState.SUCCESS){
//				//TODO
//				showError()
//			}
//		}
//		for(UserVO temp:updateUsers){
//		
//		}
	}
	

	protected Vector<Vector<String>> getVector(ArrayList<UserVO> voList){
		Vector<Vector<String>> result = new Vector<Vector<String>>();
        for(UserVO temp:users){
        	Vector<String> vRow = new Vector<String>();
        	vRow.add(temp.getId());
        	vRow.add(temp.getName());
        	vRow.add(trans.getChineseForUserRole(temp.getRole()));
        	vRow.add(temp.getSex());
        	vRow.add(temp.getAge()+"");
        	vRow.add(temp.getCity());
        	vRow.add(trans.getChineseForInstitution(temp.getInstitution()));
        	
        	result.add(vRow);
        }
		return result;
    }
	
	protected UserVO getVO(Vector<String> vector){
		UserRole role = trans.getUserRole(vector.get(2));
		int age = Integer.parseInt(vector.get(4));
		InstitutionType type = trans.getInstitutionType(vector.get(6));
		UserVO user = new UserVO(vector.get(0),vector.get(1),role,vector.get(3),age,type,vector.get(5));
		return user;
	}
	
}
