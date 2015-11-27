package businesslogic.test.Reponsitory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import junit.framework.TestCase;
import State.StorageArea;
import VO.StockTakingVO;
import businesslogic.Impl.Repository.RepositoryController;

public class TestStockTakingConfirm extends TestCase {
	
	public void testStockTakingConfirm() {
		SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		RepositoryController rc = new RepositoryController();
		ArrayList<StockTakingVO> stock=new ArrayList<StockTakingVO>();
		try {
			stock.add(new StockTakingVO("1000000000", sdf.parse("2015-11-01 00:00:00"), "南京", 
					StorageArea.CAR_TRANSPORTATION, 2, 4, 10));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(null, rc.stockTakingConfirm(stock));
	}
}
