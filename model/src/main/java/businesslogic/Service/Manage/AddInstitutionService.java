package businesslogic.Service.Manage;

import State.AddState;
import State.UpdateState;
import VO.InstitutionVO;
import VO.StaffVO;

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