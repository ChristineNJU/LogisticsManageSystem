package businesslogic.Service.Manage;

import java.util.ArrayList;

import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.StaffVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ManageStaffService.
 */
public interface ManageStaffService {

	/**
	 * 添加人员.
	 *
	 * @param staff the staff
	 * @return 添加状态
	 */
	public AddState addStaff (StaffVO staff);
	
	/**
	 * 删除人员.
	 *
	 * @param staff StaffVO
	 * @return 删除状态
	 */
	public DeleteState DeleteStaff (StaffVO staff);
	
	/**
	 * 更新人员.
	 *
	 * @param staff StaffVO
	 * @return 更新状态
	 */
	public UpdateState updateStaff (StaffVO staff);
	
	/**
	 * 查询人员.
	 *
	 * @param id 人员ID
	 * @return StaffVO的ArrayList
	 */
	public ArrayList<StaffVO> searchStaff (String id);
	
}
