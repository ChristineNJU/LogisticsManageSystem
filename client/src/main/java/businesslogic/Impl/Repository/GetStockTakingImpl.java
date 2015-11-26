package businesslogic.Impl.Repository;

import java.util.ArrayList;

import PO.WareHousePO;
import VO.StockTakingVO;
import businesslogic.Service.Repository.GetStockTakingService;

public class GetStockTakingImpl implements GetStockTakingService{

	@Override
	public ArrayList<StockTakingVO> getStockTaking(ArrayList<WareHousePO> warehouse) {
		// TODO Auto-generated method stub
		ArrayList<StockTakingVO> stockTaking=new ArrayList<StockTakingVO>();
		
		return stockTaking;
	}

}
