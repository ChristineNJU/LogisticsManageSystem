package businesslogic.Impl.MediumCenter;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.RemovalPO;
import PO.TransferPO;
import VO.TransferVO;
import businesslogic.Service.MediumCenter.GetNeedTransferService;
import businesslogic.SystemLog.SystemLog;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchRemovalService;
import data.Service.Search.SearchTransferService;

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
			SearchRemovalService removalSearch=(SearchRemovalService) Naming.lookup(RMIHelper.SEARCH_REMOVAL_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("bar_code like '%%'");
			requirement.add("isout = 'true'");
			requirement.add("istransfer ='false'");
			
			
			ArrayList<RemovalPO> searchResult=removalSearch.searchRemoval(URLHelper.getRemovalURL(SystemLog.getInstitutionId()+"0"), requirement);
			
			if(searchResult.isEmpty()){
				System.out.println("not found");
				return null;
			}
			
			else{
				for(int i=0;i<searchResult.size();i++)
					result.add(new TransferVO(searchResult.get(i)));
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return result;
		
		
	}

}
