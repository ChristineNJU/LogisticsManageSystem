package presentation.userPanel.Repository;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JLabel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumnModel;

import presentation.components.ButtonConfirm;
import presentation.components.ButtonNew;
import presentation.components.FlatComboBox;
import presentation.components.LabelHeader;
import presentation.frame.MainFrame;
import presentation.main.FontSet;
import presentation.main.FunctionAdd;
import presentation.main.Translater;
import presentation.table.ScrollPaneTable;
import presentation.table.TableAddOnly;
import presentation.table.TableModelAddOnly;
import presentation.userPanel.Manager.ManagerInstitutionMgt;
import State.AddState;
import State.ErrorState;
import State.StorageArea;
import State.UpdateState;
import VO.BalanceVO;
import VO.VO;
import VO.WareHouseVO;
import businesslogic.Impl.Repository.BlWareHouseImpl;
import businesslogic.Impl.Repository.RepositoryController;
import businesslogic.Service.Repository.BlWareHouseService;
import businesslogic.Service.Repository.RepositoryService;

public class RepositoryBalance extends FunctionAdd {

	BlWareHouseService wareHouse = new BlWareHouseImpl();
	RepositoryService repository = new RepositoryController();
	
	private ProgressBarPanel pbp = new ProgressBarPanel();
	
	String[] tableH = {"原区号", "快递编号", "新区号", "排号", "架号", "位号", ""};
	boolean[] isCellEditable = {true, true, true, true, true, false};
	
	Vector<Vector<String>> vector = new Vector<Vector<String>>();
	
	JLabel info = new JLabel();
	
	ArrayList<WareHouseVO> total = new ArrayList<WareHouseVO>();
	
	ArrayList<WareHouseVO> air = new ArrayList<WareHouseVO>();
	ArrayList<WareHouseVO> car = new ArrayList<WareHouseVO>();
	ArrayList<WareHouseVO> rail = new ArrayList<WareHouseVO>();
	
	ArrayList<WareHouseVO> change = new ArrayList<WareHouseVO>();
	ArrayList<BalanceVO> balance = new ArrayList<BalanceVO>();
	
	Listener listener = new Listener();
	
	boolean isSaved = false;
	
	NavigationRepository nav;
	
	public RepositoryBalance() {
		// TODO Auto-generated constructor stub
		super.buttonNew = new ButtonNew("新增调整");
		super.confirm = new ButtonConfirm("提交调整");
		
//		nav = navigationRepository;
		
		initUI("库区调整");
		init();
	}
	
	private void init() {
		info.setBounds(480, 590, 200, 50);
		info.setForeground(Color.red);
		info.setFont(FontSet.twenty);
		panel.add(info);
		panel.add(pbp.getPanel());
		
		total = wareHouse.getWareHouse();
		
		if(total==null){
			showError(ErrorState.CONNECTERROR);
		}
		else {
			if(total.isEmpty()){
				showError(ErrorState.SEARCHERROR);
			}
			for(int i=0;i<total.size();i++){
				if(total.get(i).getArea_code()==StorageArea.AIR_TRANSPORTATION){
					air.add(total.get(i));
				}else if(total.get(i).getArea_code()==StorageArea.CAR_TRANSPORTATION){
					car.add(total.get(i));
				}else if(total.get(i).getArea_code()==StorageArea.RAILWAY_TRANSPORTATION){
					rail.add(total.get(i));
				}
			}
		}
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
		
		model.addTableModelListener(listener);
		
		FlatComboBox old_area = new FlatComboBox();
		old_area.addItem("航空区");
		old_area.addItem("汽运区");
		old_area.addItem("铁路区");
		
		FlatComboBox bar_code = new FlatComboBox();
		
		FlatComboBox new_area = new FlatComboBox();
		new_area.addItem("航空区");
		new_area.addItem("汽运区");
		new_area.addItem("铁路区");
		new_area.addItem("机动区");
		
		FlatComboBox row = new FlatComboBox();
		FlatComboBox shelf = new FlatComboBox();
		FlatComboBox position = new FlatComboBox();
		for(int i=1;i<=10;i++){
			row.addItem(i+"");
			shelf.addItem(i+"");
			position.addItem(i+"");
		}
		
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(0).setCellEditor(new DefaultCellEditor(old_area));
		tcm.getColumn(1).setCellEditor(new DefaultCellEditor(bar_code));
		
		tcm.getColumn(2).setCellEditor(new DefaultCellEditor(new_area));
		tcm.getColumn(3).setCellEditor(new DefaultCellEditor(row));
		tcm.getColumn(4).setCellEditor(new DefaultCellEditor(shelf));
		tcm.getColumn(5).setCellEditor(new DefaultCellEditor(position));
		
		sPanel = new ScrollPaneTable(table);
		
		panel.add(sPanel);
	}

