package businesslogic.Service.Manage;

import State.AddState;
import VO.InstitutionVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface AddInstitutionService.
 */
public interface AddInstitutionService {
	 
 	/**
 	 * Adds the institution.
 	 *
 	 * @param institution the institution
 	 * @return the adds the state
 	 */
 	public AddState addInstitution (InstitutionVO institution);
}