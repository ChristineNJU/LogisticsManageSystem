package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import PO.DriverInfoPO;
import data.Helper.DBHelper.DBHelper.DBHelper;
import data.Service.Search.SearchDriverInfoService;

/**
 * 
 * @author 尹子越
 * @version 1.0.0
 */
public class SearchDriverInfoImpl extends UnicastRemoteObject implements SearchDriverInfoService {

	public SearchDriverInfoImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<DriverInfoPO> searchDriverInfo(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<DriverInfoPO> result = new ArrayList<DriverInfoPO>();
		
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
			
			ResultSet rs = s.executeQuery(DBHelper.SEARCH(DB_URL, target));
			while(rs.next()){
				String driver_number = rs.getString(1);
				String driver_name = rs.getString(2);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date driver_birthday;
				try {
					driver_birthday = sdf.parse(rs.getString(3));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
					System.out.println("创建时间对象失败");
					driver_birthday = null;
				}
				
				String driver_id = rs.getString(4);
				String driver_mobilephone = rs.getString(5);
				String driver_sex = rs.getString(6);
				int attend_time = rs.getInt(7);
				
				DriverInfoPO driver = new DriverInfoPO(driver_number, driver_name, driver_birthday,
						driver_id, driver_mobilephone, driver_sex, attend_time, DB_URL);
				
				result.add(driver);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("从数据库提取DriverInfoPO对象失败");
			return result;
		}
		return result;
	}

}
