package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import PO.SalaryPO;
import data.Service.Search.SearchSalaryService;

public class SearchSalaryImpl extends UnicastRemoteObject implements SearchSalaryService {

	public SearchSalaryImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<SalaryPO> searchSalary(ArrayList<String> requirement)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
