package presentation.userPanel.BusinessLb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.TableColumnModel;

import presentation.components.ButtonNew;
import presentation.components.FlatComboBox;
import presentation.main.FunctionADUS;
import presentation.table.ScrollPaneTable;
import presentation.table.TableADUS;
import presentation.table.TableModelADUS;
import VO.DriverInfoVO;
import businesslogic.Impl.Businesslobby.DriverMgt;

public class BusinessLbDriverMgt extends FunctionADUS{
	
	DriverMgt service=new DriverMgt();
	ArrayList<DriverInfoVO> drivers;
	
	String[] tableH = {"司机ID","司机姓名","司机生日","身份证号","司机手机","司机性别","雇佣时间"};
	boolean[] isCellEditable = {false,true,true,true,true,true};
	
	ArrayList<DriverInfoVO> addItems=new ArrayList<DriverInfoVO>();
	ArrayList<DriverInfoVO> deleteItems=new ArrayList<DriverInfoVO>();
	ArrayList<DriverInfoVO> searchItems=new ArrayList<DriverInfoVO>();
	ArrayList<DriverInfoVO> updateItems=new ArrayList<DriverInfoVO>();
	
	SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
	
	public BusinessLbDriverMgt(){
		buttonNew = new ButtonNew("新增司机");
		initUI("司机管理");
	}
	
	@Override
	protected void initTable() {
		// TODO Auto-generated method stub
		drivers=new ArrayList<DriverInfoVO>();
		
		DriverInfoVO driver1=new DriverInfoVO("321002199402210242", "张三", new Date(),"025001001","1111111111111", "男", 10);
		DriverInfoVO driver2=new DriverInfoVO("321002199402210241", "huangyong", new Date(),"025001002","1111111111111", "男", 10);
		DriverInfoVO driver3=new DriverInfoVO( "321002199402210243","yonghuang", new Date(),"025001003","1111111111111", "男", 10);
		
		drivers.add(driver1);
		drivers.add(driver2);
		drivers.add(driver3);
	
		tableV = getVector(drivers);
        
        model = new TableModelADUS(tableV, tableH,isCellEditable);
		table = new TableADUS(model);
		TableColumnModel tcm = table.getColumnModel(); 
	    String[] gender = {"男","女"}; 
	    JComboBox  genderC = new FlatComboBox(gender);  
	    tcm.getColumn(5).setCellEditor(new DefaultCellEditor(genderC)); 
		
		addDeleteColumn();
	    
	    table.addMouseListener(tableListener);
		sPanel = new ScrollPaneTable(table);
		panel.add(sPanel);
		
	}

	@Override
	protected void showSearchResult(String s) {
		// TODO Auto-generated method stub
		drivers=new ArrayList<DriverInfoVO>();
		searchItems = service.searchDriver(s);
		model = new TableModelADUS(getVector(searchItems),tableH,isCellEditable);
		table.setModel(model);
	}

	@Override
	protected void confirmRevise() {
		// TODO Auto-generated method stub
		deleteItems=new ArrayList<DriverInfoVO>();
		for(int i=0;i<tableV.size();i++){
			if(model.isDelete(i)){
				deleteItems.add((DriverInfoVO) getVO(tableV.get(i)));
			}
		}
		
		updateItems=new ArrayList<DriverInfoVO>();
		for(int i=0;i<tableV.size();i++){
			if(model.isUpdate(i)){
				updateItems.add((DriverInfoVO) getVO(tableV.get(i)));
			}
		}
		
	}
	
	protected void solveDelete(int rowUnderMouse) {
		model.delete(rowUnderMouse);
		table.repaint();
	}
	
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
			driver=new DriverInfoVO(vector.get(3),vector.get(1),sdf.parse(vector.get(2)),vector.get(0),vector.get(4),vector.get(5),Integer.parseInt(vector.get(6)));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}

	protected Vector<Vector<String>> getVector(ArrayList<DriverInfoVO> voList){
		Vector<Vector<String>> result=new Vector<Vector<String>>();
		for(DriverInfoVO temp:drivers){
			Vector<String> vRow=new Vector<String>();
			vRow.add(temp.getId());
			vRow.add(temp.getName());
			vRow.add(sdf.format(temp.getBirthday()));
			vRow.add(temp.getNumber());
			vRow.add(temp.getMobilephone());
			vRow.add(temp.getSex());
			vRow.add(String.valueOf(temp.getAttendTime()));
			
			result.add(vRow);
		}
		return result;
	}
}
