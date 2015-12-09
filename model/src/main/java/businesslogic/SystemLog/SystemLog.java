package businesslogic.SystemLog;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.crypto.Data;

import PO.LogPO;
import State.AddState;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;

// TODO: Auto-generated Javadoc
/**
 * 保存系统日志信息.
 * 在client模块的businesslogic.Impl中的所有Controller中使用,目的是在一次操作过后完成对系统日志的更新
 * 
 * 
 * @author 尹子越
 * @version 1.0.0
 */
public class SystemLog {
	
	/** The operator_name. */
	private static String operator_name = "";
	
	/** The operator_id. */
	private static String operator_id = "025000000";
	
	/** The operator_institution_id. */
	private static String operator_institution_id = "02500";
	
	/** The add log. */
	private static AddService addLog = null;
	
	/** The sdf. */
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * Sets the operator name.
	 *
	 * @param name the new operator name
	 */
	public static void setOperatorName(String name) {
		operator_name = name;
	} 
	
	/**
	 * Sets the operatior id.
	 *
	 * @param id the new operatior id
	 */
	public static void setOperatiorID(String id) {
		operator_id = id;
	}
	
	/**
	 * Sets the institution id.
	 *
	 * @param id the new institution id
	 */
	public static void setInstitutionId(String id) {
		operator_institution_id = id;
	}
	
	/**
	 * Gets the operator id.
	 *
	 * @return the operator id
	 */
	public static String getOperatorID() {
		return operator_id;
	}
	
	/**
	 * Gets the institution id.
	 *
	 * @return the institution id
	 */
	public static String getInstitutionId() {

//		return "02500";
		return operator_institution_id;
	}
	
	/**
	 * Adds the log.
	 *
	 * @param operation the operation
	 * @see AddService#add(PO.PO)
	 */
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
