package businesslogic.Impl.Manage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import PO.ArrivalPO;
import PO.BalancePO;
import PO.BenefitPO;
import PO.CostPO;
import PO.DeliveryPO;
import PO.EntruckingPO;
import PO.GatheringPO;
import PO.InstitutionPO;
import PO.LogisticsInfoPO;
import PO.RemovalPO;
import PO.StoragePO;
import PO.TransferPO;
import State.UpdateState;
import VO.ArrivalVO;
import VO.BalanceVO;
import VO.CostVO;
import VO.DeliveryVO;
import VO.EntruckingVO;
import VO.GatheringVO;
import VO.LogisticsHistoryVO;
import VO.RemovalVO;
import VO.StorageVO;
import VO.TransferVO;
import VO.VO;
import businesslogic.Impl.Inquiry.InquiryController;
import businesslogic.Service.Manage.UpdateReceiptService;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;
import data.Service.Search.SearchArrivalService;
import data.Service.Search.SearchBalanceService;
import data.Service.Search.SearchBenefitService;
import data.Service.Search.SearchCostService;
import data.Service.Search.SearchDeliveryService;
import data.Service.Search.SearchEntruckingService;
import data.Service.Search.SearchGatheringService;
import data.Service.Search.SearchInstitutionInfoService;
import data.Service.Search.SearchLogisticsService;
import data.Service.Search.SearchRemovalService;
import data.Service.Search.SearchStorageService;
import data.Service.Search.SearchTransferService;
import data.Service.Update.UpdateService;

// TODO: Auto-generated Javadoc
/**
 * The Class ManageReceipt.
 */
