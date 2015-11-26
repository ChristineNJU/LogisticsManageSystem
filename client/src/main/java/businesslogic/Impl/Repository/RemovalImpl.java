package businesslogic.Impl.Repository;

import java.rmi.Naming;
import java.util.ArrayList;

import PO.RemovalPO;
import State.AddState;
import VO.RemovalVO;
import businesslogic.Service.Repository.AddRemovalService;
import businesslogic.SystemLog.SystemLog;
import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;

public class RemovalImpl implements AddRemovalService{

	@Override
	public AddState addRemoval(ArrayList<RemovalVO> re) {
		// TODO Auto-generated method stub
		AddState state=AddState.SUCCESS;
		try{
			AddService removalAdd=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
			for(int i=0;i<re.size();i++){
				state=removalAdd.add(new RemovalPO(re.get(i),SystemLog.getInstitutionId()));
			}
		} catch (Exception ex){
			state=AddState.CONNECTERROR;
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return state;
	}

}
