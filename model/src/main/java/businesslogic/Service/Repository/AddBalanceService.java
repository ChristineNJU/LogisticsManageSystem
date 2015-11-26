package businesslogic.Service.Repository;

import java.util.ArrayList;

import State.AddState;
import VO.BalanceVO;

public interface AddBalanceService {
	
	public AddState addBalance(ArrayList<BalanceVO> balance);
}
