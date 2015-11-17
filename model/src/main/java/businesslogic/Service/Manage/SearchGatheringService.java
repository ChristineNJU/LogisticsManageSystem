package businesslogic.Service.Manage;

import java.util.ArrayList;

import VO.GatheringVO;

public interface SearchGatheringService {
	public ArrayList<GatheringVO> searchGathering(String date, String businesslobby);
}
