package businesslogic.test.BusinessLobby;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import State.DeleteState;
import State.UpdateState;
import VO.DriverInfoVO;
import businesslogic.Impl.Businesslobby.BusinessLobbyController;
import junit.framework.TestCase;

public class TestUpdateDriver extends TestCase {

	public void testUpdateDriver(){
		BusinessLobbyController businessLobbyController=new BusinessLobbyController();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DriverInfoVO driver;
		try {
			driver = new DriverInfoVO("025000009", "张斯栋", sdf.parse("1996-12-20"), 
					" 320586199612202123", "13040832063", "男", 5);
			assertEquals(UpdateState.SUCCESS,businessLobbyController.updateDriver(driver));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
