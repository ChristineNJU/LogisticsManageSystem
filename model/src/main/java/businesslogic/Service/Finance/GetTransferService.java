package businesslogic.Service.Finance;

import java.util.ArrayList;

public interface GetTransferService {
	public ArrayList<TransferVO> getTransfer(String time_start, String time_end);
}
