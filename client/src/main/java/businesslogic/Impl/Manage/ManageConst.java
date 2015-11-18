package businesslogic.Impl.Manage;

import java.util.ArrayList;

import State.AddState;
import State.UpdateState;
import VO.ConstVO;
import businesslogic.Service.Manage.AddConstService;
import businesslogic.Service.Manage.ShowConstService;
import businesslogic.Service.Manage.UpdateConstService;

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
