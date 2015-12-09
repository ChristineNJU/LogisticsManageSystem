package businesslogic.Impl.Businesslobby;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import PO.DeliveryPO;
import State.AddState;
import VO.DeliveryVO;
import businesslogic.Service.BusinessLobby.DeliveryService;
import businesslogic.SystemLog.SystemLog;
import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;

// TODO: Auto-generated Javadoc
/**
 * The Class DeliveryImpl.
 */
public class DeliveryImpl implements DeliveryService{

	/* (non-Javadoc)
	 * @see businesslogic.Service.BusinessLobby.DeliveryService#delivery(VO.DeliveryVO)
	 */
	@Override
	public AddState delivery(DeliveryVO delivery) {
		// TODO Auto-generated method stub
		AddState result=AddState.FAIL;
		try {
			AddService addService=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
			DeliveryPO requirement=new DeliveryPO(delivery,SystemLog.getInstitutionId());
			result=addService.add(requirement);
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result=AddState.CONNECTERROR;
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	

	
}
