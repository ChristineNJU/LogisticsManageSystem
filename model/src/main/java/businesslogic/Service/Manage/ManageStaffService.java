package businesslogic.Service.Manage;

import java.util.ArrayList;

import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.StaffVO;

public interface ManageStaffService {
	public AddState addStaff (StaffVO staff);
	public DeleteState DeleteStaff (StaffVO staff);
	public ArrayList<StaffVO> searchStaff (String id);
	public UpdateState updateStaff (StaffVO staff);
}
