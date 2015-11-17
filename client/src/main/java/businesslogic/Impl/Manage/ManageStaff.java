package businesslogic.Impl.Manage;

import java.util.ArrayList;

import data.State.AddState;
import data.State.DeleteState;
import data.State.UpdateState;
import VO.StaffVO;
import businesslogic.Service.Manage.AddStaffService;
import businesslogic.Service.Manage.DeleteStaffService;
import businesslogic.Service.Manage.SearchStaffService;
import businesslogic.Service.Manage.UpdateStaffService;

public class ManageStaff implements AddStaffService,UpdateStaffService,
									SearchStaffService,DeleteStaffService{

	@Override
	public DeleteState DeleteStaff(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<StaffVO> searchStaff(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateState updateStaff(StaffVO staff, String field, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddState addStaff(StaffVO staff) {
		// TODO Auto-generated method stub
		return null;
	}

}
