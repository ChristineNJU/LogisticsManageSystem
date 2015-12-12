package data.Impl.Sundry;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import State.AddState;
import State.DeleteState;
import data.Helper.DBHelper.DBHelper.DBHelper;
import data.Service.Sundry.InstitutionStorageService;

public class InstitutionStorageImpl implements InstitutionStorageService {

	@Override
	public ArrayList<String> getInstitutionStorage(String DB_URL)
			throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<String> result = new ArrayList<String>();
		
		if(DB_URL==null){
			return result;
		}
		
		Connection conn = DBHelper.getConnection();
		try {
			Statement s = conn.createStatement();

			ResultSet rs = s.executeQuery(DB_URL);
			while(rs.next()){
				result.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return result;
		}
		return result;
	}

	@Override
	public AddState addInstitutionStorage(String bar_code, String DB_URL)
			throws RemoteException {
		// TODO Auto-generated method stub
		
		if(bar_code==null){
			return AddState.FAIL;
		}
		
		Connection conn = DBHelper.getConnection();
		try {
			Statement s = conn.createStatement();
			
			boolean mark = s.execute("INSERT INTO "+DB_URL+" VALUES("+bar_code+")");
			
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
			
			ResultSet  rs = s.executeQuery(DBHelper.SEARCH(bar_code, DB_URL));
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
