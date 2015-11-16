package businesslogic.Mock.Manage;

import java.util.ArrayList;

import data.State.UpdateState;
import businesslogic.Impl.Manage.ManageReceipt;
import businesslogic.VO.VO;
import data.State.*;
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
