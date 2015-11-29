package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.InstitutionPO;

/**
 * 
 * @author 尹子越
 * @version 1.0.0
 */
public interface SearchInstitutionInfoService extends Remote{
	
	/**
	 * 从数据库中搜索InstitutionPO
	 * 
	 * @param requirement 搜索要求
	 * @return InstitutionPO的ArrayList 
	 * @exception RemoteException 如果RMI链接断开
	 */
	public ArrayList<InstitutionPO> searchInstitutionInfo(ArrayList<String> requirement) throws RemoteException;

}
