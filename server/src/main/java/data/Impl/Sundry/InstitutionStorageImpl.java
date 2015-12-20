package data.Impl.Sundry;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import PO.InstitutionStoragePO;
import State.AddState;
import State.DeleteState;
import data.Helper.DBHelper.DBHelper.DBHelper;
import data.Service.Sundry.InstitutionStorageService;

public class InstitutionStorageImpl extends UnicastRemoteObject implements InstitutionStorageService {

	public InstitutionStorageImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<InstitutionStoragePO> getInstitutionStorage(String DB_URL)
			throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<InstitutionStoragePO> result = new ArrayList<InstitutionStoragePO>();
		
		if(DB_URL==null){
			return result;
		}
		
		Connection conn = DBHelper.getConnection();
		try {
			Statement s = conn.createStatement();

			ResultSet rs = s.executeQuery("SELECT * FROM "+DB_URL+" WHERE bar_code like '%%'");
			while(rs.next()){
				
				String bar_code = rs.getString(1);
				boolean isOut = rs.getString(2).equals("true");
				boolean isTransfer = rs.getString(3).equals("true");
				
				InstitutionStoragePO in = new InstitutionStoragePO(bar_code, isOut, isTransfer, DB_URL);
				
				result.add(in);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return result;
		}
		return result;
	}

	@Override
	public AddState addInstitutionStorage(String bar_code, boolean isOut, boolean isTransfer, String DB_URL)
			throws RemoteException {
		// TODO Auto-generated method stub
		
		if(bar_code==null){
			return AddState.FAIL;
		}
		
		Connection conn = DBHelper.getConnection();
		try {
			Statement s = conn.createStatement();
			
			boolean mark = s.execute("INSERT INTO "+DB_URL+" VALUES('"+bar_code+"', '"+isOut+"', '"+isTransfer+"')");
			
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("插入虚拟存储失败");
			return AddState.FAIL;
		}
		return AddState.SUCCESS;
	}

	@Override
	public DeleteState deleteInstitutionStorage(String bar_code, String DB_URL)
			throws RemoteException {
		// TODO Auto-generated method stub
		
		if(bar_code==null){
			return DeleteState.FAIL;
		}
		
		Connection conn = DBHelper.getConnection();
		try {
			Statement s = conn.createStatement();
			
			ResultSet  rs = s.executeQuery("SELECT * FROM "+DB_URL+" WHERE bar_code='"+bar_code+"'");
			if(!rs.next()){
				return DeleteState.FAIL;
			}
			
			boolean mark = s.execute("DELETE FROM "+DB_URL+" WHERE bar_code = '"+bar_code+"'");
			
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return DeleteState.FAIL;
		}
		return DeleteState.SUCCESS;
	}

}
