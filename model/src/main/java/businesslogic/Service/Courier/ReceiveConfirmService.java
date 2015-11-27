package businesslogic.Service.Courier;

import State.UpdateState;
import VO.VO;

public interface ReceiveConfirmService {
	public UpdateState receiveConfirm(VO logistics_info);
}
