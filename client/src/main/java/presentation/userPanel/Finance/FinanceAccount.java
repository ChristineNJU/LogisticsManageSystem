package presentation.userPanel.Finance;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import presentation.components.ButtonNew;
import presentation.factory.TableFactory;
import presentation.factory.TableModelFactory;
import presentation.frame.MainFrame;
import presentation.main.FunctionADUS;
import presentation.table.ScrollPaneTable;
import State.AddState;
import State.DeleteState;
import State.ErrorState;
import State.UpdateState;
import VO.AccountVO;
import businesslogic.Impl.Finance.FinanceController;
import businesslogic.Service.Finance.FinanceService;

public class FinanceAccount extends FunctionADUS{
	
	FinanceService service=new FinanceController(); 
	
	ArrayList<AccountVO> accounts;
	
	ArrayList<AccountVO> addItems=new ArrayList<AccountVO>();
	ArrayList<AccountVO> deleteItems=new ArrayList<AccountVO>();
	ArrayList<AccountVO> searchItems=new ArrayList<AccountVO>();
	ArrayList<AccountVO> updateItems=new ArrayList<AccountVO>();
	
	NavigationFinance nav;
	
	public FinanceAccount(NavigationFinance navigationFinance){
		buttonNew = new ButtonNew("新增账户");
		initUI("账户管理");
		
		nav = navigationFinance;
	}
	
	@Override
	protected void initTable() {
		// TODO Auto-generated method stub
		accounts=new ArrayList<AccountVO>();
		
		accounts=service.searchAccount("%%");
		if(accounts!=null){
			tableV=getVector(accounts);
		}
		else {
			tableV=new Vector<Vector<String>>();
			super.isConnectError=true;
		}
		
		model = TableModelFactory.getFinanceModel(tableV);
		table = TableFactory.getFinanceTable(model);
	    
	    table.addMouseListener(tableListener);
		sPanel = new ScrollPaneTable(table);
		panel.add(sPanel);
		
		model.addTableModelListener(new ErrorListener());
	}
	

	@Override
	protected void showSearchResult(String s) {
		// TODO Auto-generated method stub
		accounts=new ArrayList<AccountVO>();
		searchItems=service.searchAccount(s);
		model = TableModelFactory.getFinanceModel(tableV);
		table.setModel(model);
		table.repaint();
		
	}

	@Override
	public void performConfirm() {
		// TODO Auto-generated method stub
		deleteItems=new ArrayList<AccountVO>();
		for(int i=0;i<tableV.size();i++){
			if(model.isDelete(i)){
				deleteItems.add(getVO(tableV.get(i)));
			}
		}
		DeleteState deleteState=DeleteState.FAIL;
		for(int i=0;i<deleteItems.size();i++){
			deleteState=service.deleteAccount(deleteItems.get(i));
			if(deleteState==DeleteState.FAIL){
				showError(ErrorState.DELETEERROR);
				break;
			}
			else if(deleteState==DeleteState.CONNECTERROR){
				showError(ErrorState.CONNECTERROR);
				break;
			}
		}
		
		updateItems=new ArrayList<AccountVO>();
		for(int i=0;i<tableV.size();i++){
			if(model.isUpdate(i)){
				updateItems.add(getVO(tableV.get(i)));
			}
		}
		UpdateState updateState=UpdateState.NOTFOUND;
		for(int i=0;i<updateItems.size();i++){
			updateState=service.updateAccount(updateItems.get(i));
			if(updateState==UpdateState.NOTFOUND){
				showError(ErrorState.UPDATEERROR);
				break;
			}
			else if(updateState==UpdateState.CONNECTERROR){
				showError(ErrorState.CONNECTERROR);
				break;
			}
		}
		
		addItems=new ArrayList<AccountVO>();
		for(int i=0;i<tableV.size();i++){
			if(model.isNew(i)){
				addItems.add(getVO(tableV.get(i)));
			}
		}
		AddState addState=AddState.FAIL;
		for(int i=0;i<addItems.size();i++){
			addState=service.addAccount(addItems.get(i));
			if(addState==AddState.FAIL){
				showError(ErrorState.ADDERROR);
				break;
			}
			else if(addState==AddState.CONNECTERROR){
				showError(ErrorState.CONNECTERROR);
				break;
			}
		}
		
		if(addState==AddState.SUCCESS&&updateState==UpdateState.SUCCESS&&deleteState==DeleteState.SUCCESS){
			nav.changeTask(1);
		}
	}
	protected void newItem() {
		model.addEmptyRow();
		 int lastIndex = table.getRowCount()-1;
         table.changeSelection(lastIndex, 0,false,false);
	}

	@Override
	protected AccountVO getVO(Vector<String> vector) {
		// TODO Auto-generated method stub
		AccountVO account=null;
		account=new AccountVO(vector.get(0).trim(),Double.parseDouble(vector.get(1).trim()));
		return account;
	}
	
	protected Vector<Vector<String>> getVector(ArrayList<AccountVO> voList){
		Vector<Vector<String>> result=new Vector<Vector<String>>();
		for(AccountVO temp:voList){
			Vector<String> vRow=new Vector<String>();
			vRow.add(temp.getName());
			vRow.add(String.valueOf(temp.getMoney()));
			vRow.add("");
			
			result.add(vRow);
		}
		
		return result;
	}

	@Override
	public void performCancel() {
//		MainFrame.changeContentPanel(new FinanceAccount().getPanel());
		nav.changeTask(1);
	}
	
	class ErrorListener implements TableModelListener {

		@Override
		public void tableChanged(TableModelEvent e) {
			int row = e.getLastRow();
			int column = e.getColumn();
			boolean isLeagel = true;
			if(column==-1){
				buttonNew.setEnabled(true);
				confirm.setEnabled(true);
			}else{				
				String content = model.getValueAt(row, column);
				if(content.equals("")){
					model.setLeagel(row, column, false);
					buttonNew.setEnabled(false);
					confirm.setEnabled(false);
					return;
				}else{
					model.setLeagel(row, column, true);
				}
				if(model.allLeagel()){
					buttonNew.setEnabled(true);
					confirm.setEnabled(true);
				}
			}
		}
	}
}
