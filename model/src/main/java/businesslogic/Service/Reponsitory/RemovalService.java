package businesslogic.Service.Reponsitory;

import java.util.ArrayList;

import State.AddState;
import VO.RemovalVO;

public interface RemovalService {
	
	public AddState removal(ArrayList<RemovalVO> re);
}
