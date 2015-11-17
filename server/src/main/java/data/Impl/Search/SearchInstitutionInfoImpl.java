package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import PO.InstitutionPO;
import data.Service.Search.SearchInstitutionInfoService;

public class SearchInstitutionInfoImpl extends UnicastRemoteObject implements SearchInstitutionInfoService {

	public SearchInstitutionInfoImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<InstitutionPO> searchInstitutionInfo(
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
