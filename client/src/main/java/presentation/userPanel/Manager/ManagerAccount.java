package presentation.userPanel.Manager;

import java.util.ArrayList;
import java.util.Vector;

import VO.AccountVO;
import VO.GatheringVO;
import businesslogic.Impl.Finance.FinanceController;
import businesslogic.Service.Finance.FinanceService;
import presentation.components.ButtonConfirm;
import presentation.main.FunctionSearch;
import presentation.table.ScrollPaneTable;
import presentation.table.TableModelSearch;
import presentation.table.TableSearch;

public class ManagerAccount extends FunctionSearch{

	FinanceService service = new FinanceController();
//	ManageService service = new ManageController();
	ArrayList<AccountVO> accounts;
	String[] tableH = {"收款日期","收款金额(￥)","收款快递员","快递单号"};
	
	public ManagerAccount(){
		confirmSearch = new ButtonConfirm("");
		initUI("银行账户查看");
		panel.remove(confirmSearch);
	}
	
	@Override
	protected void initHeader() {
	}

	@Override
	protected void initTable() {
		accounts = service.searchAccount("%%");
		tableV = getVector(accounts);
		model = new TableModelSearch(tableV,tableH);
		table = new TableSearch(model);
		sPanel = new ScrollPaneTable(table);
		panel.add(sPanel);
		
	}

	private Vector<Vector<String>> getVector(ArrayList<AccountVO> accounts2) {
		Vector<Vector<String>> result = new Vector<Vector<String>>();
        for(AccountVO temp:accounts2){
        	Vector<String> vRow = new Vector<String>();
        	vRow.add(temp.getName());
        	vRow.add(temp.getMoney()+"");
        	result.add(vRow);
        }
		return result;
	}

	@Override
	protected void initFooter() {
		
	}

	@Override
	protected void showSearch() {
	}

}
