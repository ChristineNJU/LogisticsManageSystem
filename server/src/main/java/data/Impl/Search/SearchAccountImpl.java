package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import PO.AccountPO;
import businesslogic.URLHelper.URLHelper;
import data.Helper.DBHelper.DBHelper.DBHelper;
import data.Service.Search.SearchAccountService;

public class SearchAccountImpl extends UnicastRemoteObject implements SearchAccountService {
	
	public SearchAccountImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<AccountPO> searchAccount(ArrayList<String> requirement)
			throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<AccountPO> result = new ArrayList<AccountPO>();
		
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
			
			ResultSet rs = s.executeQuery(DBHelper.SEARCH(URLHelper.getAccountURL(), target));
			
			while(rs.next()){
				int account_id = rs.getInt(1);
				String account_name = rs.getString(2);
				double amount = rs.getDouble(3);
				
				AccountPO account = new AccountPO(account_id, account_name, amount, URLHelper.getAccountURL());
				
				result.add(account);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("从数据库提取AccountPO对象失败");
			return result;
		}
		
		return result;
	}

}
