package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import PO.BenefitPO;
import businesslogic.URLHelper.URLHelper;
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
		ArrayList<BenefitPO> result = new ArrayList<BenefitPO>();
		
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
			
<<<<<<< HEAD
			ResultSet rs = s.executeQuery(DBHelper.SEARCH(table, target));
=======
			ResultSet rs = s.executeQuery(DBHelper.SEARCH(URLHelper.getBenefitURL(), target));
			
			while(rs.next()){
				int number = rs.getInt(1);
				double income = rs.getDouble(2);
				double expend = rs.getDouble(3);
				
				String start_date = rs.getString(4);
				String end_date = rs.getString(5);
				
				BenefitPO benefit = new BenefitPO(number, income, expend, URLHelper.getBenefitURL(), start_date, end_date);
				
				result.add(benefit);
			}
>>>>>>> d26ce7a269704ab2d2f228ed0c0c30a51442303d
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("从数据库提取BenefitPO对象失败败");
			return result;
		}
		
		return result;
	}

}
