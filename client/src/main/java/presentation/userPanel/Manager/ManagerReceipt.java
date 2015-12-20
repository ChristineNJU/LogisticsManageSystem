package presentation.userPanel.Manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JLabel;

import presentation.components.ButtonConfirm;
import presentation.components.FlatComboBox;
import presentation.components.LabelHeader;
import presentation.main.ColorPallet;
import presentation.main.FontSet;
import presentation.main.FunctionSearch;
import presentation.table.ScrollPaneTable;
import presentation.table.TableModelSearch;
import presentation.table.TableSearch;
import State.ErrorState;
import State.UpdateState;
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
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	ManageService service = new ManageController();
	
	String[] tableH = {"", "", ""};
	boolean[] isCellEditable = {false, false, false};
	
	ArrayList<String[]> tableHV = new ArrayList<String[]>();
	
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
	
	ButtonConfirm confirm = new ButtonConfirm("确认审批");
	
	NavigationManager nav;
	
	public ManagerReceipt(NavigationManager navigationManager) {
		super.confirmSearch = new ButtonConfirm("查看单据");
		confirmSearch.setVisible(false);
		initTableHead();
		initUI("审批单据");
		
		nav = navigationManager;
		
		confirm.setLocation(120,175+sPanel.getHeight());
		confirm.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				UpdateState state = UpdateState.SUCCESS;
				switch(((Header)header).receipt_actual.getSelectedIndex()){
				case 0:
					for(int i=0;i<arrival.size();i++){
						state = service.updateReceipt(arrival.get(i));
						System.out.println(state);
					}
					break;
				case 1:
					for(int i=0;i<balance.size();i++){
						state = service.updateReceipt(balance.get(i));
					}
					break;
				case 2:
					for(int i=0;i<cost.size();i++){
						state = service.updateReceipt(cost.get(i));
					}
					break;
				case 3:
					for(int i=0;i<delivery.size();i++){
						state = service.updateReceipt(delivery.get(i));
					}
					break;
				case 4:
					for(int i=0;i<entrucking.size();i++){
						state = service.updateReceipt(entrucking.get(i));
					}
					break;
				case 5:
					for(int i=0;i<gathering.size();i++){
						state = service.updateReceipt(gathering.get(i));
					}
					break;
				case 6:
					for(int i=0;i<removal.size();i++){
						state = service.updateReceipt(removal.get(i));
					}
					break;
				case 7:
					for(int i=0;i<storage.size();i++){
						state = service.updateReceipt(storage.get(i));
					}
					break;
				case 8:
					for(int i=0;i<transfer.size();i++){
						state = service.updateReceipt(transfer.get(i));
					}
					break;
				default:
					break;
				}
				
				if(state==UpdateState.NOTFOUND){
					showError(ErrorState.UPDATEERROR);
				}
				else if(state==UpdateState.CONNECTERROR){
					showError(ErrorState.CONNECTERROR);
				}else{
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
		panel.add(confirm);
	}
	
	private void initTableHead() {
		String[] tmp_1 = {"快递单号","出发地","到达单编号"};
		tableHV.add(tmp_1);
		String[] tmp_2 = {"原区号", "快递编号", "新区号", "排号", "架号", "位号"};
		tableHV.add(tmp_2);
		String[] tmp_3 = {"付款日期","金额","付款人","付款账目","条目"};
		tableHV.add(tmp_3);
		String[] tmp_4 = {"日期", "派件人"};
		tableHV.add(tmp_4);
		String[] tmp_5 = {"日期", "中转单编号", "目的地"};
		tableHV.add(tmp_5);
		String[] tmp_6 = {"收款日期","收款金额","收款快递员"};
		tableHV.add(tmp_6);
		String[] tmp_7 = {"快递编号", "到达地", "出库日期"};
		tableHV.add(tmp_7);
		String[] tmp_8 = {"快递编号", "到达地", "入库日期"};
		tableHV.add(tmp_8);
		String[] tmp_9 = {"日期", "中转单编号", "目的地"};
		tableHV.add(tmp_9);
	}
	
	@Override
	protected void initHeader() {
		// TODO Auto-generated method stub
		header = new Header();
		panel.add(header);
	}

	@Override
	protected void initTable() {
		tableV = getArrivalVector(arrival);
		
		arrival = service.showArrival();
		balance = service.showBalance();
		cost = service.showCost();
		delivery = service.showDelivery();
		entrucking = service.showEntrucking();
		gathering = service.showGathering();
		removal = service.showRemoval();
		storage = service.showStorage();
		transfer = service.showTransfer();
		
		System.out.println(arrival.size());
		System.out.println(balance.size());
		System.out.println(cost.size());
		System.out.println(delivery.size());
		System.out.println(entrucking.size());
		System.out.println(gathering.size());
		System.out.println(removal.size());
		System.out.println(storage.size());
		System.out.println(transfer.size());
		
		model = new TableModelSearch(tableV, tableH);
		table = new TableSearch(model);
		
		sPanel = new ScrollPaneTable(table);
		panel.add(sPanel);
	}
	
	private Vector<Vector<String>> getTask(int i) {
		switch(i){
		case 0: return getArrivalVector(arrival);
		case 1: return getBalanceVector(balance);
		case 2: return getCostVector(cost);
		case 3: return getDeliveryVector(delivery);
		case 4: return getEntruckingVector(entrucking);
		case 5: return getGatheringVector(gathering);
		case 6: return getRemovalVector(removal);
		case 7: return getStorageVector(storage);
		case 8: return getTransferVector(transfer);
		default: return new Vector<Vector<String>>();
		}
	}
	
	private Vector<Vector<String>> getArrivalVector(ArrayList<ArrivalVO> voList) {
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		for(ArrivalVO vo: voList){
			Vector<String> tmp = new Vector<String>();
			tmp.add(vo.getBarCode());
			tmp.add(vo.getDeparture());
			tmp.add(vo.getListId());
			result.add(tmp);
		}
		return result;
	}
	
	private Vector<Vector<String>> getBalanceVector(ArrayList<BalanceVO> voList) {
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		for(BalanceVO vo: voList){
			Vector<String> tmp = new Vector<String>();
			tmp.add(vo.getAreaBefore()+"");
			tmp.add(vo.getBarCode());
			tmp.add(vo.getAreaCode()+"");
			tmp.add(vo.getRow()+"");
			tmp.add(vo.getShelf()+"");
			tmp.add(vo.getPosition()+"");
			result.add(tmp);
		}
		return result;
	}

	private Vector<Vector<String>> getCostVector(ArrayList<CostVO> voList) {
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		for(CostVO vo: voList) {
			Vector<String> tmp = new Vector<String>();
			tmp.add(sdf.format(vo.getDate()));
			tmp.add(vo.getAmount()+"");
			tmp.add(vo.getPayer());
			tmp.add(vo.getPayerAccount());
			tmp.add(vo.getType()+"");
			result.add(tmp);
		}
		return result;
	}

	private Vector<Vector<String>> getDeliveryVector(ArrayList<DeliveryVO> voList) {
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		for(DeliveryVO vo: voList){
			Vector<String> tmp = new Vector<String>();
			tmp.add(sdf.format(vo.getArrivalDate()));
			tmp.add(vo.getPeople());
			result.add(tmp);
		}
		return result;
	}
	
	private Vector<Vector<String>> getEntruckingVector(ArrayList<EntruckingVO> voList) {
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		for(EntruckingVO vo: voList){
			Vector<String> tmp = new Vector<String>();
			tmp.add(sdf.format(vo.getDate()));
			tmp.add(vo.getInstitutioNumber());
			tmp.add(vo.getDestination());
			result.add(tmp);
		}
		return result;
	}
	
	private Vector<Vector<String>> getGatheringVector(ArrayList<GatheringVO> voList) {
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		for(GatheringVO vo: voList){
			Vector<String> tmp = new Vector<String>();
			tmp.add(sdf.format(vo.getDate()));
			tmp.add(vo.getMoney()+"");
			tmp.add(vo.getName());
			result.add(tmp);
		}
		return result;
	}
	
	private Vector<Vector<String>> getRemovalVector(ArrayList<RemovalVO> voList) {
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		for(RemovalVO vo: voList){
			Vector<String> tmp = new Vector<String>();
			tmp.add(vo.getBarCode());
			tmp.add(sdf.format(vo.getOutDate()));
			tmp.add(vo.getDestination());
			result.add(tmp);
		}
		return result;
	}
	
	private Vector<Vector<String>> getStorageVector(ArrayList<StorageVO> voList) {
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		for(StorageVO vo: voList){
			Vector<String> tmp = new Vector<String>();
			tmp.add(vo.getBarCode());
			tmp.add(vo.getDestination());
			tmp.add(sdf.format(vo.getStorageDate()));
			result.add(tmp);
		}
		return result;
	}
	
	private Vector<Vector<String>> getTransferVector(ArrayList<TransferVO> voList) {
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		for(TransferVO vo: voList){
			Vector<String> tmp = new Vector<String>();
			tmp.add(sdf.format(vo.getDate()));
			tmp.add(vo.getTransferId());
			tmp.add(vo.getDestination());
			result.add(tmp);
		}
		return result;
	} 

	@Override
	protected void showSearch() {
		// TODO Auto-generated method stub
		int target = ((Header)header).receipt_actual.getSelectedIndex();
		
		tableV = getTask(target);
		tableH = tableHV.get(target);
		
		model = new TableModelSearch(tableV, tableH);
		table.setModel(model);
		table.repaint();
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
		JLabel receipt = new JLabel("单据类型：", JLabel.CENTER);
		FlatComboBox receipt_actual = new FlatComboBox();
		Header() {
			setBounds(120, 80, 400, 60);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			date.addInfo(sdf.format(Calendar.getInstance().getTime()));
			
			date.setBounds(0, 0, 400, 30);
			add(date);
			
			receipt.setBounds(-55, 30, 200, 30);
			receipt.setFont(FontSet.eighteen);
			receipt.setForeground(ColorPallet.Purple);
			add(receipt);
			
			receipt_actual.setBounds(90, 32, 90, 28);
			receipt_actual.addItem("到达单");
			receipt_actual.addItem("库存调整单");
			receipt_actual.addItem("出款单");
			receipt_actual.addItem("派件单");
			receipt_actual.addItem("装车单");
			receipt_actual.addItem("收款单");
			receipt_actual.addItem("出库单");
			receipt_actual.addItem("入库单");
			receipt_actual.addItem("中转单");
			add(receipt_actual);
			
			initListener();
		}
		
		private void initListener() {
			receipt_actual.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					showSearch();
				}
			});;
		}
	}
}
