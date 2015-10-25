package businesslogic.Service.MediumCenter;

import businesslogic.VO.TransferVO;
import dataservice.State.AddState;

public interface TransferService {
	public AddState transfer(TransferVO transfer);
}
