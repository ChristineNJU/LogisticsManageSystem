package businesslogic.Impl.Finance;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import PO.AccountPO;
import PO.CarInfoPO;
import PO.InstitutionPO;
import PO.PeriodPO;
import PO.StoragePO;
import PO.UserPO;
import State.AddState;
import State.UpdateState;
import VO.PeriodVO;
import businesslogic.Service.Finance.PeriodService;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;
import data.Service.Search.SearchAccountService;
import data.Service.Search.SearchCarInfoService;
import data.Service.Search.SearchInstitutionInfoService;
import data.Service.Search.SearchPeriodService;
import data.Service.Search.SearchStorageService;
import data.Service.Search.SearchUserService;
import data.Service.Update.UpdateService;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodImpl.
 */
public class PeriodImpl implements PeriodService{

	/* (non-Javadoc)
	 * @see businesslogic.Service.Finance.PeriodService#updatePeriod()
	 */
	@Override
	public UpdateState updatePeriod(PeriodVO vo) {
		// TODO Auto-generated method stub
		UpdateState state=UpdateState.SUCCESS;
		
		try {
			UpdateService service = (UpdateService) Naming.lookup(RMIHelper.UPDATE_IMPL);
			
			SearchAccountService acc = (SearchAccountService) Naming.lookup(RMIHelper.SEARCH_ACCOUNT_IMPL);
			
			ArrayList<String> requirement = new ArrayList<String>();
			requirement.add("account_name like '%%'");
			
			ArrayList<AccountPO> account = acc.searchAccount(requirement);
			
			PeriodPO po = new PeriodPO(vo, account);
			
			state = service.update(po);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return UpdateState.CONNECTERROR;
		}
		
		return state;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Finance.PeriodService#getPeriod()
	 */
	@Override
	public PeriodVO getPeriod() {
		// TODO Auto-generated method stub
		PeriodVO period=null;
		try{
			SearchPeriodService periodSearch=(SearchPeriodService) Naming.lookup(RMIHelper.SEARCH_PERIOD_IMPL);
			
			System.out.println(periodSearch.searchPeriod()+"hhhhh");
			
			period=new PeriodVO(periodSearch.searchPeriod());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return period;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Finance.PeriodService#addPeriod()
	 */
	@Override
	public AddState addPeriod() {
		// TODO Auto-generated method stub
		AddState state=AddState.SUCCESS;
		try{
			
			AddService addPeriod=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
			
			SearchInstitutionInfoService institutionSearch=(SearchInstitutionInfoService) Naming.lookup(RMIHelper.SEARCH_INSTITUTION_IMPL);
			SearchUserService userSearch=(SearchUserService) Naming.lookup(RMIHelper.SEARCH_USER_IMPL);	
			SearchCarInfoService carSearch=(SearchCarInfoService) Naming.lookup(RMIHelper.SEARCH_CARINFO_IMPL);
			SearchStorageService storageSearch=(SearchStorageService) Naming.lookup(RMIHelper.SEARCH_STORAGE_IMPL);
			SearchAccountService accountSearch=(SearchAccountService) Naming.lookup(RMIHelper.SEARCH_ACCOUNT_IMPL);
			
			//---------------------------------------------------------------------------------------
			
			Date date=Calendar.getInstance().getTime();
			int institution_size=0;
			int staff_size=0;
			int car_size=0;
			int storage_size=0;
			ArrayList<AccountPO> account=new ArrayList<AccountPO>();
			ArrayList<String> requirementInsti=new ArrayList<String>();
			ArrayList<String> requirementStaff=new ArrayList<String>();
			ArrayList<String> requirementCar=new ArrayList<String>();
			ArrayList<String> requirementStorage=new ArrayList<String>();
			ArrayList<String> requirementAccount=new ArrayList<String>();
			
			requirementInsti.add("name like '%%'");
			requirementStaff.add("name like '%%'");
			requirementCar.add("car_number like '%%'");
			requirementStorage.add("bar_coder like '%%'");
			
			//----------------------------------------------------------------------------------------
			
			ArrayList<InstitutionPO> institutionList=institutionSearch.searchInstitutionInfo(requirementInsti);
			ArrayList<UserPO> userList=userSearch.searchUser(requirementStaff);
			account=accountSearch.searchAccount(requirementAccount);
			
			institution_size=institutionList.size();
			staff_size=userList.size();
			
			//------------------------------------------------------------------------------------------
		
			ArrayList<CarInfoPO> carList=new ArrayList<CarInfoPO>();
			ArrayList<StoragePO> storageList=new ArrayList<StoragePO>();
			
			for(int i=0;i<institutionList.size();i++){
				carList=carSearch.searchCarInfo(institutionList.get(i).getInstitutionNumber(), requirementCar);
				storageList=storageSearch.searchStorage(institutionList.get(i).getInstitutionNumber(), requirementStorage);
				car_size+=carList.size();
				storage_size+=storageList.size();
			}
			
			//-------------------------------------------------------------------------------------------
			
			state=addPeriod.add(new PeriodPO(date, institution_size, staff_size, car_size, storage_size, account, URLHelper.getPeriodURL()));
			
		} catch (Exception ex) { 
			state=AddState.CONNECTERROR;
			ex.printStackTrace();
		}
		return state;
	}
	

}
