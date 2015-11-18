package businesslogic.Mock.MediumCenter;
import State.AddState;
import VO.EntruckingVO;
import businesslogic.Impl.MediumCenter.EntruckingImpl;

public class MockEntruckingImpl extends EntruckingImpl{

	@Override
	public AddState entrucking(EntruckingVO entrucking) {
		// TODO Auto-generated method stub
		return AddState.SUCCESS;
	}

}
