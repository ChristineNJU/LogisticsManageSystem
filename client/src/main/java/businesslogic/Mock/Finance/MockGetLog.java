package businesslogic.Mock.Finance;

import java.util.ArrayList;

import businesslogic.Impl.Finance.GetLogImpl;
import businesslogic.VO.LogVO;

public class MockGetLog extends GetLogImpl{
	public ArrayList<LogVO> getLog(String time_start, String time_end) {
		// TODO Auto-generated method stub
		return new ArrayList<LogVO>();
	}
}
