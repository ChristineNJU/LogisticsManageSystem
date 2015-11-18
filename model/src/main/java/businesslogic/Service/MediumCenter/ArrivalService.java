package businesslogic.Service.MediumCenter;

import java.util.ArrayList;

import State.AddState;
import VO.ArrivalVO;

public interface ArrivalService {
	public AddState arrival(ArrayList<ArrivalVO> arrival);
}
