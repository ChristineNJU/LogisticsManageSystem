package businesslogic.Service.BusinessLobby;

import java.util.ArrayList;

import VO.ArrivalVO;
import data.State.AddState;

public interface ArrivalService {
	public AddState arrival(ArrayList<ArrivalVO> arrival);
}
