package presentation.userPanel.Manager;

import java.util.Vector;

import VO.VO;
import presentation.components.ButtonNew;
import presentation.main.FunctionADUS;

public class ManagerStaffMgt extends FunctionADUS{

	public ManagerStaffMgt(){
		buttonNew = new ButtonNew("新增员工");
		initUI("员工管理");
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
