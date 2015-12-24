package test.Stub.data;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import PO.AccountPO;
import PO.ArrivalPO;
import PO.BalancePO;
import PO.BenefitPO;
import PO.CarInfoPO;
import PO.ConstPO;
import PO.CostPO;
import PO.DeliveryPO;
import PO.DistancePO;
import PO.DriverInfoPO;
import PO.EntruckingPO;
import PO.GatheringPO;
import PO.InstitutionPO;
import PO.LogPO;
import PO.LogisticsInfoPO;
import PO.PeriodPO;
import PO.RemovalPO;
import PO.SalaryPO;
import PO.StockTakingPO;
import PO.StoragePO;
import PO.TransferPO;
import PO.UserPO;
import State.CostType;
import State.InstitutionType;
import State.LogisticsState;
import State.LogisticsType;
import State.PackingCharge;
import State.SalaryType;
import State.StorageArea;
import State.TransferType;
import State.UserRole;
import businesslogic.URLHelper.URLHelper;
import data.Service.Search.SearchAccountService;
import data.Service.Search.SearchArrivalService;
import data.Service.Search.SearchBalanceService;
import data.Service.Search.SearchBenefitService;
import data.Service.Search.SearchCarInfoService;
import data.Service.Search.SearchConstService;
import data.Service.Search.SearchCostService;
import data.Service.Search.SearchDeliveryService;
import data.Service.Search.SearchDistanceService;
import data.Service.Search.SearchDriverInfoService;
import data.Service.Search.SearchEntruckingService;
import data.Service.Search.SearchGatheringService;
import data.Service.Search.SearchInstitutionInfoService;
import data.Service.Search.SearchLogService;
import data.Service.Search.SearchLogisticsService;
import data.Service.Search.SearchPeriodService;
import data.Service.Search.SearchRemovalService;
import data.Service.Search.SearchSalaryService;
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
		
		UserPO user = new UserPO("025100001", "12345678", "张晨剑", "男", 20, InstitutionType.BusinessLobby, 
				"南京", UserRole.businessAgent, "staff_info");
		
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
		
		SalaryPO salary = new SalaryPO(UserRole.courier, 1000, SalaryType.MONTH, "salary_info");
		ArrayList<SalaryPO> list = new ArrayList<SalaryPO>();
		list.add(salary);
		return list;
	}

	@Override
	public ArrayList<InstitutionPO> searchInstitutionInfo(
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		
		InstitutionPO institution = new InstitutionPO("南京鼓楼营业厅", InstitutionType.BusinessLobby,  "南京", "0251001", "institution_info");
		ArrayList<InstitutionPO> list = new ArrayList<InstitutionPO>();
		list.add(institution);
		return list;
	}

	@Override
	public ArrayList<LogPO> searchLog(ArrayList<String> requirement)
			throws RemoteException {
		// TODO Auto-generated method stub
		LogPO log = new LogPO(new Date(), "删除账号", "张晨剑", "log_info");
		ArrayList<LogPO> list = new ArrayList<LogPO>();
		list.add(log);
		return list;
	}


	@Override
	public ArrayList<BenefitPO> searchBenefit(ArrayList<String> requirement)
			throws RemoteException {
		// TODO Auto-generated method stub
		BenefitPO benefit = new BenefitPO(1294324, 492304, "benefit_info","2015-11-26 10:20:20");
		ArrayList<BenefitPO> list = new ArrayList<BenefitPO>();
		list.add(benefit);
		return list;
	}


	@Override
	public ArrayList<BalancePO> searchBalannce(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		BalancePO balance = new BalancePO("1000000000", new Date(), "南京", StorageArea.RAILWAY_TRANSPORTATION,
				2, 2, 10, StorageArea.MANOEUVERING_AREA, 2, 3, 2, "025001_balance");
		ArrayList<BalancePO> list = new ArrayList<BalancePO>();
		list.add(balance);
		return list;
	}

	@Override
	public ArrayList<RemovalPO> searchRemoval(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		RemovalPO removal = new RemovalPO("1000000000", new Date(), "南京", TransferType.AIR,
				"0250012015102500001", "025001_removal");
		ArrayList<RemovalPO> list = new ArrayList<RemovalPO>();
		list.add(removal);
		return list;
	}

	@Override
	public ArrayList<StoragePO> searchStorage(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		StoragePO storage = new StoragePO("1000000000", new Date(), "南京", StorageArea.CAR_TRANSPORTATION,
				2, 4, 5, "025001_storage");
		ArrayList<StoragePO> list = new ArrayList<StoragePO>();
		list.add(storage);
		return list;
	}

	@Override
	public ArrayList<StockTakingPO> searchStockTaking(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		StockTakingPO stock_taking = new StockTakingPO("1000000000", new Date(), "南京", 
				StorageArea.CAR_TRANSPORTATION, 2, 4, 10, "025001_stockTaking");
		ArrayList<StockTakingPO> list = new ArrayList<StockTakingPO>();
		list.add(stock_taking);
		return list;
	}

	@Override
	public ArrayList<EntruckingPO> searchEntrucking(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<String> list_1 = new ArrayList<String>();
		list_1.add("1000000000");
		EntruckingPO entrucking = new EntruckingPO(new Date(), "02500120151025000001", "南京", "00001", "珠峰", "张晨", list_1, 
				100, "025001_entrucking");
		ArrayList<EntruckingPO> list = new ArrayList<EntruckingPO>();
		list.add(entrucking);
		return list;
	}

	@Override
	public ArrayList<TransferPO> searchTransfer(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<String> list_1 = new ArrayList<String>();
		list_1.add("1000000000");
		TransferPO transfer = new TransferPO(new Date(), "0250012015102500001",
				"D2142", "南京", "北京", "302", "张三",list_1, 1004, "025001_transfer");
		ArrayList<TransferPO> list = new ArrayList<TransferPO>();
		list.add(transfer);
		return list;
	}

	@Override
	public ArrayList<ArrivalPO> searchArrival(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		ArrivalPO arrival = new ArrivalPO("1000000000", new Date(), "0250012015102500001", "南京",
				LogisticsState.INTACT, "025001_arrival");
		ArrayList<ArrivalPO> list = new ArrayList<ArrivalPO>();
		list.add(arrival);
		return list;
	}

	@Override
	public ArrayList<DriverInfoPO> searchDriverInfo(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		DriverInfoPO driverInfo = new DriverInfoPO("025001001", "张三", new Date(), 
				"321002199402210242", "1111111111111", "男", 10, "0251001_driverInfo");
		ArrayList<DriverInfoPO> list = new ArrayList<DriverInfoPO>();
		list.add(driverInfo);
		return list;
	}

	@Override
	public ArrayList<CarInfoPO> searchCarInfo(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		CarInfoPO car_info = new CarInfoPO("025001001", "苏A 025E2", 2, "0251001_carInfo");
		ArrayList<CarInfoPO> list = new ArrayList<CarInfoPO>();
		list.add(car_info);
		return list;
	}

	@Override
	public ArrayList<DeliveryPO> searchDelivery(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<String> list_1 = new ArrayList<String>();
		list_1.add("1000000000");
		DeliveryPO delivery = new DeliveryPO(new Date(), list_1, "张三", "0251001_delivery");
		ArrayList<DeliveryPO> list = new ArrayList<DeliveryPO>();
		list.add(delivery);
		return list;
	}


	@Override
	public ArrayList<LogisticsInfoPO> searchLogisticsInfo(
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		LogisticsInfoPO logistics_info = new LogisticsInfoPO("张三", "无", "无", "88888888", "1111111111111", 
				"李四", "无", "无", "99999999", "222222222222", 
				"1000000000", 2, 4, 5, "鼠标", LogisticsType.STANDARD,
				PackingCharge.COURISE_BAG, 20, "南京", "北京", 
				new Date(), new Date(),  "王五", "logistics_info");
		logistics_info.addHistory("快递员收件");
		logistics_info.addHistory("到达南京鼓楼营业厅");
		ArrayList<LogisticsInfoPO> list = new ArrayList<LogisticsInfoPO>();
		list.add(logistics_info);
		return list;
	}

	@Override
	public ArrayList<CostPO> searchCost(ArrayList<String> requirement)
			throws RemoteException {
		// TODO Auto-generated method stub
		CostPO cost = new CostPO("2015-10-25", 23, "张三", "中国工商银行", 
				CostType.salary, "无", "cost_info");
		ArrayList<CostPO> list = new ArrayList<CostPO>();
		list.add(cost);
		return list;
	}

	@Override
	public ArrayList<AccountPO> searchAccount(ArrayList<String> requirement)
			throws RemoteException {
		// TODO Auto-generated method stub
		AccountPO account = new AccountPO(2, "中国银行", 1412414.23, "account_info");
		ArrayList<AccountPO> list = new ArrayList<AccountPO>();
		list.add(account);
		return list;
	}

	@Override
	public ArrayList<GatheringPO> searchGathering(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<String> list_1 = new ArrayList<String>();
		list_1.add("1000000000");
		GatheringPO gathering = new GatheringPO(new Date(), 20, "王五", list_1, "0251001_gathering");
		ArrayList<GatheringPO> list = new ArrayList<GatheringPO>();
		list.add(gathering);
		return list;
	}

	@Override
	public ArrayList<DistancePO> searchDistance(ArrayList<String> requirement)
			throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<DistancePO> list = new ArrayList<DistancePO>();
		return list;
	}

	@Override
	public PeriodPO searchPeriod() throws RemoteException {
		// TODO Auto-generated method stub
		return new PeriodPO(null,0, 0, 0, 0, null, URLHelper.getPeriodURL());
	}
	
}
