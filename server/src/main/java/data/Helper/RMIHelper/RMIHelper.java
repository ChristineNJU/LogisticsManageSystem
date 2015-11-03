package data.Helper.RMIHelper;

public class RMIHelper {
	
	public static final int REGISTRY = 8888;
	public static final String URL = "rmi://127.0.0.1:"+REGISTRY+"/";
	
	public static final String ADD_SERVICE = URL+"AddImpl";
	public static final String UPDATE_SERVICE = URL+"UpdateImpl";
	public static final String DELETE_SERVICE = URL+"DeleteImpl";
	
	public static final String SERVICE_ACCOUNT_IMPL = URL+"ServiceAccountImpl";
	public static final String SERVICE_ARRIVAL_IMPL = URL+"ServiceArrivalImpl";
	public static final String SERVICE_BALANCE_IMPL = URL+"ServiceBalanceImpl";
	public static final String SERVICE_BENEFIT_IMPL = URL+"ServiceBenefitImpl";
	public static final String SERVICE_CARINFO_IMPL = URL+"ServiceCarInfoImpl";
	public static final String SERVICE_CONST_IMPL = URL+"ServiceConstImpl";
	public static final String SERVICE_COST_IMPL = URL+"ServiceCostImpl";
	public static final String SERVICE_DELIVERY_SERVICE = URL+"ServiceDeliveryImpl";
	public static final String SERVICE_DISTANCE_IMPL = URL+"ServiceDistanceImpl";
	public static final String SERVICE_DRIVERINFO_IMPL = URL+"ServiceDriverInfoImpl";
	public static final String SERVICE_ENTRUCKING_IMPL = URL+"ServiceEntrucknigImpl";
	public static final String SERVICE_GATHERING_IMPL = URL+"ServiceGatheringImpl";
	public static final String SERVICE_INSTITUTION_IMPL = URL+"ServiceInstitutionImpl";
	public static final String SERVICE_LOGISTICS_IMPL = URL+"ServiceLogisticsImpl";
	public static final String SERVICE_LOG_IMPL = URL+"ServiceLogImpl";
	public static final String SERVICE_PERIOD_IMPL = URL+"ServicePeriodImpl";
	public static final String SERVICE_REMOVAL_IMPL = URL+"ServiceRemovalImpl";
	public static final String SERVICE_SALARY_IMPL = URL+"ServiceSalaryImpl";
	public static final String SERVICE_STOCKTAKING_IMPL = URL+"ServiceStockTakingImpl";
	public static final String SERVICE_STORAGE_IMPL = URL+"ServiceStorageImpl";
	public static final String SERVICE_TRANSFER_IMPL = URL+"ServiceTransferImpl";
	public static final String SERVICE_USER_IMPL = URL+"ServiceUserImpl";
}
