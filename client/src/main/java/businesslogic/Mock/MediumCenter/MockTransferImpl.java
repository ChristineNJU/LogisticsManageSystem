package businesslogic.Mock.MediumCenter;

import data.State.AddState;
import VO.TransferVO;
import businesslogic.Impl.MediumCenter.TransferImpl;
import data.State.*;

public class MockTransferImpl extends TransferImpl{
	
	@Override
	public AddState transfer(TransferVO transfer) {
		// TODO Auto-generated method stub
		return AddState.SUCCESS;
	}
}
