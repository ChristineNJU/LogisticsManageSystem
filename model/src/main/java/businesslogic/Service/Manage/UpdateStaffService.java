package businesslogic.Service.Manage;

import businesslogic.VO.StaffVO;
import data.State.UpdateState;

public interface UpdateStaffService {
	public UpdateState updateStaff (StaffVO staff, String field, String value);
}