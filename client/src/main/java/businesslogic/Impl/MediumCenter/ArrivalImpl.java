package businesslogic.Impl.MediumCenter;

import java.rmi.Naming;
import java.util.ArrayList;

import PO.ArrivalPO;
import State.AddState;
import VO.ArrivalVO;
import businesslogic.Service.BusinessLobby.ArrivalService;
import businesslogic.SystemLog.SystemLog;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;
import data.Service.Sundry.InstitutionStorageService;

// TODO: Auto-generated Javadoc
/**
 * The Class ArrivalImpl.
 */
public class ArrivalImpl implements ArrivalService{

	/* (non-Javadoc)
	 * @see businesslogic.Service.BusinessLobby.ArrivalService#arrival(java.util.ArrayList)
	 */
	@Override
	public AddState arrival(ArrayList<ArrivalVO> arrival) {
		// TODO Auto-generated method stub
		AddState state=AddState.SUCCESS;
		try{
			AddService arrivalAdd=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
			InstitutionStorageService istorageService=(InstitutionStorageService) Naming.lookup(RMIHelper.INSTITUTION_STORAGE_IMPL);
			
			for(int i=0;i<arrival.size();i++){
				state=arrivalAdd.add(new ArrivalPO(arrival.get(i), SystemLog.getInstitutionId()));
				istorageService.addInstitutionStorage(arrival.get(i).getBarCode(), false,true, URLHelper.getInstitutionStorage(SystemLog.getInstitutionId()));
			} 
			
		} catch(Exception ex){
			state=AddState.CONNECTERROR;
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return state;
	}

}
