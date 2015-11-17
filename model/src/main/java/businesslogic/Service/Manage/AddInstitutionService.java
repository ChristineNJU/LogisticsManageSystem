package businesslogic.Service.Manage;

import VO.InstitutionVO;
import VO.StaffVO;
import data.State.AddState;
import data.State.UpdateState;

public interface AddInstitutionService {
	 public AddState addInstitution (InstitutionVO institution);
}