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

import PO.DeliveryPO;
import businesslogic.URLHelper.URLHelper;
import data.Helper.DBHelper.DBHelper.DBHelper;
import data.Service.Search.SearchDeliveryService;

/**
 * 
 * @author 尹子越
 * @version 1.0.0
 */
public class SearchDeliveryImpl extends UnicastRemoteObject implements SearchDeliveryService {

	public SearchDeliveryImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * 从数据库中搜索DeliveryPO
	 * 
	 * @param DB_URL 表链接
	 * @param requirement 搜索要求
	 * @return DeliveryPO的ArrayList 
	 */
	public ArrayList<DeliveryPO> searchDelivery(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<DeliveryPO> result = new ArrayList<DeliveryPO>();
		
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
			
			ResultSet rs = s.executeQuery(DBHelper.SEARCH(URLHelper.getDeliveryURL(DB_URL), target));
		
			while(rs.next()){				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				Date date;
				try {
					date = sdf.parse(rs.getString(1));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					date = null;
					System.out.println(DB_URL+"时间未正确初始化");
				}
				
				String[] list = rs.getString(2).split(",");
				ArrayList<String> bar_code_list = new ArrayList<String>();
				for(int i=0;i<list.length;i++){
					bar_code_list.add(list[i]);
				}
				
				String courier = rs.getString(3);
				boolean isApproved = rs.getString(4).equals("true");
				
				DeliveryPO delivery = new DeliveryPO(date, bar_code_list, courier, DB_URL);
				
				delivery.setApproved(isApproved);
				
				result.add(delivery);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("从数据库提取DeliveryPO对象失败");
			return result;
		}
		return result;
	}

}
