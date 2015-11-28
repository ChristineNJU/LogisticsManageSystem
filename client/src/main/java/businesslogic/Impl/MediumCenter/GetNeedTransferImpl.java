package businesslogic.Impl.MediumCenter;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.TransferPO;
import VO.TransferVO;
import businesslogic.Service.MediumCenter.GetNeedTransferService;
import businesslogic.SystemLog.SystemLog;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchTransferService;

public class GetNeedTransferImpl implements GetNeedTransferService{

	@Override
	public ArrayList<TransferVO> getNeedTransfer() {
		// TODO Auto-generated method stub
		ArrayList<TransferVO> result=new ArrayList<TransferVO>();
		try {
			SearchTransferService searchTransfer=(SearchTransferService) Naming.lookup(RMIHelper.SEARCH_GATHERING_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("TRANSFER_NUMBER like '%%'");
			
			ArrayList<TransferPO> searchResult=searchTransfer.searchTransfer(URLHelper.getTransferURL(SystemLog.getInstitutionId()), requirement);
			
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
