package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import PO.SalaryPO;
import State.SalaryType;
import State.StateSwitch;
import State.UserRole;
import businesslogic.URLHelper.URLHelper;
import data.Helper.DBHelper.DBHelper.DBHelper;
import data.Service.Search.SearchSalaryService;

/**
 * 
 * @author 尹子越
 * @version 1.0.0
 */
public class SearchSalaryImpl extends UnicastRemoteObject implements SearchSalaryService {

	public SearchSalaryImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * 从数据库中搜索SalaryPO
	 * 
	 * @param requirement 搜索要求
	 * @return SalaryPO的ArrayList 
	 */
	public ArrayList<SalaryPO> searchSalary(ArrayList<String> requirement)
			throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<SalaryPO> result = new ArrayList<SalaryPO>();
		
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
			
			ResultSet rs = s.executeQuery(DBHelper.SEARCH(URLHelper.getSalaryURL(), target));
			while(rs.next()){
				UserRole staff = StateSwitch.switchToUserRole(rs.getString(1));
				double salary = rs.getDouble(2);
				SalaryType type = StateSwitch.switchToSalaryType(rs.getString(3));
				
				SalaryPO sa = new SalaryPO(staff, salary, type, URLHelper.getSalaryURL());
				
				result.add(sa);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("从数据库提取SalaryPO对象失败");
			return result;
		}
		return result;
	}

}
