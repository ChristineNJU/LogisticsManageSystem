package data.Impl.Delete;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import PO.PO;
import State.DeleteState;
import data.Helper.DBHelper.DBHelper.DBHelper;
import data.Service.Delete.DeleteService;

public class DeleteImpl extends UnicastRemoteObject implements DeleteService {

	public DeleteImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public DeleteState delete(PO statistics) throws RemoteException {
		// TODO Auto-generated method stub
		
		if(statistics==null){
			return DeleteState.FAIL;
		}
		
		Connection conn = DBHelper.getConnection();
		try {
			Statement s = conn.createStatement();
			boolean mark = s.execute("DELETE FROM "+statistics.getURL()+" WHERE "+statistics.getPrimaryKey());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("删除PO对象失败");
			
			return DeleteState.FAIL;
		}
		return DeleteState.SUCCESS;
	}

}
