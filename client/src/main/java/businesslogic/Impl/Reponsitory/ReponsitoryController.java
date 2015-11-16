package businesslogic.Impl.Reponsitory;

import java.util.ArrayList;

import data.State.AddState;
import businesslogic.Service.Reponsitory.*;
import businesslogic.State.OutputState;
import businesslogic.VO.StockTakingVO;

public class ReponsitoryController implements GetNeedStorageService,StockTakingConfirmService,
												StockTakingExcelService,StockTakingService{

	
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

}
