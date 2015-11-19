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
//				insert_User();
				insert_Logistics();
//				deleteTable(URLHelper.getLogisticsURL());
//				deleteTable(URLHelper.getUserURL());
				
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
			s.execute("CREATE TABLE "+table_name+" (ID varchar(20), Password varchar(20), Name varchar(20),"
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
			s.execute("CREATE TABLE "+table_name+" (bar_code varchar(20), sender_name varchar(20), sender_address varchar(100), "
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
					+ "'南京栖霞区收件-南京栖霞区正在派件-收件人已收件')");
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
