package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.InstitutionPO;

public interface SearchInstitutionInfoService extends Remote{
	
	public ArrayList<InstitutionPO> searchInstitutionInfo(ArrayList<String> requirement) throws RemoteException;

}
