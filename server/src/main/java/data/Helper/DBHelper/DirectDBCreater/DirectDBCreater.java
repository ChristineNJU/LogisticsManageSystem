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
			
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void createTable_User() {
		String table_name = URLHelper.getUserURL();
		
		try {
			s = conn.createStatement();
			s.execute("CREATE TABLE "+table_name+" (User_ID varchar(20), User_Password varchar(20), User_Name varchar(20),"
					+ " User_Sex varchar(5), User_Age int, User_InstitutionType varchar(15), User_City varchar(20),"
					+ " User_UserRole varchar(15))");
			conn.commit();
			
			System.out.println("create table "+table_name);
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
					+ "recipient_organization varchar(50), recipient_telephone varchar(25), "
					+ "actual_recipient_name varchar(20), original_number int, logistics_weight double, "
					+ "logistics_size double, internal_name varchar(50), logistics_type varchar(20), packing_charge varchar(20), "
					+ "total_cost double, time_starting varchar(20), time_destination varchar(20), "
					+ "logistics_state varchar(20), send_date varchar(25), receive_date varchar(25), "
					+ "courier_id varchar(20), is_approved varchar(5), is_received varchar(5))");
			conn.commit();
			
			System.out.println("create table "+table_name);
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
