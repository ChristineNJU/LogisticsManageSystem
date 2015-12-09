package businesslogic.Service.Manage;

import java.util.ArrayList;

import VO.InstitutionVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface GetInstitutionService.
 */
public interface GetInstitutionService {
	
	/**
	 * Search institution.
	 *
	 * @param id the id
	 * @return the array list
	 */
	public ArrayList<InstitutionVO> searchInstitution (String id);
}
