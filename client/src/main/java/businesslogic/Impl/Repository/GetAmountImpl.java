package businesslogic.Impl.Repository;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import data.RMIHelper.RMIHelper;
import data.Service.Sundry.WareHouseService;
import State.StorageArea;
import businesslogic.Service.Repository.GetAmountService;
import businesslogic.SystemLog.SystemLog;
import businesslogic.URLHelper.URLHelper;

public class GetAmountImpl implements GetAmountService {
	
	@Override
	public int getAmount(StorageArea area) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		int result = 0;
		WareHouseService whs = (WareHouseService) Naming.lookup(RMIHelper.WAREHOUSE_IMPL);
		result = whs.getAmount(URLHelper.getWareHouseURL(SystemLog.getInstitutionId()), area);
		return result;
	}

}
