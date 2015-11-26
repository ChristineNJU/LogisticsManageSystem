package presentation.userPanel.Admin;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.TableColumnModel;

import State.InstitutionType;
import State.UserRole;
import VO.UserVO;
import presentation.main.ColorPallet;
import presentation.main.FontSet;
import presentation.panel.components.ButtonCancel;
import presentation.panel.components.ButtonOk;
import presentation.panel.components.ButtonSearch;
import presentation.panel.components.FlatComboBox;
import presentation.panel.components.MyTableModel;
import presentation.panel.components.PanelContent;
import presentation.panel.components.RendererDelete;
import presentation.panel.components.RendererGender;
import presentation.panel.components.ScrollPaneTable;
import presentation.panel.components.Table;
import presentation.panel.components.TextField;
import test.Stub.businesslogic.AdminBlService_Stub;
/*
 * initTable有问题
 */
public class AdminUserAccount {

//	AdminService service = new AdminController();
	AdminBlService_Stub service = new AdminBlService_Stub();
	ArrayList<UserVO> users;
	
	private PanelContent panel = new PanelContent("账号管理");

	private TextField input = new TextField();
	private ButtonSearch search = new ButtonSearch();
	private ButtonOk confirmUp = new ButtonOk("提交修改");
	
	private TableListener tableListener = new TableListener();
	
	String[] header = {"员工编号","姓名","职务","性别","年龄","所属机构","   ","   "};
	Vector<String> tebleH = new Vector<String>();
	Vector<Vector<Object>> tableV = new Vector<Vector<Object>>();
	private MyTableModel model;
	private TableColumnModel columnModel;
	private Table table;
	private ScrollPaneTable sPanel;
	
	private ButtonOk confirmDown = new ButtonOk("提交修改");
	private ButtonCancel cancel = new ButtonCancel();
	
	public AdminUserAccount(){
		init();

	}
	
	private void init(){

		panel.setLayout(null);
		input.setBounds(120,105,160,30);
		panel.add(input);
		search.setBounds(280,105,60,30);
		panel.add(search);
		confirmUp.setFont(FontSet.eighteen);
		confirmUp.setBounds(780,105,110,30);
		panel.add(confirmUp);
		
	
		
		initTable();
		
	}
	
	private void initTable(){
		/*
		 * 有问题这里这里这里这里
		 */

		for(String s:header){
			tebleH.add(s);
		}

		users = new ArrayList<UserVO>();
		UserVO u = new UserVO("141250194", "jack", UserRole.manager, "男", 34, InstitutionType.BusinessLobby);
		for(int i = 0;i < 10;i++)
			users.add(u);
		
        for(UserVO temp:users){
        	Vector<Object> vRow = new Vector<Object>();
        	vRow.add(temp.getId());
        	vRow.add(temp.getName());
        	vRow.add(temp.getRole());
        	vRow.add(temp.getSex());
        	vRow.add(temp.getAge());
        	vRow.add(temp.getInstitution().toString());
        	tableV.add(vRow);
        }
        

        
        
		model = new MyTableModel(tableV, tebleH);
		table = new Table(model);
        
        
        String[] age = {"男","女"};  
        JComboBox com = new FlatComboBox(age);  
        TableColumnModel tcm = table.getColumnModel(); 
        
//        tcm.getColumn(3).setCellRenderer(new RendererGender()); 
        tcm.getColumn(3).setCellEditor(new DefaultCellEditor(com)); 
        
        tcm.getColumn(6).setCellRenderer(new RendererDelete());
        
		table.addMouseListener(tableListener);
		
		sPanel = new ScrollPaneTable(table);


		panel.add(sPanel);
	}
	
	public PanelContent getPanel(){
		return this.panel;
	}
	
	public class TableListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
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
