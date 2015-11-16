package businesslogic.Impl.Manage;

import java.util.ArrayList;

import data.State.AddState;
import data.State.UpdateState;
import businesslogic.Service.Manage.AddConstService;
import businesslogic.Service.Manage.ShowConstService;
import businesslogic.Service.Manage.UpdateConstService;
import businesslogic.VO.ConstVO;

public class ManageConst implements ShowConstService,UpdateConstService,AddConstService{

	@Override
	public ArrayList<ConstVO> showConst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateState updateConst(ConstVO constant, String field, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddState addConst(ConstVO constant) {
		// TODO Auto-generated method stub
		return null;
	}

}
