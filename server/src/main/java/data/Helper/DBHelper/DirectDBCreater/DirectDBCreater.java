package data.Helper.DBHelper.DirectDBCreater;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
			
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void createTable() {
		String table_name = "table_1";
		
		try {
			s = conn.createStatement();
			s.execute("CREATE TABLE "+table_name+"()");
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
