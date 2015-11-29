package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import PO.InstitutionPO;
import State.InstitutionType;
import State.StateSwitch;
import businesslogic.URLHelper.URLHelper;
import data.Helper.DBHelper.DBHelper.DBHelper;
import data.Service.Search.SearchInstitutionInfoService;

/**
 * 
 * @author 尹子越
 * @version 1.0.0
 */
public class SearchInstitutionInfoImpl extends UnicastRemoteObject implements SearchInstitutionInfoService {

	public SearchInstitutionInfoImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<InstitutionPO> searchInstitutionInfo(
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<InstitutionPO> result = new ArrayList<InstitutionPO>();
		
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
			
			ResultSet rs = s.executeQuery(DBHelper.SEARCH(URLHelper.getInstitutionURL(), target));
			while(rs.next()){
				String institution_name = rs.getString(1);
				InstitutionType institution_type = StateSwitch.switchToInstitutionType(rs.getString(2));
				String city = rs.getString(3);
				String institution_number = rs.getString(4);
				
				InstitutionPO institution = new InstitutionPO(institution_name, institution_type, city,
						institution_number, URLHelper.getInstitutionURL());
				
				result.add(institution);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("从数据库提取InstitutionPO对象失败");
			return result;
		}
		return result;
	}

}
