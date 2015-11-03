package data.Impl.Search;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.PO.GatheringPO;
import data.Service.Search.SearchGatheringService;

public class SearchGatheringImpl implements SearchGatheringService {

	@Override
	public ArrayList<GatheringPO> searchGathering(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
