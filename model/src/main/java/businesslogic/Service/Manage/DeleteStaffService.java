package businesslogic.Service.Manage;

import State.DeleteState;
import VO.StaffVO;

public interface DeleteStaffService {
	public DeleteState DeleteStaff (StaffVO staff);
}
