package businesslogic.Impl.Repository;

import java.rmi.Naming;
import java.util.ArrayList;

import PO.InstitutionPO;
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
import data.Service.Search.SearchInstitutionInfoService;
import data.Service.Sundry.InstitutionStorageService;

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
			InstitutionStorageService istorageservice=(InstitutionStorageService) Naming.lookup(RMIHelper.INSTITUTION_STORAGE_IMPL);
			SearchInstitutionInfoService institutionsearch=(SearchInstitutionInfoService) Naming.lookup(RMIHelper.SEARCH_INSTITUTION_IMPL);
			for(int i=0;i<re.size();i++){
				RemovalPO po = new RemovalPO(re.get(i),SystemLog.getInstitutionId());
				state=removalAdd.add(po);
				WareHousePO wareHouse = new WareHousePO(re.get(i), URLHelper.getWareHouseURL(SystemLog.getInstitutionId()));
				delete.delete(wareHouse);
//				state=removalAdd.add(new RemovalPO(re.get(i),"02500"));
				
				
				boolean isTransfer=true;
				ArrayList<String> requirement=new ArrayList<String>();
				requirement.add("institution_number = '"+SystemLog.getInstitutionId().substring(0,4)+"'");
				System.out.println("requirement"+requirement.get(i));
				ArrayList<InstitutionPO> temp=institutionsearch.searchInstitutionInfo(requirement);
				System.out.println("temp"+temp.size());
				if(temp.get(0).getCity()==re.get(i).getDestination())
					isTransfer=false;
				istorageservice.addInstitutionStorage(re.get(i).getBarCode(), true, isTransfer, URLHelper.getInstitutionStorage(temp.get(0).getInstitutionNumber()));
		
			}
		} catch (Exception ex){
			state=AddState.CONNECTERROR;
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return state;
	}

}
