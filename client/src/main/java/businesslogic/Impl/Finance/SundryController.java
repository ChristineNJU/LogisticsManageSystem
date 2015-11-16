package businesslogic.Impl.Finance;

import java.util.ArrayList;

import businesslogic.Service.Finance.GetEntruckingService;
import businesslogic.Service.Finance.GetGatheringService;
import businesslogic.Service.Finance.GetLogService;
import businesslogic.Service.Finance.GetTransferService;
import businesslogic.VO.EntruckingVO;
import businesslogic.VO.GatheringVO;
import businesslogic.VO.LogVO;
import businesslogic.VO.TransferVO;

public class SundryController implements GetEntruckingService, GetGatheringService,GetTransferService,GetLogService{

	
	@Override
	public ArrayList<LogVO> getLog(String time_start, String time_end) {
		// TODO Auto-generated method stub
		GetLogImpl getLog=new GetLogImpl();
		return getLog.getLog(time_start, time_end);
	}

	@Override
	public ArrayList<TransferVO> getTransfer(String time_start, String time_end) {
		// TODO Auto-generated method stub
		GetTransferImpl getTransfer=new GetTransferImpl();
		return getTransfer.getTransfer(time_start, time_end);
	}

	@Override
	public ArrayList<GatheringVO> searchGathering(String date,
			String businesslobby) {
		// TODO Auto-generated method stub
		GetGatheringImpl getGathering=new GetGatheringImpl();
		return getGathering.searchGathering(date, businesslobby);
	}

	@Override
	public ArrayList<EntruckingVO> getEntrucking(String time_start,
			String time_end) {
		// TODO Auto-generated method stub
		GetEntruckingImpl getEntrucking=new GetEntruckingImpl();
		return getEntrucking.getEntrucking(time_start, time_end);
	}

}
