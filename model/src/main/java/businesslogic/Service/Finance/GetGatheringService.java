package businesslogic.Service.Finance;

import java.util.ArrayList;

import VO.GatheringVO;

public interface GetGatheringService {
	public ArrayList<GatheringVO> searchGathering(String date, String businesslobby);
	public ArrayList<GatheringVO> searchGathering(String startDate, String endDate, String businesslobby);
}
