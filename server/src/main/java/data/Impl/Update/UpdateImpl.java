package data.Impl.Update;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import PO.PO;
import State.UpdateState;
import data.Helper.DBHelper.DBHelper.DBHelper;
import data.Service.Update.UpdateService;

public class UpdateImpl extends UnicastRemoteObject implements UpdateService {

	public UpdateImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public UpdateState update(PO statistics, String field, String value)
			throws RemoteException {
		// TODO Auto-generated method stub
		
		if(statistics==null){
			System.out.println("更新传入空数据");
			return UpdateState.NOTFOUND;
		}
		
		Connection conn = DBHelper.getConnection();
		try {
			Statement s = conn.createStatement();
			boolean mark;
			
			mark = s.execute("DELETE FROM "+statistics.getURL()+" WHERE "+statistics.getPrimaryKey());
			conn.commit();
			
			mark = s.execute("INSERT INTO "+statistics.getURL()+" VALUES("+statistics.toString()+")");
			conn.commit();
//			if(mark==false){
//				return UpdateState.NOTFOUND;
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("更新PO对象失败");
			
			if(e.getSQLState().equals("23505")){
				System.out.println("PO对象已经存在于数据库中");
			}
			
			return UpdateState.NOTFOUND;
		} 
		return UpdateState.SUCCESS;
	}

}
