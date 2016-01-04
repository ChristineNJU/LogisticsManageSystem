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

import server.frame.ServerFrame;
import PO.TransferPO;
import data.Helper.DBHelper.DBHelper.DBHelper;
import data.Service.Search.SearchTransferService;

/**
 * 
 * @author 尹子越
 * @version 1.0.0
 */
public class SearchTransferImpl extends UnicastRemoteObject implements SearchTransferService {

	public SearchTransferImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<TransferPO> searchTransfer(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<TransferPO> result = new ArrayList<TransferPO>();
		
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
				String transport_id = rs.getString(3);
				String starting = rs.getString(4);
				String destination = rs.getString(5);
				String container_number = rs.getString(6);
				String guard_name = rs.getString(7);
				
				String[] list = rs.getString(8).split(",");
				ArrayList<String> bar_code_list = new ArrayList<String>();
				for(int i=0;i<list.length;i++){
					bar_code_list.add(list[i]);
				}
				
				double amount = rs.getDouble(9);
				boolean isApproved = rs.getString(10).equals("true");
				
				TransferPO transfer = new TransferPO(date, transfer_number, transport_id, starting, destination,
						container_number, guard_name, bar_code_list, amount, DB_URL);
				
				transfer.setApproved(isApproved);
				
				result.add(transfer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("从数据库提取TransferPO对象失败");
			
			ServerFrame.addInfo(e.getMessage());
			
			return result;
		}
		return result;
	}

}
