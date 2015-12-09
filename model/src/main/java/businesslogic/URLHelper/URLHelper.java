package businesslogic.URLHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class URLHelper.
 */
public class URLHelper {
	
	/** The Constant DB_Logistics. */
	private static final String DB_Logistics = "Logistics_info";
	
	/** The Constant DB_BsLb_Gathering. */
	private static final String DB_BsLb_Gathering = "BsLb_Gathering_info_";
	
	/** The Constant DB_BsLb_Delivery. */
	private static final String DB_BsLb_Delivery = "BsLb_Delivery_info_";
	
	/** The Constant DB_BsLb_CarInfo. */
	private static final String DB_BsLb_CarInfo = "BsLb_CarInfo_info_";
	
	/** The Constant DB_BsLb_DriverInfo. */
	private static final String DB_BsLb_DriverInfo = "BsLb_DriverInfo_info_";
	
	/** The Constant DB_Arrival. */
	private static final String DB_Arrival = "Arrival_info_";
	
	/** The Constant DB_Entrucking. */
	private static final String DB_Entrucking = "Entrucking_info_";	

	/** The Constant DB_MC_Transfer. */
	private static final String DB_MC_Transfer = "MC_Transfer_info_";
	
	/** The Constant DB_Repo_Balance. */
	private static final String DB_Repo_Balance = "Repo_Balance_info_";
	
	/** The Constant DB_Repo_Storage. */
	private static final String DB_Repo_Storage = "Repo_Storage_info_";
	
	/** The Constant DB_Repo_Removal. */
	private static final String DB_Repo_Removal = "Repo_Removal_info_";
	
	/** The Constant DB_Repo_StockTaking. */
	private static final String DB_Repo_StockTaking = "Repo_StockTaking_info_";
	
	/** The Constant DB_Repo_WareHouse. */
	private static final String DB_Repo_WareHouse = "Repo_WareHouse_";
	
	/** The Constant DB_Account. */
	private static final String DB_Account = "Account_info";
	
	/** The Constant DB_Benefit. */
	private static final String DB_Benefit = "Benefit_info";
	
	/** The Constant DB_Cost. */
	private static final String DB_Cost = "Cost_info";
	
	/** The Constant DB_Const. */
	private static final String DB_Const = "Const_info";
	
	/** The Constant DB_Distance. */
	private static final String DB_Distance = "Distance_info";
	
	/** The Constant DB_Salary. */
	private static final String DB_Salary = "Salary_info";
	
	/** The Constant DB_Log. */
	private static final String DB_Log = "Log_info";
	
	/** The Constant DB_Period. */
	private static final String DB_Period = "Period_info";
	
	/** The Constant DB_User. */
	private static final String DB_User = "User_info";
	
	/** The Constant DB_Institution. */
	private static final String DB_Institution = "Institution_info";
	
	/**
	 * Gets the logistics url.
	 *
	 * @return the logistics url
	 */
	public static String getLogisticsURL() {
		return DB_Logistics;
	}
	
	/**
	 * Gets the gathering url.
	 *
	 * @param institution_id the institution_id
	 * @return the gathering url
	 */
	public static String getGatheringURL(String institution_id) {
		return DB_BsLb_Gathering + institution_id;
	}
	
	/**
	 * Gets the delivery url.
	 *
	 * @param institution_id the institution_id
	 * @return the delivery url
	 */
	public static String getDeliveryURL(String institution_id) {
		return DB_BsLb_Delivery + institution_id;
	}
	
	/**
	 * Gets the arrival url.
	 *
	 * @param institution_id the institution_id
	 * @return the arrival url
	 */
	public static String getArrivalURL(String institution_id) {
		return DB_Arrival + institution_id;
	}
	
	/**
	 * Gets the entrucking url.
	 *
	 * @param institution_id the institution_id
	 * @return the entrucking url
	 */
	public static String getEntruckingURL(String institution_id) {
		return DB_Entrucking + institution_id;
	}
	
	/**
	 * Gets the car info url.
	 *
	 * @param institution_id the institution_id
	 * @return the car info url
	 */
	public static String getCarInfoURL(String institution_id) {
		return DB_BsLb_CarInfo + institution_id;
	}
	
	/**
	 * Gets the driver info url.
	 *
	 * @param institution_id the institution_id
	 * @return the driver info url
	 */
	public static String getDriverInfoURL(String institution_id) {
		return DB_BsLb_DriverInfo+institution_id;
	}
	
	/**
	 * Gets the transfer url.
	 *
	 * @param institution_id the institution_id
	 * @return the transfer url
	 */
	public static String getTransferURL(String institution_id) {
		return DB_MC_Transfer + institution_id;
	}
	
	/**
	 * Gets the balance url.
	 *
	 * @param institution_id the institution_id
	 * @return the balance url
	 */
	public static String getBalanceURL(String institution_id) {
		return DB_Repo_Balance + institution_id;
	}
	
	/**
	 * Gets the stock taking url.
	 *
	 * @param institution_id the institution_id
	 * @return the stock taking url
	 */
	public static String getStockTakingURL(String institution_id) {
		return DB_Repo_StockTaking + institution_id;
	}
	
	/**
	 * Gets the storage url.
	 *
	 * @param institution_id the institution_id
	 * @return the storage url
	 */
	public static String getStorageURL(String institution_id) {
		return DB_Repo_Storage + institution_id;
	}
	
	/**
	 * Gets the removal url.
	 *
	 * @param institution_id the institution_id
	 * @return the removal url
	 */
	public static String getRemovalURL(String institution_id) {
		return DB_Repo_Removal + institution_id;
	}
	
	/**
	 * Gets the ware house url.
	 *
	 * @param institution_id the institution_id
	 * @return the ware house url
	 */
	public static String getWareHouseURL(String institution_id) {
		return DB_Repo_WareHouse + institution_id;
	}
	
	/**
	 * Gets the account url.
	 *
	 * @return the account url
	 */
	public static String getAccountURL() {
		return DB_Account;
	}
	
	/**
	 * Gets the benefit url.
	 *
	 * @return the benefit url
	 */
	public static String getBenefitURL(){
		return DB_Benefit;
	}
	
	/**
	 * Gets the cost url.
	 *
	 * @return the cost url
	 */
	public static String getCostURL() {
		return DB_Cost;
	}
	
	/**
	 * Gets the const url.
	 *
	 * @return the const url
	 */
	public static String getConstURL() {
		return DB_Const;
	}
	
	/**
	 * Gets the distance url.
	 *
	 * @return the distance url
	 */
	public static String getDistanceURL() {
		return DB_Distance;
	}
	
	/**
	 * Gets the log url.
	 *
	 * @return the log url
	 */
	public static String getLogURL() {
		return DB_Log;
	}
	
	/**
	 * Gets the salary url.
	 *
	 * @return the salary url
	 */
	public static String getSalaryURL() {
		return DB_Salary;
	}
	
	/**
	 * Gets the period url.
	 *
	 * @return the period url
	 */
	public static String getPeriodURL() {
		return DB_Period;
	}
	
	/**
	 * Gets the user url.
	 *
	 * @return the user url
	 */
	public static String getUserURL() {
		return DB_User;
	}
	
	/**
	 * Gets the institution url.
	 *
	 * @return the institution url
	 */
	public static String getInstitutionURL() {
		return DB_Institution;
	}
}
