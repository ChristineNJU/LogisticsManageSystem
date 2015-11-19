package businesslogic.Service.BusinessLobby;

import java.util.ArrayList;

import VO.DriverInfoVO;

public interface GetDriverService {
	public ArrayList<DriverInfoVO> searchDriver(String id);
}
