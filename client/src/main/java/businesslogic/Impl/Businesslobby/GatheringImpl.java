package businesslogic.Impl.Businesslobby;

import java.rmi.Naming;

import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;
import PO.EntruckingPO;
import PO.GatheringPO;
import State.AddState;
import VO.GatheringVO;
import businesslogic.Service.BusinessLobby.GatheringService;
import businesslogic.SystemLog.SystemLog;

public class GatheringImpl implements GatheringService{

	@Override
	public AddState gathering(GatheringVO gathering) {
		// TODO Auto-generated method stub
		AddState state=AddState.SUCCESS;
		try{
			AddService gatheringAdd=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
		
			state=gatheringAdd.add(new GatheringPO(gathering, SystemLog.getInstitutionId()));
			
		} catch(Exception ex){
			state=AddState.CONNECTERROR;
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return state;
	}

}
