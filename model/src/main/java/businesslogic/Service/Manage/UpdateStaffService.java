package businesslogic.Service.Manage;

import State.UpdateState;
import VO.StaffVO;

public interface UpdateStaffService {
	public UpdateState updateStaff (StaffVO staff, String field, String value);
}
