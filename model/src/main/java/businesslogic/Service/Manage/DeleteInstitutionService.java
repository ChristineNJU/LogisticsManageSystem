package businesslogic.Service.Manage;

import State.DeleteState;
import VO.InstitutionVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface DeleteInstitutionService.
 */
public interface DeleteInstitutionService {
	
	/**
	 * Delete institution.
	 *
	 * @param insitiution the insitiution
	 * @return the delete state
	 */
	public DeleteState deleteInstitution (InstitutionVO insitiution);
}
