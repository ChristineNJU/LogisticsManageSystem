package businesslogic.Impl.Businesslobby;

import java.rmi.Naming;
import java.util.ArrayList;

import PO.AccountPO;
import PO.GatheringPO;
import State.AddState;
import VO.AccountVO;
import VO.GatheringVO;
import businesslogic.Service.BusinessLobby.GatheringService;
import businesslogic.Service.Finance.UpdateAccountService;
import businesslogic.SystemLog.SystemLog;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;
import data.Service.Search.SearchAccountService;
import data.Service.Sundry.InstitutionStorageService;

// TODO: Auto-generated Javadoc
/**
 * The Class GatheringImpl.
 * 营业厅收款单的实现
 * 
 * @see AddService
 */
public class GatheringImpl implements GatheringService{

	/* (non-Javadoc)
	 * @see businesslogic.Service.BusinessLobby.GatheringService#gathering(VO.GatheringVO)
	 */
	@Override
	public AddState gathering(GatheringVO gathering) {
		// TODO Auto-generated method stub
		AddState state=AddState.SUCCESS;
		try{
			AddService gatheringAdd=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
		
			state=gatheringAdd.add(new GatheringPO(gathering, SystemLog.getInstitutionId()));
		
			//添加到营业厅暂存
			InstitutionStorageService istorageservice=(InstitutionStorageService) Naming.lookup(RMIHelper.INSTITUTION_STORAGE_IMPL);
			for(String bar_code:gathering.id()){
				istorageservice.addInstitutionStorage(bar_code, true, URLHelper.getInstitutionStorage(SystemLog.getInstitutionId()),true);
				
			}
			
			
			SearchAccountService searchAccount=(SearchAccountService) Naming.lookup(RMIHelper.SEARCH_ACCOUNT_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("account_name like '%%'");
			AccountPO account=searchAccount.searchAccount(requirement).get(0);
			UpdateAccountService updateAccount=(UpdateAccountService) Naming.lookup(RMIHelper.UPDATE_IMPL);
			account.setAmount(account.getAmount()+gathering.getMoney());
			updateAccount.updateAccount(new AccountVO(account));
			
		} catch(Exception ex){
			state=AddState.CONNECTERROR;
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return state;
	}

}
