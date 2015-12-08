package presentation.userPanel.Manager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JLabel;

import presentation.components.ButtonConfirm;
import presentation.components.FlatComboBox;
import presentation.components.LabelHeader;
import presentation.main.FunctionSearch;
import presentation.table.ScrollPaneTable;
import presentation.table.TableModelSearch;
import presentation.table.TableSearch;
import VO.ArrivalVO;
import VO.BalanceVO;
import VO.CostVO;
import VO.DeliveryVO;
import VO.EntruckingVO;
import VO.GatheringVO;
import VO.RemovalVO;
import VO.StorageVO;
import VO.TransferVO;
import VO.VO;
import businesslogic.Impl.Manage.ManageController;
import businesslogic.Service.Manage.ManageService;

public class ManagerReceipt extends FunctionSearch{
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	ManageService service = new ManageController();
	
	String[] tableH = {"单据类型", "主要信息", ""};
	boolean[] isCellEditable = {false, false, false};
	
	String[][] tableAH = {{}};
	
	ArrayList<ArrivalVO> arrival = new ArrayList<ArrivalVO>();
	ArrayList<BalanceVO> balance = new ArrayList<BalanceVO>();
	ArrayList<CostVO> cost = new ArrayList<CostVO>();
	ArrayList<DeliveryVO> delivery = new ArrayList<DeliveryVO>();
	ArrayList<EntruckingVO> entrucking = new ArrayList<EntruckingVO>();
	ArrayList<GatheringVO> gathering = new ArrayList<GatheringVO>();
	ArrayList<RemovalVO> removal = new ArrayList<RemovalVO>();
	ArrayList<StorageVO> storage = new ArrayList<StorageVO>();
	ArrayList<TransferVO> transfer = new ArrayList<TransferVO>();
	
	ArrayList<VO> voList = new ArrayList<VO>();
	
	public ManagerReceipt() {
		super.confirmSearch = new ButtonConfirm("");
		
		initUI("审批单据");
	}
	
	@Override
	protected void initHeader() {
		// TODO Auto-generated method stub
		header = new Header();
		panel.add(header);
	}

	@Override
	protected void initTable() {
		tableV = getVector(voList);
		
		arrival = service.showArrival();
		balance = service.showBalance();
		cost = service.showCost();
		delivery = service.showDelivery();
		entrucking = service.showEntrucking();
		gathering = service.showGathering();
		removal = service.showRemoval();
		storage = service.showStorage();
		transfer = service.showTransfer();
		
		model = new TableModelSearch(tableV, tableH);
		table = new TableSearch(model);
		
		sPanel = new ScrollPaneTable(table);
		panel.add(sPanel);
	}

	private Vector<Vector<String>> getVector(ArrayList<VO> voList2) {
		Vector<Vector<String>> result= new  Vector<Vector<String>>();
		for(VO temp:voList2){
			Vector<String> oneItem = new Vector<String>();
			//TODO
			if(temp instanceof ArrivalVO){
				oneItem.add("到达单");
				oneItem.add(((ArrivalVO)temp).getBarCode());
			}else if(temp instanceof BalanceVO){
				oneItem.add("库存调整单");
				oneItem.add(((BalanceVO)temp).getBarCode());
			}else if(temp instanceof CostVO){
				oneItem.add("出款单");
				oneItem.add(((CostVO)temp).getPayer());
			}else if(temp instanceof DeliveryVO){
				oneItem.add("派件单");
				oneItem.add(sdf.format(((DeliveryVO)temp).getArrivalDate()));
			}else if(temp instanceof EntruckingVO){
				oneItem.add("装车单");
				oneItem.add(((EntruckingVO)temp).getCarNumber());
			}else if(temp instanceof GatheringVO){
				oneItem.add("收款单");
				oneItem.add(sdf.format(((GatheringVO)temp).getDate()));
			}else if(temp instanceof RemovalVO){
				oneItem.add("出库单");
				oneItem.add(((RemovalVO)temp).getBarCode());
			}else if(temp instanceof StorageVO){
				oneItem.add("入库单");
				oneItem.add(((StorageVO)temp).getBarCode());
			}else if(temp instanceof TransferVO){
				oneItem.add("中转单");
				oneItem.add(((TransferVO)temp).getTransferId());
			}
			
			result.add(oneItem);
		}
		
		return result;
	}

	@Override
	protected void showSearch() {
		// TODO Auto-generated method stub
		
	}

	protected VO getVO(Vector<String> vector) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void initFooter() {
		// TODO Auto-generated method stub
		
	}

	class Header extends JLabel {
		LabelHeader date = new LabelHeader("当前日期：");
		Header() {
			setBounds(120, 100, 400, 30);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			date.addInfo(sdf.format(Calendar.getInstance().getTime()));
			
			date.setBounds(0, 0, 400, 30);
			add(date);
		}
	}
}
