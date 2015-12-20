package businesslogic.Impl.Businesslobby;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.DeliveryPO;
import PO.InstitutionStoragePO;
import VO.DeliveryVO;
import VO.EntruckingVO;
import businesslogic.Service.BusinessLobby.getNeedDeliveryService;
import businesslogic.SystemLog.SystemLog;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Sundry.InstitutionStorageService;

public class getNeedDeliveryImpl implements getNeedDeliveryService{

	@Override
	public ArrayList<DeliveryVO> getNeedDelivery() {
		// TODO Auto-generated method stub
		ArrayList<DeliveryVO> result = new ArrayList<DeliveryVO>();
		try {
			InstitutionStorageService istorageService = (InstitutionStorageService) Naming.lookup(RMIHelper.INSTITUTION_STORAGE_IMPL);
		
			ArrayList<InstitutionStoragePO> searchResult = istorageService.getInstitutionStorage(URLHelper.getInstitutionStorage(SystemLog.getInstitutionId()));
			
			if(searchResult.isEmpty()){
				System.out.println("not found");
				return result;
			}
			
			else{
				for(int i=0;i<searchResult.size();i++){
					if(!searchResult.get(i).isOut())
						result.add(new DeliveryVO(searchResult.get(i)));
					}
					
			}
		
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
