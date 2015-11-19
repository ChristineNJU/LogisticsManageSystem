package test.Stub.businesslogic;

import java.rmi.RemoteException;
import java.util.ArrayList;

import test.Stub.data.SearchService_Stub;
import PO.LogisticsInfoPO;
import VO.LogisticsHistoryVO;
import businesslogic.Service.Inquiry.InquiryService;

public class InquiryBlService_Stub implements InquiryService{
	/*-------------------------------------------
	 查询快递信息
	---------------------------------------------*/
	public LogisticsHistoryVO getLogistics(String bar_code){
		System.out.println("Logic_Stub "+"查询成功");
		LogisticsHistoryVO result=new LogisticsHistoryVO(null);
		ArrayList<String> requirement=new ArrayList<String>();
		requirement.add(bar_code);
		try{
			ArrayList<LogisticsInfoPO> lpo=new SearchService_Stub().searchLogisticsInfo(requirement);
			result=new LogisticsHistoryVO(lpo.get(0));
		} catch(RemoteException e){
			e.printStackTrace();
		}
		
		return result;
	}
}
