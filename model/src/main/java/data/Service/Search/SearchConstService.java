package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.ConstPO;

/**
 * 
 * @author 尹子越
 * @version 1.0.0
 */
public interface SearchConstService extends Remote{
	
	/**
	 * 从数据库中搜索ConstPO
	 * 
	 * @param requirement 搜索要求
	 * @return ConstPO的ArrayList 
	 */
	public ArrayList<ConstPO> searchConst(ArrayList<String> requirement) throws RemoteException;

}