public class ManageReceipt implements UpdateReceiptService{

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.UpdateReceiptService#updateReceipt(VO.VO)
	 */
	@Override
	public UpdateState updateReceipt(VO receipt) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		UpdateState result=UpdateState.NOTFOUND;
		
		
		try {
			UpdateService updateService=(UpdateService) Naming.lookup(RMIHelper.UPDATE_IMPL);
			
			
			
			ArrayList<String> requirement=new ArrayList<String>();
			String institutionid="";
			
			ArrayList<String> requirementBusinesslobby=new ArrayList<String>();
			requirementBusinesslobby.add("institution_type='BusinessLobby'");
			
			ArrayList<String> requirementReponsitory=new ArrayList<String>();
			requirementReponsitory.add("institution_type='Repository'");
			
			ArrayList<String> requirementMediumCenter=new ArrayList<String>();
			requirementMediumCenter.add("institution_type='MediumCenter'");
			
			SearchInstitutionInfoService searchInstitution=(SearchInstitutionInfoService) Naming.lookup(RMIHelper.SEARCH_INSTITUTION_IMPL);
			ArrayList<InstitutionPO> searchResultBusinesslobby=searchInstitution.searchInstitutionInfo(requirementBusinesslobby);
			ArrayList<InstitutionPO> searchResultReponsitory=searchInstitution.searchInstitutionInfo(requirementReponsitory);
			ArrayList<InstitutionPO> searchResultMediumCenter=searchInstitution.searchInstitutionInfo(requirementMediumCenter);
			
			//arrival   
			if(receipt instanceof ArrivalVO){
				ArrivalVO arrival=(ArrivalVO) receipt;
				SearchArrivalService searchArrival=(SearchArrivalService) Naming.lookup(RMIHelper.SEARCH_ARRIVAL_IMPL);
				requirement.add("bar_code='"+arrival.getBarCode()+"'");
				ArrayList<ArrivalPO> searchResult=new ArrayList<ArrivalPO>();
				for(int i=0;i<searchResultBusinesslobby.size();i++){

					ArrayList<ArrivalPO> arrivalResult=searchArrival.searchArrival(URLHelper.getArrivalURL(searchResultBusinesslobby.get(0).getInstitutionNumber()), requirement);

					for(int j=0;j<arrivalResult.size();j++){
						searchResult.add(arrivalResult.get(j));
						institutionid=searchResultBusinesslobby.get(i).getInstitutionNumber();
						this.updateArrival(arrival,searchResultBusinesslobby.get(i));
					}
				}
				for(int i=0;i<searchResultMediumCenter.size();i++){
					ArrayList<ArrivalPO> arrivalResult=searchArrival.searchArrival(URLHelper.getArrivalURL(searchResultMediumCenter.get(i).getInstitutionNumber()), requirement);
					for(int j=0;j<arrivalResult.size();j++){
						searchResult.add(arrivalResult.get(j));	
						institutionid=searchResultMediumCenter.get(i).getInstitutionNumber();
						this.updateArrival(arrival,searchResultMediumCenter.get(i));
						
					}
				}
				
				if(searchResult.isEmpty()){
					System.out.println("not found");
					return UpdateState.NOTFOUND;
				}
				else{
					ArrivalPO temp=searchResult.get(0);
					temp.setApproved(true);
//					System.out.println("here");
					result=updateService.update(temp);
				}
			}
			
			//balance 
			if(receipt instanceof BalanceVO){
				BalanceVO balance=(BalanceVO) receipt;
				SearchBalanceService searchBalance=(SearchBalanceService) Naming.lookup(RMIHelper.SEARCH_BALANCE_IMPL);
				requirement.add("storage_date='"+sdf.format(balance.getDate())+"'");
				ArrayList<BalancePO> searchResult=new ArrayList<BalancePO>();
				for(int i=0;i<searchResultReponsitory.size();i++){
					ArrayList<BalancePO> balanceResult=searchBalance.searchBalannce(URLHelper.getBalanceURL(searchResultReponsitory.get(i).getInstitutionNumber()), requirement);
					for(int j=0;j<balanceResult.size();j++){
						searchResult.add(balanceResult.get(j));
						institutionid=searchResultReponsitory.get(i).getInstitutionNumber();
						
						}
				}
				
				if(searchResult.isEmpty()){
					System.out.println("not found");
					return UpdateState.NOTFOUND;
				}
				else{
					BalancePO temp=searchResult.get(0);
					temp.setApproved(true);
					result=updateService.update(temp);
					
				}
			}
			
			//Cost 
			if(receipt instanceof CostVO){
				CostVO cost=(CostVO) receipt;
				SearchCostService searchCost=(SearchCostService) Naming.lookup(RMIHelper.SEARCH_COST_IMPL);
				requirement.add("cost_date='"+sdf.format(cost.getDate())+"'");
				ArrayList<CostPO> searchResult=searchCost.searchCost(requirement);
				
				if(searchResult.isEmpty()){
					System.out.println("not found");
					return UpdateState.NOTFOUND;
				}
				else{
					CostPO temp=searchResult.get(0);
					temp.setApproved(true);
					result=updateService.update(temp);
					
				}
				
				SearchBenefitService searchBenefit=(SearchBenefitService) Naming.lookup(RMIHelper.SEARCH_BENEFIT_IMPL);
				ArrayList<String> requireBenefit=new ArrayList<String>();
				requireBenefit.add("date like '%%'");
				ArrayList<BenefitPO> searchResultBenefit=searchBenefit.searchBenefit(requireBenefit);
				AddService addService=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
				if(searchResultBenefit.isEmpty()){
					
				}else{
					BenefitPO benefit=new BenefitPO(cost, searchResultBenefit.get(searchResultBenefit.size()-1));
					addService.add(benefit);
				}
			}
			
			//Delivery 
			if(receipt instanceof DeliveryVO){
				DeliveryVO delivery=(DeliveryVO) receipt;
				SearchDeliveryService searchDelivery=(SearchDeliveryService) Naming.lookup(RMIHelper.SEARCH_DELIVERY_SERVICE);
				requirement.add("Date='"+sdf.format(delivery.getArrivalDate())+"'");
				ArrayList<DeliveryPO> searchResult=new ArrayList<DeliveryPO>();
				for(int i=0;i<searchResultBusinesslobby.size();i++){
					ArrayList<DeliveryPO> deliveryResult=searchDelivery.searchDelivery(URLHelper.getDeliveryURL(searchResultBusinesslobby.get(i).getInstitutionNumber()), requirement);
					for(int j=0;j<deliveryResult.size();j++){
						searchResult.add(deliveryResult.get(j));	
						institutionid=searchResultBusinesslobby.get(i).getInstitutionNumber();
						this.updateDelivery(delivery,searchResultBusinesslobby.get(i));
						}
				}
				
				
				if(searchResult.isEmpty()){
					System.out.println("! not found");
					System.out.println("!"+institutionid);
					return UpdateState.NOTFOUND;
				}
				else{
					
					DeliveryPO temp=searchResult.get(0);
					temp.setApproved(true);
					result=updateService.update(temp);
					
				}
			}
			
			
			//entrucking 
			if(receipt instanceof EntruckingVO){
				EntruckingVO entrucking=(EntruckingVO) receipt;
				SearchEntruckingService searchEntrucking=(SearchEntruckingService) Naming.lookup(RMIHelper.SEARCH_ENTRUCKING_IMPL);
				requirement.add("Transfer_number='"+entrucking.getInstitutioNumber()+"'");
				ArrayList<EntruckingPO> searchResult=new ArrayList<EntruckingPO>();
				for(int i=0;i<searchResultBusinesslobby.size();i++){
					ArrayList<EntruckingPO> entruckingResult=searchEntrucking.searchEntrucking(URLHelper.getEntruckingURL(searchResultBusinesslobby.get(i).getInstitutionNumber()), requirement);
					for(int j=0;j<entruckingResult.size();j++){
						searchResult.add(entruckingResult.get(j));	
						institutionid=searchResultBusinesslobby.get(i).getInstitutionNumber();	
						this.updateEntrucking(entrucking,searchResultBusinesslobby.get(i));
					}
				}
				for(int i=0;i<searchResultMediumCenter.size();i++){
					ArrayList<EntruckingPO> entruckingResult=searchEntrucking.searchEntrucking(URLHelper.getEntruckingURL(searchResultMediumCenter.get(i).getInstitutionNumber()), requirement);
					for(int j=0;j<entruckingResult.size();j++){
						searchResult.add(entruckingResult.get(j));	
						institutionid=searchResultMediumCenter.get(i).getInstitutionNumber();	
						this.updateEntrucking(entrucking,searchResultMediumCenter.get(i));
					}
				}
				
				if(searchResult.isEmpty()){
					System.out.println("not found");
					return UpdateState.NOTFOUND;
				}
				else{
					EntruckingPO temp=searchResult.get(0);
					temp.setApproved(true);;
					result=updateService.update(temp);
					
				}
			}
			
			//gathering 
			if(receipt instanceof GatheringVO){
				GatheringVO gathering=(GatheringVO) receipt;
				SearchGatheringService searchGathering=(SearchGatheringService) Naming.lookup(RMIHelper.SEARCH_GATHERING_IMPL);
				requirement.add("date='"+sdf.format(gathering.getDate())+"'");
				ArrayList<GatheringPO> searchResult=new ArrayList<GatheringPO>();
				for(int i=0;i<searchResultBusinesslobby.size();i++){
					ArrayList<GatheringPO> gatheringResult=searchGathering.searchGathering(URLHelper.getGatheringURL(searchResultBusinesslobby.get(i).getInstitutionNumber()), requirement);
					for(int j=0;j<gatheringResult.size();j++){
						searchResult.add(gatheringResult.get(j));
						institutionid=searchResultBusinesslobby.get(i).getInstitutionNumber();	
					}
				}
				
				if(searchResult.isEmpty()){
					System.out.println("not found");
					return UpdateState.NOTFOUND;
				}
				else{
					GatheringPO temp=searchResult.get(0);
					temp.setApproved(true);
					result=updateService.update(temp);
					
				}
				
				
				SearchBenefitService searchBenefit=(SearchBenefitService) Naming.lookup(RMIHelper.SEARCH_BENEFIT_IMPL);
				ArrayList<String> requireBenefit=new ArrayList<String>();
				requireBenefit.add("date like '%%'");
				ArrayList<BenefitPO> searchResultBenefit=searchBenefit.searchBenefit(requireBenefit);
				AddService addService=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
				BenefitPO benefit=new BenefitPO(gathering, searchResultBenefit.get(searchResultBenefit.size()));
				addService.add(benefit);
			}
			
			
			//removal
			if(receipt instanceof RemovalVO){
				RemovalVO removal=(RemovalVO) receipt;
				SearchRemovalService searchRemoval=(SearchRemovalService) Naming.lookup(RMIHelper.SEARCH_REMOVAL_IMPL);
				requirement.add("bar_Code='"+removal.getBarCode()+"'");
				ArrayList<RemovalPO> searchResult=new ArrayList<RemovalPO>();
				for(int i=0;i<searchResultReponsitory.size();i++){
					ArrayList<RemovalPO> removalResult=searchRemoval.searchRemoval(URLHelper.getRemovalURL(searchResultReponsitory.get(i).getInstitutionNumber()), requirement);
					for(int j=0;j<removalResult.size();j++){
						searchResult.add(removalResult.get(j));
						institutionid=searchResultReponsitory.get(i).getInstitutionNumber();
						this.updateRemoval(removal,searchResultReponsitory.get(i));
					}
				}
				
				if(searchResult.isEmpty()){
					System.out.println("not found");
					return UpdateState.NOTFOUND;
				}
				else{
					RemovalPO temp=searchResult.get(0);
					temp.setApproved(true);
					result=updateService.update(temp);
					
				}
				
			}
			
			
			//storage 
			if(receipt instanceof StorageVO){
				StorageVO storage=(StorageVO) receipt;
				SearchStorageService searchStorage=(SearchStorageService) Naming.lookup(RMIHelper.SEARCH_STORAGE_IMPL);
				requirement.add("bar_Code='"+storage.getBarCode()+"'");
				ArrayList<StoragePO> searchResult=new ArrayList<StoragePO>();
				for(int i=0;i<searchResultReponsitory.size();i++){
					ArrayList<StoragePO> storageResult=searchStorage.searchStorage(URLHelper.getStorageURL(searchResultReponsitory.get(i).getInstitutionNumber()), requirement);
					for(int j=0;j<storageResult.size();j++){
						searchResult.add(storageResult.get(j));
						institutionid=searchResultReponsitory.get(i).getInstitutionNumber();	
						this.updateStorage(storage,searchResultReponsitory.get(i));
					}
				}
				
				if(searchResult.isEmpty()){
					System.out.println("not found");
					return UpdateState.NOTFOUND;
				}
				else{
					StoragePO temp=searchResult.get(0);
					temp.setApproved(true);
					result=updateService.update(temp);
					
				}
			}
			
		
			//transfer
			if(receipt instanceof TransferVO){
				TransferVO transfer=(TransferVO) receipt;
				SearchTransferService searchTransfer=(SearchTransferService) Naming.lookup(RMIHelper.SEARCH_TRANSFER_IMPL);
				requirement.add("date='"+sdf.format(transfer.getDate())+"'");
				ArrayList<TransferPO> searchResult=new ArrayList<TransferPO>();
				for(int i=0;i<searchResultMediumCenter.size();i++){
					ArrayList<TransferPO> transferResult=searchTransfer.searchTransfer(URLHelper.getTransferURL(searchResultMediumCenter.get(i).getInstitutionNumber()), requirement);
					for(int j=0;j<transferResult.size();j++){
						searchResult.add(transferResult.get(j));
						institutionid=searchResultMediumCenter.get(i).getInstitutionNumber();		
						this.updateTransfer(transfer,searchResultMediumCenter.get(i));
						
					}
				}

				if(searchResult.isEmpty()){
					System.out.println("not found");
					return UpdateState.NOTFOUND;
				}
				else{
					TransferPO temp=searchResult.get(0);
					temp.setApproved(true);
					result=updateService.update(temp);
					
				}
			}
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			result=UpdateState.CONNECTERROR;
			System.out.println("error");
			e.printStackTrace();
		}
		
		
		
		
		return result;
	}

	/**
	 * Update arrival.
	 *
	 * @param arrival the arrival
	 * @param institution 更新物流信息
	 * 测试存在困难
	 * 可能会出现问题
	 */
	
	public void updateArrival(ArrivalVO arrival,InstitutionPO institution){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			SearchLogisticsService service=(SearchLogisticsService) Naming.lookup(RMIHelper.SEARCH_LOGISTICS_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("bar_code='"+arrival.getBarCode()+"'");
			ArrayList<LogisticsInfoPO> list = service.searchLogisticsInfo(requirement);
			if(list.isEmpty()){
				return;
			}
			LogisticsInfoPO logistic=list.get(0);
			logistic.addHistory(institution.getInstitutionName()+"已收件,"+sdf.format(arrival.getDate()));
		
			UpdateService updateservice=(UpdateService) Naming.lookup(RMIHelper.UPDATE_IMPL);
			updateservice.update(logistic);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("更新物流信息失败");
		}
	}
	
	
	
	/**
	 * Update delivery.
	 *
	 * @param delivery the delivery
	 * @param institution the institution
	 */
	public void updateDelivery(DeliveryVO delivery,InstitutionPO institution){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			SearchLogisticsService service=(SearchLogisticsService) Naming.lookup(RMIHelper.SEARCH_LOGISTICS_IMPL);
			for(String s:delivery.getBarCodeList()){
				ArrayList<String> requirement=new ArrayList<String>();
				requirement.add("bar_code='"+s+"'");
				ArrayList<LogisticsInfoPO> list = service.searchLogisticsInfo(requirement);
				if(list.isEmpty()){
					return;
				}
				LogisticsInfoPO logistic=list.get(0);
				logistic.addHistory(institution.getInstitutionName()+"正在派件,"+sdf.format(delivery.getArrivalDate()));
				
				UpdateService updateservice=(UpdateService) Naming.lookup(RMIHelper.UPDATE_IMPL);
				updateservice.update(logistic);
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("更新物流信息失败");
		}
	}
	
	/**
	 * Update entrucking.
	 *
	 * @param entrucking the entrucking
	 * @param institution the institution
	 */
	public void updateEntrucking(EntruckingVO entrucking,InstitutionPO institution){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			SearchLogisticsService service=(SearchLogisticsService) Naming.lookup(RMIHelper.SEARCH_LOGISTICS_IMPL);
			for(String s:entrucking.getBarCodeList()){
				ArrayList<String> requirement=new ArrayList<String>();
				requirement.add("bar_code='"+s+"'");
				ArrayList<LogisticsInfoPO> list = service.searchLogisticsInfo(requirement);
				if(list.isEmpty()){
					return;
				}
				LogisticsInfoPO logistic=list.get(0);
				logistic.addHistory(institution.getInstitutionName()+"正在扫描装车,"+sdf.format(entrucking.getDate()));
			
				UpdateService updateservice=(UpdateService) Naming.lookup(RMIHelper.UPDATE_IMPL);
				updateservice.update(logistic);
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("更新物流信息失败");
		}
	}
	
	
	
	/**
	 * Update removal.
	 *
	 * @param removal the removal
	 * @param institution the institution
	 */
	public void updateRemoval(RemovalVO removal ,InstitutionPO institution){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			SearchLogisticsService service=(SearchLogisticsService) Naming.lookup(RMIHelper.SEARCH_LOGISTICS_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("bar_code='"+removal.getBarCode()+"'");
			ArrayList<LogisticsInfoPO> list = service.searchLogisticsInfo(requirement);
			if(list.isEmpty()){
				return;
			}
			LogisticsInfoPO logistic=list.get(0);
			logistic.addHistory(institution.getInstitutionName()+"正在出库,"+sdf.format(removal.getOutDate()));
			
			UpdateService updateservice=(UpdateService) Naming.lookup(RMIHelper.UPDATE_IMPL);
			updateservice.update(logistic);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("更新物流信息失败");
		}
	}
	
	/**
	 * Update storage.
	 *
	 * @param storage the storage
	 * @param institution the institution
	 */
	public void updateStorage(StorageVO storage ,InstitutionPO institution){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			SearchLogisticsService service=(SearchLogisticsService) Naming.lookup(RMIHelper.SEARCH_LOGISTICS_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("bar_code='"+storage.getBarCode()+"'");
			ArrayList<LogisticsInfoPO> list = service.searchLogisticsInfo(requirement);
			if(list.isEmpty()){
				return;
			}
			LogisticsInfoPO logistic=list.get(0);
			logistic.addHistory(institution.getInstitutionName()+"正在入库,"+sdf.format(storage.getStorageDate()));
			
			UpdateService updateservice=(UpdateService) Naming.lookup(RMIHelper.UPDATE_IMPL);
			updateservice.update(logistic);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("更新物流信息失败");
		}
	}
	
	/**
	 * Update transfer.
	 *
	 * @param transfer the transfer
	 * @param institution the institution
	 */
	public void updateTransfer(TransferVO transfer ,InstitutionPO institution){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			SearchLogisticsService service=(SearchLogisticsService) Naming.lookup(RMIHelper.SEARCH_LOGISTICS_IMPL);
			for(String s:transfer.getItemId()){
				ArrayList<String> requirement=new ArrayList<String>();
				requirement.add("bar_code='"+s+"'");
				ArrayList<LogisticsInfoPO> list = service.searchLogisticsInfo(requirement);
				if(list.isEmpty()){
					return;
				}
				LogisticsInfoPO logistic=list.get(0);
				logistic.addHistory(institution.getInstitutionName()+"正在中转发送,"+sdf.format(transfer.getDate()));
				
				UpdateService updateservice=(UpdateService) Naming.lookup(RMIHelper.UPDATE_IMPL);
				updateservice.update(logistic);
			}
			} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("更新物流信息失败");
		}
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.UpdateReceiptService#updateArrival(VO.ArrivalVO)
	 */
	@Override
	public UpdateState updateArrival(ArrivalVO arrival) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.UpdateReceiptService#updateBalance(VO.BalanceVO)
	 */
	@Override
	public UpdateState updateBalance(BalanceVO balance) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.UpdateReceiptService#updateCost(VO.CostVO)
	 */
	@Override
	public UpdateState updateCost(CostVO cost) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.UpdateReceiptService#updateDelivery(VO.DeliveryVO)
	 */
	@Override
	public UpdateState updateDelivery(DeliveryVO delivery) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.UpdateReceiptService#updateEntrucking(VO.EntruckingVO)
	 */
	@Override
	public UpdateState updateEntrucking(EntruckingVO entrucking) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.UpdateReceiptService#updateGathering(VO.GatheringVO)
	 */
	@Override
	public UpdateState updateGathering(GatheringVO gathering) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.UpdateReceiptService#updateRemoval(VO.RemovalVO)
	 */
	@Override
	public UpdateState updateRemoval(RemovalVO removal) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.UpdateReceiptService#updateStorage(VO.StorageVO)
	 */
	@Override
	public UpdateState updateStorage(StorageVO storage) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.UpdateReceiptService#updateTransfer(VO.TransferVO)
	 */
	@Override
	public UpdateState updateTransfer(TransferVO transfer) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
