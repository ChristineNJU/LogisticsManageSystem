package businesslogic.Service.Manage;

import businesslogic.VO.InstitutionVO;
import businesslogic.VO.StaffVO;
import data.State.AddState;
import data.State.UpdateState;

public interface AddInstitutionService {
	 public AddState addInstitution (InstitutionVO institution);
}