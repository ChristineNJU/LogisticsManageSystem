package businesslogic.Service.Manage;

import java.util.ArrayList;

import businesslogic.VO.InstitutionVO;

public interface SearchInstitutionService {
	public ArrayList<InstitutionVO> searchInstitution (String id);
}
