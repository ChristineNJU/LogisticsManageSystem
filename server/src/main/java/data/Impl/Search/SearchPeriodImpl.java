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

import businesslogic.URLHelper.URLHelper;
import PO.AccountPO;
import PO.PeriodPO;
import data.Helper.DBHelper.DBHelper.DBHelper;
import data.Service.Search.SearchPeriodService;

/**
 * 
 * @author 尹子越
 * @version 1.0.0
 */
public class SearchPeriodImpl extends UnicastRemoteObject implements SearchPeriodService {

	public SearchPeriodImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public PeriodPO searchPeriod() throws RemoteException {
		// TODO Auto-generated method stub
		PeriodPO period = null;		
		
		Connection conn = DBHelper.getConnection();
		try {
			Statement s = conn.createStatement();
			
			String target = "date like '%%'";
			
			ResultSet rs = s.executeQuery(DBHelper.SEARCH(URLHelper.getPeriodURL(), target));
			rs.next();
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
			
			int institution_size = rs.getInt(2);
			int staff_size = rs.getInt(3);
			int car_size = rs.getInt(4);
			int storage_size = rs.getInt(5);
			
			String[] list = rs.getString(6).split(",");
			ArrayList<AccountPO> account = new ArrayList<AccountPO>();
			for(int i=0;i<list.length;i++){
				ArrayList<String> r = new ArrayList<String>();
				r.add("account_id = "+list[i]);
				ArrayList<AccountPO> tmp = new SearchAccountImpl().searchAccount(r);
				if(!tmp.isEmpty()){
					account.add(tmp.get(0));
				}
			}
			
			period = new PeriodPO(date, institution_size, staff_size, car_size, storage_size, 
					account, URLHelper.getPeriodURL());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("从数据库提取PeriodPO对象失败");
			return null;
		}
		
		return period;
	}

}
