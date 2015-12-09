package businesslogic.Impl.Finance;

import java.rmi.Naming;
import java.util.ArrayList;

import PO.EntruckingPO;
import PO.GatheringPO;
import PO.InstitutionPO;
import PO.LogPO;
import PO.TransferPO;
import VO.EntruckingVO;
import VO.GatheringVO;
import VO.LogVO;
import VO.TransferVO;
import businesslogic.Service.Finance.GetEntruckingService;
import businesslogic.Service.Finance.GetGatheringService;
import businesslogic.Service.Finance.GetLogService;
import businesslogic.Service.Finance.GetTransferService;
import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchEntruckingService;
import data.Service.Search.SearchGatheringService;
import data.Service.Search.SearchInstitutionInfoService;
import data.Service.Search.SearchLogService;
import data.Service.Search.SearchTransferService;

// TODO: Auto-generated Javadoc
/**
 * The Class SundryImpl.
 */
public class SundryImpl implements GetEntruckingService,GetGatheringService,GetLogService,GetTransferService{

	/* (non-Javadoc)
	 * @see businesslogic.Service.Finance.GetTransferService#getTransfer(java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<TransferVO> getTransfer(String time_start, String time_end) {
		// TODO Auto-generated method stub
		ArrayList<TransferVO>  transfer=new ArrayList<TransferVO>();
		try{
			SearchTransferService transferSearch=(SearchTransferService) Naming.lookup(RMIHelper.SEARCH_TRANSFER_IMPL);
			SearchInstitutionInfoService instiSearch=(SearchInstitutionInfoService) Naming.lookup(RMIHelper.SEARCH_INSTITUTION_IMPL);
			ArrayList<String> requirementTrans=new ArrayList<String>();
			ArrayList<String> institutionID=new ArrayList<String>();
			ArrayList<String> requirementInsti=new ArrayList<String>();
			ArrayList<TransferPO> transferList=new ArrayList<TransferPO>();
			ArrayList<InstitutionPO> institutionList=instiSearch.searchInstitutionInfo(requirementInsti);
			requirementTrans.add("date between '"+time_start+"' and '"+time_end+"'");
			requirementInsti.add("city like '%%'");
			for(int i=0;i<institutionList.size();i++){
				institutionID.add(institutionList.get(i).getInstitutionNumber());
			}
			for(int i=0;i<institutionID.size();i++){
				ArrayList<TransferPO> transferTemp=transferSearch.searchTransfer(institutionID.get(i), requirementTrans);
				for(int j=0;j<transferTemp.size();j++)
				transferList.add(transferTemp.get(j));
			}
			for(int i=0;i<transferList.size();i++){
				transfer.add(new TransferVO(transferList.get(i)));
			}
		} catch (Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return transfer;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Finance.GetLogService#getLog(java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<LogVO> getLog(String time_start, String time_end) {
		ArrayList<LogVO>  log=new ArrayList<LogVO>();
		try{
			SearchLogService logSearch=(SearchLogService) Naming.lookup(RMIHelper.SEARCH_LOG_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("time between '"+time_start+"' and '"+time_end+"'");
			ArrayList<LogPO> logList=logSearch.searchLog(requirement);
			for(int i=0;i<logList.size();i++){
				log.add(new LogVO(logList.get(i)));
			}
		} catch (Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return log;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Finance.GetGatheringService#searchGathering(java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<GatheringVO> searchGathering(String date,
			String businesslobby) {
		ArrayList<GatheringVO> gathering=new ArrayList<GatheringVO>();
		try{
			SearchGatheringService gatheringSearch=(SearchGatheringService) Naming.lookup(RMIHelper.SEARCH_GATHERING_IMPL);
			SearchInstitutionInfoService instiSearch=(SearchInstitutionInfoService) Naming.lookup(RMIHelper.SEARCH_INSTITUTION_IMPL);
			ArrayList<String> requirementInsti=new ArrayList<String>();
			ArrayList<String> requirementGathering=new ArrayList<String>();
			ArrayList<String> institutionID=new ArrayList<String>();
			ArrayList<InstitutionPO> institutionList=new ArrayList<InstitutionPO>();
			requirementInsti.add("city like '%%'");
			requirementGathering.add("date='"+date+"'");
			institutionList=instiSearch.searchInstitutionInfo(requirementInsti);
			for(int i=0;i<institutionList.size();i++){
				if(businesslobby.equals(institutionList.get(i).getInstitutionName())||businesslobby.equals(institutionList.get(i).getInstitutionNumber())){
					institutionID.add(institutionList.get(i).getInstitutionNumber());
				}
				else if(businesslobby.equals("%%")){
					institutionID.add(institutionList.get(i).getInstitutionNumber());
				}
			}
			for(int i=0;i<institutionID.size();i++){
				ArrayList<GatheringPO> temp=gatheringSearch.searchGathering(institutionID.get(i), requirementGathering);
				for(int j=0;j<temp.size();j++){
					gathering.add(new GatheringVO(temp.get(j)));
				}
				
			}
			
		} catch (Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		// TODO Auto-generated method stub
		return gathering;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Finance.GetEntruckingService#getEntrucking(java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<EntruckingVO> getEntrucking(String time_start,
			String time_end) {
		ArrayList<EntruckingVO> entrucking=new ArrayList<EntruckingVO>();
		// TODO Auto-generated method stub
		try{
			SearchEntruckingService entruckingSearch=(SearchEntruckingService) Naming.lookup(RMIHelper.SEARCH_ENTRUCKING_IMPL);
			SearchInstitutionInfoService institutionSearch=(SearchInstitutionInfoService) Naming.lookup(RMIHelper.SEARCH_INSTITUTION_IMPL);
			ArrayList<InstitutionPO> instiList=new ArrayList<InstitutionPO>();
			ArrayList<String> requirementEntruck=new ArrayList<String>();
			ArrayList<String> requirementInsti=new ArrayList<String>();
			ArrayList<String> institutionID=new ArrayList<String>();
			requirementInsti.add("city like '%%'");
			requirementEntruck.add("date between '"+time_start+"' and '"+time_end+"'");
			instiList=institutionSearch.searchInstitutionInfo(requirementInsti);
			
			for(int i=0;i<instiList.size();i++){
				System.out.println(instiList.get(i).getInstitutionNumber());
				institutionID.add(instiList.get(i).getInstitutionNumber());
			}
			for(int i=0;i<institutionID.size();i++){
				ArrayList<EntruckingPO> temp=entruckingSearch.searchEntrucking(institutionID.get(i), requirementEntruck);
				for(int j=0;j<temp.size();j++){
					entrucking.add(new EntruckingVO(temp.get(j)));
				}
			}
		} catch (Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return entrucking;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Finance.GetGatheringService#searchGathering(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<GatheringVO> searchGathering(String startDate,
			String endDate, String businesslobby) {
		// TODO Auto-generated method stub
		ArrayList<GatheringVO> gathering=new ArrayList<GatheringVO>();
		try{
			SearchGatheringService gatheringSearch=(SearchGatheringService) Naming.lookup(RMIHelper.SEARCH_GATHERING_IMPL);
			SearchInstitutionInfoService instiSearch=(SearchInstitutionInfoService) Naming.lookup(RMIHelper.SEARCH_INSTITUTION_IMPL);
			ArrayList<String> requirementInsti=new ArrayList<String>();
			ArrayList<String> requirementGathering=new ArrayList<String>();
			ArrayList<String> institutionID=new ArrayList<String>();
			ArrayList<InstitutionPO> institutionList=new ArrayList<InstitutionPO>();
			requirementInsti.add("city like '%%'");
			requirementGathering.add("date between '"+startDate+"' and '"+endDate+"'");
			institutionList=instiSearch.searchInstitutionInfo(requirementInsti);
			for(int i=0;i<institutionList.size();i++){
				if(businesslobby.equals(institutionList.get(i).getInstitutionName())||businesslobby.equals(institutionList.get(i).getInstitutionNumber())){
					institutionID.add(institutionList.get(i).getInstitutionNumber());
				}
				else if(businesslobby.equals("%%")){
					institutionID.add(institutionList.get(i).getInstitutionNumber());
				}
			}
			for(int i=0;i<institutionID.size();i++){
				ArrayList<GatheringPO> temp=gatheringSearch.searchGathering(institutionID.get(i), requirementGathering);
				for(int j=0;j<temp.size();j++){
					gathering.add(new GatheringVO(temp.get(j)));
				}
				
			}
			
		} catch (Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		// TODO Auto-generated method stub
		return gathering;
	}

}
