package businesslogic.Service.Manage;

import java.util.ArrayList;

import businesslogic.VO.GatheringVO;

public interface SearchGatheringService {
	public ArrayList<GatheringVO> searchGathering(String date, String businesslobby);
}
