package data.Helper.DBHelper.DBHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 创建数据库链接以及提供Connection对象
 *
 * @author 尹子越
 * @version 1.0.0
 */
public class DBHelper {
	
	private static final String db_name = "LogisticsManageSystemDataBase";
	
	private static Connection conn = null;
	
	public static DBHelper db = null;
	
	/**
	 * 构造函数声明私有,只允许创建一个
	 * @exception InstantiationException | IllegalAccessException | 
	 * 			ClassNotFoundException | SQLException
	 */
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
	
	/**
	 * 静态创建方法
	 * 
	 * @return 该类的唯一对象实例
	 */
	public static DBHelper createDBHelper() {
		if(db==null){
			return db = new DBHelper();
		}else{
			return db;
		}	
	}
	
	/**
	 * 获取静态的Connection实例
	 * 
	 * @return 静态Connection实例
	 */
	public static Connection getConnection() {
		return conn;
	}
	
	/**
	 * 获取SQL搜索语句
	 * 
	 * @param table 获取表名称
	 * @param target 获取搜索依据
	 * @return SQL搜索语句
	 */
	public static String SEARCH(String table, String target) {
		return "SELECT * FROM "+table+" WHERE "+target;
	}
	
}
