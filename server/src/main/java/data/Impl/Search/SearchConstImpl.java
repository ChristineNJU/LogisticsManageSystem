package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import PO.ConstPO;
import businesslogic.URLHelper.URLHelper;
import data.Helper.DBHelper.DBHelper.DBHelper;
import data.Service.Search.SearchConstService;

public class SearchConstImpl extends UnicastRemoteObject implements SearchConstService {

	public SearchConstImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<ConstPO> searchConst(ArrayList<String> requirement)
			throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<ConstPO> result = new ArrayList<ConstPO>();
		
		if(requirement.isEmpty()||requirement==null){
			return result;
		}
		
		Connection conn = DBHelper.getConnection();
		try {
			Statement s = conn.createStatement();
			
			String target = requirement.get(0);
			
			ResultSet rs = s.executeQuery(DBHelper.SEARCH(URLHelper.getConstURL(), target));
			
			while(rs.next()){
				
				String name = rs.getString(1);
				double value = rs.getDouble(2);
				
				ConstPO co = new ConstPO(name, value, URLHelper.getConstURL());
				
				result.add(co);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("从数据库提取ConstPO对象失败");
			return result;
		}
		
		return result;
	}

}
