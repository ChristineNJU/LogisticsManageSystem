package businesslogic.Service.Manage;

import State.DeleteState;
import VO.StaffVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface DeleteStaffService.
 */
public interface DeleteStaffService {
	
	/**
	 * Delete staff.
	 *
	 * @param staff the staff
	 * @return the delete state
	 */
	public DeleteState DeleteStaff (StaffVO staff);
}
