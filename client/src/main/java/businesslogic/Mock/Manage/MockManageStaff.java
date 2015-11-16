package businesslogic.Mock.Manage;
import java.util.ArrayList;

import data.State.AddState;
import data.State.DeleteState;
import data.State.UpdateState;
import businesslogic.Impl.Manage.ManageStaff;
import businesslogic.VO.StaffVO;
import data.State.*;
public class MockManageStaff extends ManageStaff {
	@Override
	public DeleteState DeleteStaff(String id) {
		// TODO Auto-generated method stub
		return DeleteState.SUCCESS;
	}

	@Override
	public ArrayList<StaffVO> searchStaff(String id) {
		// TODO Auto-generated method stub
		return new ArrayList<StaffVO>();
	}

	@Override
	public UpdateState updateStaff(StaffVO staff, String field, String value) {
		// TODO Auto-generated method stub
		return UpdateState.SUCCESS;
	}

	@Override
	public AddState addStaff(StaffVO staff) {
		// TODO Auto-generated method stub
		return AddState.SUCCESS;
	}
}
