package businesslogic.Service.Manage;

import businesslogic.VO.InstitutionVO;
import dataservice.State.UpdateState;

public interface UpdateInstitutionService {
	public UpdateState UpdateInstitution (InstitutionVO institution, String field,String value);
}
