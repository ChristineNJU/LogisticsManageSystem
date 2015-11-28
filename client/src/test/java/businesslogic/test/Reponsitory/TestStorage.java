package businesslogic.test.Reponsitory;

import java.util.ArrayList;
import java.util.Date;

import junit.framework.TestCase;
import State.StorageArea;
import State.StorageState;
import VO.StorageVO;
import businesslogic.Impl.Repository.RepositoryController;

public class TestStorage extends TestCase {
	
	public void testStorage() {
		
		RepositoryController rc = new RepositoryController();
		ArrayList<StorageVO> storage=new ArrayList<StorageVO>();
		storage.add(new StorageVO("1000000000", new Date(), "南京", StorageArea.CAR_TRANSPORTATION,
				2, 4, 5));
		assertEquals(StorageState.SUCCESS, rc.storage(storage));
	}
}
