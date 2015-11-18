package businesslogic.Service.Manage;

import State.DeleteState;
import VO.InstitutionVO;

public interface DeleteInstitutionService {
	public DeleteState deleteInstitution (InstitutionVO insitiution);
}
