package businesslogic.Service.Reponsitory;

import java.util.ArrayList;

import VO.RemovalVO;
import data.State.AddState;

public interface RemovalService {
	
	public AddState removal(ArrayList<RemovalVO> re);
}
