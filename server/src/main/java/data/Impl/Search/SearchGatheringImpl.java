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

import PO.GatheringPO;
import data.Helper.DBHelper.DBHelper.DBHelper;
import data.Service.Search.SearchGatheringService;

/**
 * 
 * @author 尹子越
 * @version 1.0.0
 */
public class SearchGatheringImpl extends UnicastRemoteObject implements SearchGatheringService {

	public SearchGatheringImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<GatheringPO> searchGathering(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<GatheringPO> result = new ArrayList<GatheringPO>();
		
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
			
//			System.out.println(target);
//			System.out.println(DBHelper.SEARCH(DB_URL, target));
			
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
				
				double amount = rs.getDouble(2);
				String courier = rs.getString(3);
				
				String[] list = rs.getString(4).split(",");
				ArrayList<String> bar_code_list = new ArrayList<String>();
				for(int i=0;i<list.length;i++){
					bar_code_list.add(list[i]);
				}
				
				boolean isApproved = rs.getString(5).equals("true");
				
				GatheringPO gathering = new GatheringPO(date, amount, courier, bar_code_list, DB_URL);
				
				gathering.setApproved(isApproved);
				
				result.add(gathering);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("从数据库提取GatheringPO对象失败");
			return result;
		}
		return result;
	}

}
