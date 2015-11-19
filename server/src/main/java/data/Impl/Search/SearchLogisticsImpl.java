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

import PO.LogisticsInfoPO;
import State.LogisticsState;
import State.LogisticsType;
import State.PackingCharge;
import State.StateSwitch;
import businesslogic.URLHelper.URLHelper;
import data.Helper.DBHelper.DBHelper.DBHelper;
import data.Service.Search.SearchLogisticsService;

public class SearchLogisticsImpl extends UnicastRemoteObject implements SearchLogisticsService {

	public SearchLogisticsImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<LogisticsInfoPO> searchLogisticsInfo(
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		
		ArrayList<LogisticsInfoPO> result = new ArrayList<LogisticsInfoPO>();
		
		if(requirement.isEmpty()){
			return result;
		}
		
		Connection conn = DBHelper.getConnection();
		
		try {
			Statement s = conn.createStatement();
			
			String target = requirement.get(0);
			
			ResultSet rs = s.executeQuery(DBHelper.SEARCH(URLHelper.getLogisticsURL(), target));
			
			while(rs.next()){				
				String bar_code = rs.getString(1);
				
				String sender_name = rs.getString(2);
				String sender_address = rs.getString(3);
				String sender_organization = rs.getString(4);
				String sender_telephone = rs.getString(5);
				String sender_mobilephone = rs.getString(6);
				String recipient_name = rs.getString(7);
				String recipient_address = rs.getString(8);
				String recipient_organization = rs.getString(9);
				String recipient_telephone = rs.getString(10);
				String recipient_mobilephone = rs.getString(11);
				
				String actual_recipient_name = rs.getString(12);
				
				int original_number = rs.getInt(13);
				double weight = rs.getDouble(14);
				double size = rs.getDouble(15);
				String internal_name = rs.getString(16);
				LogisticsType type = StateSwitch.switchLogisticsTypeToState(rs.getString(17));
				PackingCharge pack = StateSwitch.switchPackChargeToState(rs.getString(18));
				double total_cost = rs.getDouble(19);
				String starting = rs.getString(20);
				String destination = rs.getString(21);
				LogisticsState state = StateSwitch.switchLogisticsStateToState(rs.getString(22));			
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				Date send_date;
				Date receive_date;
				try {
					send_date = sdf.parse(rs.getString(23));
					receive_date = sdf.parse(rs.getString(24));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					send_date= null;
					receive_date = null;
					System.out.println(URLHelper.getLogisticsURL()+"时间未正确初始化");
				}
				
				String courier_id = rs.getString(25);
				boolean is_approved = rs.getString(26).equals("true");
				boolean is_received = rs.getString(27).equals("true");
				
				String[] history = rs.getString(28).split("-");
				
				LogisticsInfoPO logistics = new LogisticsInfoPO(sender_name, sender_address, sender_organization,
						sender_telephone, sender_mobilephone, recipient_name, recipient_address, 
						recipient_organization, recipient_telephone, recipient_mobilephone, bar_code, 
						original_number, weight, size, internal_name, type, pack, total_cost, 
						starting, destination, send_date, receive_date, courier_id, URLHelper.getLogisticsURL());
				
				logistics.setState(state);
				logistics.setActualRecipientName(actual_recipient_name);
				logistics.setApproved(is_approved);
				logistics.setReceived(is_received);
				for(int i=0;i<history.length;i++){
					logistics.addHistory(history[i]);
				}
				
				result.add(logistics);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("从数据库提取UserPO对象失败");
			return result;
		}
		
		return result;
	}

}
