package presentation.userPanel.Admin;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;


import State.InstitutionType;
import State.UserRole;
import VO.UserVO;
import businesslogic.Impl.Admin.AdminController;
import businesslogic.Service.Admin.AdminService;

import presentation.components.ButtonCancel;
import presentation.components.ButtonNew;
import presentation.components.ButtonOk;
import presentation.components.ButtonSearch;
import presentation.components.ButtonTotal;
import presentation.components.FlatComboBox;
import presentation.components.PanelContent;
import presentation.components.RendererDelete;
import presentation.components.ScrollPaneTable;
import presentation.components.Table;
import presentation.components.TableModel;
import presentation.components.TextField;
import presentation.frame.MgtFourFunctions;
import presentation.main.ColorPallet;
import presentation.main.FontSet;
import presentation.main.Translater;
/*
 * initTable有问题
 */
public class AdminUserAccount extends MgtFourFunctions{

	AdminService service = new AdminController();
	Translater trans = new Translater();
	ArrayList<UserVO> users;
	
	private PanelContent panel = new PanelContent("账号管理");

	private TextField input = new TextField();
	private ButtonSearch search = new ButtonSearch();
	private ButtonNew buttonNew = new ButtonNew("新增账号");
	private ButtonOk confirmUp = new ButtonOk("提交修改");
	
	private TableListener tableListener = new TableListener();
	private FuncionListener functionListener = new FuncionListener();
	
	
	
	String[] tableH = {"员工编号","姓名","职务","性别","年龄","城市","所属机构"};
	boolean[] isCellEditable = {false,true,true,true,true,true,true};
	Vector<Vector<String>> tableV = new Vector<Vector<String>>();
	private TableModel model;
	private Table table;
	private ScrollPaneTable sPanel;
	
	
	private ButtonOk confirmDown = new ButtonOk("提交修改");
	private ButtonCancel cancel = new ButtonCancel();
	String[] position = {"管理员","营业厅业务员","快递员","财务人员","总经理","中转中心业务员","仓库管理员"}; 
	String[] gender = {"男","女"}; 
	String[] city = {"南京","北京","上海","广州"};
	String[] age = new String[42];
	String[] institution = {"营业厅","中转中心","仓库","总部"};
	JComboBox positionC;
	JComboBox genderC;
	JComboBox ageC;
	JComboBox cityC;
	JComboBox institutionC;
	
	private int addUsersNum = 0;
	private ArrayList<UserVO> addUsers = new ArrayList<UserVO>();
	private ArrayList<UserVO> deleteUsers;
	private ArrayList<UserVO> updateUsers = new ArrayList<UserVO>();
	private ArrayList<UserVO> searchUsers = new ArrayList<UserVO>();
	
	public AdminUserAccount(){
		initUI();
	}
	
	protected void initUI(){

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
	
	protected void initTable(){
		/*
		 * 有问题这里这里这里这里
		 */

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
		
		tableV = getVector(users);
        
        
		model = new TableModel(tableV, tableH,isCellEditable);
		table = new Table(model);
        
        

        TableColumnModel tcm = table.getColumnModel(); 
        
        positionC = new FlatComboBox(position);  
        tcm.getColumn(2).setCellEditor(new DefaultCellEditor(positionC)); 
        
        genderC = new FlatComboBox(gender);  
        tcm.getColumn(3).setCellEditor(new DefaultCellEditor(genderC)); 
        
        for(int i = 0;i < age.length;i++)
        	age[i] = i+18+"";
        ageC = new FlatComboBox(age);  
        tcm.getColumn(4).setCellEditor(new DefaultCellEditor(ageC));

        cityC = new FlatComboBox(city);  
        tcm.getColumn(5).setCellEditor(new DefaultCellEditor(cityC));
        
        institutionC = new FlatComboBox(institution);  
        tcm.getColumn(6).setCellEditor(new DefaultCellEditor(institutionC));
        
        tcm.addColumn(new TableColumn());
        tcm.getColumn(7).setCellRenderer(new RendererDelete());
        tcm.getColumn(7).setPreferredWidth(40);
        
        
		table.addMouseListener(tableListener);
		
		sPanel = new ScrollPaneTable(table);


		panel.add(sPanel);
	}
	
	protected void showSearchResult(){
		ArrayList<String> require = new ArrayList<String>();
		require.add(input.getText());
		searchUsers = service.searchUser(require);
		model = new TableModel(getVector(searchUsers),tableH,isCellEditable);
		table.setModel(model);
	}
	
	protected void confirmRevise(){
		deleteUsers = new ArrayList<UserVO>();
		for(int i = 0;i < tableV.size();i++){
			if(model.isDelete(i)){
				deleteUsers.add(getVO(tableV.get(i)));
			}
		}
		System.out.println("----------------------------deleteusers:");
		for(int i = 0; i < deleteUsers.size();i++){
			System.out.println(deleteUsers.get(i).getId());
		}
		updateUsers = new ArrayList<UserVO>();
		for(int i = 0;i < tableV.size();i++){
			if(model.isUpdate(i)){
				updateUsers.add(getVO(tableV.get(i)));
			}
		}
		System.out.println("----------------------------deleteusers:");
		for(int i = 0; i < updateUsers.size();i++){
			System.out.println(updateUsers.get(i).getId());
		}
		//TODO 全部提交之后更新界面
//		for(UserVO temp:addUsers){
//			AddState state = service.addUser(temp);
//			
//			if(state != AddState.SUCCESS){
//				showError();
//			}
//			
//		}
//		for(UserVO temp:deleteUsers){
//			DeleteState state = service.deleteUser(temp);
//			if(state != DeleteState.SUCCESS){
//				showError();
//			}
//		}
//		for(UserVO temp:updateUsers){
//		
//		}
	}
	
	protected void showError(){
		
	}
 
	protected void solveDelete(int rowUnderMouse){
		//处理界面显示问题并且更新tablemodel，
		//使得最后一起更新的时候，deleteUsers可以直接从model获知某行是否需要删除
		model.delete(rowUnderMouse);
		table.repaint();
	}
	
	protected void newItem(){
		model.addEmptyRow();
//		table.scrollRectToVisible(table.getCellRect(table.getRowCount(), 0, true));
		 int lastIndex = table.getRowCount()-1;
         table.changeSelection(lastIndex, 0,false,false);
	}
	
//	public PanelContent getPanel(){
//		return this.panel;
//	}

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
	
	public PanelContent getPanel(){
		return this.panel;
	}
	
	public class FuncionListener implements MouseListener{


		@Override
		public void mouseClicked(MouseEvent e) {
			ButtonTotal source = (ButtonTotal)e.getSource();
			if(source.equals(buttonNew)){
				newItem();
			}
			if(source.equals(confirmUp)){
				confirmRevise();
			}
			if(source.equals(search)){
				showSearchResult();
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}
		
	}
	
	public class TableListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			Point p = table.getMousePosition();
			int row = table.rowAtPoint(p);
			int column = table.columnAtPoint(p);
			System.out.println("position clicked :   row"+row+"   column"+column);
			if(column == table.getColumnCount() -1){
				solveDelete(row);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
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
