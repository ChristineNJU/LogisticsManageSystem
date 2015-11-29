package businesslogic.test.BusinessLobby;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import junit.framework.TestCase;
import State.DeleteState;
import VO.DriverInfoVO;
import businesslogic.Impl.Businesslobby.BusinessLobbyController;

public class TestDeleteDriver extends TestCase {

	public void testDeleteDriver(){
		BusinessLobbyController businessLobbyController=new BusinessLobbyController();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DriverInfoVO driver;
		try {
			driver = new DriverInfoVO("025000009", "张斯栋", sdf.parse("1996-12-20"), 
					" 320586199612202123", "13040832063", "男", 5);
			assertEquals(DeleteState.SUCCESS,businessLobbyController.deleteDriver(driver));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
