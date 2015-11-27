package presentation.userPanel.Admin;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import State.AddState;
import State.DeleteState;
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
import presentation.components.EditorDelete;
import presentation.components.FlatComboBox;
import presentation.components.PanelContent;
import presentation.components.RendererDelete;
import presentation.components.ScrollPaneTable;
import presentation.components.Table;
import presentation.components.TableModel;
import presentation.components.TextField;
import presentation.main.ColorPallet;
import presentation.main.FontSet;
import presentation.main.Navigation;
import presentation.main.Translater;
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
	
	String[] header = {"员工编号","姓名","职务","性别","年龄","城市","所属机构"};
	Vector<String> tebleH = new Vector<String>(); 
	Vector<Vector<String>> tableV = new Vector<Vector<String>>();
	private TableModel model;
	private TableColumnModel columnModel;
	private Table table;
	private ScrollPaneTable sPanel;
	
	PanelNewUser smallPanel;
	
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
        
        
		model = new TableModel(tableV, tebleH);
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
        tcm.getColumn(7).setCellEditor(new EditorDelete(this));
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
		model = new TableModel(getVector(searchUsers),tebleH);
		table.setModel(model);
	}
	
	private void confirmRevise(){
		deleteUsers = new ArrayList<UserVO>();
		for(int i = 0;i < tableV.size();i++){
			if(model.isDelete(i)){
				deleteUsers.add(getVO(tableV.get(i)));
			}
		}
		System.out.println("----------------------------deleteusers:");
		for(int i = 0; i < deleteUsers.size();i++){
			System.out.println(i+deleteUsers.get(i).getName());
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
	
	private void showError(){
		
	}
 
	public void solveDelete(int rowUnderMouse){
		//处理界面显示问题并且更新tablemodel，
		//使得最后一起更新的时候，deleteUsers可以直接从model获知某行是否需要删除
//		System.out.println("delete in Admin "+rowUnderMouse);
		model.delete(rowUnderMouse);
		table.repaint();
	}
	
	private void newUser(){
		smallPanel = new PanelNewUser();
		smallPanel.setVisible(true);
	}
	
	public PanelContent getPanel(){
		return this.panel;
	}
	
	public class FuncionListener implements MouseListener{


		@Override
		public void mouseClicked(MouseEvent e) {
			ButtonTotal source = (ButtonTotal)e.getSource();
			if(source.equals(buttonNew)){
				newUser();
				addUsersNum ++;
			}
			if(source.equals(confirmUp)){
//				for(int i = 0;i < addUsersNum;i++)
//				users.add(getVO(tableV.get(i)));
				confirmRevise();
			}
			if(source.equals(search)){
				showSearchResult();
			}
//			if(source.equals(smallPanel.ok)){
//				
//			}
//			if(source.equals(smallPanel.cancel)){
//				panel.remove(smallPanel);
//				panel.repaint();
//			}
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
			Point p = table.getMousePosition();
			int row = table.rowAtPoint(p);
			int column = table.columnAtPoint(p);
			System.out.println("position clicked :   row"+row+"   column"+column);
			if(column == table.getColumnCount() -1);
				solveDelete(row);
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
	

	public class PanelNewUser extends JDialog{
		
		JPanel container = new JPanel();
		Label idL = new Label("工号");
		Label nameL = new Label("姓名");
		Label positionL = new Label("职务");
		Label genderL = new Label("性别");
		Label ageL = new Label("年龄");
		Label cityL = new Label("城市");
		Label institutionL = new Label("单位");
		TextField idI = new TextField();
		TextField nameI = new TextField();
		FlatComboBox positionI = new FlatComboBox(position);
		FlatComboBox genderI = new FlatComboBox(gender);
		FlatComboBox ageI = new FlatComboBox(age);
		FlatComboBox cityI = new FlatComboBox(city);
		FlatComboBox institutionI = new FlatComboBox(institution);
		
		ButtonOk ok = new ButtonOk("确定");
		ButtonCancel cancel = new ButtonCancel();
		
		public PanelNewUser(){
			container.setLayout(null);
			container.setLocation(0,0);
			this.setBounds(530,0,300,400);
//			container.setBackground(Color.white);
			this.setContentPane(container);
			
			idL.setLocation(10,5);
			nameL.setLocation(10,40);
			positionL.setLocation(10,75);
			genderL.setLocation(10,110);
			ageL.setLocation(10,145);
			cityL.setLocation(10,180);
			institutionL.setLocation(10,215);
			
			idI.setLocation(80,5);
			nameI.setLocation(80,40);
			positionI.setLocation(80,75);
			genderI.setLocation(80,110);
			ageI.setLocation(80,145);
			cityI.setLocation(80,180);
			institutionI.setLocation(80,215);
			
			ok.setFont(FontSet.fourteen);
			cancel.setFont(FontSet.fourteen);
			ok.setBounds(130,250,100,30);
			cancel.setBounds(10,250,100,30);
			
			ok.addMouseListener(functionListener);
			cancel.addMouseListener(functionListener);
			container.add(idL);
			container.add(idI);
			container.add(nameL);
			container.add(nameI);
			container.add(positionL);
			container.add(positionI);
			container.add(genderL);
			container.add(genderI);
			container.add(ageL);
			container.add(ageI);
			container.add(cityL);
			container.add(cityI);
			container.add(institutionL);
			container.add(institutionI);
			container.add(ok);
			container.add(cancel);
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
