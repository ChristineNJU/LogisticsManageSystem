package businesslogic.Service.Repository;

import java.util.ArrayList;

import State.AddState;
import VO.BalanceVO;

public interface BalanceService {
	
	public AddState balance(ArrayList<BalanceVO> balance);
}
