package data.Impl.Search;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.PO.DriverInfoPO;
import data.Service.Search.SearchDriverInfoService;

public class SearchDriverInfoImpl implements SearchDriverInfoService {

	@Override
	public ArrayList<DriverInfoPO> searchDriverInfo(String DB_URL,
			ArrayList<String> requirement) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
