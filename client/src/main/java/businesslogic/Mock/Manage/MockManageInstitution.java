package businesslogic.Mock.Manage;

import java.util.ArrayList;

import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.InstitutionVO;
import businesslogic.Impl.Manage.ManageInstitution;

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
	public AddState addInstitution(InstitutionVO institution) {
		// TODO Auto-generated method stub
		return AddState.SUCCESS;
	}

}
