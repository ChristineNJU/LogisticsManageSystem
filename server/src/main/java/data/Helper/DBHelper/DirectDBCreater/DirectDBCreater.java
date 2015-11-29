	package data.Helper.DBHelper.DirectDBCreater;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import businesslogic.URLHelper.URLHelper;

/**
 * 用于直接在数据库中创建删除表,以及创建删除数据
 * 
 * @author 尹子越
 * @version 1.0.0
 */
public class DirectDBCreater {
	
	private static final String db_name = "LogisticsManageSystemDataBase";
	
	private static Connection conn = null;
	private static Statement s = null;
	
	public static void main(String[] args) {
		
			try {
				Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
				System.out.println("Load the embedded driver");
				
				conn = DriverManager.getConnection("jdbc:derby:"+db_name+";create=true");
				System.out.println("create and connect to "+db_name);
				conn.setAutoCommit(false);
				
//				createTable_User();
//				insert_User();
//				deleteTable(URLHelper.getUserURL());
				
//				createTable_Logistics();
//				insert_Logistics();
//				deleteTable(URLHelper.getLogisticsURL());
				
//				createTable_Const();
//				insert_Const();
//				deleteTable(URLHelper.getConstURL());
				
//				createTable_Institution();
//				insert_Institution();
//				deleteTable(URLHelper.getInstitutionURL());
				
//				createTable_Account();
//				insert_Account();
//				deleteTable(URLHelper.getAccountURL());
				
//				createTable_Log();
//				insert_Log();
//				deleteTable(URLHelper.getLogURL());
				
//				createTable_Salary();
//				insert_Salary();
//				deleteTable(URLHelper.getSalaryURL());
				
//				createTable_Distance();
//				insert_Distance();
//				deleteTable(URLHelper.getDistanceURL());
				
//				createTable_Driver("025000");
//				insert_Driver("025000");
//				deleteTable(URLHelper.getDriverInfoURL("025000"));
				
//				createTable_Car("025000");
//				insert_Car("025000");
//				deleteTable(URLHelper.getCarInfoURL("025000"));
				
//				createTable_Arrival("025000");
//				insert_Arrival("025000");
//				deleteTable(URLHelper.getArrivalURL("025000"));
//				createTable_Arrival("0250");
//				insert_Arrival("0250");
//				deleteTable(URLHelper.getArrivalURL("0250"));
				
//				createTable_Delivery("025000");
//				insert_Delivery("025000");
//				deleteTable(URLHelper.getDeliveryURL("025000"));
				
//				createTable_Entrucking("025000");
//				insert_Entrucking("025000");
//				deleteTable(URLHelper.getEntruckingURL("025000"));
//				createTable_Entrucking("0250");
//				insert_Entrucking("0250");
//				deleteTable(URLHelper.getEntruckingURL("0250"));
				
//				createTable_Balance("02500");
//				insert_Balance("02500");
//				deleteTable(URLHelper.getBalanceURL("02500"));
				
//				createTable_StockTaking("02500");
//				insert_StockingTaking("02500");
//				deleteTable(URLHelper.getStockTakingURL("02500"));
				
//				createTable_Storage("02500");
//				insert_Storage("02500");
//				deleteTable(URLHelper.getStorageURL("02500"));
				
//				createTable_Removal("02500");
//				insert_Removal("02500");
//				deleteTable(URLHelper.getRemovalURL("02500"));
				
//				createTable_Transfer("0250");
//				insert_Transfer("0250");
//				deleteTable(URLHelper.getTransferURL("0250"));
				
//				createTable_Gathering("025000");
//				insert_Gathering("025000");
//				deleteTable(URLHelper.getGatheringURL("025000"));
				
//				createTable_Period();
//				deleteTable(URLHelper.getPeriodURL());
				
//				createTable_Benefit();
//				deleteTable(URLHelper.getBenefitURL());
				
//				createTable_Cost();
//				deleteTable(URLHelper.getCostURL());
				
//				createTable_WareHouse("02500");
//				insert_WareHouse("02500");
//				deleteTable(URLHelper.getWareHouseURL("02500"));				
				
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void deleteTable(String url) {
		String table_name = url;
		
		try {
			s = conn.createStatement();
			s.execute("DROP TABLE "+table_name);
			conn.commit();
			
			System.out.println("Delete table "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createTable_User() {
		String table_name = URLHelper.getUserURL();
		
		try {
			s = conn.createStatement();
			s.execute("CREATE TABLE "+table_name+" (ID varchar(20) PRIMARY key, Password varchar(20), Name varchar(20),"
					+ " Sex varchar(5), Age int, Institution varchar(15), City varchar(20),"
					+ " Role varchar(15))");
			conn.commit();
			
			System.out.println("create table "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insert_User() {
		String table_name = URLHelper.getUserURL();
		
		try {
			s = conn.createStatement();
			boolean mark = s.execute("INSERT INTO "+table_name+" VALUES('admin', 'admin', '黄勇', '男', 20, "
					+ "'Other', '南京', 'admin')");
			conn.commit();
			System.out.println("insert into "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createTable_Logistics() {
		String table_name = URLHelper.getLogisticsURL();
		
		try {
			s = conn.createStatement();
			s.execute("CREATE TABLE "+table_name+" (bar_code varchar(20) PRIMARY key, sender_name varchar(20), sender_address varchar(100), "
					+ "sender_organization varchar(50), sender_telephone varchar(25), "
					+ "sender_mobilephone varchar(25), recipient_name varchar(20), recipient_address varchar(100), "
					+ "recipient_organization varchar(50), recipient_telephone varchar(25), recipient_mobilephone varchar(25), "
					+ "actual_recipient_name varchar(20), original_number int, weight double, "
					+ "size double, internal_name varchar(50), type varchar(20), pack varchar(20), "
					+ "total_cost double, starting varchar(20), destination varchar(20), "
					+ "state varchar(20), send_date varchar(25), receive_date varchar(25), "
					+ "courier varchar(20), isApproved varchar(5), isReceived varchar(5), history varchar(1000))");
			conn.commit();
			
			System.out.println("create table "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insert_Logistics() {
		String table_name = URLHelper.getLogisticsURL();
		
		try {
			s = conn.createStatement();
			boolean mark = s.execute("INSERT INTO "+table_name+" VALUES('0000000001', '黄勇', '南京大学仙林校区1B-434-1', '南京大学', "
					+ "'22222222', '13851988941', '张晨剑', '南京大学仙林校区1B-434-2', '南京大学', '22222222', '13851988941', "
					+ "'张晨剑', 1, 2, 2, 'iPhone 6S Plus', 'ECONOMIC', 'COURISE_BAG', 6, '南京', '南京', 'DAMAGED', "
					+ "'2015-11-11 12:20:20', '2015-11-19 20:20:20', '刘钦', 'true', 'true', "
					+ "'南京栖霞区收件,2015-11-12 12:00:00>>南京栖霞区正在派件,2015-11-18 12:00:00>>收件人已收件,2015-11-19 20:20:20')");
			conn.commit();
			System.out.println("insert into "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createTable_Const() {
		String table_name = URLHelper.getConstURL();
		
		try {
			s = conn.createStatement();
			s.execute("CREATE TABLE "+table_name+" (name varchar(50) PRIMARY key, value double)");
			conn.commit();
			
			System.out.println("create table "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insert_Const() {
		String table_name = URLHelper.getConstURL();
		
		try {
			s = conn.createStatement();
			boolean mark;
			
			mark = s.execute("INSERT INTO "+table_name+" VALUES('AIR', 20)");
			mark = s.execute("INSERT INTO "+table_name+" VALUES('RAILWAT', 0.2)");
			mark = s.execute("INSERT INTO "+table_name+" VALUES('CAR', 2)");
			mark = s.execute("INSERT INTO "+table_name+" VALUES('ECONOMIC', 18)");
			mark = s.execute("INSERT INTO "+table_name+" VALUES('STANDARD', 23)");
			mark = s.execute("INSERT INTO "+table_name+" VALUES('EXPRESS', 25)");
			mark = s.execute("INSERT INTO "+table_name+" VALUES('WOODEN_CASE', 10)");
			mark = s.execute("INSERT INTO "+table_name+" VALUES('COURISE_BAG', 1)");
			mark = s.execute("INSERT INTO "+table_name+" VALUES('PAPER_CASE', 5)");
			
			conn.commit();
			
			System.out.println("insert into "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createTable_Institution() {
		String table_name = URLHelper.getInstitutionURL();
		
		try {
			s = conn.createStatement();
			s.execute("CREATE TABLE "+table_name+" (institution_name varchar(200), institution_type varchar(20),"
					+ " city varchar(20), institution_number varchar(25) PRIMARY key)");
			conn.commit();
		
			System.out.println("create table "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insert_Institution() {
		String table_name = URLHelper.getInstitutionURL();
		
		try {
			s = conn.createStatement();
			boolean mark;
//			mark = s.execute("INSERT INTO "+table_name+" VALUES('南京市鼓楼营业厅', 'BusinessLobby', "
//					+ "'南京', '025000')");
//			mark = s.execute("INSERT INTO "+table_name+" VALUES('南京市中转中心', 'MediumCenter', "
//					+ "'南京', '0250')");
			mark = s.execute("INSERT INTO "+table_name+" VALUES('南京市中转中心仓库', 'Repository', "
					+ "'南京', '02500')");
			conn.commit();
			
			System.out.println("insert into "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createTable_Account() {
		String table_name = URLHelper.getAccountURL();
		
		try {
			s = conn.createStatement();
			s.execute("CREATE TABLE "+table_name+" (account_id int PRIMARY key, account_name varchar(50), "
					+ "amount double)");
			conn.commit();
			
			System.out.println("create table "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insert_Account() {
		String table_name = URLHelper.getAccountURL();
		
		try {
			s = conn.createStatement();
			boolean mark = s.execute("INSERT INTO "+table_name+" VALUES(1, '中国银行南京分行', 2403495.03)");
			conn.commit();
			
			System.out.println("insert into "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createTable_Log() {
		String table_name = URLHelper.getLogURL();
		
		try {
			s = conn.createStatement();
			s.execute("CREATE TABLE "+table_name+" (time varchar(30) PRIMARY key, operation varchar(50), operator varchar(20))");
			conn.commit();
			
			System.out.println("create table "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insert_Log() {
		String table_name = URLHelper.getLogURL();
		
		try {
			s = conn.createStatement();
			boolean mark = s.execute("INSERT INTO "+table_name+" VALUES('2015-11-22 12:22:02', '创建数据库表', '黄勇')");
			conn.commit();
			
			System.out.println("insert into "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createTable_Salary() {
		String table_name = URLHelper.getSalaryURL();
		
		try {
			s = conn.createStatement();
			s.execute("CREATE TABLE "+table_name+" (staff varchar(20) PRIMARY key, salary double, type varchar(20))");
			conn.commit();
			
			System.out.println("create table "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insert_Salary() {
		String table_name = URLHelper.getSalaryURL();
		
		try {
			s = conn.createStatement();
			boolean mark = s.execute("INSERT INTO "+table_name+" VALUES('admin', 3000, 'MONTH')");
			conn.commit();
			
			System.out.println("insert into "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createTable_Distance() {
		String table_name = URLHelper.getDistanceURL();
		
		try {
			s = conn.createStatement();
			s.execute("CREATE TABLE "+table_name+" (city_1 varchar(20), city_2 varchar(20), distance double, time double)");
			conn.commit();
			
			System.out.println("create table "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insert_Distance() {
		String table_name = URLHelper.getDistanceURL();
		
		try {
			s = conn.createStatement();
			boolean mark;
			mark = s.execute("INSERT INTO "+table_name+" VALUES('北京', '上海', 1064.7, 0)");
			mark = s.execute("INSERT INTO "+table_name+" VALUES('北京', '广州', 1888.8, 0)");
			mark = s.execute("INSERT INTO "+table_name+" VALUES('北京', '南京', 900, 0)");
			mark = s.execute("INSERT INTO "+table_name+" VALUES('上海', '广州', 1213, 0)");
			mark = s.execute("INSERT INTO "+table_name+" VALUES('上海', '南京', 266, 0)");
			mark = s.execute("INSERT INTO "+table_name+" VALUES('广州', '南京', 1132, 0)");
			conn.commit();
			
			System.out.println("insert into "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createTable_Driver(String URL) {
		String table_name = URLHelper.getDriverInfoURL(URL);
		
		try {
			s = conn.createStatement();
			s.execute("CREATE TABLE "+table_name+" (driver_number varchar(20) PRIMARY key, driver_name varchar(20), driver_birthday varchar(20), "
					+ "driver_id varchar(20), driver_mobilephone varchar(20), driver_sex varchar(10), attend_time int)");
			conn.commit();
			
			System.out.println("create table "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insert_Driver(String URL) {
		String table_name = URLHelper.getDriverInfoURL(URL);
		
		try {
			s = conn.createStatement();
			boolean mark = s.execute("INSERT INTO "+table_name+" VALUES('025000000', '黄勇', '1996-12-20', "
					+ " '321002199612200239', '1304083920674', '男', 5)");
			conn.commit();
			
			System.out.println("insert into "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createTable_Car(String URL) {
		String table_name = URLHelper.getCarInfoURL(URL);
		
		try {
			s = conn.createStatement();
			s.execute("CREATE TABLE "+table_name+" (car_number varchar(20) PRIMARY key, car_license varchar(20),"
					+ " attend_time int)");
			conn.commit();
			
			System.out.println("create table "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insert_Car(String URL) {
		String table_name = URLHelper.getCarInfoURL(URL);
		
		try {
			s = conn.createStatement();
			boolean mark = s.execute("INSERT INTO "+table_name+" VALUES('025000000', '苏A 35D02', 2)");
			conn.commit();
			
			System.out.println("insert into "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createTable_Arrival(String URL) {
		String table_name = URLHelper.getArrivalURL(URL);
		
		try {
			s = conn.createStatement();
			s.execute("CREATE TABLE "+table_name+" (bar_code varchar(20) PRIMARY key, arrival_date varchar(20), "
					+ "transfer_number varchar(25), starting varchar(20), state varchar(20), "
					+ "isApproved varchar(10))");
			conn.commit();
			
			System.out.println("create table "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insert_Arrival(String URL) {
		String table_name = URLHelper.getArrivalURL(URL);
		
		try {
			s = conn.createStatement();
			boolean mark = s.execute("INSERT INTO "+table_name+" VALUES('0000000001', '2015-11-21 12:22:43', '02502015112100000', "
					+ "'北京', 'INTACT', 'true')");
			conn.commit();
			
			System.out.println("insert into "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createTable_Delivery(String URL) {
		String table_name = URLHelper.getDeliveryURL(URL);
		
		try {
			s = conn.createStatement();
			s.execute("CREATE TABLE "+table_name+" (date varchar(25) PRIMARY key, bar_code_list varchar(1000), courier varchar(20), "
					+ "isApproved varchar(10))");
			conn.commit();
			
			System.out.println("create table "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insert_Delivery(String URL) {
		String table_name = URLHelper.getDeliveryURL(URL);
		
		try {
			s = conn.createStatement();
			boolean mark = s.execute("INSERT INTO "+table_name+" VALUES('2015-11-12 15:34:23', '0000000001', "
					+ "'02500000001', 'true')");
			conn.commit();
			
			System.out.println("insert into "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createTable_Entrucking(String URL) {
		String table_name = URLHelper.getEntruckingURL(URL);
	
		try {
			s = conn.createStatement();
			s.execute("CREATE TABLE "+table_name+" (date varchar(25), transfer_number varchar(20) PRIMARY key, destination varchar(20), "
					+ "car_number varchar(20), guard_name varchar(20), supercargo_name varchar(20), "
					+ "bar_code_list varchar(1000), amount double, isApproved varchar(10))");
			conn.commit();
			
			System.out.println("create table "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insert_Entrucking(String URL) {
		String table_name = URLHelper.getEntruckingURL(URL);
	
		try {
			s = conn.createStatement();
			boolean mark = s.execute("INSERT INTO "+table_name+" VALUES('2015-11-23 14:22:23', '02502015112300000', '南京', "
					+ "'025000000', '黄勇', '黄勇', '0000000001', 12, 'true')");
		
			System.out.println("insert into "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	public static void createTable_Balance(String URL) {
		String table_name = URLHelper.getBalanceURL(URL);
		
		try {
			s = conn.createStatement();
			s.execute("CREATE TABLE "+table_name+" (bar_code varchar(20) PRIMARY key, storage_date varchar(20), destination varchar(50), "
					+ "old_area varchar(50), old_row int, old_shelf int, old_position int, "
					+ "new_area varchar(50), new_row int, new_shelf int, new_position int, isApproved varchar(10))");
			conn.commit();
			
			System.out.println("create table "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insert_Balance(String URL) {
		String table_name = URLHelper.getBalanceURL(URL);
		
		try {
			s = conn.createStatement();
			boolean mark = s.execute("INSERT INTO "+table_name+" VALUES('0000000001', '2015-11-20 12:20:22', '南京', "
					+ "'RAILWAY_TRANSPORTATION', 2, 3, 40, 'AIR_TRANSPORTATION', 2, 4, 10, 'true')");
			conn.commit();
			
			System.out.println("insert into "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createTable_StockTaking(String URL) {
		String table_name = URLHelper.getStockTakingURL(URL);
		
		try {
			s = conn.createStatement();
			s.execute("CREATE TABLE "+table_name+" (bar_code varchar(20) PRIMARY key, storage_date varchar(20), "
					+ "destination varchar(20), area_code varchar(20), row int, shelf int, position int)");
			conn.commit();
			
			System.out.println("create table "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insert_StockingTaking(String URL) {
		String table_name = URLHelper.getStockTakingURL(URL);
		
		try {
			s = conn.createStatement();
			boolean mark = s.execute("INSERT INTO "+table_name+" VALUES('0000000001', '2015-11-22 15:00:34', "
					+ "'南京', 'AIR_TRANSPORTATION', 2, 5, 12)");
			conn.commit();
			
			System.out.println("insert into "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createTable_Storage(String URL) {
		String table_name = URLHelper.getStorageURL(URL);
		
		try {
			s = conn.createStatement();
			s.execute("CREATE TABLE "+table_name+" (bar_code varchar(20) PRIMARY key, storage_date varchar(20), "
					+ "destination varchar(20), area_code varchar(20), row int, shelf int, "
					+ "position int, isApproved varchar(10))");
			conn.commit();
		
			System.out.println("create table "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insert_Storage(String URL) {
		String table_name = URLHelper.getStorageURL(URL);
		
		try {
			s = conn.createStatement();
			boolean mark = s.execute("INSERT INTO "+table_name+" VALUES('0000000001', '2015-11-12 18:33:30', "
					+ "'南京', 'AIR_TRANSPORTATION', 1, 2, 5, 'true')");
			conn.commit();
			
			System.out.println("insert into "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createTable_Removal(String URL) {
		String table_name = URLHelper.getRemovalURL(URL);
		
		try {
			s = conn.createStatement();
			s.execute("CREATE TABLE "+table_name+" (bar_code varchar(20) PRIMARY key, removal_date varchar(20), "
					+ "destination varchar(20), type varchar(15), transfer_number varchar(20), "
					+ "isApproved varchar(10))");
			conn.commit();
			
			System.out.println("create table "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insert_Removal(String URL) {
		String table_name = URLHelper.getRemovalURL(URL);
		
		try {
			s = conn.createStatement();
			boolean mark = s.execute("INSERT INTO "+table_name+" VALUES('0000000001', '2015-11-22 23:32:22', "
					+ "'南京', 'AIR', '02502015112200000', 'true')");
			conn.commit();
			
			System.out.println("insert into "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createTable_Transfer(String URL) {
		String table_name = URLHelper.getTransferURL(URL);
	
		try {
			s = conn.createStatement();
			s.execute("CREATE TABLE "+table_name+" (date varchar(20), transfer_number varchar(20) PRIMARY key, "
					+ "transport_id varchar(50), starting varchar(20), destination varchar(20), "
					+ "container_number varchar(20), guard_name varchar(20), bar_code_list varchar(1000), "
					+ "amount double, isApproved varchar(10))");
			conn.commit();
			
			System.out.println("create table "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insert_Transfer(String URL) {
		String table_name = URLHelper.getTransferURL(URL);
		
		try {
			s = conn.createStatement();
			boolean mark = s.execute("INSERT INTO "+table_name+" VALUES('2015-11-23 02:20:21', '02502015112300000', "
					+ "'D0323', '南京', '北京', '0234', '黄勇', '0000000001', 120, 'true')");
			conn.commit();
			
			System.out.println("insert into "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createTable_Gathering(String URL) {
		String table_name = URLHelper.getGatheringURL(URL);
		
		try {
			s = conn.createStatement();
			s.execute("CREATE TABLE "+table_name+" (date varchar(20) PRIMARY key, amount double, "
					+ "courier varchar(20), bar_code_list varchar(1000), isApproved varchar(10))");
			conn.commit();
			
			System.out.println("create table "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insert_Gathering(String URL) {
		String table_name = URLHelper.getGatheringURL(URL);
		
		try {
			s = conn.createStatement();
			boolean mark = s.execute("INSERT INTO "+table_name+" VALUES('2015-11-21 17:34:01', 204.34, "
					+ "'黄勇', '0000000001', 'true')");
			conn.commit();
			
			System.out.println("insert into "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createTable_Period() {
		String table_name = URLHelper.getPeriodURL();
		
		try {
			s = conn.createStatement();
			s.execute("CREATE TABLE "+table_name+" (date varchar(20) PRIMARY key, institution_size int, staff_size int, "
					+ "car_size int, storage_size int, account varchar(1000))");
			conn.commit();
			
			System.out.println("create table "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insert_Period() {
		String table_name = URLHelper.getPeriodURL();
		
		try {
			s = conn.createStatement();
			boolean mark = s.execute("INSERT INTO "+table_name+" VALUES()");
			conn.commit();
			
			System.out.println("insert into "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createTable_Benefit() {
		String table_name = URLHelper.getBenefitURL();
		
		try {
			s = conn.createStatement();
			s.execute("CREATE TABLE "+table_name+" (income double, expend double, benefit double, "
					+ "date varchar(20) PRIMARY key)");
			conn.commit();
			
			System.out.println("create table "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insert_Benefit() {
		String table_name = URLHelper.getBenefitURL();
		
		try {
			s = conn.createStatement();
			boolean mark = s.execute("INSERT INTO "+table_name+" VALUES()");
			conn.commit();
			
			System.out.println("insert into "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createTable_Cost() {
		String table_name = URLHelper.getCostURL();
		
		try {
			s = conn.createStatement();
			s.execute("CREATE TABLE "+table_name+" (cost_date varchar(20) PRIMARY key, cost_amount double, "
					+ "cost_name varchar(50), account_name varchar(50), type varchar(50), "
					+ "remark varchar(100), isApproved varchar(10))");
			conn.commit();
			
			System.out.println("create table "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insert_Cost() {
		String table_name = URLHelper.getCostURL();
		
		try {
			s = conn.createStatement();
			boolean mark = s.execute("INSERT INTO "+table_name+" VALUES()");
			conn.commit();
			
			System.out.println("insert into "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createTable_WareHouse(String URL) {
		String table_name = URLHelper.getWareHouseURL(URL);
		
		try {
			s = conn.createStatement();
			s.execute("CREATE TABLE "+table_name+" (bar_code varchar(20) PRIMARY key, destination varchar(20), "
					+ "area_code varchar(50), row int, shelf int, position int)");
			conn.commit();
			
			System.out.println("create table "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
		
	public static void insert_WareHouse(String URL) {
		String table_name = URLHelper.getWareHouseURL(URL);
		
		try {
			s = conn.createStatement();
			boolean mark = s.execute("INSERT INTO "+table_name+" VALUES('0000000001', '南京', "
					+ "'AIR_TRANSPORTATION', 2, 5, 8)");
			conn.commit();
			
			System.out.println("insert into "+table_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static void createType() {
		String type_name = null;
		String class_name = null;
		
		try {
			s = conn.createStatement();
			s.execute("CREATE TYPE "+type_name+" EXTERNAL NAME "+class_name+" LANGUAGE JAVA");
			System.out.println("create type "+type_name+" as "+class_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
