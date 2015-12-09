package businesslogic.Service.Manage;

import State.AddState;
import VO.StaffVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface AddStaffService.
 */
public interface AddStaffService {
	
	/**
	 * Adds the staff.
	 *
	 * @param staff the staff
	 * @return the adds the state
	 */
	public AddState addStaff (StaffVO staff);
}
