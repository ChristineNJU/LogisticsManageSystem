package businesslogic.Mock.MediumCenter;
import VO.EntruckingVO;
import businesslogic.Impl.MediumCenter.EntruckingImpl;
import data.State.*;

public class MockEntruckingImpl extends EntruckingImpl{

	@Override
	public AddState entrucking(EntruckingVO entrucking) {
		// TODO Auto-generated method stub
		return AddState.SUCCESS;
	}

}
