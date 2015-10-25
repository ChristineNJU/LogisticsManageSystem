package businesslogic.Service.Manage;

import businesslogic.VO.ConstVO;
import data.State.UpdateState;

public interface UpdateConstService {
	public UpdateState updateConst(ConstVO constant, String field, String value);
}
