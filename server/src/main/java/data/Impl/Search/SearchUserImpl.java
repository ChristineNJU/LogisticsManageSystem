package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import PO.UserPO;
import State.InstitutionType;
import State.UserRole;
import businesslogic.URLHelper.URLHelper;
import data.Helper.DBHelper.DBHelper.DBHelper;
import data.Service.Search.SearchUserService;


public class SearchUserImpl extends UnicastRemoteObject implements SearchUserService {

	public SearchUserImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<UserPO> searchUser(ArrayList<String> requirement)
			throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<UserPO> result = new ArrayList<UserPO>();
		
		if(requirement.isEmpty()){
			return result;
		}
		
		Connection conn = DBHelper.getConnection();
		try {
			Statement s = conn.createStatement();
			
			String target = requirement.get(0);
			
//			System.out.println(DBHelper.SEARCH(URLHelper.getUserURL(), target));
			
			ResultSet rs = s.executeQuery(DBHelper.SEARCH(URLHelper.getUserURL(), target));
			
			while(rs.next()){
				
				String id = rs.getString(1);
				String password = rs.getString(2);
				String name = rs.getString(3);
				String sex = rs.getString(4);
				int age = rs.getInt(5);
				InstitutionType type = null;
				String city = rs.getString(7);
				UserRole role = null;
				
				UserPO user = new UserPO(id, password, name, sex, age, type, city, role, URLHelper.getUserURL());
				
				result.add(user);				
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
