package businesslogic.Service.Finance;

import java.util.ArrayList;

import businesslogic.VO.AccountVO;

public interface GetAccountService {
	public ArrayList<AccountVO> searchAccount(String name);
}
