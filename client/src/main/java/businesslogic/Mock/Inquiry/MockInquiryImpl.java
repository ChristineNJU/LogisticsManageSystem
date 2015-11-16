package businesslogic.Mock.Inquiry;

import businesslogic.Impl.Inquiry.InquiryImpl;
import businesslogic.VO.LogisticsInputVO;

public class MockInquiryImpl extends InquiryImpl{
	
	public LogisticsInputVO getLogistics(String bar_code) {
		
		return new LogisticsInputVO(null, null, null, null, null, null, null, null, null, null, 
				null, 1, 2, 2, null, null, null, 12, null, null, null, null, null, null);
	}
}
