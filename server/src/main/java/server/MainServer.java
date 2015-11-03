package server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import data.Helper.RMIHelper.RMIHelper;
import data.Impl.Add.AddImpl;
import data.Impl.Delete.DeleteImpl;
import data.Impl.Search.SearchAccountImpl;
import data.Impl.Search.SearchArrivalImpl;
import data.Impl.Search.SearchBalanceImpl;
import data.Impl.Search.SearchBenefitImpl;
import data.Impl.Search.SearchCarInfoImpl;
import data.Impl.Search.SearchConstImpl;
import data.Impl.Search.SearchCostImpl;
import data.Impl.Search.SearchDeliveryImpl;
import data.Impl.Search.SearchDistanceImpl;
import data.Impl.Search.SearchDriverInfoImpl;
import data.Impl.Search.SearchEntruckingImpl;
import data.Impl.Search.SearchGatheringImpl;
import data.Impl.Search.SearchInstitutionInfoImpl;
import data.Impl.Search.SearchLogImpl;
import data.Impl.Search.SearchLogisticsImpl;
import data.Impl.Search.SearchPeriodImpl;
import data.Impl.Search.SearchRemovalImpl;
import data.Impl.Search.SearchSalaryImpl;
import data.Impl.Search.SearchStockTakingImpl;
import data.Impl.Search.SearchStorageImpl;
import data.Impl.Search.SearchTransferImpl;
import data.Impl.Search.SearchUserImpl;
import data.Impl.Update.UpdateImpl;
import data.Service.Add.AddService;
import data.Service.Delete.DeleteService;
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
import data.Service.Update.UpdateService;

public class MainServer {
		
	public static void main(String[] args) {
		AddService add_service = new AddImpl();
		UpdateService update_service = new UpdateImpl();
		DeleteService delete_service = new DeleteImpl();
		
		SearchAccountService search_account_service = new SearchAccountImpl();
		SearchArrivalService search_arrival_service = new SearchArrivalImpl();
		SearchBalanceService search_balance_service = new SearchBalanceImpl();
		SearchBenefitService search_benefit_service = new SearchBenefitImpl();
		SearchCarInfoService search_carInfo_service = new SearchCarInfoImpl();
		SearchConstService search_const_service = new SearchConstImpl();
		SearchCostService search_cost_service = new SearchCostImpl();
		SearchDeliveryService search_delivery_service = new SearchDeliveryImpl();
		SearchDistanceService search_distance_service = new SearchDistanceImpl();
		SearchDriverInfoService search_driverInfo_service = new SearchDriverInfoImpl();
		SearchEntruckingService search_entrucking_service = new SearchEntruckingImpl();
		SearchGatheringService search_gathering_service = new SearchGatheringImpl();
		SearchInstitutionInfoService search_institution_service = new SearchInstitutionInfoImpl();
		SearchLogisticsService search_logistics_service = new SearchLogisticsImpl();
		SearchLogService search_log_service = new SearchLogImpl();
		SearchPeriodService search_period_service = new SearchPeriodImpl();
		SearchRemovalService search_removal_service = new SearchRemovalImpl();
		SearchSalaryService search_salary_service = new SearchSalaryImpl();
		SearchStockTakingService search_stockTaking_service = new SearchStockTakingImpl();
		SearchStorageService search_storage_service = new SearchStorageImpl();
		SearchTransferService search_transfer_service = new SearchTransferImpl();
		SearchUserService search_user_service = new SearchUserImpl();
		
		try {
			LocateRegistry.createRegistry(RMIHelper.REGISTRY);
			
			Naming.bind(RMIHelper.URL+"AddImpl", add_service);
			print("AddImpl");
			Naming.bind(RMIHelper.URL+"UpdateImpl", update_service);
			print("UpdateImpl");
			Naming.bind(RMIHelper.URL+"DeleteImpl", delete_service);
			print("DeleteImpl");
			Naming.bind(RMIHelper.URL+"SearchAccountImpl", search_account_service);
			print("SearchAccountImpl");
			Naming.bind(RMIHelper.URL+"SearchArrivalImpl", search_arrival_service);
			print("SearchArrivalImpl");
			Naming.bind(RMIHelper.URL+"SearchBalanceImpl", search_balance_service);
			print("SearchBalanceImpl");
			Naming.bind(RMIHelper.URL+"SearchBenefitImpl", search_benefit_service);
			print("SearchBenefitImpl");
			Naming.bind(RMIHelper.URL+"SearchCarInfoImpl", search_carInfo_service);
			print("SearchCarInfoImpl");
			Naming.bind(RMIHelper.URL+"SearchConstImpl", search_const_service);
		} catch (RemoteException | MalformedURLException | AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void print(String object_name) {
		System.out.println(">>>>>>远程"+object_name+"对象绑定成功！");
	}
}
