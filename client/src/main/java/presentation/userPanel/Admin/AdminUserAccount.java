package presentation.userPanel.Admin;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.TableColumnModel;

import State.AddState;
import State.DeleteState;
import State.InstitutionType;
import State.UserRole;
import VO.UserVO;
import businesslogic.Impl.Admin.AdminController;
import businesslogic.Service.Admin.AdminService;
import presentation.main.ColorPallet;
import presentation.main.FontSet;
import presentation.main.Navigation;
import presentation.main.Translater;
import presentation.panel.components.ButtonCancel;
import presentation.panel.components.ButtonNew;
import presentation.panel.components.ButtonOk;
import presentation.panel.components.ButtonSearch;
import presentation.panel.components.ButtonTotal;
import presentation.panel.components.FlatComboBox;
import presentation.panel.components.MyTableModel;
import presentation.panel.components.PanelContent;
import presentation.panel.components.RendererDelete;
import presentation.panel.components.ScrollPaneTable;
import presentation.panel.components.Table;
import presentation.panel.components.TextField;
/*
 * initTable有问题
 */
public class AdminUserAccount {

	AdminService service = new AdminController();
	Translater trans = new Translater();
//	AdminBlService_Stub service = new AdminBlService_Stub();
	ArrayList<UserVO> users;
	
	private PanelContent panel = new PanelContent("账号管理");

	private TextField input = new TextField();
	private ButtonSearch search = new ButtonSearch();
	private ButtonNew buttonNew = new ButtonNew("新增账号");
	private ButtonOk confirmUp = new ButtonOk("提交修改");
	
	private TableListener tableListener = new TableListener();
	private FuncionListener functionListener = new FuncionListener();
	
	
	ArrayList<String> userRoleA = new ArrayList<String>();
	ArrayList<UserRole> userRole;
	
	String[] header = {"员工编号","姓名","职务","性别","年龄","城市","所属机构","   "};
	Vector<String> tebleH = new Vector<String>(); 
	Vector<Vector<String>> tableV = new Vector<Vector<String>>();
	private MyTableModel model;
	private TableColumnModel columnModel;
	private Table table;
	private ScrollPaneTable sPanel;
	
	private ButtonOk confirmDown = new ButtonOk("提交修改");
	private ButtonCancel cancel = new ButtonCancel();
	
	private int addUsersNum = 0;
	private ArrayList<UserVO> addUsers = new ArrayList<UserVO>();
	private ArrayList<UserVO> deleteUsers = new ArrayList<UserVO>();
	private ArrayList<UserVO> updateUsers = new ArrayList<UserVO>();
	private ArrayList<UserVO> searchUsers = new ArrayList<UserVO>();
	
	Navigation nav;
	public AdminUserAccount(Navigation nav){
		initUI();
		this.nav = nav;
	}
	
	private void initUI(){

		panel.setLayout(null);
		input.setBounds(120,110,160,30);
		panel.add(input);
		search.setBounds(280,110,60,30);
		search.addMouseListener(functionListener);
		panel.add(search);
		
		initTable();
		
		buttonNew.setFont(FontSet.eighteen);
		buttonNew.setBounds(762,110,110,30);
		buttonNew.addMouseListener(functionListener);
		panel.add(buttonNew);
		confirmUp.setFont(FontSet.eighteen);
		confirmUp.setBounds(120,175+sPanel.getHeight(),110,30);
		confirmUp.addMouseListener(functionListener);
		panel.add(confirmUp);
		
	}
	
