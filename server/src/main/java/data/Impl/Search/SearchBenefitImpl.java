package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import PO.BenefitPO;
import data.Helper.DBHelper.DBHelper.DBHelper;
import data.Service.Search.SearchBenefitService;

public class SearchBenefitImpl extends UnicastRemoteObject implements SearchBenefitService {

	public SearchBenefitImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<BenefitPO> searchBenefit(ArrayList<String> requirement)
			throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<BenefitPO> benefit = new ArrayList<BenefitPO>();
		
		if(requirement.isEmpty()||requirement==null){
			return benefit;
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
			
			ResultSet rs = s.executeQuery(DBHelper.SEARCH(table, target))
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
