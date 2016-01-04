package data.Impl.Sundry;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import server.frame.ServerFrame;
import PO.GatheringStoragePO;
import State.AddState;
import State.DeleteState;
import data.Helper.DBHelper.DBHelper.DBHelper;
import data.Service.Sundry.GatheringStorageService;

public class GatheringStorageImpl extends UnicastRemoteObject implements
		GatheringStorageService {

	public GatheringStorageImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<GatheringStoragePO> getGatheringStorage(String DB_URL)
			throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<GatheringStoragePO> result = new ArrayList<GatheringStoragePO>();
		
		if(DB_URL==null){
			return result;
		}
		
		Connection conn = DBHelper.getConnection();
		try {
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery("SELECT * FROM "+DB_URL+" WHERE bar_code like '%%'");
			while(rs.next()){
				
				String bar_code = rs.getString(1);
				double amount = rs.getDouble(2);
				String courier = rs.getString(3);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date d = Calendar.getInstance().getTime();
				try {
					d = sdf.parse(rs.getString(4));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				GatheringStoragePO po = new GatheringStoragePO(bar_code, amount, courier, d,DB_URL);
				
				result.add(po);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			ServerFrame.addInfo(e.getMessage());
			
			return result;
		}
		return result;
	}

	@Override
	public AddState addGatheringStorage(String bar_code, double amount, String courier, String date,
			String DB_URL) throws RemoteException {
		// TODO Auto-generated method stub
		if(bar_code==null){
			return AddState.FAIL;
		}
		
		Connection conn = DBHelper.getConnection();
		try {
			Statement s = conn.createStatement();
			
			System.out.println("INSERT INTO "+DB_URL+" VALUES('"+bar_code+"', "+amount+", '"+courier+"', "
					+ "'"+date+"')");
			
			boolean mark = s.execute("INSERT INTO "+DB_URL+" VALUES('"+bar_code+"', "+amount+", '"+courier+"', "
					+ "'"+date+"')");
		
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			ServerFrame.addInfo(e.getMessage());
			
			return AddState.FAIL;
		}
		return AddState.SUCCESS;
	}

	@Override
	public DeleteState deleteGatheringStorage(String bar_code, String DB_URL)
			throws RemoteException {
		// TODO Auto-generated method stub
		
		if(bar_code==null){
			return DeleteState.FAIL;
		}
		
		Connection conn = DBHelper.getConnection();
		try {
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery("SELECT * FROM "+DB_URL+" WHERE bar_code='"+bar_code+"'");
			if(!rs.next()){
				return DeleteState.FAIL;
			}
			
			boolean mark = s.execute("DELETE FROM "+DB_URL+" WHERE bar_code = '"+bar_code+"'");
			
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			ServerFrame.addInfo(e.getMessage());
			
			return DeleteState.FAIL;
		}
		return DeleteState.SUCCESS;
	}

}
