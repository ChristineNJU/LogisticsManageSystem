package presentation.userPanel.Finance;

import java.util.Vector;

import VO.VO;
import presentation.components.ButtonNew;
import presentation.main.FunctionADUS;

public class FinanceAccount extends FunctionADUS{

	public FinanceAccount(){
		buttonNew = new ButtonNew("新增账户");
		initUI("账户管理");
	}
	
	@Override
	protected void initTable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void showSearchResult(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void confirmRevise() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected VO getVO(Vector<String> vector) {
		// TODO Auto-generated method stub
		return null;
	}

}
