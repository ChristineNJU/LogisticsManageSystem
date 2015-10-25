package businesslogic.Service.Manage;

import businesslogic.VO.InstitutionVO;
import dataservice.State.DeleteState;

public interface DeleteInstitutionService {
	public DeleteState deleteInstitution (InstitutionVO insitiution);
}
