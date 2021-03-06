package businesslogic.Impl.MediumCenter;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.InstitutionStoragePO;
import PO.RemovalPO;
import PO.TransferPO;
import VO.TransferVO;
import businesslogic.Service.MediumCenter.GetNeedTransferService;
import businesslogic.SystemLog.SystemLog;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchRemovalService;
import data.Service.Search.SearchTransferService;
import data.Service.Sundry.InstitutionStorageService;

// TODO: Auto-generated Javadoc
/**
 * The Class GetNeedTransferImpl.
 */
public class GetNeedTransferImpl implements GetNeedTransferService{

	/* (non-Javadoc)
	 * @see businesslogic.Service.MediumCenter.GetNeedTransferService#getNeedTransfer()
	 */
	@Override
	public ArrayList<TransferVO> getNeedTransfer() {
		// TODO Auto-generated method stub
		ArrayList<TransferVO> result=new ArrayList<TransferVO>();
		try {
			InstitutionStorageService istorageservice=(InstitutionStorageService) Naming.lookup(RMIHelper.INSTITUTION_STORAGE_IMPL);
			
			ArrayList<InstitutionStoragePO> searchResult=istorageservice.getInstitutionStorage(URLHelper.getInstitutionStorage(SystemLog.getInstitutionId()));
			
			if(searchResult.isEmpty()){
				System.out.println("not found");
				return result;
			}
			
			else{
				for(int i=0;i<searchResult.size();i++)
					if(searchResult.get(i).isOut()&&!searchResult.get(i).isTransfer()){
						result.add(new TransferVO(searchResult.get(i)));
					}
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return result;
		
		
	}

}
