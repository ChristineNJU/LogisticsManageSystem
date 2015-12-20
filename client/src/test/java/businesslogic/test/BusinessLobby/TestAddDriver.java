package businesslogic.test.BusinessLobby;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import junit.framework.TestCase;
import State.AddState;
import VO.DriverInfoVO;
import businesslogic.Impl.Businesslobby.BusinessLobbyController;

public class TestAddDriver extends TestCase {

	public void testAddDriver(){
		BusinessLobbyController businessLobbyController=new BusinessLobbyController();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			DriverInfoVO driver=new DriverInfoVO("025000009", "张斯栋", sdf.parse("1996-12-20"), 
				" 320586199612202123", "13040832064", "男", 5);
			//System.out.println(new DriverInfoPO(driver).toString());
			assertEquals(AddState.SUCCESS,businessLobbyController.AddDriver(driver));
			assertEquals(AddState.FAIL,businessLobbyController.AddDriver(driver));
			businessLobbyController.deleteDriver(driver);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
