package businesslogic.Impl.Reponsitory;

import java.util.ArrayList;

import businesslogic.Service.Reponsitory.AlarmService;
import businesslogic.Service.Reponsitory.BalanceService;
import businesslogic.Service.Reponsitory.GetNeedRemovalService;
import businesslogic.Service.Reponsitory.GetNeedStorageService;
import businesslogic.Service.Reponsitory.RemovalService;
import businesslogic.Service.Reponsitory.SeeService;
import businesslogic.Service.Reponsitory.StockTakingConfirmService;
import businesslogic.Service.Reponsitory.StockTakingExcelService;
import businesslogic.Service.Reponsitory.StockTakingService;
import businesslogic.Service.Reponsitory.StorageService;
import businesslogic.State.OutputState;
import businesslogic.State.StorageState;
import businesslogic.VO.RemovalVO;
import businesslogic.VO.StockTakingVO;
import businesslogic.VO.StorageVO;
import businesslogic.VO.VO;
import data.State.AddState;

public class ReponsitoryController implements GetNeedStorageService,StockTakingConfirmService,
												StockTakingExcelService,StockTakingService, GetNeedRemovalService,
												SeeService, RemovalService, StorageService,
												AlarmService, BalanceService{

	
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
