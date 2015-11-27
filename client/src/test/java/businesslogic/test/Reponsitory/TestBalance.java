package businesslogic.test.Reponsitory;

import java.util.ArrayList;
import java.util.Date;

import junit.framework.TestCase;
import State.AddState;
import State.StorageArea;
import VO.BalanceVO;
import businesslogic.Impl.Repository.RepositoryController;

public class TestBalance extends TestCase {
	
	public void testBalance() {
		
		RepositoryController rc = new RepositoryController();
		ArrayList<BalanceVO> balance=new ArrayList<BalanceVO>();
		balance.add(new BalanceVO("1000000000", new Date(), "南京", StorageArea.RAILWAY_TRANSPORTATION,
				2, 2, 10, StorageArea.MANOEUVERING_AREA, 2, 3, 2));
		assertEquals(AddState.SUCCESS, rc.addBalance(balance));
	}
}
