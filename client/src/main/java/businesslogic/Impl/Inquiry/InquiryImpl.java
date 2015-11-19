package businesslogic.Impl.Inquiry;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchLogisticsService;
import PO.LogisticsInfoPO;
import VO.LogisticsInputVO;

public class InquiryImpl {
	
	public LogisticsInputVO getLogistics(String bar_code) {
		LogisticsInputVO  logisticsVO = null ;
		try {
			SearchLogisticsService searchLogistic=(SearchLogisticsService) Naming.lookup(RMIHelper.SEARCH_LOGISTICS_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("bar_code="+bar_code);
			ArrayList<LogisticsInfoPO> result=searchLogistic.searchLogisticsInfo(requirement);
			
			if(result.isEmpty()){
				return null;
			}
			
			else{
				LogisticsInfoPO logisticsPO=result.get(0);
				logisticsVO=new LogisticsInputVO(logisticsPO);
			}
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return logisticsVO;
	}
}
