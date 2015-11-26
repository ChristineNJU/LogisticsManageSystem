package data.Impl.Add;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import PO.PO;
import State.AddState;
import data.Helper.DBHelper.DBHelper.DBHelper;
import data.Service.Add.AddService;

public class AddImpl extends UnicastRemoteObject implements AddService {

	public AddImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public AddState add(PO statistics) throws RemoteException {
		// TODO Auto-generated method stub
		
		if(statistics==null){
			return AddState.FAIL;
		}
		
		Connection conn = DBHelper.getConnection();
		
		try {
			Statement s = conn.createStatement();
			
			boolean mark = s.execute("INSERT INTO "+statistics.getURL()+" VALUES("+statistics.toString()+")");
			
//			if(mark==false){
//				return AddState.FAIL;
//			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("插入PO对象失败");
			
			if(e.getSQLState().equals("23505")){
				
			}else{
				e.printStackTrace();
			}
			return AddState.FAIL;
		}
		
		return AddState.SUCCESS;
	}
	
}
