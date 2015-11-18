package businesslogic.Service.Manage;

import State.UpdateState;
import VO.ConstVO;

public interface UpdateConstService {
	public UpdateState updateConst(ConstVO constant, String field, String value);
}
