package businesslogic.Impl.Repository;

import java.util.ArrayList;

import State.AddState;
import State.OutputState;
import State.StorageState;
import VO.RemovalVO;
import VO.StockTakingVO;
import VO.StorageVO;
import VO.VO;
import businesslogic.Service.Repository.ReponsitoryService;

public class RepositoryController implements ReponsitoryService{

	
	@Override
	public ArrayList<StockTakingVO> stockTaking() {
		// TODO Auto-generated method stub
		StockTakingImpl stockTaking=new StockTakingImpl();
		return stockTaking.stockTaking();
	}

	@Override
	public OutputState stockTakingExcel() {
		// TODO Auto-generated method stub
		StockTakingExcelImpl stockTakingExcel=new StockTakingExcelImpl();
		return stockTakingExcel.stockTakingExcel();
	}

	@Override
	public AddState stockTakingConfirm() {
		// TODO Auto-generated method stub
		StockTakingConfirmImpl stockTakingConfirm=new StockTakingConfirmImpl();
		return stockTakingConfirm.stockTakingConfirm();
	}

	@Override
	public String getNeedStorage() {
		// TODO Auto-generated method stub
		GetNeedStorageImpl getNeedStorage=new GetNeedStorageImpl();
		return getNeedStorage.getNeedStorage();
	}

	@Override
	public AddState balance() {
		// TODO Auto-generated method stub
		BalanceImpl balance = new BalanceImpl();
		return balance.balance();
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
	public ArrayList<VO> see(String time_start, String time_end) {
		// TODO Auto-generated method stub
		SeeImpl see = new SeeImpl();
		return see.see(time_start, time_end);
	}

	@Override
	public ArrayList<String> getNeedRemoval() {
		// TODO Auto-generated method stub
		GetNeedRemovalImpl gnr = new GetNeedRemovalImpl();
		return gnr.getNeedRemoval();
	}

	@Override
	public AddState removal(ArrayList<RemovalVO> re) {
		// TODO Auto-generated method stub
		RemovalImpl removal = new RemovalImpl();
		return removal.removal(re);
	}

}
