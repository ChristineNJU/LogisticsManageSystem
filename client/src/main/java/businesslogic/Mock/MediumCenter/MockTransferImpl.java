package businesslogic.Mock.MediumCenter;

import State.AddState;
import VO.TransferVO;
import businesslogic.Impl.MediumCenter.TransferImpl;

public class MockTransferImpl extends TransferImpl{
	
	@Override
	public AddState transfer(TransferVO transfer) {
		// TODO Auto-generated method stub
		return AddState.SUCCESS;
	}
}
