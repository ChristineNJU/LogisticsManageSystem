package businesslogic.Mock.Repository;

import java.util.ArrayList;

import businesslogic.Impl.Reponsitory.StorageImpl;
import businesslogic.State.StorageState;
import businesslogic.VO.StorageVO;

public class MockStorage extends StorageImpl{

	@Override
	public StorageState storage(ArrayList<StorageVO> storage) {
		// TODO Auto-generated method stub
		return StorageState.SUCCESS;
	}
}
