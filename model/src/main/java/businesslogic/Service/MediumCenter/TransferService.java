package businesslogic.Service.MediumCenter;

import VO.TransferVO;
import data.State.AddState;

public interface TransferService {
	public AddState transfer(TransferVO transfer);
}
