package data.RMIHelper;

public class RMIHelper {
	
	public static final int REGISTRY = 8888;
	public static final String URL = "rmi://127.0.0.1:"+REGISTRY+"/";
//	public static final String URL = "rmi://127.0.0.1:"
	
	public static final String ADD_IMPL = URL+"AddImpl";
	public static final String UPDATE_IMPL = URL+"UpdateImpl";
	public static final String DELETE_IMPL = URL+"DeleteImpl";
	
	public static final String SEARCH_ACCOUNT_IMPL = URL+"ServiceAccountImpl";
	public static final String SEARCH_ARRIVAL_IMPL = URL+"ServiceArrivalImpl";
	public static final String SEARCH_BALANCE_IMPL = URL+"ServiceBalanceImpl";
	public static final String SEARCH_BENEFIT_IMPL = URL+"ServiceBenefitImpl";
	public static final String SEARCH_CARINFO_IMPL = URL+"ServiceCarInfoImpl";
	public static final String SEARCH_CONST_IMPL = URL+"ServiceConstImpl";
	public static final String SEARCH_COST_IMPL = URL+"ServiceCostImpl";
	public static final String SEARCH_DELIVERY_SERVICE = URL+"ServiceDeliveryImpl";
	public static final String SEARCH_DISTANCE_IMPL = URL+"ServiceDistanceImpl";
	public static final String SEARCH_DRIVERINFO_IMPL = URL+"ServiceDriverInfoImpl";
	public static final String SEARCH_ENTRUCKING_IMPL = URL+"ServiceEntrucknigImpl";
	public static final String SEARCH_GATHERING_IMPL = URL+"ServiceGatheringImpl";
	public static final String SEARCH_INSTITUTION_IMPL = URL+"ServiceInstitutionImpl";
	public static final String SEARCH_LOGISTICS_IMPL = URL+"ServiceLogisticsImpl";
	public static final String SEARCH_LOG_IMPL = URL+"ServiceLogImpl";
	public static final String SEARCH_PERIOD_IMPL = URL+"ServicePeriodImpl";
	public static final String SEARCH_REMOVAL_IMPL = URL+"ServiceRemovalImpl";
	public static final String SEARCH_SALARY_IMPL = URL+"ServiceSalaryImpl";
	public static final String SEARCH_STOCKTAKING_IMPL = URL+"ServiceStockTakingImpl";
	public static final String SEARCH_STORAGE_IMPL = URL+"ServiceStorageImpl";
	public static final String SEARCH_TRANSFER_IMPL = URL+"ServiceTransferImpl";
	public static final String SEARCH_USER_IMPL = URL+"ServiceUserImpl";
}
