package businesslogic.Service.Finance;

import java.util.ArrayList;

import VO.TransferVO;

public interface GetTransferService {
	public ArrayList<TransferVO> getTransfer(String time_start, String time_end);
}
