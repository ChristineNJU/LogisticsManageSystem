package businesslogic.Service.Finance;

import java.util.ArrayList;

import VO.TransferVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface GetTransferService.
 */
public interface GetTransferService {
	
	/**
	 * Gets the transfer.
	 *
	 * @param time_start the time_start
	 * @param time_end the time_end
	 * @return the transfer
	 */
	public ArrayList<TransferVO> getTransfer(String time_start, String time_end);
}
