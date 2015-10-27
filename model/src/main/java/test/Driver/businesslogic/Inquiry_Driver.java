package test.Driver.businesslogic;

import test.Stub.businesslogic.InquiryBlService_Stub;
import businesslogic.VO.LogisticsHistoryVO;

public class Inquiry_Driver {
	public void drive(InquiryBlService_Stub inquiry){
		LogisticsHistoryVO logistics=new LogisticsHistoryVO(null, null);
		logistics=(LogisticsHistoryVO) inquiry.getLogistics(null);
		System.out.println(logistics.getBarCode());
		System.out.println(logistics.getHistory());
		
	}
	
}
