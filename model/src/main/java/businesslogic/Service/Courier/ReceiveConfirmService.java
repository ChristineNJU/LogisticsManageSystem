package businesslogic.Service.Courier;

import businesslogic.VO.VO;
import data.State.UpdateState;

public interface ReceiveConfirmService {
	public UpdateState receiveConfirm(VO logistics_info, String field, String value);
}
