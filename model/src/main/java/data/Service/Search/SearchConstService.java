package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.PO.ConstPO;

public interface SearchConstService extends Remote{
	
	public ArrayList<ConstPO> searchConst(ArrayList<String> requirement) throws RemoteException;

}
