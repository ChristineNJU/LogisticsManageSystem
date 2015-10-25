package businesslogic.Service.BusinessLobby;

import java.util.ArrayList;

import businesslogic.VO.DriverInfoVO;

public interface SearchDriverService {
	public ArrayList<DriverInfoVO> searchDriver(String id);
}
