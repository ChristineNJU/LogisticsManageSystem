package businesslogic.Service.Finance;

import java.util.ArrayList;

import businesslogic.VO.GatheringVO;

public interface GetGatheringService {
	public ArrayList<GatheringVO> searchGathering(String date, String businesslobby);
}
