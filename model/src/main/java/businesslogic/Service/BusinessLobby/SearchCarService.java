package businesslogic.Service.BusinessLobby;

import java.util.ArrayList;

import businesslogic.VO.CarInfoVO;

public interface SearchCarService {
	public ArrayList<CarInfoVO> searchCar(String id);
}
