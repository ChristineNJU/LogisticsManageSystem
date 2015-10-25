package dataservice.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.PO.UserPO;

public interface SearchUserService extends Remote{
	
	public ArrayList<UserPO> searchUser(ArrayList<String> requirement) throws RemoteException;

}
