package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.SalaryPO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SearchSalaryService.
 *
 * @author 尹子越
 * @version 1.0.0
 */
public interface SearchSalaryService extends Remote {
	
	/**
	 * 从数据库中搜索SalaryPO.
	 *
	 * @param requirement 搜索要求
	 * @return SalaryPO的ArrayList
	 * @exception RemoteException 如果RMI链接断开
	 */
	public ArrayList<SalaryPO> searchSalary(ArrayList<String> requirement) throws RemoteException;
}
