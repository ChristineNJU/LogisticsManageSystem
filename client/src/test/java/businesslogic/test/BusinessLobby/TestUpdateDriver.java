package businesslogic.test.BusinessLobby;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import junit.framework.TestCase;
import State.UpdateState;
import VO.DriverInfoVO;
import businesslogic.Impl.Businesslobby.BusinessLobbyController;

public class TestUpdateDriver extends TestCase {

	public void testUpdateDriver(){
		BusinessLobbyController businessLobbyController=new BusinessLobbyController();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DriverInfoVO driver;
		try {
			driver = new DriverInfoVO("025000009", "张斯栋", sdf.parse("1996-12-20"), 
					" 320586199612202123", "13040832063", "男", 5);
			businessLobbyController.AddDriver(driver);
			DriverInfoVO driver1 = new DriverInfoVO("025000009", "hy", sdf.parse("1996-12-13"), 
					" 320586199612202124", "13140832063", "女", 6);
			assertEquals(UpdateState.SUCCESS,businessLobbyController.updateDriver(driver1));
			DriverInfoVO driver2 = new DriverInfoVO("025000010", "hy", sdf.parse("1996-12-13"), 
					" 320586199612202124", "13140832063", "女", 6);
			assertEquals(UpdateState.NOTFOUND,businessLobbyController.updateDriver(driver2));
			businessLobbyController.deleteDriver(driver1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
