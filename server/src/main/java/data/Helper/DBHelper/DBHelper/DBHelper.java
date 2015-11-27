package data.Helper.DBHelper.DBHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	
	private static final String db_name = "LogisticsManageSystemDataBase";
	
	private static Connection conn = null;
	
	public static DBHelper db = null;
	
	private DBHelper() {
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
	
	public static DBHelper createDBHelper() {
		if(db==null){
			return db=new DBHelper();
		}else{
			return db;
		}	
	}
	
	public static Connection getConnection() {
		return conn;
	}
	
	public static String SEARCH(String table, String target) {
		return "SELECT * FROM "+table+" WHERE "+target;
	}
	
}
