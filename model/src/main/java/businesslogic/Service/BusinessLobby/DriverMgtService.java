package businesslogic.Service.BusinessLobby;

import java.util.ArrayList;

import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.DriverInfoVO;

public interface DriverMgtService{

	public AddState addDriver(DriverInfoVO car);
	public DeleteState deleteDriver(DriverInfoVO driver);
	public ArrayList<DriverInfoVO> searchDriver(String id);
	public UpdateState updateDriver(DriverInfoVO driver);
	
}
