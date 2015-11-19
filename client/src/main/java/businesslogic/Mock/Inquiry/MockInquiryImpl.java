package businesslogic.Mock.Inquiry;

import VO.LogisticsHistoryVO;
import businesslogic.Impl.Inquiry.InquiryImpl;

public class MockInquiryImpl extends InquiryImpl{
	
	public LogisticsHistoryVO getLogistics(String bar_code) {
		
		return new LogisticsHistoryVO(null);
	}
}
