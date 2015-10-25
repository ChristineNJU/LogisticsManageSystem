package businesslogic.Service.Manage;

import businesslogic.VO.StaffVO;
import dataservice.State.AddState;

public interface AddStaffService {
	public AddState addStaff (StaffVO staff);
}
