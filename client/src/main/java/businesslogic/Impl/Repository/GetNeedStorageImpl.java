package businesslogic.Impl.Repository;

import java.rmi.Naming;
import java.util.ArrayList;

import PO.StoragePO;
import VO.StorageVO;
import businesslogic.Service.Repository.GetNeedStorageService;
import businesslogic.SystemLog.SystemLog;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchStorageService;

// TODO: Auto-generated Javadoc
/**
 * The Class GetNeedStorageImpl.
 */
public class GetNeedStorageImpl implements GetNeedStorageService {

	/* (non-Javadoc)
	 * @see businesslogic.Service.Repository.GetNeedStorageService#getNeedStorage(java.lang.String)
	 */
	@Override
	public ArrayList<StorageVO> getNeedStorage(String destination) {
		// TODO Auto-generated method stub
		ArrayList<StorageVO> storage=new ArrayList<StorageVO>();
		try{
			SearchStorageService storageSearch=(SearchStorageService) Naming.lookup(RMIHelper.SEARCH_STORAGE_IMPL);
			ArrayList<StoragePO> storageList=new ArrayList<StoragePO>();
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("destination='"+destination+"'");
			storageList=storageSearch.searchStorage(URLHelper.getStorageURL(SystemLog.getInstitutionId()), requirement);
			for(int i=0;i<storageList.size();i++){
				storage.add(new StorageVO(storageList.get(i)));
			}
			
		} catch(Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return storage;
	}

}
