package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import businesslogic.URLHelper.URLHelper;
import PO.DistancePO;
import data.Helper.DBHelper.DBHelper.DBHelper;
import data.Service.Search.SearchDistanceService;

public class SearchDistanceImpl extends UnicastRemoteObject implements SearchDistanceService {

	public SearchDistanceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<DistancePO> searchDistance(ArrayList<String> requirement)
			throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<DistancePO> result = new ArrayList<DistancePO>();
		
		if(requirement==null||requirement.isEmpty()){
			return result;
		}
		
		Connection conn = DBHelper.getConnection();
		try {
			Statement s = conn.createStatement();
			
			String target = "";
			for(int i=0;i<requirement.size();i++){
				if(i!=requirement.size()-1){
					target = target + requirement.get(i) + " AND ";
				}else{
					target = target + requirement.get(i);
				}
			}
			
			ResultSet rs = s.executeQuery(DBHelper.SEARCH(URLHelper.getDistanceURL(), target));
			while(rs.next()){
				String city_1 = rs.getString(1);
				String city_2 = rs.getString(2);
				double distance = rs.getDouble(3);
				double time = rs.getDouble(4);
				
				DistancePO d = new DistancePO(city_1, city_2, distance, time, URLHelper.getDistanceURL());
				
				result.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("从数据库提取DistancePO对象失败");
			return result;
		}
		
		return result;
	}

}
