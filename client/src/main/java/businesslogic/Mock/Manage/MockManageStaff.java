package businesslogic.Mock.Manage;
import java.util.ArrayList;

import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.StaffVO;
import businesslogic.Impl.Manage.ManageStaff;
public class MockManageStaff extends ManageStaff {
	@Override
	public DeleteState DeleteStaff(StaffVO staff) {
		// TODO Auto-generated method stub
		return DeleteState.SUCCESS;
	}

	@Override
	public ArrayList<StaffVO> searchStaff(String id) {
		// TODO Auto-generated method stub
		return new ArrayList<StaffVO>();
	}


	@Override
	public AddState addStaff(StaffVO staff) {
		// TODO Auto-generated method stub
		return AddState.SUCCESS;
	}
}
