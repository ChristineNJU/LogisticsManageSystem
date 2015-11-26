package businesslogic.Service.Repository;

import java.util.ArrayList;

import State.AddState;
import VO.RemovalVO;

public interface AddRemovalService {
	
	public AddState addRemoval(ArrayList<RemovalVO> re);
}
