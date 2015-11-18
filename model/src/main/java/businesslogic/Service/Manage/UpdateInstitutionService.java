package businesslogic.Service.Manage;

import State.UpdateState;
import VO.InstitutionVO;

public interface UpdateInstitutionService {
	public UpdateState UpdateInstitution (InstitutionVO institution, String field,String value);
}
