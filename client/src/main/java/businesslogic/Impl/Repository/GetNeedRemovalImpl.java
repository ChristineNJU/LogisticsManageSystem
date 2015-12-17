package businesslogic.Impl.Repository;

import java.rmi.Naming;
import java.util.ArrayList;

import PO.StoragePO;
import VO.RemovalVO;
import businesslogic.Service.Repository.BlWareHouseService;
import businesslogic.Service.Repository.GetNeedRemovalService;
import businesslogic.SystemLog.SystemLog;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchStorageService;

// TODO: Auto-generated Javadoc
/**
 * The Class GetNeedRemovalImpl.
 */
public class GetNeedRemovalImpl implements GetNeedRemovalService {

	/* (non-Javadoc)
	 * @see businesslogic.Service.Repository.GetNeedRemovalService#getNeedRemoval(java.lang.String)
	 */
	@Override
	public ArrayList<RemovalVO> getNeedRemoval() {
		// TODO Auto-generated method stub
		ArrayList<RemovalVO> removal=new ArrayList<RemovalVO>();
//		try{
//			BlWareHouseService storageSearch=(BlWareHouseService) Naming.lookup(RMIHelper.WAREHOUSE_IMPL);
//			ArrayList<String> requirement=new ArrayList<String>();
//			requirement.add("bar_code like '%%'");
//			
//			ArrayList<StoragePO> removalList=storageSearch.searchStorage(URLHelper.getStorageURL(SystemLog.getInstitutionId()), requirement);
//			
//			for(int i=0;i<removalList.size();i++){
//				removal.add(new RemovalVO(removalList.get(i)));
//			}
//		} catch (Exception ex){
//			System.out.println(ex.getMessage());
//			ex.printStackTrace();
//		}
		return removal;
	}

}
