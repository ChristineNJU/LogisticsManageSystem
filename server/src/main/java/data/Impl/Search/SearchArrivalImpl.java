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

import PO.ArrivalPO;
import State.LogisticsState;
import State.StateSwitch;
import data.Helper.DBHelper.DBHelper.DBHelper;
import data.Service.Search.SearchArrivalService;

public class SearchArrivalImpl extends UnicastRemoteObject implements SearchArrivalService {

	public SearchArrivalImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<ArrivalPO> searchArrival(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<ArrivalPO> result = new ArrayList<ArrivalPO>();
		
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
				Date arrival_date;
				
				try {
					arrival_date = sdf.parse(rs.getString(2));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
					System.out.println("创建时间对象失败");
					arrival_date = null;
				}
				
				String transfer_number = rs.getString(3);
				String starting = rs.getString(4);
				LogisticsState state = StateSwitch.switchToLogisticsState(rs.getString(5));
				boolean isApproved = rs.getString(6).equals("true");
				
				ArrivalPO arrival = new ArrivalPO(bar_code, arrival_date, transfer_number,
						starting, state, DB_URL);
				
				arrival.setApproved(isApproved);
				
				result.add(arrival);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("从数据库提取ArrivalPO对象失败");
			return result;
		}
		
		return result;
	}

}
