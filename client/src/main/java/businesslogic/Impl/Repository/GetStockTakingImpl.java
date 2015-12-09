package businesslogic.Impl.Repository;

import java.rmi.Naming;
import java.util.ArrayList;

import PO.StockTakingPO;
import PO.WareHousePO;
import State.StorageArea;
import VO.StockTakingVO;
import businesslogic.Service.Repository.GetStockTakingService;
import businesslogic.SystemLog.SystemLog;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchStockTakingService;
import data.Service.Sundry.WareHouseService;

// TODO: Auto-generated Javadoc
/**
 * The Class GetStockTakingImpl.
 */
public class GetStockTakingImpl implements GetStockTakingService{

	/* (non-Javadoc)
	 * @see businesslogic.Service.Repository.GetStockTakingService#getStockTaking()
	 */
	@Override
	public ArrayList<StockTakingVO> getStockTaking() {
		// TODO Auto-generated method stub
		ArrayList<StockTakingVO> stockTaking=new ArrayList<StockTakingVO>();
		try{
			WareHouseService wareHouse=(WareHouseService) Naming.lookup(RMIHelper.WAREHOUSE_IMPL);
			ArrayList<WareHousePO> ware=wareHouse.searchWareHouse(URLHelper.getWareHouseURL(SystemLog.getInstitutionId()));
			ArrayList<String> requirement=new ArrayList<String>();
			StorageArea area=ware.get(0).getArea_code();
			SearchStockTakingService stockSearch=(SearchStockTakingService) Naming.lookup(RMIHelper.SEARCH_STOCKTAKING_IMPL);
			requirement.add("area_code='"+area+"'");
			ArrayList<StockTakingPO> stockList=stockSearch.searchStockTaking(URLHelper.getStockTakingURL(SystemLog.getInstitutionId()), requirement);
			for(int i=0;i<stockList.size();i++){
				stockTaking.add(new StockTakingVO(stockList.get(i)));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return stockTaking;
	}

}
