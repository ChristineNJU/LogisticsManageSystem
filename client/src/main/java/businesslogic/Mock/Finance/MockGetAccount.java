package businesslogic.Mock.Finance;

import java.util.ArrayList;

import businesslogic.Impl.Finance.GetAccountImpl;
import businesslogic.VO.AccountVO;

public class MockGetAccount extends GetAccountImpl{
	public ArrayList<AccountVO> searchAccount(String name) {
		// TODO Auto-generated method stub
		 
		return new ArrayList<AccountVO>();
	}
}
