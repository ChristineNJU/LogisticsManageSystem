package presentation.userPanel.Finance;

import java.util.ArrayList;
import java.util.Vector;

import presentation.components.ButtonNew;
import presentation.main.FunctionADUS;
import presentation.table.ScrollPaneTable;
import presentation.table.TableADUS;
import presentation.table.TableModelADUS;
import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.AccountVO;
import businesslogic.Impl.Finance.AccountImpl;
import businesslogic.Service.Finance.AccountService;

public class FinanceAccount extends FunctionADUS{
	
	AccountService service=new AccountImpl(); 
	
	ArrayList<AccountVO> accounts;
	String[] tableH={"账户名称","账户余额"};
	boolean[] isCellEditable={true,false};
	
	ArrayList<AccountVO> addItems=new ArrayList<AccountVO>();
	ArrayList<AccountVO> deleteItems=new ArrayList<AccountVO>();
	ArrayList<AccountVO> searchItems=new ArrayList<AccountVO>();
	ArrayList<AccountVO> updateItems=new ArrayList<AccountVO>();
	
	public FinanceAccount(){
		buttonNew = new ButtonNew("新增账户");
		initUI("账户管理");
	}
	
	@Override
	protected void initTable() {
		// TODO Auto-generated method stub
		accounts=new ArrayList<AccountVO>();
		
		accounts=service.searchAccount("%%");
		
		tableV=getVector(accounts);
		
		model = new TableModelADUS(tableV, tableH,isCellEditable);
		table = new TableADUS(model);
		
		addDeleteColumn();
	    
	    table.addMouseListener(tableListener);
		sPanel = new ScrollPaneTable(table);
		panel.add(sPanel);
	}
	

	@Override
	protected void showSearchResult(String s) {
		// TODO Auto-generated method stub
		accounts=new ArrayList<AccountVO>();
		searchItems=service.searchAccount(s);
		model = new TableModelADUS(getVector(searchItems),tableH,isCellEditable);
		table.setModel(model);
		table.repaint();
		
	}

	@Override
	protected void confirmRevise() {
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
				break;
			}
			else if(deleteState==DeleteState.CONNECTERROR){
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
				break;
			}
			else if(updateState==UpdateState.CONNECTERROR){
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
				break;
			}
			else if(addState==AddState.CONNECTERROR){
				break;
			}
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
			
			result.add(vRow);
		}
		
		return result;
	}
 
}
