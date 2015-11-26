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

import PO.StockTakingPO;
import State.StateSwitch;
import State.StorageArea;
import data.Helper.DBHelper.DBHelper.DBHelper;
import data.Service.Search.SearchStockTakingService;

public class SearchStockTakingImpl extends UnicastRemoteObject implements SearchStockTakingService {

	public SearchStockTakingImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<StockTakingPO> searchStockTaking(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<StockTakingPO> result = new ArrayList<StockTakingPO>();
		
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

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
				StorageArea area_code = StateSwitch.switchToStorageArea(rs.getString(4));
				int row = rs.getInt(5);
				int shelf = rs.getInt(6);
				int position = rs.getInt(7);
				
				StockTakingPO stock = new StockTakingPO(bar_code, storage_date, destination,
						area_code, row, shelf, position, DB_URL);
				
				result.add(stock);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("从数据库提取StockTakingPO对象失败");
			return result;
		}
		return result;
	}

}
