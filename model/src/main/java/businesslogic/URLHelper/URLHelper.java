package businesslogic.URLHelper;

public class URLHelper {
	
	private static final String DB_Logistics = "Logistics_info";
	
	private static final String DB_BsLb_Gathering = "_BsLb_Gathering_info";
	private static final String DB_BsLb_Delivery = "_BsLb_Delivery_info";
	private static final String DB_BsLb_CarInfo = "_BsLb_CarInfo_info";
	private static final String DB_BsLb_DriverInfo = "_BsLb_DriverInfo_info";
	
	private static final String DB_Arrival = "_Arrival_info";
	private static final String DB_Entrucking = "_Entrucking_info";	

	private static final String DB_MC_Transfer = "_MC_Transfer_info";
	
	private static final String DB_Repo_Balance = "_Repo_Balance_info";
	private static final String DB_Repo_Storage = "_Repo_Storage_info";
	private static final String DB_Repo_Removal = "_Repo_Removal_info";
	private static final String DB_Repo_StockTaking = "_DB_Repo_StockTaking_info";

	private static final String DB_Cost = "Cost_info";
	private static final String DB_Const = "Const_info";
	private static final String DB_Period = "Period_info";
	private static final String DB_User = "User_info";
	private static final String DB_Institution = "Institution_info";
	
	public static String getLogisticsURL() {
		return DB_Logistics;
	}
	
	public static String getGatheringURL(String institution_id) {
		return institution_id+DB_BsLb_Gathering;
	}
	
	public static String getDeliveryURL(String institution_id) {
		return institution_id+DB_BsLb_Delivery;
	}
	
	public static String getArrivalURL(String institution_id) {
		return institution_id+DB_Arrival;
	}
	
	public static String getEntruckingURL(String institution_id) {
		return institution_id+DB_Entrucking;
	}
	
	public static String getCarInfoURL(String institution_id) {
		return institution_id+DB_BsLb_CarInfo;
	}
	
	public static String getDriverInfoURL(String institution_id) {
		return institution_id+DB_BsLb_DriverInfo;
	}
	
	public static String getTransferURL(String institution_id) {
		return institution_id+DB_MC_Transfer;
	}
	
	public static String getBalanceURL(String institution_id) {
		return institution_id+DB_Repo_Balance;
	}
	
	public static String getStockTakingURL(String institution_id) {
		return institution_id+DB_Repo_StockTaking;
	}
	
	public static String getStorageURL(String institution_id) {
		return institution_id+DB_Repo_Storage;
	}
	
	public static String getRemovalURL(String institution_id) {
		return institution_id+DB_Repo_Removal;
	}
	
	public static String getCostURL() {
		return DB_Cost;
	}
	
	public static String getConstURL() {
		return DB_Const;
	}
	
	public static String getPeriodURL() {
		return DB_Period;
	}
	
	public static String getUserURL() {
		return DB_User;
	}
	
	public static String getInstitutionURL() {
		return DB_Institution;
	}
}
