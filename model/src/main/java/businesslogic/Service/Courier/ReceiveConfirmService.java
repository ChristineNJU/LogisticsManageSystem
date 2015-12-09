package businesslogic.Service.Courier;

import State.UpdateState;
import VO.VO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ReceiveConfirmService.
 */
public interface ReceiveConfirmService {
	
	/**
	 * Receive confirm.
	 *
	 * @param logistics_info the logistics_info
	 * @return the update state
	 */
	public UpdateState receiveConfirm(VO logistics_info);
}
