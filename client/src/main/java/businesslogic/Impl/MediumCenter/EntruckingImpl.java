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
import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;

public class EntruckingImpl implements EntruckingService{

	@Override
	public AddState entrucking(EntruckingVO entrucking) {
		// TODO Auto-generated method stub
		AddState result=AddState.FAIL;
		try {
			AddService addService=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
			result=addService.add(new EntruckingPO(entrucking,SystemLog.getInstitutionId()));
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			result=AddState.CONNECTERROR;
			System.out.println("error");
			e.printStackTrace();
		}
		return result;
	}

}
