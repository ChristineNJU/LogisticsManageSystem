package businesslogic.Impl.Repository;

import java.rmi.Naming;
import java.util.ArrayList;

import PO.RemovalPO;
import PO.WareHousePO;
import State.AddState;
import VO.RemovalVO;
import businesslogic.Service.Repository.AddRemovalService;
import businesslogic.SystemLog.SystemLog;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;
import data.Service.Delete.DeleteService;

// TODO: Auto-generated Javadoc
/**
 * The Class RemovalImpl.
 */
public class RemovalImpl implements AddRemovalService{

	/* (non-Javadoc)
	 * @see businesslogic.Service.Repository.AddRemovalService#addRemoval(java.util.ArrayList)
	 */
	@Override
	public AddState addRemoval(ArrayList<RemovalVO> re) {
		// TODO Auto-generated method stub
		AddState state=AddState.SUCCESS;
		try{
			AddService removalAdd=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
			DeleteService delete = (DeleteService) Naming.lookup(RMIHelper.DELETE_IMPL);
			for(int i=0;i<re.size();i++){
				RemovalPO po = new RemovalPO(re.get(i),SystemLog.getInstitutionId());
				state=removalAdd.add(po);
				WareHousePO wareHouse = new WareHousePO(re.get(i), URLHelper.getWareHouseURL(SystemLog.getInstitutionId()));
				delete.delete(wareHouse);
//				state=removalAdd.add(new RemovalPO(re.get(i),"02500"));
			}
		} catch (Exception ex){
			state=AddState.CONNECTERROR;
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return state;
	}

}
