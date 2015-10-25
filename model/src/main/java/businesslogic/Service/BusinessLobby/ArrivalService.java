package businesslogic.Service.BusinessLobby;

import java.util.ArrayList;

import businesslogic.VO.ArrivalVO;
import dataservice.State.AddState;

public interface ArrivalService {
	public AddState arrival(ArrayList<ArrivalVO> arrival);
}
