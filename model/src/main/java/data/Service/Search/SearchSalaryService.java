package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.PO.SalaryPO;

public interface SearchSalaryService extends Remote {
	public ArrayList<SalaryPO> searchSalary(ArrayList<String> requirement) throws RemoteException;
}
