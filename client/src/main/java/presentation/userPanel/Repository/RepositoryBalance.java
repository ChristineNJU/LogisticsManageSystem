package presentation.userPanel.Repository;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JLabel;

import businesslogic.Impl.Repository.GetWareHouseImpl;
import businesslogic.Service.Repository.GetWareHouseService;
import presentation.components.ButtonConfirm;
import presentation.components.ButtonNew;
import presentation.components.FlatComboBox;
import presentation.components.LabelHeader;
import presentation.main.ColorPallet;
import presentation.main.FontSet;
import presentation.main.FunctionAdd;
import presentation.table.ScrollPaneTable;
import presentation.table.TableAddOnly;
import presentation.table.TableModelAddOnly;
import State.StorageArea;
import VO.BalanceVO;
import VO.VO;
import VO.WareHouseVO;

public class RepositoryBalance extends FunctionAdd {

	GetWareHouseService getWareHouse = new GetWareHouseImpl();
	
	private ProgressBarPanel pbp = new ProgressBarPanel();
	
	String[] tableH = {"快递编号", "现在的区号", "排号", "架号", "位号", ""};
	boolean[] isCellEditable = {true, true, true, true, true, false};
	
	Vector<Vector<String>> vector = new Vector<Vector<String>>();
	
	JLabel info = new JLabel();
	
	ArrayList<WareHouseVO> air = new ArrayList<WareHouseVO>();
	ArrayList<WareHouseVO> car = new ArrayList<WareHouseVO>();
	ArrayList<WareHouseVO> rail = new ArrayList<WareHouseVO>();
	
	ArrayList<WareHouseVO> change = new ArrayList<WareHouseVO>();
	ArrayList<BalanceVO> balance = new ArrayList<BalanceVO>();
	
	public RepositoryBalance() {
		// TODO Auto-generated constructor stub
		super.buttonNew = new ButtonNew("新增调整");
		super.confirm = new ButtonConfirm("提交调整");
		
		initUI("库区调整");
		init();
	}
	
	private void init() {
		info.setBounds(480, 590, 200, 50);
		info.setForeground(Color.red);
		info.setFont(FontSet.twenty);
		panel.add(info);
		panel.add(pbp.getPanel());
		
		ArrayList<WareHouseVO> tmp = getWareHouse.getWareHouse();
		for(int i=0;i<tmp.size();i++){
			if(tmp.get(i).getArea_code()==StorageArea.AIR_TRANSPORTATION){
				air.add(tmp.get(i));
			}else if(tmp.get(i).getArea_code()==StorageArea.CAR_TRANSPORTATION){
				car.add(tmp.get(i));
			}else if(tmp.get(i).getArea_code()==StorageArea.RAILWAY_TRANSPORTATION){
				rail.add(tmp.get(i));
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
		
		sPanel = new ScrollPaneTable(table);
		panel.add(sPanel);
	}

	@Override
	protected void confirmAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected VO getVO(Vector<String> vector) {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	
	
	private class Header extends JLabel {
		LabelHeader date = new LabelHeader("调整日期:");
		JLabel area = new JLabel("原 库 区 :", JLabel.CENTER);
		FlatComboBox area_actual = new FlatComboBox();
		public Header() {
			// TODO Auto-generated constructor stub
			init();
			initComboBox();
		}
		
		private void init() {
			setBounds(120, 80, 680, 600);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			date.addInfo(sdf.format(Calendar.getInstance().getTime()));
			
			date.setBounds(0, 0, 400, 30);
			add(date);
			
			area.setBounds(-12, 30, 100, 30);
			area.setForeground(ColorPallet.Purple);
			area.setFont(FontSet.eighteen);
			add(area);
			
			area_actual.setBounds(76, 32, 60, 26);
			area_actual.setFont(FontSet.eighteen);
			add(area_actual);
		}
		
		private void initComboBox() {
			area_actual.addItem("航空区");
			area_actual.addItem("汽运区");
			area_actual.addItem("铁路区");
		}
	}
}
