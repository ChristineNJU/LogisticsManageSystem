package presentation.userPanel.Manager;

import java.util.ArrayList;
import java.util.Vector;

import State.ErrorState;
import VO.AccountVO;
import VO.GatheringVO;
import businesslogic.Impl.Finance.FinanceController;
import businesslogic.Service.Finance.FinanceService;
import presentation.components.ButtonConfirm;
import presentation.factory.TableFactory;
import presentation.factory.TableModelFactory;
import presentation.main.FunctionSearch;
import presentation.table.ScrollPaneTable;
import presentation.table.TableModelSearch;
import presentation.table.TableSearch;

public class ManagerAccount extends FunctionSearch{

	FinanceService service = new FinanceController();
//	ManageService service = new ManageController();
	ArrayList<AccountVO> accounts;
	
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
		if(accounts==null){
			showError(ErrorState.CONNECTERROR);
			tableV=new Vector<Vector<String>>();
		}
		else if(accounts.isEmpty()){
			showError(ErrorState.SEARCHERROR);
			tableV=getVector(accounts);
		}
		else {
			tableV=getVector(accounts);
		}
		tableV = getVector(accounts);
		model = TableModelFactory.getBankAccountModel(tableV);
		table = TableFactory.getBankAccountTable(model);
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
