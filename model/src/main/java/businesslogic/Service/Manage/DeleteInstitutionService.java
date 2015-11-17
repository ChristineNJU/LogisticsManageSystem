package businesslogic.Service.Manage;

import VO.InstitutionVO;
import data.State.DeleteState;

public interface DeleteInstitutionService {
	public DeleteState deleteInstitution (InstitutionVO insitiution);
}
