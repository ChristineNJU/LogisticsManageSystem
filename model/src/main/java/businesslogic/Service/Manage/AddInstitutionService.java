package businesslogic.Service.Manage;

import State.AddState;
import State.UpdateState;
import VO.InstitutionVO;
import VO.StaffVO;

public interface AddInstitutionService {
	 public AddState addInstitution (InstitutionVO institution);
}