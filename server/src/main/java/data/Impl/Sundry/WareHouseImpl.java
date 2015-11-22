package data.Impl.Sundry;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data.Helper.DBHelper.DBHelper.DBHelper;
import data.Service.Sundry.WareHouseService;

public class WareHouseImpl extends UnicastRemoteObject implements WareHouseService {

	public WareHouseImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getAmount(String DB_URL) {
		// TODO Auto-generated method stub
		int result = 0;
		
		if(DB_URL==null){
			return result;
		}
		
		Connection conn = DBHelper.getConnection();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("SELECT count(*) FROM "+DB_URL);
			rs.next();
			
			result = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("计数失败");
			return result;
		}
		return result;
	}

}
