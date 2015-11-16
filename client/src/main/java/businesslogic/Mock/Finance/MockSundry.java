package businesslogic.Mock.Finance;

import java.util.ArrayList;

import businesslogic.Impl.Finance.SundryImpl;
import businesslogic.VO.EntruckingVO;
import businesslogic.VO.GatheringVO;
import businesslogic.VO.LogVO;
import businesslogic.VO.TransferVO;

public class MockSundry extends SundryImpl{

	@Override
	public ArrayList<TransferVO> getTransfer(String time_start, String time_end) {
		// TODO Auto-generated method stub
		return new ArrayList<TransferVO>();
	}

	@Override
	public ArrayList<LogVO> getLog(String time_start, String time_end) {
		// TODO Auto-generated method stub
		return new ArrayList<LogVO>();
	}

	@Override
	public ArrayList<GatheringVO> searchGathering(String date,
			String businesslobby) {
		// TODO Auto-generated method stub
		return new ArrayList<GatheringVO>();
	}

	@Override
	public ArrayList<EntruckingVO> getEntrucking(String time_start,
			String time_end) {
		// TODO Auto-generated method stub
		return new ArrayList<EntruckingVO>();
	}
}