	@Override
	protected void confirmAll() {
		// TODO Auto-generated method stub
		
		if(table.getRowCount()==0){
			info.setText("空的提交信息");
			return;
		}
		
		if(isSaved){
			info.setText("请勿重复提交");
			return;
		}
		
		for(int i=0;i<table.getRowCount();i++){
			String bar_code = table.getValueAt(i, 1).toString();
			
//			System.out.println(bar_code);
			WareHouseVO old = null;
			for(int j=0;j<total.size();j++){
				if(total.get(j).getBar_code().equals(bar_code)){
					old = total.get(j);
					break;
				}
			}
			
//			System.out.println(old);
			
			StorageArea new_area = Translater.getStorageArea(table.getValueAt(i, 2).toString());
			int new_row = Integer.parseInt(table.getValueAt(i, 3).toString());
			int new_shelf = Integer.parseInt(table.getValueAt(i, 4).toString());
			int new_position = Integer.parseInt(table.getValueAt(i, 5).toString());
			
			WareHouseVO ne = new WareHouseVO(bar_code, old.getDestination(), new_area, 
					new_row, new_shelf, new_position);
			
			BalanceVO bal = new BalanceVO(bar_code, Calendar.getInstance().getTime(),
					old.getDestination(), old.getArea_code(), 
					old.getRow(), old.getShelf(), old.getPosition(), 
					new_area, new_row, new_shelf, new_position);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			change.add(ne);
			balance.add(bal);
		}
		
		for(int i=0;i<change.size();i++){
			UpdateState state=wareHouse.updateWareHouse(change.get(i));
			if(state==UpdateState.CONNECTERROR){
				showError(ErrorState.CONNECTERROR);
				break;
			}
			else if(state==UpdateState.NOTFOUND){
				showError(ErrorState.UPDATEERROR);
			}
		}
		
		AddState state = repository.addBalance(balance);
		
		if(state==AddState.SUCCESS){
			nav.changeTask(3);
			nav.repositoryBalance.info.setText("保存成功");
		}else{
			if(state==AddState.CONNECTERROR){
				showError(ErrorState.CONNECTERROR);
			}
			else if(state==AddState.FAIL){
				showError(ErrorState.ADDERROR);
			}
			info.setText("保存失败");
		}
	}

	@Override
	protected VO getVO(Vector<String> vector) {
		// TODO Auto-generated method stub
		String bar_code = vector.get(0);
		
		
		return null;
	}
	
	public void initComboBox() {
		
	}
	
	private class Header extends JLabel {
		LabelHeader date = new LabelHeader("调整日期:");
//		JLabel area = new JLabel("原 库 区 :", JLabel.CENTER);
//		FlatComboBox area_actual = new FlatComboBox();
		public Header() {
			// TODO Auto-generated constructor stub
			init();
//			initComboBox();
		}
		
		private void init() {
			setBounds(120, 100, 400, 30);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			date.addInfo(sdf.format(Calendar.getInstance().getTime()));
			
			date.setBounds(0, 0, 400, 30);
			add(date);
			
//			area.setBounds(-12, 30, 100, 30);
//			area.setForeground(ColorPallet.Purple);
//			area.setFont(FontSet.eighteen);
//			add(area);
//			
//			area_actual.setBounds(76, 32, 60, 26);
//			area_actual.setFont(FontSet.eighteen);
//			add(area_actual);
		}
		
//		private void initComboBox() {
//			area_actual.addItem("航空区");
//			area_actual.addItem("汽运区");
//			area_actual.addItem("铁路区");
//		}
	}

	class Listener implements TableModelListener {

		@Override
		public void tableChanged(TableModelEvent e) {
			// TODO Auto-generated method stub
			int row = e.getLastRow();
			int column = e.getColumn();
			if (e.getType() == TableModelEvent.UPDATE) {
				if(column==0){
					if(table.getValueAt(row, column).equals("航空区")){
						System.out.println(e.getLastRow()+" "+e.getColumn());
						DefaultCellEditor editor = (DefaultCellEditor) table.getCellEditor(row, 1);
						FlatComboBox tmp = (FlatComboBox) editor.getComponent();
						tmp.removeAllItems();
						for(int i=0;i<air.size();i++){
							tmp.addItem(air.get(i).getBar_code());
						}
					}else if(table.getValueAt(row, column).equals("汽运区")){
						System.out.println(e.getLastRow()+" "+e.getColumn());
						DefaultCellEditor editor = (DefaultCellEditor) table.getCellEditor(row, 1);
						FlatComboBox tmp = (FlatComboBox) editor.getComponent();
						tmp.removeAllItems();
						for(int i=0;i<car.size();i++){
							tmp.addItem(car.get(i).getBar_code());
						}
					}else if(table.getValueAt(row, column).equals("铁路区")){
						System.out.println(e.getLastRow()+" "+e.getColumn());
						DefaultCellEditor editor = (DefaultCellEditor) table.getCellEditor(row, 1);
						FlatComboBox tmp = (FlatComboBox) editor.getComponent();
						tmp.removeAllItems();
						for(int i=0;i<rail.size();i++){
							tmp.addItem(rail.get(i).getBar_code());
						}
					}
				}
			}
		}
		
	}

	@Override
	public void performCancel() {
		MainFrame.changeContentPanel(new RepositoryBalance().getPanel());		
	}
}
