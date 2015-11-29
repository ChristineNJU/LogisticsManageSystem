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

/**
 * 
 * @author 尹子越
 * @version 1.0.0
 */
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
			

			ResultSet rs = s.executeQuery(DBHelper.SEARCH(URLHelper.getBenefitURL(), target));
			
			while(rs.next()){
				double income = rs.getDouble(1);
				double expend = rs.getDouble(2);
				
				String date = rs.getString(3);
				
				BenefitPO benefit = new BenefitPO(income, expend, URLHelper.getBenefitURL(), date);
				
				result.add(benefit);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("从数据库提取BenefitPO对象失败败");
			return result;
		}
		
		return result;
	}

}
