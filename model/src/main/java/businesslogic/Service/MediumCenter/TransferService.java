package businesslogic.Service.MediumCenter;

import State.AddState;
import VO.TransferVO;

public interface TransferService {
	public AddState transfer(TransferVO transfer);
}
