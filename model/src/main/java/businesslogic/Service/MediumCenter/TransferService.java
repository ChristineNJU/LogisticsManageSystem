package businesslogic.Service.MediumCenter;

import State.AddState;
import VO.TransferVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface TransferService.
 */
public interface TransferService {
	
	/**
	 * Transfer.
	 *
	 * @param transfer the transfer
	 * @return the adds the state
	 */
	public AddState transfer(TransferVO transfer);
}
