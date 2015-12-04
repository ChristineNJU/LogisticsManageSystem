package businesslogic.Service.Manage;

import State.UpdateState;
import VO.DistanceVO;

public interface UpdateDistanceService {
	
	public UpdateState updateDistance(DistanceVO distance);
}
