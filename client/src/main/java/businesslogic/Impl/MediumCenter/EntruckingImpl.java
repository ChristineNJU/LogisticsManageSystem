package businesslogic.Impl.MediumCenter;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import PO.EntruckingPO;
import State.AddState;
import VO.EntruckingVO;
import businesslogic.Service.MediumCenter.EntruckingService;
import businesslogic.SystemLog.SystemLog;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;
import data.Service.Sundry.InstitutionStorageService;

// TODO: Auto-generated Javadoc
/**
 * The Class EntruckingImpl.
 */
public class EntruckingImpl implements EntruckingService{

	/* (non-Javadoc)
	 * @see businesslogic.Service.MediumCenter.EntruckingService#entrucking(VO.EntruckingVO)
	 */
	@Override
	public AddState entrucking(EntruckingVO entrucking) {
		// TODO Auto-generated method stub
		AddState result=AddState.FAIL;
		try {
			AddService addService=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
			InstitutionStorageService istorageservice=(InstitutionStorageService) Naming.lookup(RMIHelper.INSTITUTION_STORAGE_IMPL);
			result=addService.add(new EntruckingPO(entrucking,SystemLog.getInstitutionId()));
			for(String bar_code:entrucking.getBarCodeList())
				istorageservice.deleteInstitutionStorage(bar_code, URLHelper.getInstitutionStorage(SystemLog.getInstitutionId()));
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			result=AddState.CONNECTERROR;
			System.out.println("error");
			e.printStackTrace();
		}
		return result;
	}

}
