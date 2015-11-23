package businesslogic.Impl.Businesslobby;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import PO.CarInfoPO;
import State.AddState;
import VO.CarInfoVO;
import businesslogic.Service.BusinessLobby.AddCarService;
import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;

public class AddCarImpl implements AddCarService {

	@Override
	public AddState addCar(CarInfoVO car) {
		// TODO Auto-generated method stub
		AddState result=AddState.FAIL;
		try {
			AddService addService=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
			CarInfoPO requirement=new CarInfoPO(car);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			result=AddState.CONNECTERROR;
			System.out.println("error");
			e.printStackTrace();
		}
		return null;
	}

}
