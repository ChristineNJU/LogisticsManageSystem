package dataservice.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface SearchInstitutionInfoService extends Remote{
	
	public ArrayList<InstitutionInfoPO> searchInstitutionInfo(ArrayList<String> requirement) throws RemoteException;

}
