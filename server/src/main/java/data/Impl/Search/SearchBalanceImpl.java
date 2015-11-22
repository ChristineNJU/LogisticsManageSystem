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

import PO.BalancePO;
import State.StateSwitch;
import State.StorageArea;
import data.Helper.DBHelper.DBHelper.DBHelper;
import data.Service.Search.SearchBalanceService;

public class SearchBalanceImpl extends UnicastRemoteObject implements SearchBalanceService {

	public SearchBalanceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<BalancePO> searchBalannce(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<BalancePO> result = new ArrayList<BalancePO>();
		
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
				String bar_code = rs.getString(1);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
				Date storage_date;
				try {
					storage_date = sdf.parse(rs.getString(2));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
					System.out.println("创建时间对象失败");
					storage_date = null; 
				}
				String destination = rs.getString(3);
				StorageArea old_area = StateSwitch.switchToStorageArea(rs.getString(4));
				int old_row = rs.getInt(5);
				int old_shelf = rs.getInt(6);
				int old_position = rs.getInt(7);
				StorageArea new_area = StateSwitch.switchToStorageArea(rs.getString(8));
				int new_row = rs.getInt(9);
				int new_shelf = rs.getInt(10);
				int new_position = rs.getInt(11);
				boolean isApproved = rs.getString(12).equals("true");
				
				BalancePO balance = new BalancePO(bar_code, storage_date,
						destination, old_area, old_row, old_shelf, old_position, new_area, 
						new_row, new_shelf, new_position, DB_URL);
				
				balance.setApproved(isApproved);
				
				result.add(balance);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("从数据库提取BalancePO对象失败");
			return result;
		}
		
		return result;
	}

}
