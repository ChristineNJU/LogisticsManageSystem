package server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import data.Helper.DBHelper.DBHelper.DBHelper;
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
import data.Impl.Sundry.TableOperationImpl;
import data.Impl.Sundry.WareHouseImpl;
import data.Impl.Update.UpdateImpl;
import data.RMIHelper.RMIHelper;
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
import data.Service.Sundry.TableOperationService;
import data.Service.Sundry.WareHouseService;
import data.Service.Update.UpdateService;

public class MainServer {
		
	public static void main(String[] args) {
		AddService add_service = null;
		DeleteService delete_service = null;
		UpdateService update_service = null;
		
		SearchAccountService search_account_service = null;
		SearchArrivalService search_arrival_service = null;
		SearchBalanceService search_balance_service = null;
		SearchBenefitService search_benefit_service = null;
		SearchCarInfoService search_carInfo_service = null;
		SearchConstService search_const_service = null;
		SearchCostService search_cost_service = null;
		SearchDeliveryService search_delivery_service = null;
		SearchDistanceService search_distance_service = null;
		SearchDriverInfoService search_driverInfo_service = null;
		SearchEntruckingService search_entrucking_service = null;
		SearchGatheringService search_gathering_service = null;
		SearchInstitutionInfoService search_institution_service = null;
		SearchLogisticsService search_logistics_service = null;
		SearchLogService search_log_service = null;
		SearchPeriodService search_period_service = null;
		SearchRemovalService search_removal_service = null;
		SearchSalaryService search_salary_service = null;
		SearchStockTakingService search_stockTaking_service = null;
		SearchStorageService search_storage_service = null;
		SearchTransferService search_transfer_service = null;
		SearchUserService search_user_service = null;
		
		WareHouseService ware_house_service = null;
		TableOperationService table_operation_service = null;
		try {
			add_service = new AddImpl();
			delete_service = new DeleteImpl();
			update_service = new UpdateImpl();
			
			search_account_service = new SearchAccountImpl();
			search_arrival_service = new SearchArrivalImpl();
			search_balance_service = new SearchBalanceImpl();
			search_benefit_service = new SearchBenefitImpl();
			search_carInfo_service = new SearchCarInfoImpl();
			search_const_service = new SearchConstImpl();
			search_cost_service = new SearchCostImpl();
			search_delivery_service = new SearchDeliveryImpl();
			search_distance_service = new SearchDistanceImpl();
			search_driverInfo_service = new SearchDriverInfoImpl();
			search_entrucking_service = new SearchEntruckingImpl();
			search_gathering_service = new SearchGatheringImpl();
			search_institution_service = new SearchInstitutionInfoImpl();
			search_logistics_service = new SearchLogisticsImpl();
			search_log_service = new SearchLogImpl();
			search_period_service = new SearchPeriodImpl();
			search_removal_service = new SearchRemovalImpl();
			search_salary_service = new SearchSalaryImpl();
			search_stockTaking_service = new SearchStockTakingImpl();
			search_storage_service = new SearchStorageImpl();
			search_transfer_service = new SearchTransferImpl();
			search_user_service = new SearchUserImpl();
			
			ware_house_service = new WareHouseImpl();
			table_operation_service = new TableOperationImpl();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			System.out.println("接口实现创建失败");
			e1.printStackTrace();
		}
		
		try {
			LocateRegistry.createRegistry(RMIHelper.REGISTRY);
			
			Naming.bind(RMIHelper.ADD_IMPL, add_service);
			print("AddImpl");
			Naming.bind(RMIHelper.UPDATE_IMPL, update_service);
			print("UpdateImpl");
			Naming.bind(RMIHelper.DELETE_IMPL, delete_service);
			print("DeleteImpl");
			Naming.bind(RMIHelper.SEARCH_ACCOUNT_IMPL, search_account_service);
			print("SearchAccountImpl");
			Naming.bind(RMIHelper.SEARCH_ARRIVAL_IMPL, search_arrival_service);
			print("SearchArrivalImpl");
			Naming.bind(RMIHelper.SEARCH_BALANCE_IMPL, search_balance_service);
			print("SearchBalanceImpl");
			Naming.bind(RMIHelper.SEARCH_BENEFIT_IMPL, search_benefit_service);
			print("SearchBenefitImpl");
			Naming.bind(RMIHelper.SEARCH_CARINFO_IMPL, search_carInfo_service);
			print("SearchCarInfoImpl");
			Naming.bind(RMIHelper.SEARCH_CONST_IMPL, search_const_service);
			print("SearchConstImpl");
			Naming.bind(RMIHelper.SEARCH_COST_IMPL, search_cost_service);
			print("SearchCostImpl");
			Naming.bind(RMIHelper.SEARCH_DELIVERY_SERVICE, search_delivery_service);
			print("SearchDeliveryImpl");
			Naming.bind(RMIHelper.SEARCH_DISTANCE_IMPL, search_distance_service);
			print("SearchDistanceImpl");
			Naming.bind(RMIHelper.SEARCH_DRIVERINFO_IMPL, search_driverInfo_service);
			print("SearchDriverInfoImpl");
			Naming.bind(RMIHelper.SEARCH_ENTRUCKING_IMPL, search_entrucking_service);
			print("SearchEntruckingImpl");
			Naming.bind(RMIHelper.SEARCH_GATHERING_IMPL, search_gathering_service);
			print("SearchGatheringImpl");
			Naming.bind(RMIHelper.SEARCH_INSTITUTION_IMPL, search_institution_service);
			print("SearchInstitutionImpl");
			Naming.bind(RMIHelper.SEARCH_LOG_IMPL, search_log_service);
			print("SearchLogService");
			Naming.bind(RMIHelper.SEARCH_LOGISTICS_IMPL, search_logistics_service);
			print("SearchLogisticsImpl");
			Naming.bind(RMIHelper.SEARCH_PERIOD_IMPL, search_period_service);
			print("SearchPeriodImpl");
			Naming.bind(RMIHelper.SEARCH_REMOVAL_IMPL, search_removal_service);
			print("SearchRemovalImpl");
			Naming.bind(RMIHelper.SEARCH_SALARY_IMPL, search_salary_service);
			print("SearchSalaryImpl");
			Naming.bind(RMIHelper.SEARCH_STOCKTAKING_IMPL, search_stockTaking_service);
			print("SearchStockTakingImpl");
			Naming.bind(RMIHelper.SEARCH_STORAGE_IMPL, search_storage_service);
			print("SearchStorageImpl");
			Naming.bind(RMIHelper.SEARCH_TRANSFER_IMPL, search_transfer_service);
			print("SearchTransferImpl");
			Naming.bind(RMIHelper.SEARCH_USER_IMPL, search_user_service);
			print("SearchUserImpl");
			Naming.bind(RMIHelper.WAREHOUSE_IMPL, ware_house_service);
			print("WareHouseImpl");
			Naming.bind(RMIHelper.TABLE_OPERATION_IMPL, table_operation_service);
			print("TableOperationImpl");
		} catch (RemoteException | MalformedURLException | AlreadyBoundException e) {
			// TODO Auto-generated catch block
			System.out.println("RMI远程端口绑定失败");
			e.printStackTrace();
		}
		
		DBHelper db_helper = DBHelper.createDBHelper();
	}
	
	private static void print(String object_name) {
		System.out.println(">>>>>>远程"+object_name+"对象绑定成功！");
	}
}
