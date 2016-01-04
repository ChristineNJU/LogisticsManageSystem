package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import server.frame.ServerFrame;
import PO.CostPO;
import State.CostType;
import State.StateSwitch;
import businesslogic.URLHelper.URLHelper;
import data.Helper.DBHelper.DBHelper.DBHelper;
import data.Service.Search.SearchCostService;

/**
 * 
 * @author 尹子越
 * @version 1.0.0
 */
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

			String target = "";
			for(int i=0;i<requirement.size();i++){
				if(i!=requirement.size()-1){
					target = target + requirement.get(i) + " AND ";
				}else{
					target = target + requirement.get(i);
				}
			}
			
			ResultSet rs = s.executeQuery(DBHelper.SEARCH(URLHelper.getCostURL(), target));
			
			while(rs.next()){
				String cost_date = rs.getString(1);
				double cost_amount = rs.getDouble(2);
				String cost_name = rs.getString(3);
				String account_name = rs.getString(4);
				CostType type = StateSwitch.switchToCostType(rs.getString(5));
				String remark = rs.getString(6);
				boolean isApproved = rs.getString(7).equals("true");
				
				CostPO cost = new CostPO(cost_date, cost_amount, cost_name, account_name, type,
						remark, URLHelper.getCostURL());
				
				cost.setApproved(isApproved);
				
				result.add(cost);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("从数据库提取CostPO对象失败");
			
			ServerFrame.addInfo(e.getMessage());
			
			return result;
		}
		
		return result;
	}

}
