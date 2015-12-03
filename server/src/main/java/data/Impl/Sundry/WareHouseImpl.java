package data.Impl.Sundry;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import PO.WareHousePO;
import State.StateSwitch;
import State.StorageArea;
import data.Helper.DBHelper.DBHelper.DBHelper;
import data.Service.Sundry.WareHouseService;

/**
 * 
 * @author 尹子越
 * @version 1.0.0
 */
public class WareHouseImpl extends UnicastRemoteObject implements WareHouseService {

	public WareHouseImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getAmount(String DB_URL, StorageArea area) {
		// TODO Auto-generated method stub
		int result = 0;
		
		if(DB_URL==null){
			return result;
		}
		
		Connection conn = DBHelper.getConnection();
		try {
			Statement s = conn.createStatement();
			
			String a = StateSwitch.switchToStr(area);
			
			ResultSet rs = s.executeQuery("SELECT count(*) FROM "+DB_URL+" WHERE area_code = '"+a+"'");
			rs.next();
			
			result = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("计数失败");
			return result;
		}
		return result;
	}

	@Override
	public ArrayList<WareHousePO> searchWareHouse(String DB_URL) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<WareHousePO> result = new ArrayList<WareHousePO>();
		
		Connection conn = DBHelper.getConnection();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM "+DB_URL);
			while(rs.next()){
				String bar_code = rs.getString(1);
				String destination = rs.getString(2);
				StorageArea area_code = StateSwitch.switchToStorageArea(rs.getString(3));
				int row = rs.getInt(4);
				int shelf = rs.getInt(5);
				int position = rs.getInt(6);
				
				WareHousePO warehouse = new WareHousePO(bar_code, destination, area_code, row, shelf, position, DB_URL);
				
				result.add(warehouse);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("从数据库提取WareHousePO对象失败");
			return result;
		}
		return result;
	}

}
