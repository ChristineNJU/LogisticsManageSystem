package data.Impl.Search;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import businesslogic.PO.BenefitPO;
import data.Service.Search.SearchBenefitService;

public class SearchBenefitImpl extends UnicastRemoteObject implements SearchBenefitService {

	public SearchBenefitImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<BenefitPO> searchBenefit(ArrayList<String> requirement)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
