package businesslogic.Impl.Repository;

import java.rmi.Naming;
import java.util.ArrayList;

import PO.RemovalPO;
import PO.StoragePO;
import VO.RemovalVO;
import VO.StorageVO;
import businesslogic.Service.Repository.SeeService;
import businesslogic.SystemLog.SystemLog;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchRemovalService;
import data.Service.Search.SearchStorageService;

public class SeeImpl implements SeeService {

	@Override
	public ArrayList<StorageVO> seeStorage(String time_start, String time_end) {
		ArrayList<StorageVO> storage=new ArrayList<StorageVO>();
		try{
			SearchStorageService storageSearch=(SearchStorageService) Naming.lookup(RMIHelper.SEARCH_STORAGE_IMPL);
			ArrayList<StoragePO> storageList=new ArrayList<StoragePO>();
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("storage_date between '"+time_start+"' and '"+time_end+"'");
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

	@Override
	public ArrayList<RemovalVO> seeRemoval(String time_start, String time_end) {
		// TODO Auto-generated method stub
				ArrayList<RemovalVO> removal=new ArrayList<RemovalVO>();
				try{
					SearchRemovalService removalSearch=(SearchRemovalService) Naming.lookup(RMIHelper.SEARCH_REMOVAL_IMPL);
					ArrayList<String> requirement=new ArrayList<String>();
					requirement.add("removal_date between '"+time_start+"' and '"+time_end+"'");
//					ArrayList<RemovalPO> removalList=removalSearch.searchRemoval(URLHelper.getRemovalURL(SystemLog.getInstitutionId()), requirement);
					ArrayList<RemovalPO> removalList=removalSearch.searchRemoval(URLHelper.getRemovalURL("02500"), requirement);
					for(int i=0;i<removalList.size();i++){
						removal.add(new RemovalVO(removalList.get(i)));
					}
				} catch (Exception ex){
					System.out.println(ex.getMessage());
					ex.printStackTrace();
				}
				return removal;
			}
	

}
