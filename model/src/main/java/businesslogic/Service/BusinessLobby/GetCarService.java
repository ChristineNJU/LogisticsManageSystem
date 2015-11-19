package businesslogic.Service.BusinessLobby;

import java.util.ArrayList;

import VO.CarInfoVO;

public interface GetCarService {
	public ArrayList<CarInfoVO> searchCar(String id);
}
