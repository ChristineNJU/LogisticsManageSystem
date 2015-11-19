package businesslogic.Mock.Repository;

import java.util.ArrayList;

import State.StorageState;
import VO.StorageVO;
import businesslogic.Impl.Reponsitory.StorageImpl;

public class MockStorage extends StorageImpl{

	@Override
	public StorageState storage(ArrayList<StorageVO> storage) {
		// TODO Auto-generated method stub
		return StorageState.SUCCESS;
	}
}
