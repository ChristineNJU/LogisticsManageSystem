package businesslogic.Impl.Inquiry;

import businesslogic.Service.Inquiry.InquiryService;
import businesslogic.VO.VO;

public class InquiryController implements InquiryService{
	
	private InquiryImpl inquiryImpl = new InquiryImpl();
	
	@Override
	public VO getLogistics(String bar_code) {
		// TODO Auto-generated method stub
		
		VO vo = inquiryImpl.getLogistics(bar_code);
		
		return null;
	}

}
