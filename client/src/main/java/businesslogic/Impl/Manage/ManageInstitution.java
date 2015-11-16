package businesslogic.Impl.Manage;

import java.util.ArrayList;

import data.State.AddState;
import data.State.DeleteState;
import data.State.UpdateState;
import businesslogic.Service.Manage.AddInstitutionService;
import businesslogic.Service.Manage.DeleteInstitutionService;
import businesslogic.Service.Manage.SearchInstitutionService;
import businesslogic.Service.Manage.UpdateInstitutionService;
import businesslogic.VO.InstitutionVO;

public class ManageInstitution implements AddInstitutionService,UpdateInstitutionService,
											DeleteInstitutionService,SearchInstitutionService{

	@Override
	public ArrayList<InstitutionVO> searchInstitution(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteState deleteInstitution(InstitutionVO insitiution) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateState UpdateInstitution(InstitutionVO institution,
			String field, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddState addInstitution(InstitutionVO institution) {
		// TODO Auto-generated method stub
		return null;
	}

}
