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

import PO.LogPO;
import businesslogic.URLHelper.URLHelper;
import data.Helper.DBHelper.DBHelper.DBHelper;
import data.Service.Search.SearchLogService;

/**
 * 
 * @author 尹子越
 * @version 1.0.0
 */
public class SearchLogImpl extends UnicastRemoteObject implements SearchLogService {

	public SearchLogImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<LogPO> searchLog(ArrayList<String> requirement)
			throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<LogPO> result = new ArrayList<LogPO>();
		
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
			
			ResultSet rs = s.executeQuery(DBHelper.SEARCH(URLHelper.getLogURL(), target));
			while(rs.next()){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date time;
				try {
					time = sdf.parse(rs.getString(1));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
					System.out.println("创建时间对象失败");
					time = null;
				}
				
				String operation = rs.getString(2);
				String operator = rs.getString(3);
				
				LogPO log = new LogPO(time, operation, operator, URLHelper.getLogURL());
				
				result.add(log);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("从数据库提取LogPO对象失败");
			return result;
		}
		return result;
	}

}
