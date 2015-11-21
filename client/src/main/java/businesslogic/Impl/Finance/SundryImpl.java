package businesslogic.Impl.Finance;

import java.rmi.Naming;
import java.util.ArrayList;

import PO.TransferPO;
import VO.EntruckingVO;
import VO.GatheringVO;
import VO.LogVO;
import VO.TransferVO;
import PO.LogPO;
import businesslogic.Service.Finance.GetEntruckingService;
import businesslogic.Service.Finance.GetGatheringService;
import businesslogic.Service.Finance.GetLogService;
import businesslogic.Service.Finance.GetTransferService;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchLogService;
import data.Service.Search.SearchTransferService;

public class SundryImpl implements GetEntruckingService,GetGatheringService,GetLogService,GetTransferService{

	@Override
	public ArrayList<TransferVO> getTransfer(String time_start, String time_end) {
		// TODO Auto-generated method stub
		ArrayList<TransferVO>  transfer=new ArrayList<TransferVO>();
		try{
			SearchTransferService transferSearch=(SearchTransferService) Naming.lookup(RMIHelper.SEARCH_TRANSFER_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("date between '"+time_start+"' and '"+time_end+"'");
			ArrayList<TransferPO> transferList=transferSearch.searchTransfer(URLHelper.getTransferURL(institution_id), requirement);
			for(int i=0;i<transferList.size();i++){
				transfer.add(new TransferVO(transferList.get(i)));
			}
		} catch (Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return transfer;
	}

	@Override
	public ArrayList<LogVO> getLog(String time_start, String time_end) {
		ArrayList<LogVO>  log=new ArrayList<LogVO>();
		try{
			SearchLogService logSearch=(SearchLogService) Naming.lookup(RMIHelper.SEARCH_LOG_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("time between '"+time_start+"' and '"+time_end+"'");
			ArrayList<LogPO> logList=logSearch.searcLog(URLHelper.getTransferURL(institution_id), requirement);
			for(int i=0;i<logList.size();i++){
				log.add(new LogVO(logList.get(i)));
			}
		} catch (Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return log;
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
