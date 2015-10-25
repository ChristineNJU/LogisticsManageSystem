package businesslogic.Service.Finance;

import java.util.ArrayList;

public interface GetEntruckingService {
	public ArrayList<EntruckingVO> getEntrucking(String time_start, String time_end);
}
