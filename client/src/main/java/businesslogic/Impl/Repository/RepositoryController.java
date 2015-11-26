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
import VO.VO;
import businesslogic.Service.Repository.ReponsitoryService;

public class RepositoryController implements ReponsitoryService{

	
	@Override
	public ArrayList<StockTakingVO> getStockTaking(ArrayList<WareHousePO> warehouse) {
		// TODO Auto-generated method stub
		GetStockTakingImpl stockTaking=new GetStockTakingImpl();
		return stockTaking.getStockTaking(warehouse);
	}

	@Override
	public OutputState stockTakingExcel() {
		// TODO Auto-generated method stub
		StockTakingExcelImpl stockTakingExcel=new StockTakingExcelImpl();
		return stockTakingExcel.stockTakingExcel();
	}

	@Override
	public AddState stockTakingConfirm(ArrayList<StockTakingVO> stockList) {
		// TODO Auto-generated method stub
		StockTakingConfirmImpl stockTakingConfirm=new StockTakingConfirmImpl();
		return stockTakingConfirm.stockTakingConfirm(stockList);
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
		return balance.addBalance(balanceList);
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
		return s.storage(storage);
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
		return removal.addRemoval(re);
	}

}
