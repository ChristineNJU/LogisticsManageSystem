package businesslogic.Impl.MediumCenter;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.EntruckingPO;
import VO.EntruckingVO;
import businesslogic.Service.MediumCenter.GetNeedEntruckingService;
import businesslogic.SystemLog.SystemLog;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchEntruckingService;

public class GetNeedEntruckingImpl implements GetNeedEntruckingService{

	@Override
	public ArrayList<EntruckingVO> getNeedEntrucking() {
		// TODO Auto-generated method stub
		ArrayList<EntruckingVO> result=new ArrayList<EntruckingVO>();
		try {
			SearchEntruckingService searchEntrucking=(SearchEntruckingService) Naming.lookup(RMIHelper.SEARCH_ENTRUCKING_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("TRANSFER_NUMBER like '%%'");
			
			ArrayList<EntruckingPO> searchResult=searchEntrucking.searchEntrucking(URLHelper.getEntruckingURL(SystemLog.getInstitutionId()), requirement);
			
			if(searchResult.isEmpty()){
				System.out.println("not found");
				return null;
			}
			
			else{
				for(int i=0;i<searchResult.size();i++)
					result.add(new EntruckingVO(searchResult.get(i)));
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return result;
		
	}

}
