package businesslogic.Mock.Courier;

import data.State.UpdateState;
import businesslogic.Impl.Courier.ReceiveConfirmImpl;
import businesslogic.VO.VO;

public class MockReceiveConfirm extends ReceiveConfirmImpl{
	public UpdateState receiveConfirm(VO logistics_info, String field,
			String value) {
		// TODO Auto-generated method stub
		return UpdateState.SUCCESS;
	}
}
