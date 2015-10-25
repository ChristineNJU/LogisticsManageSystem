package businesslogic.Service.Finance;

import java.util.ArrayList;

public interface GetLogService {
	public ArrayList<LogVO> getLog(String time_start, String time_end);
}
