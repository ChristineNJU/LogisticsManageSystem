package data.Impl.Search;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.PO.CarInfoPO;
import data.Service.Search.SearchCarInfoService;

public class SearchCarInfoImpl implements SearchCarInfoService {

	@Override
	public ArrayList<CarInfoPO> searchCarInfo(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
