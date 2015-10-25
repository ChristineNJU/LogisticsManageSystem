package businesslogic.Service.MediumCenter;

import businesslogic.VO.TransferVO;
import data.State.AddState;

public interface TransferService {
	public AddState transfer(TransferVO transfer);
}
