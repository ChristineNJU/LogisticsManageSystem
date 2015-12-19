package businesslogic.Impl.Businesslobby;

import java.rmi.Naming;

import PO.EntruckingPO;
import State.AddState;
import VO.EntruckingVO;
import businesslogic.Service.BusinessLobby.EntruckingService;
import businesslogic.SystemLog.SystemLog;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;
import data.Service.Delete.DeleteService;
import data.Service.Sundry.InstitutionStorageService;

// TODO: Auto-generated Javadoc
/**
 * The Class EntruckingImpl.
 * 营业厅装车单的实现
 * 
 * @see AddService
 */
public class EntruckingImpl implements EntruckingService{

	/* (non-Javadoc)
	 * @see businesslogic.Service.BusinessLobby.EntruckingService#entrucking(VO.EntruckingVO)
	 */
	@Override
	public AddState entrucking(EntruckingVO entrucking) {
		// TODO Auto-generated method stub
		AddState state=AddState.SUCCESS;
		try{
			AddService entruckingAdd=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
		
			state=entruckingAdd.add(new EntruckingPO(entrucking, SystemLog.getInstitutionId()));
			
			InstitutionStorageService institutionService=(InstitutionStorageService) Naming.lookup(RMIHelper.INSTITUTION_STORAGE_IMPL);
			for(int i=0;i<entrucking.getBarCodeList().size();i++){
				institutionService.deleteInstitutionStorage(entrucking.getBarCodeList().get(i),URLHelper.getInstitutionStorage(SystemLog.getInstitutionId()));
			}
			
		} catch(Exception ex){
			state=AddState.CONNECTERROR;
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return state;
		
	}

}
