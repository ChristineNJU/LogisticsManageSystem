package businesslogic.URLHelper;

public class URLHelper {
	
	private static final String DB_Logistics = "Logistics_info";
	
	private static final String DB_BsLb_Gathering = "BsLb_Gathering_info_";
	private static final String DB_BsLb_Delivery = "BsLb_Delivery_info_";
	private static final String DB_BsLb_CarInfo = "BsLb_CarInfo_info_";
	private static final String DB_BsLb_DriverInfo = "BsLb_DriverInfo_info_";
	
	private static final String DB_Arrival = "Arrival_info_";
	private static final String DB_Entrucking = "Entrucking_info_";	

	private static final String DB_MC_Transfer = "MC_Transfer_info_";
	
	private static final String DB_Repo_Balance = "Repo_Balance_info_";
	private static final String DB_Repo_Storage = "Repo_Storage_info_";
	private static final String DB_Repo_Removal = "Repo_Removal_info_";
	private static final String DB_Repo_StockTaking = "DB_Repo_StockTaking_info_";
	private static final String DB_Repo_WareHouse = "DB_Repo_WareHouse_";
	
	private static final String DB_Account = "Account_info";
	private static final String DB_Benefit = "Benefit_info";
	private static final String DB_Cost = "Cost_info";
	private static final String DB_Const = "Const_info";
	private static final String DB_Distance = "Distance_info";
	private static final String DB_Salary = "Salary_info";
	private static final String DB_Log = "Log_info";
	private static final String DB_Period = "Period_info";
	private static final String DB_User = "User_info";
	private static final String DB_Institution = "Institution_info";
	
	public static String getLogisticsURL() {
		return DB_Logistics;
	}
	
	public static String getGatheringURL(String institution_id) {
		return DB_BsLb_Gathering + institution_id;
	}
	
	public static String getDeliveryURL(String institution_id) {
		return DB_BsLb_Delivery + institution_id;
	}
	
	public static String getArrivalURL(String institution_id) {
		return DB_Arrival + institution_id;
	}
	
	public static String getEntruckingURL(String institution_id) {
		return DB_Entrucking + institution_id;
	}
	
	public static String getCarInfoURL(String institution_id) {
		return DB_BsLb_CarInfo + institution_id;
	}
	
	public static String getDriverInfoURL(String institution_id) {
		return DB_BsLb_DriverInfo+institution_id;
	}
	
	public static String getTransferURL(String institution_id) {
		return DB_MC_Transfer + institution_id;
	}
	
	public static String getBalanceURL(String institution_id) {
		return DB_Repo_Balance + institution_id;
	}
	
	public static String getStockTakingURL(String institution_id) {
		return DB_Repo_StockTaking + institution_id;
	}
	
	public static String getStorageURL(String institution_id) {
		return DB_Repo_Storage + institution_id;
	}
	
	public static String getRemovalURL(String institution_id) {
		return DB_Repo_Removal + institution_id;
	}
	
	public static String getWareHouseURL(String institution_id) {
		return DB_Repo_WareHouse + institution_id;
	}
	
	public static String getAccountURL() {
		return DB_Account;
	}
	
	public static String getBenefitURL(){
		return DB_Benefit;
	}
	
	public static String getCostURL() {
		return DB_Cost;
	}
	
	public static String getConstURL() {
		return DB_Const;
	}
	
	public static String getDistanceURL() {
		return DB_Distance;
	}
	
	public static String getLogURL() {
		return DB_Log;
	}
	
	public static String getSalaryURL() {
		return DB_Salary;
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
