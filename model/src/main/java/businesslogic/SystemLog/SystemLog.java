package businesslogic.SystemLog;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import PO.LogPO;
import State.AddState;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;

public class SystemLog {
	
	private static String operator_name = "";
	private static String operator_id = "025000000";
	private static String operator_institution_id = "02500";
	
	private static AddService addLog = null;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static void setOperatorName(String name) {
		operator_name = name;
	} 
	
	public static void setOperatiorID(String id) {
		operator_id = id;
	}
	
	public static void setInstitutionId(String id) {
		operator_id = id;
	}
	
	public static String getOperatorID() {
		return operator_id;
	}
	
	public static String getInstitutionId() {

//		return "02500";
		return operator_institution_id;
	}
	
	public static void addLog(String operation) {
		
		LogPO log;
		AddState state;
		
		try {
			addLog = (AddService) Naming.lookup(RMIHelper.ADD_IMPL);
			System.out.println("远程AddImpl接口绑定成功");
			
			Date time = new Date();
			
			log = new LogPO(time, operation, operator_id, URLHelper.getLogURL());
			
			state = addLog.add(log);
//			LogPO log = new LogPO(, operation, operator, DB_URL);
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			System.out.println("远程AddImpl接口绑定失败");
			state = AddState.CONNECTERROR;
		}
		
		System.out.println("添加系统日志:"+state);
	}
}
