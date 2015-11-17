package businesslogic.Mock.Manage;

import java.util.ArrayList;

import data.State.AddState;
import data.State.DeleteState;
import data.State.UpdateState;
import VO.InstitutionVO;
import businesslogic.Impl.Manage.ManageInstitution;
import data.State.*;

public class MockManageInstitution extends ManageInstitution{

	@Override
	public ArrayList<InstitutionVO> searchInstitution(String id) {
		// TODO Auto-generated method stub
		return new ArrayList<InstitutionVO>();
	}

	@Override
	public DeleteState deleteInstitution(InstitutionVO insitiution) {
		// TODO Auto-generated method stub
		return DeleteState.SUCCESS;
	}

	@Override
	public UpdateState UpdateInstitution(InstitutionVO institution,
			String field, String value) {
		// TODO Auto-generated method stub
		return UpdateState.SUCCESS;
	}

	@Override
	public AddState addInstitution(InstitutionVO institution) {
		// TODO Auto-generated method stub
		return AddState.SUCCESS;
	}

}
