package businesslogic.Mock.Manage;

import java.util.ArrayList;

import data.State.AddState;
import data.State.UpdateState;
import VO.ConstVO;
import businesslogic.Impl.Manage.ManageConst;
import data.State.*;

public class MockManageConst extends ManageConst{
	
	@Override
	public ArrayList<ConstVO> showConst() {
		// TODO Auto-generated method stub
		return new ArrayList<ConstVO>();
	}

	@Override
	public UpdateState updateConst(ConstVO constant, String field, String value) {
		// TODO Auto-generated method stub
		return UpdateState.SUCCESS;
	}

	@Override
	public AddState addConst(ConstVO constant) {
		// TODO Auto-generated method stub
		return AddState.SUCCESS;
	}

}
