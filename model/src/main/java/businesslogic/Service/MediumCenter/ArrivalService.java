package businesslogic.Service.MediumCenter;

import java.util.ArrayList;

import businesslogic.VO.ArrivalVO;
import data.State.AddState;

public interface ArrivalService {
	public AddState arrival(ArrayList<ArrivalVO> arrival);
}
