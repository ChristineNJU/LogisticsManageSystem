package data.Service.Sundry;

import java.rmi.Remote;
import java.rmi.RemoteException;

import State.InstitutionType;

public interface TableOperationService extends Remote {
	
	public boolean createInstitutionTable(String institution_id, InstitutionType type) throws RemoteException;
	
	public boolean deleteInstitutionTable(String institution_id, InstitutionType type)throws RemoteException;
}
