package businesslogic.Service.Manage;

import dataservice.State.UpdateState;

public interface UpdateStaffService {
	public UpdateState updateStaff (StaffVO staff, String field, String value);
}
