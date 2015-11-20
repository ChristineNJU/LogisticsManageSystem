package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import PO.CarInfoPO;
import data.Helper.DBHelper.DBHelper.DBHelper;
import data.Service.Search.SearchCarInfoService;

public class SearchCarInfoImpl extends UnicastRemoteObject implements SearchCarInfoService {

	public SearchCarInfoImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<CarInfoPO> searchCarInfo(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		
		ArrayList<CarInfoPO> car_info = new ArrayList<CarInfoPO>();
		
		if(requirement.isEmpty()){
			return car_info;
		}
		
		Connection conn = DBHelper.getConnection();
		try {
			Statement s = conn.createStatement();
			
			String target = requirement.get(0);
			
			ResultSet rs = s.executeQuery(DBHelper.SEARCH(DB_URL, target));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
