package businesslogic.Service.Inquiry;

import java.util.ArrayList;

import businesslogic.VO.LogisticsHistoryVO;
import businesslogic.VO.VO;


public interface InquiryService {
	
	public LogisticsHistoryVO getLogistics(String bar_code);
}
