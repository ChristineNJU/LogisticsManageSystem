package businesslogic.Impl.Finance;

import java.util.ArrayList;

import VO.EntruckingVO;
import VO.GatheringVO;
import VO.LogVO;
import VO.TransferVO;
import businesslogic.Service.Finance.GetEntruckingService;
import businesslogic.Service.Finance.GetGatheringService;
import businesslogic.Service.Finance.GetLogService;
import businesslogic.Service.Finance.GetTransferService;

public class SundryImpl implements GetEntruckingService,GetGatheringService,GetLogService,GetTransferService{

	@Override
	public ArrayList<TransferVO> getTransfer(String time_start, String time_end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<LogVO> getLog(String time_start, String time_end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<GatheringVO> searchGathering(String date,
			String businesslobby) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<EntruckingVO> getEntrucking(String time_start,
			String time_end) {
		// TODO Auto-generated method stub
		return null;
	}

}
