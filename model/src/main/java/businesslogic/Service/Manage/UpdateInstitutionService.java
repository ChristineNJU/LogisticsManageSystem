package businesslogic.Service.Manage;

import State.UpdateState;
import VO.InstitutionVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface UpdateInstitutionService.
 */
public interface UpdateInstitutionService {
	
	/**
	 * Update institution.
	 *
	 * @param institution the institution
	 * @return the update state
	 */
	public UpdateState UpdateInstitution (InstitutionVO institution);
}
