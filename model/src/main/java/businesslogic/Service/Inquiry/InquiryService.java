package businesslogic.Service.Inquiry;


import VO.LogisticsHistoryVO;


public interface InquiryService {
	
	public LogisticsHistoryVO getLogistics(String bar_code);
}
