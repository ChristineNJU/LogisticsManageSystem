package data.Service.Sundry;

import java.awt.Font;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.InstitutionStoragePO;
import State.AddState;
import State.DeleteState;

// TODO: Auto-generated Javadoc
/**
 * The Interface InstitutionStorageService.
 *
 * @author 尹子越
 * @version 1.0.0
 */
public interface InstitutionStorageService extends Remote {

	/**
	 * 获取当前机构临时存储的快递.
	 *
	 * @param DB_URL 数据库连接
	 * @return 当前临时存储的快递 ArrayList<String>类型
	 * @throws RemoteException the remote exception
	 */
	public ArrayList<InstitutionStoragePO> getInstitutionStorage(String DB_URL) throws RemoteException;
	
	/**
	 * 添加当前机构临时存储的快递
	 *
	 * @param bar_code 快递条形码
	 * @param DB_URL the 数据库连接
	 * @return the adds 添加状态Font.BOLD
	 * @throws RemoteException the remote exception
	 */
	public AddState addInstitutionStorage(String bar_code, boolean isOut, String DB_URL) throws RemoteException;
	
	/**
	 * 删除当前机构临时存储的快递
	 *
	 * @param bar_code the bar_code
	 * @param DB_URL the db url
	 * @return the delete state
	 * @throws RemoteException the remote exception
	 */
	public DeleteState deleteInstitutionStorage(String bar_code, String DB_URL) throws RemoteException;
}
