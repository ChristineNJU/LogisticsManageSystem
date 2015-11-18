package businesslogic.Mock.Manage;

import java.util.ArrayList;

import State.UpdateState;
import VO.VO;
import businesslogic.Impl.Manage.ManageReceipt;
public class MockManageReceipt extends ManageReceipt {
	
	@Override
	public UpdateState updateReceipt(VO receipt) {
		// TODO Auto-generated method stub
		return UpdateState.SUCCESS;
	}

	@Override
	public ArrayList<VO> showReceipt() {
		// TODO Auto-generated method stub
		return new ArrayList<VO>();
	}

}
