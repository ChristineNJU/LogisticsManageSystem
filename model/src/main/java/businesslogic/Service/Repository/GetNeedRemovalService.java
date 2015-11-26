package businesslogic.Service.Repository;

import java.util.ArrayList;

import VO.RemovalVO;

public interface GetNeedRemovalService {
	
	public ArrayList<RemovalVO> getNeedRemoval(String destination);
	
}
