package presentation.userPanel.Manager;

import java.util.Vector;

import VO.VO;
import presentation.components.ButtonNew;
import presentation.main.MgtFourFunctions;

public class ManagerInsititutionMgt extends MgtFourFunctions{

	public ManagerInsititutionMgt(){
		buttonNew = new ButtonNew("新增机构");
		initUI("机构管理");
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
