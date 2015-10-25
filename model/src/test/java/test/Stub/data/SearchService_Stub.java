package test.Stub.data;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.PO.ArrivalPO;
import businesslogic.PO.BalancePO;
import businesslogic.PO.BenefitPO;
import businesslogic.PO.CarInfoPO;
import businesslogic.PO.ConstPO;
import businesslogic.PO.DeliveryPO;
import businesslogic.PO.DriverInfoPO;
import businesslogic.PO.EntruckingPO;
import businesslogic.PO.InstitutionPO;
import businesslogic.PO.LogPO;
import businesslogic.PO.LogisticsInfoPO;
import businesslogic.PO.PeriodPO;
import businesslogic.PO.RemovalPO;
import businesslogic.PO.SalaryPO;
import businesslogic.PO.StockTakingPO;
import businesslogic.PO.StoragePO;
import businesslogic.PO.TransferPO;
import businesslogic.PO.UserPO;
import businesslogic.Service.Finance.SearchAccountService;
import businesslogic.Service.Finance.SearchCostService;
import businesslogic.Service.Finance.SearchGatheringService;
import businesslogic.Service.Manage.SearchStaffService;
import businesslogic.State.UserRole;
import businesslogic.VO.AccountVO;
import businesslogic.VO.CostVO;
import businesslogic.VO.GatheringVO;
import data.Service.Search.SearchArrivalService;
import data.Service.Search.SearchBalanceService;
import data.Service.Search.SearchBenefitService;
import data.Service.Search.SearchCarInfoService;
import data.Service.Search.SearchConstService;
import data.Service.Search.SearchDeliveryService;
import data.Service.Search.SearchDistanceService;
import data.Service.Search.SearchDriverInfoService;
import data.Service.Search.SearchEntruckingService;
import data.Service.Search.SearchInstitutionInfoService;
import data.Service.Search.SearchLogService;
import data.Service.Search.SearchLogisticsService;
import data.Service.Search.SearchPeriodService;
import data.Service.Search.SearchRemovalService;
import data.Service.Search.SearchStockTakingService;
import data.Service.Search.SearchStorageService;
import data.Service.Search.SearchTransferService;
import data.Service.Search.SearchUserService;

public class SearchService_Stub implements SearchLogisticsService, SearchGatheringService,
										SearchDeliveryService, SearchCarInfoService, SearchDriverInfoService,
										SearchArrivalService, SearchTransferService, SearchEntruckingService,
										SearchStockTakingService, SearchStorageService, SearchRemovalService,
										SearchBalanceService, SearchAccountService, SearchCostService,
										SearchBenefitService, SearchPeriodService, SearchLogService,
										SearchInstitutionInfoService, SearchSalaryService, SearchConstService,
										SearchDistanceService, SearchUserService{

	@Override
	public ArrayList<UserPO> searchUser(ArrayList<String> requirement)
			throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<String> ins = new ArrayList<String>();
		ins.add("0251001_gathering");
		ins.add("0251001_delivery");
		ins.add("0251001_arrival");
		ins.add("0251001_carInfo");
		ins.add("0251001_driverInfo");
		
		UserPO user = new UserPO("025100001", "12345678", "张晨剑", UserRole.businessAgent,
				 ins, "staff_info");
		
		ArrayList<UserPO> list = new ArrayList<UserPO>();
		list.add(user);
		
		return list;
	}

	@Override
	public ArrayList<ConstPO> searchConst(ArrayList<String> requirement)
			throws RemoteException {
		// TODO Auto-generated method stub
		
		ConstPO con = new ConstPO("标准快递", 28, "const_info");		
		ArrayList<ConstPO> list = new ArrayList<ConstPO>();
		list.add(con);
		return list;
	}

	@Override
	public ArrayList<SalaryPO> searchSalary(ArrayList<String> requirement)
			throws RemoteException {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public ArrayList<InstitutionPO> searchInstitutionInfo(
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<LogPO> searchLog(ArrayList<String> requirement)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PeriodPO> searchPeriod(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BenefitPO> searchBenefit(ArrayList<String> requirement)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CostVO> searchCost(String time_start, String time_end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AccountVO> searchAccount(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BalancePO> searchBalannce(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<RemovalPO> searchRemoval(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<StoragePO> searchStorage(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<StockTakingPO> searchStockTaking(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<EntruckingPO> searchEntrucking(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TransferPO> searchTransfer(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ArrivalPO> searchArrival(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DriverInfoPO> searchDriverInfo(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CarInfoPO> searchCarInfo(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DeliveryPO> searchDelivery(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<GatheringVO> searchGathering(String date,
			String businesslobby) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<LogisticsInfoPO> searchLogisticsInfo(
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
