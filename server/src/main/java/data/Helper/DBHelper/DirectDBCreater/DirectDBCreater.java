	package data.Helper.DBHelper.DirectDBCreater;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import businesslogic.URLHelper.URLHelper;

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
//				createTable_Logistics();
//				createTable_Const();
//				createTable_Institution();
//				createTable_Account();
//				createTable_Log();
//				createTable_Salary();
//				createTable_Distance();
//				insert_User();
//				insert_Logistics();
//				insert_Const();
//				insert_Institution();
//				insert_Account();
//				insert_Log();
//				insert_Salary();
//				insert_Distance();
//				deleteTable(URLHelper.getLogisticsURL());
//				deleteTable(URLHelper.getUserURL());
//				deleteTable(URLHelper.getConstURL());
//				deleteTable(URLHelper.getInstitutionURL());
				
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
					+ "'管理员', '南京', '管理员')");
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
			
			mark = s.execute("INSERT INTO "+table_name+" VALUES('plane', 20)");
			mark = s.execute("INSERT INTO "+table_name+" VALUES('train', 0.2)");
			mark = s.execute("INSERT INTO "+table_name+" VALUES('car', 2)");
			mark = s.execute("INSERT INTO "+table_name+" VALUES('economic', 18)");
			mark = s.execute("INSERT INTO "+table_name+" VALUES('standard', 23)");
			mark = s.execute("INSERT INTO "+table_name+" VALUES('express', 25)");
			mark = s.execute("INSERT INTO "+table_name+" VALUES('wooden_case', 10)");
			mark = s.execute("INSERT INTO "+table_name+" VALUES('courise_bag', 1)");
			mark = s.execute("INSERT INTO "+table_name+" VALUES('paper_case', 5)");
			
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
			s.execute("CREATE TABLE "+table_name+" (staff varchar(20), salary double, type varchar(20))");
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
