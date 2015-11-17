package businesslogic.Service.Finance;

import java.util.ArrayList;

import VO.AccountVO;

public interface GetAccountService {
	public ArrayList<AccountVO> searchAccount(String name);
}
