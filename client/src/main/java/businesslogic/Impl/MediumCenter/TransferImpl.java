package businesslogic.Impl.MediumCenter;

import java.rmi.Naming;

import PO.TransferPO;
import State.AddState;
import VO.TransferVO;
import businesslogic.Service.MediumCenter.TransferService;
import businesslogic.SystemLog.SystemLog;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;
import data.Service.Sundry.InstitutionStorageService;

// TODO: Auto-generated Javadoc
/**
 * The Class TransferImpl.
 */
public class TransferImpl implements TransferService{

	/* (non-Javadoc)
	 * @see businesslogic.Service.MediumCenter.TransferService#transfer(VO.TransferVO)
	 */
	@Override
	public AddState transfer(TransferVO transfer) {
		// TODO Auto-generated method stub
		AddState state=AddState.SUCCESS;
		try{
			AddService transferAdd=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
			InstitutionStorageService istorageservice=(InstitutionStorageService) Naming.lookup(RMIHelper.INSTITUTION_STORAGE_IMPL);
			state=transferAdd.add(new TransferPO(transfer, SystemLog.getInstitutionId()));
			for(String bar_code:transfer.getItemId())
				istorageservice.deleteInstitutionStorage(bar_code, URLHelper.getInstitutionStorage(SystemLog.getInstitutionId()));
		} catch(Exception ex){
			state=AddState.CONNECTERROR;
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return state;
		
		
	}

}
