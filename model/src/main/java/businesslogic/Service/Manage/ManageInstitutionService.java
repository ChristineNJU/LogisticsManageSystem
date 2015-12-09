package businesslogic.Service.Manage;

import java.util.ArrayList;

import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.InstitutionVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ManageInstitutionService.
 */
public interface ManageInstitutionService {

	/**
	 * 添加机构.
	 *
	 * @param institution InstitutionVO
	 * @return 添加状态
	 */
	public AddState addInstitution (InstitutionVO institution);
	
	/**
	 * 删除机构.
	 *
	 * @param insitiution InstitutionVO
	 * @return 删除状态
	 */
	public DeleteState deleteInstitution (InstitutionVO insitiution);
	
	/**
	 * 查询机构信息.
	 *
	 * @param id 机构ID
	 * @return InstitutionVO的ArrayList
	 */
	public ArrayList<InstitutionVO> searchInstitution (String id);
	
	/**
	 * 更新机构.
	 *
	 * @param institution institutionVO
	 * @return 更新状态
	 */
	public UpdateState UpdateInstitution (InstitutionVO institution);
	
}
