package presentation.userPanel.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

import presentation.main.FunctionAdd;
import VO.RemovalVO;
import VO.VO;
import businesslogic.Impl.Repository.RepositoryController;

public class RepositoryRemovall extends FunctionAdd{

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	RepositoryController service = new RepositoryController();
	ArrayList<RemovalVO> needRemoval;
	
	String[]  tableH = {"",""};
	
	@Override
	protected void initHeader() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initTable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void confirmAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected VO getVO(Vector<String> vector) {
		// TODO Auto-generated method stub
		return null;
	}

}
