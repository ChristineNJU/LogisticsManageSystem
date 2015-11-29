package data.Service.Sundry;

import java.rmi.Remote;
import java.rmi.RemoteException;

import State.InstitutionType;

/**
 * 
 * @author 尹子越
 * @version 1.0.0
 */
public interface TableOperationService extends Remote {
	
	/**
	 * 在数据库中创建相应表
	 * 
	 * @param institution_id 机构ID
	 * @param type 机构类型
	 * @return 创建是否成功
	 * @throws RemoteException 如果RMI链接断开 
	 */
	public boolean createInstitutionTable(String institution_id, InstitutionType type) throws RemoteException;
	
	/**
	 * 在数据库中删除相应表
	 * 
	 * @param institution_id 机构ID
	 * @param type 机构类型
	 * @return 删除是否成功
	 * @throws RemoteException 如果RMI链接断开 
	 */
	public boolean deleteInstitutionTable(String institution_id, InstitutionType type)throws RemoteException;
}
