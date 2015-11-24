package businesslogic.SystemLog;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;

public class SystemLog {
	
	private static String operator_name = "";
	private static String operator_id = "";
	private static String operator_institution_id = "";
	
	public static void setOperatorName(String name) {
		operator_name = name;
	} 
	
	public static void setOperatiorID(String id) {
		operator_id = id;
	}
	
	public static void setInstitutionId(String id) {
		operator_id = id;
	}
	
	public static String getInstitutionId() {
		return operator_institution_id;
	}
	
	public static void addLog(String operation) {
		AddService addLog = null;
		
		try {
			addLog = (AddService) Naming.lookup(RMIHelper.ADD_IMPL);
			System.out.println("远程AddImpl接口绑定成功");
			
			Date time = new Date();
			
//			LogPO log = new LogPO(, operation, operator, DB_URL);
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			System.out.println("远程AddImpl接口绑定失败");
		}
	}
}
