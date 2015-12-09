package businesslogic.Impl.MediumCenter;

import java.rmi.Naming;

import PO.TransferPO;
import State.AddState;
import VO.TransferVO;
import businesslogic.Service.MediumCenter.TransferService;
import businesslogic.SystemLog.SystemLog;
import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;

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
		
			state=transferAdd.add(new TransferPO(transfer, SystemLog.getInstitutionId()));
			
		} catch(Exception ex){
			state=AddState.CONNECTERROR;
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return state;
		
		
	}

}
