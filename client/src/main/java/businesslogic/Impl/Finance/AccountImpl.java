package businesslogic.Impl.Finance;

import java.rmi.Naming;
import java.util.ArrayList;

import PO.AccountPO;
import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.AccountVO;
import businesslogic.Service.Finance.AddAccountService;
import businesslogic.Service.Finance.DeleteAccountService;
import businesslogic.Service.Finance.GetAccountService;
import businesslogic.Service.Finance.UpdateAccountService;
import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;
import data.Service.Delete.DeleteService;
import data.Service.Search.SearchAccountService;
import data.Service.Update.UpdateService;

public class AccountImpl implements AddAccountService, DeleteAccountService, GetAccountService, UpdateAccountService{

	@Override
	public UpdateState updateAccount(AccountVO account) {
		// TODO Auto-generated method stub
		UpdateState state=UpdateState.SUCCESS;
		try{
			SearchAccountService accountGet=(SearchAccountService) Naming.lookup(RMIHelper.SEARCH_ACCOUNT_IMPL);
			UpdateService accountUpdate=(UpdateService) Naming.lookup(RMIHelper.UPDATE_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("name='"+account.getName()+"'");
			ArrayList<AccountPO> accountList=accountGet.searchAccount(requirement);
			for(int i=0;i<accountList.size();i++){
				state=accountUpdate.update(accountList.get(i));
			}
		} catch(Exception ex){
			state=UpdateState.CONNECTERROR;
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return state;
	}

	@Override
	public ArrayList<AccountVO> searchAccount(String name) {
		// TODO Auto-generated method stub
		ArrayList<AccountVO> result=new ArrayList<AccountVO>();
		try{
			SearchAccountService accountSearch=(SearchAccountService) Naming.lookup(RMIHelper.SEARCH_ACCOUNT_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("name='"+name+"'");
			ArrayList<AccountPO> accountList=accountSearch.searchAccount(requirement);
			for(int i=0;i<accountList.size();i++){
				result.add(new AccountVO(accountList.get(i)));
			}
		} catch(Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public DeleteState deleteAccount(AccountVO account) {
		// TODO Auto-generated method stub
		DeleteState state=DeleteState.SUCCESS;
		try{
			DeleteService accountDelete=(DeleteService) Naming.lookup(RMIHelper.DELETE_IMPL);
			SearchAccountService accountSearch=(SearchAccountService) Naming.lookup(RMIHelper.SEARCH_ACCOUNT_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("name='"+account.getName()+"'");
			ArrayList<AccountPO> accountList=accountSearch.searchAccount(requirement);
			for(int i=0;i<accountList.size();i++){
				state=accountDelete.delete(accountList.get(i));
			}
		} catch(Exception ex){
			state=DeleteState.CONNECTERROR;
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return state;
	}

	@Override
	public AddState addAccount(AccountVO account) {
		// TODO Auto-generated method stub
		AddState state=AddState.SUCCESS;
		try{
			AddService accountAdd=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
			state=accountAdd.add(new AccountPO(account));
		} catch(Exception ex){
			state=AddState.CONNECTERROR;
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return state;
	}

}
