package businesslogic.Mock.Finance;

import java.util.ArrayList;

import businesslogic.Impl.Finance.GetEntruckingImpl;
import businesslogic.Impl.Finance.GetGatheringImpl;
import businesslogic.Impl.Finance.GetLogImpl;
import businesslogic.Impl.Finance.GetTransferImpl;
import businesslogic.Impl.Finance.SundryController;
import businesslogic.VO.EntruckingVO;
import businesslogic.VO.GatheringVO;
import businesslogic.VO.LogVO;
import businesslogic.VO.TransferVO;

public class MockSundryController extends SundryController{
	@Override
	public ArrayList<LogVO> getLog(String time_start, String time_end) {
		// TODO Auto-generated method stub
		MockGetLog getLog=new MockGetLog();
		return getLog.getLog(time_start, time_end);
	}

	@Override
	public ArrayList<TransferVO> getTransfer(String time_start, String time_end) {
		// TODO Auto-generated method stub
		MockGetTransfer getTransfer=new MockGetTransfer();
		return getTransfer.getTransfer(time_start, time_end);
	}

	@Override
	public ArrayList<GatheringVO> searchGathering(String date,
			String businesslobby) {
		// TODO Auto-generated method stub
		MockGetGathering getGathering=new MockGetGathering();
		return getGathering.searchGathering(date, businesslobby);
	}

	@Override
	public ArrayList<EntruckingVO> getEntrucking(String time_start,
			String time_end) {
		// TODO Auto-generated method stub
		MockGetEntrucking getEntrucking=new MockGetEntrucking();
		return getEntrucking.getEntrucking(time_start, time_end);
	}
}
