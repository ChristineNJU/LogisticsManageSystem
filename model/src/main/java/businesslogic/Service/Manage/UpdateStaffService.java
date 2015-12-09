package businesslogic.Service.Manage;

import State.UpdateState;
import VO.StaffVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface UpdateStaffService.
 */
public interface UpdateStaffService {
	
	/**
	 * Update staff.
	 *
	 * @param staff the staff
	 * @return the update state
	 */
	public UpdateState updateStaff (StaffVO staff);
}
