package presentation.userPanel.Repository;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JLabel;
import javax.swing.table.TableColumnModel;

import presentation.components.ButtonConfirm;
import presentation.components.ButtonNew;
import presentation.components.FlatComboBox;
import presentation.components.LabelHeader;
import presentation.main.FontSet;
import presentation.main.FunctionAdd;
import presentation.main.Translater;
import presentation.table.ScrollPaneTable;
import presentation.table.TableAddOnly;
import presentation.table.TableModelAddOnly;
import State.StateSwitch;
import State.StorageState;
import VO.StorageVO;
import businesslogic.Impl.Courier.CourierImpl;
import businesslogic.Impl.Repository.RepositoryController;
import businesslogic.Service.Courier.CourierService;
import businesslogic.Service.Courier.GetCityService;
import businesslogic.Service.Repository.RepositoryService;

public class RepositoryStorage extends FunctionAdd {

	RepositoryService service = new RepositoryController();
	CourierService getCity = new CourierImpl();
	
	String[] tableH = {"快递编号", "到达地", "区号", "排号", "架号", "位号", ""};
	boolean[] isCellEditable = {true, true, true, true, true, true, false};
	
	private ProgressBarPanel pbp = new ProgressBarPanel();
	
	ArrayList<StorageVO> storage = new ArrayList<StorageVO>();
	
	Vector<Vector<String>> vector = new Vector<Vector<String>>();
	
	boolean isSaved = false;
	
	JLabel info = new JLabel();
	
	NavigationRepository nav;
	
	public RepositoryStorage(NavigationRepository nav) {
		super.buttonNew = new ButtonNew("新增入库单");
		super.confirm = new ButtonConfirm("提交入库单");
		
		this.nav = nav;
		
		initUI("入库");
		init();
	}
	
	private void init() {
		
		confirm.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(confirm.isEnabled()){
					nav.changeTask(1);
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
			
		});
		
		info.setBounds(480, 590, 200, 50);
		info.setForeground(Color.red);
		info.setFont(FontSet.twenty);
		panel.add(info);
		panel.add(pbp.getPanel());
	}
	
	@Override
	protected void initHeader() {
		// TODO Auto-generated method stub
		header = new Header();
		panel.add(header);
	}

	@Override
	protected void initTable() {
		// TODO Auto-generated method stub
		model = new TableModelAddOnly(vector, tableH, isCellEditable);
		table = new TableAddOnly(model);
		
		TableColumnModel tcm = table.getColumnModel();
///		tcm.getColumn(tcm.getColumnCount()-1).setCellRenderer(new RendererDelete());
//		tcm.getColumn(tcm.getColumnCount()-1).setCellEditor(new ));
		
		ArrayList<String> city_actual = getCity.getCity();
		
		FlatComboBox city = new FlatComboBox();
		
		for(int i=0;i<city_actual.size();i++){
			city.addItem(city_actual.get(i));
		}
		
		FlatComboBox area = new FlatComboBox();
		area.addItem("航空区");
		area.addItem("汽运区");
		area.addItem("铁路区");
		area.addItem("机动区");
		
		FlatComboBox row = new FlatComboBox();
		FlatComboBox shelf = new FlatComboBox();
		FlatComboBox position = new FlatComboBox();
		for(int i=1;i<=10;i++){
			row.addItem(i+"");
			shelf.addItem(i+"");
			position.addItem(i+"");
		}
		
		tcm.getColumn(1).setCellEditor(new DefaultCellEditor(city));
		tcm.getColumn(2).setCellEditor(new DefaultCellEditor(area));
		
		tcm.getColumn(3).setCellEditor(new DefaultCellEditor(row));
		tcm.getColumn(4).setCellEditor(new DefaultCellEditor(shelf));
		tcm.getColumn(5).setCellEditor(new DefaultCellEditor(position));
		
		sPanel = new ScrollPaneTable(table);
		panel.add(sPanel);
	}

	@Override
	protected void confirmAll() {
		// TODO Auto-generated method stub
		
		if(isSaved){
			info.setText("已保存");
			return;
		}
		
		if(pbp.isLeak()){
			info.setText("请进行库存调整后入库");
			return;
		}
		
		boolean isLegal = true;
		
		
		for(int i=0;i<table.getRowCount();i++){
			Vector<String> v = model.getRow(i);
			System.out.println(isLegal(v));
			if(!isLegal(v)){
				storage = new ArrayList<StorageVO>();
				isLegal = false;
				continue;
			}else{				
				storage.add(getVO(v));
			}
		}
		
		if(!isLegal){
			info.setText("输入条目错误");
			return;
		}
		
		if(storage.isEmpty()){
			info.setText("空的提交信息");
			return;
		}
		
		StorageState state = service.storage(storage);
		
		if(state==StorageState.SUCCESS){
			info.setText("保存成功");
			isSaved = true;
			nav.changeTask(1);
		}else{
			info.setText("保存失败");
		}
	}

	@Override
	protected StorageVO getVO(Vector<String> vector) {
		StorageVO vo = new StorageVO(vector.get(0).trim(), Calendar.getInstance().getTime(),
				vector.get(1), Translater.getStorageArea(vector.get(2)), Integer.parseInt(vector.get(3))
				, Integer.parseInt(vector.get(4)), Integer.parseInt(vector.get(5)));
		return vo;
	}
	
	private Vector<String> getVector(StorageVO vo) {
		Vector<String> result = new Vector<String>();
		result.add(vo.getBarCode());
		result.add(vo.getAreaCode()+"");
		result.add(vo.getRow()+"");
		result.add(vo.getShelf()+"");
		result.add(vo.getPosition()+"");
		return result;
	}
	
	private boolean isLegal(Vector<String> v) {
		if(v.get(0).trim().equals("")){
			return false;
		}
		if(v.get(1).trim().equals("")){
			return false;
		}
		if(v.get(2).trim().equals("")){
			return false;
		}
		if(v.get(3).trim().equals("")){
			return false;
		}
		if(v.get(4).trim().equals("")){
			for(int i=0;i<v.get(4).length();i++){
				if(v.get(4).charAt(i)<='9'&&v.get(4).charAt(i)>='0'){
					
				}else{
					return false;
				}
			}
		}
		if(v.get(5).trim().equals("")){
			for(int i=0;i<v.get(4).length();i++){
				if(v.get(4).charAt(i)<='9'&&v.get(4).charAt(i)>='0'){
					
				}else{
					return false;
				}
			}
		}
		return true;
	}
	
 	private class Header extends JLabel {
		LabelHeader date = new LabelHeader("入库日期:");
		public Header() {
			// TODO Auto-generated constructor stub
			setBounds(120, 100, 680, 30);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			date.addInfo(sdf.format(Calendar.getInstance().getTime()));
			
			date.setBounds(0, 0, 400, 30);
			add(date);
		}
	}
}
