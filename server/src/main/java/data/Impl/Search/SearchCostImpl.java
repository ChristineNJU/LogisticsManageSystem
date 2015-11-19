package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import businesslogic.URLHelper.URLHelper;
import PO.CostPO;
import data.Helper.DBHelper.DBHelper.DBHelper;
import data.Service.Search.SearchCostService;

public class SearchCostImpl extends UnicastRemoteObject implements SearchCostService {

	public SearchCostImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<CostPO> searchCost(ArrayList<String> requirement)
			throws RemoteException {
		// TODO Auto-generated method stub
		
		ArrayList<CostPO> result = new ArrayList<CostPO>();
		
		if(requirement.isEmpty()){
			return result;
		}
		
		Connection conn = DBHelper.getConnection();
		
		try {
			Statement s = conn.createStatement();

			String target = requirement.get(0);
			
			ResultSet rs = s.executeQuery(DBHelper.SEARCH(URLHelper.getCostURL(), target));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}

}
