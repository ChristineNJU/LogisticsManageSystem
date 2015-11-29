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

import PO.EntruckingPO;
import data.Helper.DBHelper.DBHelper.DBHelper;
import data.Service.Search.SearchEntruckingService;

/**
 * 
 * @author 尹子越
 * @version 1.0.0
 */
public class SearchEntruckingImpl extends UnicastRemoteObject implements SearchEntruckingService {

	public SearchEntruckingImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<EntruckingPO> searchEntrucking(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<EntruckingPO> result = new ArrayList<EntruckingPO>();
		
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
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date;
				try {
					date = sdf.parse(rs.getString(1));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
					System.out.println("创建时间对象失败");
					date = null;
				}
				
				String transfer_number = rs.getString(2);
				String destination = rs.getString(3);
				String car_number = rs.getString(4);
				String guard_name = rs.getString(5);
				String supercargo_name = rs.getString(6);
				
				String[] list = rs.getString(7).split(",");
				ArrayList<String> bar_code_list = new ArrayList<String>();
				for(int i=0;i<list.length;i++){
					bar_code_list.add(list[i]);
				}
				
				double amount = rs.getDouble(8);
				boolean isApproved = rs.getString(9).equals("true");
				
				EntruckingPO entrucking = new EntruckingPO(date, transfer_number, destination, car_number, guard_name, supercargo_name,
						bar_code_list, amount, DB_URL);
				
				entrucking.setApproved(isApproved);
				
				result.add(entrucking);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("从数据库提取EntruckingPO对象失败");
			return result;
		}
		return result;
	}

}
