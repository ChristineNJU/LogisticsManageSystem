package presentation.userPanel.Admin;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import State.AddState;
import State.DeleteState;
import State.ErrorState;
import State.InstitutionType;
import State.UpdateState;
import State.UserRole;
import VO.LogisticsHistoryVO;
import VO.UserVO;
import businesslogic.Impl.Admin.AdminController;
import businesslogic.Service.Admin.AdminService;
/*
 *
 */
import presentation.components.ButtonNew;
import presentation.components.FlatComboBox;
import presentation.factory.ComboxFactory;
import presentation.factory.TableFactory;
import presentation.factory.TableModelFactory;
import presentation.frame.MainFrame;
import presentation.main.FunctionADUS;
import presentation.table.RendererDelete;
import presentation.table.ScrollPaneTable;
import presentation.table.TableADUS;
import presentation.table.TableModelADUS;



public class AdminUserAccount extends FunctionADUS{

	AdminService service = new AdminController();
	ArrayList<UserVO> users;
	

	protected ArrayList<UserVO> addItems = new ArrayList<UserVO>();
	protected ArrayList<UserVO> deleteItems ;
	protected ArrayList<UserVO> updateItems = new ArrayList<UserVO>();
	protected ArrayList<UserVO> searchItems = new ArrayList<UserVO>();

	
	public AdminUserAccount(){
		buttonNew = new ButtonNew("新增账号");
		initUI("账号管理");
	}
	
	protected void initTable(){
		

		users = new ArrayList<UserVO>();
		
		ArrayList<String> requirement = new ArrayList<String>();
		requirement.add("%%");
		users = service.searchUser(requirement);
		if(users!=null){
			
			tableV = getVector(users);
		}
		else {
			tableV=new Vector<Vector<String>>();
			super.isConnectError=true;
		}
		tableV = getVector(users);
		
		model = TableModelFactory.getUserAccountModel(tableV);
		table = TableFactory.getUserAccountTable(model);
        
        
		table.addMouseListener(tableListener);
		sPanel = new ScrollPaneTable(table);
		panel.add(sPanel);
		
		ErrorListener errorListener = new ErrorListener();
		model.addTableModelListener(errorListener);
	}

	@Override
	protected void showSearchResult(String s){
		ArrayList<String> require = new ArrayList<String>();
		require.add(s);
		searchItems = service.searchUser(require);
		System.out.println(searchItems.size());
		model = TableModelFactory.getUserAccountModel(getVector(searchItems));
		table.setModel(model);
		table.repaint();
	}
	
	
	
	public void performConfirm(){
//		removeError();
		DeleteState deleteState=DeleteState.CONNECTERROR;
		deleteItems = new ArrayList<UserVO>();
//		System.out.println(tableV.size());
		for(int i = 0;i < tableV.size();i++){
			if(model.isDelete(i)){
				deleteItems.add(getVO(tableV.get(i)));
			}
		}
		for(int i = 0; i < deleteItems.size();i++){
			deleteState=service.deleteUser(deleteItems.get(i));
			if(deleteState==DeleteState.CONNECTERROR){
				showError(ErrorState.CONNECTERROR);
				return;
			}else if(deleteState==DeleteState.FAIL){
				showError(ErrorState.DELETEERROR);
				return;
			}
		}
		
		UpdateState updateState=UpdateState.CONNECTERROR;
		updateItems = new ArrayList<UserVO>();
		for(int i = 0;i < tableV.size();i++){
			if(model.isUpdate(i)){
				updateItems.add(getVO(tableV.get(i)));
			}
		}

		for(int i = 0; i < updateItems.size();i++){
			updateState=service.updateUser(updateItems.get(i));
			if(updateState==UpdateState.CONNECTERROR){
				showError(ErrorState.CONNECTERROR);
				break;
			}
			else if(updateState==UpdateState.NOTFOUND){
				showError(ErrorState.SEARCHERROR);
			}
		}
		
		AddState addState = AddState.CONNECTERROR;
		addItems = new ArrayList<UserVO>();
		for(int i = 0;i < tableV.size();i++){
			if(model.isNew(i)){
				addItems.add(getVO(tableV.get(i)));
			}
		}

		for(int i = 0; i < addItems.size();i++){
			addState = service.addUser(addItems.get(i));
			if(addState == AddState.CONNECTERROR){
				showError(ErrorState.CONNECTERROR);
				break;
			}
			else if(addState==AddState.FAIL){
				showError(ErrorState.ADDERROR);
			}
		}
		
		MainFrame.changeContentPanel(new AdminUserAccount().getPanel());
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
	
	public boolean isConnectError(){
		return super.isConnectError;
	}
	
	protected UserVO getVO(Vector<String> vector){
		UserRole role = trans.getUserRole(vector.get(2));
		int age = Integer.parseInt(vector.get(4));
		InstitutionType type = trans.getInstitutionType(vector.get(6));
		UserVO user = new UserVO(vector.get(0),vector.get(1),role,vector.get(3),age,type,vector.get(5));
		return user;
	}

	@Override
	public void performCancel() {
//		MainFrame.changeContentPanel(new AdminUserAccount().getPanel());
//		initTable();
//		ArrayList<String> requirement = new ArrayList<String>();
//		requirement.add("%%");
//		users = service.searchUser(requirement);
//		if(users!=null){
//			tableV = getVector(users);
//		}
//		else {
//			tableV=new Vector<Vector<String>>();
//			super.isConnectError=true;
//		}
//		tableV = getVector(users);
//		model = TableModelFactory.getUserAccountModel(tableV);
//		table = TableFactory.getUserAccountTable(model);
//		table.setModel(model);
		MainFrame.changeContentPanel(new AdminUserAccount().getPanel());
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
