package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.UserPO;

/**
 * 
 * @author 尹子越
 * @version 1.0.0
 */
public interface SearchUserService extends Remote{
	
	/**
	 * 从数据库中搜索UserPO
	 * 
	 * @param requirement 搜索要求
	 * @return UserPO的ArrayList 
	 * @throws RemoteException 如果RMI链接断开
	 */
	public ArrayList<UserPO> searchUser(ArrayList<String> requirement) throws RemoteException;

}
