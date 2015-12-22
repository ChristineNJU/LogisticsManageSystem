package data.RMIHelper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Class RMIHelper.
 */
public class RMIHelper {
	
	/** The Constant REGISTRY. */
	public static final int REGISTRY = 8888;
	

	/** The Constant URL. */
	public static String URL = "rmi://127.0.0.1:"+REGISTRY+"/";
	
	/** The add impl. */
	public static String ADD_IMPL = URL+"AddImpl";
	
	/** The update impl. */
	public static String UPDATE_IMPL = URL+"UpdateImpl";
	
	/** The delete impl. */
	public static String DELETE_IMPL = URL+"DeleteImpl";
	
	/** The search account impl. */
	public static String SEARCH_ACCOUNT_IMPL = URL+"ServiceAccountImpl";
	
	/** The search arrival impl. */
	public static String SEARCH_ARRIVAL_IMPL = URL+"ServiceArrivalImpl";
	
	/** The search balance impl. */
	public static String SEARCH_BALANCE_IMPL = URL+"ServiceBalanceImpl";
	
	/** The search benefit impl. */
	public static String SEARCH_BENEFIT_IMPL = URL+"ServiceBenefitImpl";
	
	/** The search carinfo impl. */
	public static String SEARCH_CARINFO_IMPL = URL+"ServiceCarInfoImpl";
	
	/** The search const impl. */
	public static String SEARCH_CONST_IMPL = URL+"ServiceConstImpl";
	
	/** The search cost impl. */
	public static String SEARCH_COST_IMPL = URL+"ServiceCostImpl";
	
	/** The search delivery service. */
	public static String SEARCH_DELIVERY_SERVICE = URL+"ServiceDeliveryImpl";
	
	/** The search distance impl. */
	public static String SEARCH_DISTANCE_IMPL = URL+"ServiceDistanceImpl";
	
	/** The search driverinfo impl. */
	public static String SEARCH_DRIVERINFO_IMPL = URL+"ServiceDriverInfoImpl";
	
	/** The search entrucking impl. */
	public static String SEARCH_ENTRUCKING_IMPL = URL+"ServiceEntrucknigImpl";
	
	/** The search gathering impl. */
	public static String SEARCH_GATHERING_IMPL = URL+"ServiceGatheringImpl";
	
	/** The search institution impl. */
	public static String SEARCH_INSTITUTION_IMPL = URL+"ServiceInstitutionImpl";
	
	/** The search logistics impl. */
	public static String SEARCH_LOGISTICS_IMPL = URL+"ServiceLogisticsImpl";
	
	/** The search log impl. */
	public static String SEARCH_LOG_IMPL = URL+"ServiceLogImpl";
	
	/** The search period impl. */
	public static String SEARCH_PERIOD_IMPL = URL+"ServicePeriodImpl";
	
	/** The search removal impl. */
	public static String SEARCH_REMOVAL_IMPL = URL+"ServiceRemovalImpl";
	
	/** The search salary impl. */
	public static String SEARCH_SALARY_IMPL = URL+"ServiceSalaryImpl";
	
	/** The search stocktaking impl. */
	public static String SEARCH_STOCKTAKING_IMPL = URL+"ServiceStockTakingImpl";
	
	/** The search storage impl. */
	public static String SEARCH_STORAGE_IMPL = URL+"ServiceStorageImpl";
	
	/** The search transfer impl. */
	public static String SEARCH_TRANSFER_IMPL = URL+"ServiceTransferImpl";
	
	/** The search user impl. */
	public static String SEARCH_USER_IMPL = URL+"ServiceUserImpl";

	/** The warehouse impl. */
	public static String WAREHOUSE_IMPL = URL+"WareHouseImpl";
	
	/** The table operation impl. */
	public static String TABLE_OPERATION_IMPL = URL+"TableOperationImpl";
	
	/** The institution storage impl. */
	public static String INSTITUTION_STORAGE_IMPL = URL+"InstitutionStorageImpl";
	
	/** The gathering storage impl. */
	public static String GATHERING_STORAGE_IMPL = URL+"GatheringStorageImpl";
	
	/** The rmi connection impl. */
	public static String RMI_CONNECTION_IMPL = URL+"RMIConnectionImpl";

	/**
	 * Instantiates a new RMI helper.
	 */
	public RMIHelper() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("IPConfig.txt"));
			String ip = br.readLine();
			
			URL = "rmi://"+ip+":"+REGISTRY+"/";
			ADD_IMPL = URL+"AddImpl";
			UPDATE_IMPL = URL+"UpdateImpl";
			DELETE_IMPL = URL+"DeleteImpl";
			SEARCH_ACCOUNT_IMPL = URL+"ServiceAccountImpl";
			SEARCH_ARRIVAL_IMPL = URL+"ServiceArrivalImpl";
			SEARCH_BALANCE_IMPL = URL+"ServiceBalanceImpl";
			SEARCH_BENEFIT_IMPL = URL+"ServiceBenefitImpl";
			SEARCH_CARINFO_IMPL = URL+"ServiceCarInfoImpl";
			SEARCH_CONST_IMPL = URL+"ServiceConstImpl";
			SEARCH_COST_IMPL = URL+"ServiceCostImpl";
			SEARCH_DELIVERY_SERVICE = URL+"ServiceDeliveryImpl";
			SEARCH_DISTANCE_IMPL = URL+"ServiceDistanceImpl";
			SEARCH_DRIVERINFO_IMPL = URL+"ServiceDriverInfoImpl";
			SEARCH_ENTRUCKING_IMPL = URL+"ServiceEntrucknigImpl";
			SEARCH_GATHERING_IMPL = URL+"ServiceGatheringImpl";
			SEARCH_INSTITUTION_IMPL = URL+"ServiceInstitutionImpl";
			SEARCH_LOGISTICS_IMPL = URL+"ServiceLogisticsImpl";
			SEARCH_LOG_IMPL = URL+"ServiceLogImpl";
			SEARCH_PERIOD_IMPL = URL+"ServicePeriodImpl";
			SEARCH_PERIOD_IMPL = URL+"ServicePeriodImpl";
			SEARCH_REMOVAL_IMPL = URL+"ServiceRemovalImpl";
			SEARCH_SALARY_IMPL = URL+"ServiceSalaryImpl";
			SEARCH_STOCKTAKING_IMPL = URL+"ServiceStockTakingImpl";
			SEARCH_STORAGE_IMPL = URL+"ServiceStorageImpl";
			SEARCH_TRANSFER_IMPL = URL+"ServiceTransferImpl";
			SEARCH_USER_IMPL = URL+"ServiceUserImpl";
			WAREHOUSE_IMPL = URL+"WareHouseImpl";
			TABLE_OPERATION_IMPL = URL+"TableOperationImpl";
			INSTITUTION_STORAGE_IMPL = URL+"InstitutionStorageImpl";
			GATHERING_STORAGE_IMPL = URL+"GatheringStorageImpl";
			RMI_CONNECTION_IMPL = URL+"RMIConnectionImpl";
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
