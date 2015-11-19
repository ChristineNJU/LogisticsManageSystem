package businesslogic.Impl.Inquiry;

import VO.LogisticsHistoryVO;

import businesslogic.Service.Inquiry.InquiryService;


public class InquiryController implements InquiryService{
	
	
	@Override
	public LogisticsHistoryVO getLogistics(String bar_code) {
		// TODO Auto-generated method stub
		
		InquiryImpl inquiryImpl = new InquiryImpl();
		LogisticsHistoryVO vo = inquiryImpl.getLogistics(bar_code);
		
		return vo;
	}

}
