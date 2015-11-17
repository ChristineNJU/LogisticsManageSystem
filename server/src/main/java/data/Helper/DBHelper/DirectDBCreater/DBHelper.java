package data.Helper.DBHelper.DirectDBCreater;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	
	private static final String db_name = "LogisticsManageSystemDataBase";
	
	private static Connection conn = null;
	
	public DBHelper() {
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
	
	public static Connection getConnection() {
		return conn;
	}
}
