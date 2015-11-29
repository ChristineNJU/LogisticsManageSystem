package businesslogic.Impl.Businesslobby;

import java.rmi.Naming;

import PO.EntruckingPO;
import State.AddState;
import VO.EntruckingVO;
import businesslogic.Service.BusinessLobby.EntruckingService;
import businesslogic.SystemLog.SystemLog;
import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;

public class EntruckingImpl implements EntruckingService{

	@Override
	public AddState entrucking(EntruckingVO entrucking) {
		// TODO Auto-generated method stub
		AddState state=AddState.SUCCESS;
		try{
			AddService entruckingAdd=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
		
			state=entruckingAdd.add(new EntruckingPO(entrucking, SystemLog.getInstitutionId()));
			
		} catch(Exception ex){
			state=AddState.CONNECTERROR;
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return state;
		
	}

}
