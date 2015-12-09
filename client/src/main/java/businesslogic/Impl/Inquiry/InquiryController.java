package businesslogic.Impl.Inquiry;

import VO.LogisticsHistoryVO;
import businesslogic.Service.Inquiry.InquiryService;


// TODO: Auto-generated Javadoc
/**
 * The Class InquiryController.
 */
public class InquiryController implements InquiryService{
	
	
	/* (non-Javadoc)
	 * @see businesslogic.Service.Inquiry.InquiryService#getLogistics(java.lang.String)
	 */
	@Override
	public LogisticsHistoryVO getLogistics(String bar_code) {
		// TODO Auto-generated method stub
		
		InquiryImpl inquiryImpl = new InquiryImpl();
		LogisticsHistoryVO vo = inquiryImpl.getLogistics(bar_code);
		
		return vo;
	}

}
