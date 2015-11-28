package businesslogic.test.BusinessLobby;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import VO.DriverInfoVO;
import businesslogic.Impl.Businesslobby.BusinessLobbyController;
import junit.framework.TestCase;

public class TestSearchDriver extends TestCase {

	public void testSearchDriver(){
		BusinessLobbyController businessLobbyController=new BusinessLobbyController();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			DriverInfoVO driver=new DriverInfoVO("025000009", "张斯栋", sdf.parse("1996-12-20"), 
					" 320586199612202123", "13040832064", "男", 5);
			assertEquals(driver.getName(),businessLobbyController.searchDriver("025000009").get(0).getName());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
