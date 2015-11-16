package businesslogic.Mock.Finance;

import java.util.ArrayList;

import businesslogic.Impl.Finance.GetEntruckingImpl;
import businesslogic.VO.EntruckingVO;

public class MockGetEntrucking extends GetEntruckingImpl{
	public ArrayList<EntruckingVO> getEntrucking(String time_start,
			String time_end) {
		// TODO Auto-generated method stub
		return new ArrayList<EntruckingVO>();
	}
}
