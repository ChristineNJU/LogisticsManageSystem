package businesslogic.Service.Courier;

import dataservice.State.UpdateState;

public interface ReceiveConfirmSerivce {
	public UpdateState receiveConfirm(VO logistics_info, String field, String value);
}
