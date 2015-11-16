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

	GetEntruckingImpl getEntrucking=new GetEntruckingImpl();
	GetGatheringImpl getGathering=new GetGatheringImpl();
	GetTransferImpl getTransfer=new GetTransferImpl();
	GetLogImpl getLog=new GetLogImpl();
	
	@Override
	public ArrayList<LogVO> getLog(String time_start, String time_end) {
		// TODO Auto-generated method stub
		return getLog.getLog(time_start, time_end);
	}

	@Override
	public ArrayList<TransferVO> getTransfer(String time_start, String time_end) {
		// TODO Auto-generated method stub
		return getTransfer.getTransfer(time_start, time_end);
	}

	@Override
	public ArrayList<GatheringVO> searchGathering(String date,
			String businesslobby) {
		// TODO Auto-generated method stub
		return getGathering.searchGathering(date, businesslobby);
	}

	@Override
	public ArrayList<EntruckingVO> getEntrucking(String time_start,
			String time_end) {
		// TODO Auto-generated method stub
		return getEntrucking.getEntrucking(time_start, time_end);
	}

}
