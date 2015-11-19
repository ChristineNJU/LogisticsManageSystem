package businesslogic.Service.Manage;

import java.util.ArrayList;

import VO.InstitutionVO;

public interface GetInstitutionService {
	public ArrayList<InstitutionVO> searchInstitution (String id);
}
