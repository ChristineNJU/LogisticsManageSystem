package businesslogic.Service.Manage;

import businesslogic.VO.InstitutionVO;
import data.State.UpdateState;

public interface AddInstitutionService {
	public UpdateState UpdateInstitution (InstitutionVO institution, String field,String value);
}
