package businesslogic.Impl.Businesslobby;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.EntruckingPO;
import VO.EntruckingVO;
import businesslogic.Service.BusinessLobby.GetNeedEntruckingService;
import businesslogic.SystemLog.SystemLog;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchEntruckingService;

// TODO: Auto-generated Javadoc
/**
 * The Class GetNeedEntruckingImpl.
 * 营业厅获取需要装车的快递的实现
 * 
 */
public class GetNeedEntruckingImpl implements GetNeedEntruckingService{

	/* (non-Javadoc)
	 * @see businesslogic.Service.BusinessLobby.GetNeedEntruckingService#getNeedEntrucking()
	 */
	@Override
	public ArrayList<EntruckingVO> getNeedEntrucking() {
		// TODO Auto-generated method stub
		ArrayList<EntruckingVO> result=new ArrayList<EntruckingVO>();
		try {
			SearchEntruckingService searchEntrucking=(SearchEntruckingService) Naming.lookup(RMIHelper.SEARCH_ENTRUCKING_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("bar_code like '%%'");
			
			ArrayList<EntruckingPO> searchResult=searchEntrucking.searchEntrucking(URLHelper.getInstitutionStorage(SystemLog.getInstitutionId()), requirement);
			
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
