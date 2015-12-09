package businesslogic.Service.Manage;

import java.util.ArrayList;

import VO.StaffVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface GetStaffService.
 */
public interface GetStaffService {
	
	/**
	 * Search staff.
	 *
	 * @param id the id
	 * @return the array list
	 */
	public ArrayList<StaffVO> searchStaff (String id);
}
