package businesslogic.Service.Manage;

import java.util.ArrayList;

import VO.GatheringVO;

public interface GetGatheringService {
	public ArrayList<GatheringVO> searchGathering(String date, String businesslobby);
}
