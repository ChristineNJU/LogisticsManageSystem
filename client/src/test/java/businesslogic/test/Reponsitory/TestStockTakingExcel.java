package businesslogic.test.Reponsitory;

import java.util.ArrayList;
import java.util.Date;

import junit.framework.TestCase;
import State.OutputState;
import State.StorageArea;
import VO.StockTakingVO;
import businesslogic.Impl.Repository.RepositoryController;

public class TestStockTakingExcel extends TestCase {
		
	public void testStockTakingExcel() {
		
		RepositoryController rc = new RepositoryController();
		ArrayList<StockTakingVO> stockTaking=new ArrayList<StockTakingVO>();
		stockTaking.add(new StockTakingVO("1000000000", new Date(), "南京", 
				StorageArea.CAR_TRANSPORTATION, 2, 4, 10));
		stockTaking.add(new StockTakingVO("1000000001", new Date(), "南京", 
				StorageArea.CAR_TRANSPORTATION, 2, 5, 11));
		assertEquals(OutputState.SUCCESS, rc.stockTakingExcel(stockTaking));
	}
}
