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

/**
 * 
 * @author 尹子越
 * @version 1.0.0
 */
public class SearchCarInfoImpl extends UnicastRemoteObject implements SearchCarInfoService {

	public SearchCarInfoImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<CarInfoPO> searchCarInfo(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		
		ArrayList<CarInfoPO> result = new ArrayList<CarInfoPO>();
		
		if(requirement.isEmpty()){
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
			
			ResultSet rs = s.executeQuery(DBHelper.SEARCH(DB_URL, target));
			
			while(rs.next()){
				String car_number = rs.getString(1);
				String car_license = rs.getString(2);
				int attend_time = rs.getInt(3);
				
				CarInfoPO car = new CarInfoPO(car_number, car_license, attend_time, DB_URL);
				
				result.add(car);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("从数据库提取CarInfoPO对象失败");
			return result;
		}
		
		return result;
	}

}
