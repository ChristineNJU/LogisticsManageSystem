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

import PO.RemovalPO;
import State.StateSwitch;
import State.TransferType;
import data.Helper.DBHelper.DBHelper.DBHelper;
import data.Service.Search.SearchRemovalService;

public class SearchRemovalImpl extends UnicastRemoteObject implements SearchRemovalService {

	public SearchRemovalImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<RemovalPO> searchRemoval(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<RemovalPO> result = new ArrayList<RemovalPO>();
		
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
				Date removal_date;
				try {
					removal_date = sdf.parse(rs.getString(2));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
					System.out.println("创建时间对象失败");
					removal_date = null;
				}
				
				String destination = rs.getString(3);
				TransferType type = StateSwitch.switchToTransferType(rs.getString(1));
				String transfer_number = rs.getString(5);
				boolean isApproved = rs.getString(6).equals("true");
				
				RemovalPO removal = new RemovalPO(bar_code, removal_date, destination, type, transfer_number, DB_URL);
				
				removal.setApproved(isApproved);
				
				result.add(removal);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("从数据库提取RemovalPO对象失败");
			return result;
		}
		return result;
	}

}
