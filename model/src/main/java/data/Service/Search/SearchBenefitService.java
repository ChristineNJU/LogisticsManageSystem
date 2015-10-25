package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.PO.BenefitPO;

public interface SearchBenefitService extends Remote {
	public ArrayList<BenefitPO> searchBenefit(ArrayList<String> requirement) throws RemoteException;
}