	private void initTable(){
		/*
		 * 有问题这里这里这里这里
		 */

		for(String s:header){
			tebleH.add(s);
		}

		users = new ArrayList<UserVO>();
		UserVO u = new UserVO("141250194", "jack", UserRole.manager, "男", 34, InstitutionType.BusinessLobby,"南京");
		for(int i = 0;i < 10;i++)
			users.add(u);
		
		tableV = getVector(users);
        
        
		model = new MyTableModel(tableV, tebleH);
		table = new Table(model);
        
        

        TableColumnModel tcm = table.getColumnModel(); 
        
        String[] position = {"管理员","营业厅业务员","快递员","财务人员","总经理","中转中心业务员","仓库管理员"};  
        JComboBox positionC = new FlatComboBox(position);  
        tcm.getColumn(2).setCellEditor(new DefaultCellEditor(positionC)); 
        String[] gender = {"男","女"};  
        JComboBox genderC = new FlatComboBox(gender);  
        tcm.getColumn(3).setCellEditor(new DefaultCellEditor(genderC)); 
        String[] age = new String[42];
        for(int i = 0;i < age.length;i++)
        	age[i] = i+18+"";
        JComboBox ageC = new FlatComboBox(age);  
        tcm.getColumn(4).setCellEditor(new DefaultCellEditor(ageC));
        String[] city = {"南京","北京","上海","广州"};
        JComboBox cityC = new FlatComboBox(city);  
        tcm.getColumn(5).setCellEditor(new DefaultCellEditor(cityC));
        String[] institution = {"营业厅","中转中心","仓库","总部"};
        JComboBox institutionC = new FlatComboBox(institution);  
        tcm.getColumn(6).setCellEditor(new DefaultCellEditor(institutionC));

        tcm.getColumn(7).setCellRenderer(new RendererDelete());
        tcm.getColumn(7).setPreferredWidth(40);
        
        
		table.addMouseListener(tableListener);
		
		sPanel = new ScrollPaneTable(table);


		panel.add(sPanel);
	}
	

	private Vector<Vector<String>> getVector(ArrayList<UserVO> voList){
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
	
	private UserVO getVO(Vector<String> vector){
		UserRole role = trans.getUserRole(vector.get(2));
		int age = Integer.parseInt(vector.get(4));
		InstitutionType type = trans.getInstitutionType(vector.get(6));
		UserVO user = new UserVO(vector.get(0),vector.get(1),role,vector.get(3),age,type,vector.get(5));
		return user;
	}
	


	private void showSearchResult(){
		ArrayList<String> require = new ArrayList<String>();
		require.add(input.getText());
		searchUsers = service.searchUser(require);
		model = new MyTableModel(getVector(searchUsers),tebleH);
		table.setModel(model);
	}
	
	private void confirmRevise(){
//		AddState state;
		for(UserVO temp:addUsers){
			AddState state = service.addUser(temp);
			
			if(state != AddState.SUCCESS){
				showError();
			}
			
		}
		for(UserVO temp:deleteUsers){
			DeleteState state = service.deleteUser(temp);
			if(state != DeleteState.SUCCESS){
				showError();
			}
		}
		for(UserVO temp:updateUsers){
//			UpdateState state = service.updateUser(temp, field, value)
		}
	}
	
	private void showError(){
		
	}
 
	private void showDelete(int row){
		for(int i = 0; i < tebleH.size()-1;i++){
			Component renderer = (Component)table.getCellRenderer(row, i);
			renderer.setForeground(ColorPallet.Yellow);
			table.repaint();
		}
	}
	
	public PanelContent getPanel(){
		return this.panel;
	}
	
	public class FuncionListener implements MouseListener{


		@Override
		public void mouseClicked(MouseEvent e) {
			ButtonTotal source = (ButtonTotal)e.getSource();
			if(source.equals(buttonNew)){
				model.addEmptyRow();
				addUsersNum ++;
			}
			if(source.equals(confirmUp)){
				for(int i = 0;i < addUsersNum;i++)
				users.add(getVO(tableV.get(i)));
				confirmRevise();
			}
			if(source.equals(search)){
				showSearchResult();
			}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class TableListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
             int c= table.getSelectedColumn();
			 if(c != 6)
            	 return;
			 int r= table.getSelectedRow();
			 System.out.println(r+"   "+c+"    "+'\n');
			showDelete(r);
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	

}
