package businesslogic.Impl.MediumCenter;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;
import State.AddState;
import VO.EntruckingVO;
import businesslogic.Service.MediumCenter.EntruckingService;

public class EntruckingImpl implements EntruckingService{

	@Override
	public AddState entrucking(EntruckingVO entrucking) {
		// TODO Auto-generated method stub
		AddState result=AddState.FAIL;
		try {
			AddService addService=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			result=AddState.CONNECTERROR;
			System.out.println("error");
			e.printStackTrace();
		}
		return result;
	}

}
