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
	public ArrayList<LogisticsHistoryVO> getLogistics(String bar_code){
		System.out.println("Logic_Stub "+"查询成功");
		ArrayList<LogisticsHistoryVO> list = new ArrayList<LogisticsHistoryVO>();
		ArrayList<String> requirement=new ArrayList<String>();
		requirement.add(bar_code);
		try{
			ArrayList<LogisticsInfoPO> lpo=new SearchService_Stub().searchLogisticsInfo(requirement);
			for(int i=0;i<lpo.size();i++){
				LogisticsHistoryVO log=new LogisticsHistoryVO(lpo.get(i).getBarCode(),lpo.get(i).getHistory());
				list.add(log);
			}
		} catch(RemoteException e){
			e.printStackTrace();
		}
		
		return list;
	}
}
