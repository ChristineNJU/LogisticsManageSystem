package businesslogic.test.Inquiry;

import junit.framework.TestCase;
import businesslogic.Impl.Inquiry.InquiryController;

public class TestGetLogistics extends TestCase {
	
	public void TestGetLogistics() {
		
		InquiryController inquiry = new InquiryController();
		
		assertEquals(null, inquiry.getLogistics("02395023"));	
	}
}
