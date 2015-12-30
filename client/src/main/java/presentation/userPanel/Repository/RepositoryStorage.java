package presentation.userPanel.Repository;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JLabel;
import javax.swing.table.TableColumnModel;

import State.StorageState;
import VO.StorageVO;
import businesslogic.Impl.Courier.CourierImpl;
import businesslogic.Impl.Repository.RepositoryController;
import businesslogic.Service.Courier.CourierService;
import businesslogic.Service.Repository.RepositoryService;
import presentation.components.ButtonConfirm;
import presentation.components.ButtonNew;
import presentation.components.FlatComboBox;
import presentation.components.LabelHeader;
import presentation.factory.TableFactory;
import presentation.factory.TableModelFactory;
import presentation.frame.MainFrame;
import presentation.main.FontSet;
import presentation.main.FunctionAdd;
import presentation.main.Translater;
import presentation.table.ScrollPaneTable;
import presentation.table.TableAddOnly;
import presentation.table.TableModelAddOnly;

public class RepositoryStorage extends FunctionAdd {

	RepositoryService service = new RepositoryController();
	CourierService getCity = new CourierImpl();
	
	
	private ProgressBarPanel pbp = new ProgressBarPanel();
	
	ArrayList<String> getNeed = new ArrayList<String>();
	
	ArrayList<StorageVO> storage = new ArrayList<StorageVO>();
	
	Vector<Vector<String>> vector = new Vector<Vector<String>>();
	
	boolean isSaved = false;
	
	JLabel info = new JLabel();
	
	NavigationRepository nav;
	
	public RepositoryStorage(NavigationRepository navigationRepository) {
		super.buttonNew = new ButtonNew("新增入库单");
		super.confirm = new ButtonConfirm("提交入库单");
		
		this.nav = navigationRepository;
		
		initUI("入库");
		init();
	}
	
	private void init() {
		
//		confirm.addMouseListener(new MouseAdapter() {
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				if(confirm.isEnabled()){
//					nav.changeTask(1);
//				}
//			}
//			
//		});
		
		info.setBounds(480, 590, 200, 50);
		info.setForeground(Color.red);
		info.setFont(FontSet.twenty);
		panel.add(info);
		panel.add(pbp.getPanel());
	}
	
	@Override
	protected void initHeader() {
		header = new Header();
		panel.add(header);
	}

	@Override
	protected void initTable() {
		


		ArrayList<StorageVO> bar_code = service.getNeedStorage();
		
		tableV = getVector(bar_code);
		ArrayList<StorageVO> needStorage = service.getNeedStorage();
		
//		for(StorageVO vo:needStorage){
//			Vector<String> tm = new Vector<String>();
//			tm.add(vo.getBarCode());
//			tm.add("");
//			tm.add("");
//			tm.add("");
//			tm.add("");
//			tm.add("");
//			tableV.add(tm);
//		}
		
		model = TableModelFactory.getStorageModel(tableV);
		table = TableFactory.getStorageTable(model);
		sPanel = new ScrollPaneTable(table);
		panel.add(sPanel);
	}

	@Override
	public void performConfirm() {
		
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
	
	private Vector<Vector<String>> getVector(ArrayList<StorageVO> list) {
		Vector<Vector<String>> temp = new Vector<Vector<String>>();
		for(StorageVO vo:list){
			Vector<String> result = new Vector<String>();
			result.add(vo.getBarCode());
			result.add("");
			result.add("");
			result.add("");
			result.add("");
			result.add("");
			temp.add(result);
		}
		return temp;
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

	@Override
	public void performCancel() {
//		MainFrame.changeContentPanel(new RepositoryStorage().getPanel());
		nav.changeTask(1);
	}
}
