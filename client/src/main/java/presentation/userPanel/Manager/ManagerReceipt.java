package presentation.userPanel.Manager;

import java.util.ArrayList;
import java.util.Vector;

import VO.VO;
import businesslogic.Impl.Manage.ManageReceipt;
import businesslogic.Service.Manage.ShowReceiptService;
import businesslogic.Service.Manage.UpdateReceiptService;
import presentation.main.FunctionSearch;
import presentation.table.TableModelReceipt;

public class ManagerReceipt extends FunctionSearch{

	ShowReceiptService serviceShow = new ManageReceipt();
	UpdateReceiptService serviceUpdate = new ManageReceipt();
	
	String[] tableH = {"单据类型"};
	boolean[] isCellEditable = {false};
	
	ArrayList<VO> voList = new ArrayList<VO>();
	
	@Override
	protected void initHeader() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initTable() {
		voList = serviceShow.showReceipt();
		tableV = getVector(voList);
		
//		model = new TableModelReceipt(tableV,tableH,isCellEitable);
	}

	private Vector<Vector<String>> getVector(ArrayList<VO> voList2) {
		Vector<Vector<String>> result= new  Vector<Vector<String>>();
		for(VO temp:voList2){
			Vector<String> oneItem = new Vector<String>();
			//TODO
		}
		
		return result;
	}

	@Override
	protected void showSearch() {
		// TODO Auto-generated method stub
		
	}

	protected VO getVO(Vector<String> vector) {
		// TODO Auto-generated method stub
		return null;
	}

}
