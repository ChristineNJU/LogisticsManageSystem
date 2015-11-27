package businesslogic.Impl.Repository;

import java.util.ArrayList;

import PO.WareHousePO;
import State.AddState;
import State.OutputState;
import State.StorageState;
import VO.BalanceVO;
import VO.RemovalVO;
import VO.StockTakingVO;
import VO.StorageVO;
import businesslogic.Service.Repository.ReponsitoryService;
import businesslogic.SystemLog.SystemLog;

public class RepositoryController implements ReponsitoryService{

	
	@Override
	public ArrayList<StockTakingVO> getStockTaking() {
		// TODO Auto-generated method stub
		GetStockTakingImpl stockTaking=new GetStockTakingImpl();
		return stockTaking.getStockTaking();
	}

	@Override
	public OutputState stockTakingExcel() {
		// TODO Auto-generated method stub
		StockTakingExcelImpl stockTakingExcel=new StockTakingExcelImpl();
		OutputState state = stockTakingExcel.stockTakingExcel();
		if(state==OutputState.SUCCESS){
			SystemLog.addLog("导出盘点信息");
		}
		return state;
	}

	@Override
	public AddState stockTakingConfirm(ArrayList<StockTakingVO> stockList) {
		// TODO Auto-generated method stub
		StockTakingConfirmImpl stockTakingConfirm=new StockTakingConfirmImpl();
		AddState state = stockTakingConfirm.stockTakingConfirm(stockList);
		if(state==AddState.SUCCESS){
			SystemLog.addLog("添加盘点信息");
		}
		return state;
	}

	@Override
	public ArrayList<StorageVO> getNeedStorage(String destination) {
		// TODO Auto-generated method stub
		GetNeedStorageImpl getNeedStorage=new GetNeedStorageImpl();
		return getNeedStorage.getNeedStorage(destination);
	}

	@Override
	public AddState addBalance(ArrayList<BalanceVO> balanceList) {
		// TODO Auto-generated method stub
		BalanceImpl balance = new BalanceImpl();
		AddState state = balance.addBalance(balanceList);
		if(state==AddState.SUCCESS){
			SystemLog.addLog("添加库存调整信息");
		}
		return state;
	}

	@Override
	public boolean alarm() {
		// TODO Auto-generated method stub
		AlarmImpl alarm = new AlarmImpl();
		return alarm.alarm();
	}

	@Override
	public StorageState storage(ArrayList<StorageVO> storage) {
		// TODO Auto-generated method stub
		StorageImpl s = new StorageImpl();
		StorageState state = s.storage(storage);
		if(state!=StorageState.FAIL){
			SystemLog.addLog("添加入库单信息");
		}
		return state;
	}

	@Override
	public ArrayList<StorageVO> seeStorage(String time_start, String time_end) {
		// TODO Auto-generated method stub
		SeeImpl see = new SeeImpl();
		return see.seeStorage(time_start, time_end);
	}
	
	public ArrayList<RemovalVO> seeRemoval(String time_start, String time_end) {
		// TODO Auto-generated method stub
		SeeImpl see = new SeeImpl();
		return see.seeRemoval(time_start, time_end);
	}

	@Override
	public ArrayList<RemovalVO> getNeedRemoval(String destination) {
		// TODO Auto-generated method stub
		GetNeedRemovalImpl gnr = new GetNeedRemovalImpl();
		return gnr.getNeedRemoval(destination);
	}

	@Override
	public AddState addRemoval(ArrayList<RemovalVO> re) {
		// TODO Auto-generated method stub
		RemovalImpl removal = new RemovalImpl();
		AddState state = removal.addRemoval(re);
		if(state==AddState.SUCCESS){
			SystemLog.addLog("添加出库单信息");
		}
		return state;
	}

}
