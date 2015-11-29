package businesslogic.Impl.Manage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.ArrivalPO;
import PO.BalancePO;
import PO.BenefitPO;
import PO.CostPO;
import PO.DeliveryPO;
import PO.EntruckingPO;
import PO.GatheringPO;
import PO.InstitutionPO;
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
import VO.RemovalVO;
import VO.StorageVO;
import VO.TransferVO;
import VO.VO;
import businesslogic.Service.Manage.ShowReceiptService;
import businesslogic.Service.Manage.UpdateReceiptService;
import businesslogic.SystemLog.SystemLog;
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
import data.Service.Search.SearchRemovalService;
import data.Service.Search.SearchStorageService;
import data.Service.Search.SearchTransferService;
import data.Service.Update.UpdateService;

public class ManageReceipt implements ShowReceiptService, UpdateReceiptService{

	@Override
	public UpdateState updateReceipt(VO receipt) {
		// TODO Auto-generated method stub
		UpdateState result=UpdateState.NOTFOUND;
		try {
			UpdateService updateService=(UpdateService) Naming.lookup(RMIHelper.UPDATE_IMPL);
			
			ArrayList<String> requirement=new ArrayList<String>();
			
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
			
			System.out.println(searchResultBusinesslobby.get(0).getInstitutionNumber());
			System.out.println(searchResultMediumCenter.get(0).getInstitutionNumber());
			System.out.println(searchResultReponsitory.get(0).getInstitutionNumber());
			//arrival
			if(receipt instanceof ArrivalVO){
				
				ArrivalVO arrival=(ArrivalVO) receipt;
				SearchArrivalService searchArrival=(SearchArrivalService) Naming.lookup(RMIHelper.SEARCH_ARRIVAL_IMPL);
				requirement.add("barCode='"+arrival.getBarCode()+"'");
				ArrayList<ArrivalPO> searchResult=new ArrayList<ArrivalPO>();
				for(int i=0;i<searchResultBusinesslobby.size();i++){
					//String r = URLHelper.getArrivalURL(searchResultBusinesslobby.get(i).getInstitutionNumber());
					//System.out.println(r);
					ArrayList<ArrivalPO> arrivalResult=searchArrival.searchArrival(searchResultBusinesslobby.get(0).getInstitutionNumber(), requirement);
					//System.out.println(searchResultBusinesslobby.size());
					for(int j=0;j<arrivalResult.size();j++)
						searchResult.add(arrivalResult.get(j));	
				}
//				for(int i=0;i<searchResultMediumCenter.size();i++){
//					ArrayList<ArrivalPO> arrivalResult=searchArrival.searchArrival(URLHelper.getArrivalURL(searchResultMediumCenter.get(i).getInstitutionNumber()), requirement);
//					for(int j=0;j<arrivalResult.size();j++)
//						searchResult.add(arrivalResult.get(j));	
//				}
				
				if(!searchResult.isEmpty()){
					System.out.println("not found");
					return UpdateState.NOTFOUND;
				}
				else{
					ArrivalPO temp=new ArrivalPO((ArrivalVO)receipt,SystemLog.getInstitutionId());
					temp.setApproved(true);
					result=updateService.update(temp);
				}
			}
			
			//balance
			if(receipt instanceof BalanceVO){
				BalanceVO balance=(BalanceVO) receipt;
				SearchBalanceService searchBalance=(SearchBalanceService) Naming.lookup(RMIHelper.SEARCH_BALANCE_IMPL);
				requirement.add("barCode='"+balance.getBarCode()+"'");
				ArrayList<BalancePO> searchResult=new ArrayList<BalancePO>();
				for(int i=0;i<searchResultReponsitory.size();i++){
					ArrayList<BalancePO> balanceResult=searchBalance.searchBalannce(URLHelper.getBalanceURL(searchResultReponsitory.get(i).getInstitutionNumber()), requirement);
					for(int j=0;j<balanceResult.size();j++)
						searchResult.add(balanceResult.get(j));
				}
				
				if(!searchResult.isEmpty()){
					System.out.println("not found");
					return UpdateState.NOTFOUND;
				}
				else{
					BalancePO temp=new BalancePO((BalanceVO)receipt, SystemLog.getInstitutionId());
					temp.setApproved(true);
					result=updateService.update(temp);
					
				}
			}
			
			//Cost
			if(receipt instanceof CostVO){
				CostVO cost=(CostVO) receipt;
				SearchCostService searchCost=(SearchCostService) Naming.lookup(RMIHelper.SEARCH_COST_IMPL);
				requirement.add("date='"+cost.getDate()+"'");
				ArrayList<CostPO> searchResult=searchCost.searchCost(requirement);
				
				if(!searchResult.isEmpty()){
					System.out.println("not found");
					return UpdateState.NOTFOUND;
				}
				else{
					CostPO temp=new CostPO((CostVO) receipt);
					temp.setApproved(true);
					result=updateService.update(temp);
					
				}
				
				
				SearchBenefitService searchBenefit=(SearchBenefitService) Naming.lookup(RMIHelper.SEARCH_BENEFIT_IMPL);
				ArrayList<String> requireBenefit=new ArrayList<String>();
				requireBenefit.add("date like '%%'");
				ArrayList<BenefitPO> searchResultBenefit=searchBenefit.searchBenefit(requireBenefit);
				AddService addService=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
				BenefitPO benefit=new BenefitPO(cost, searchResultBenefit.get(searchResultBenefit.size()));
				addService.add(benefit);
			}
			
			//Delivery
			if(receipt instanceof DeliveryVO){
				DeliveryVO delivery=(DeliveryVO) receipt;
				SearchDeliveryService searchDelivery=(SearchDeliveryService) Naming.lookup(RMIHelper.SEARCH_DELIVERY_SERVICE);
				requirement.add("arrivalDate='"+delivery.getArrivalDate()+"'");
				ArrayList<DeliveryPO> searchResult=new ArrayList<DeliveryPO>();
				for(int i=0;i<searchResultBusinesslobby.size();i++){
					ArrayList<DeliveryPO> deliveryResult=searchDelivery.searchDelivery(URLHelper.getDeliveryURL(searchResultBusinesslobby.get(i).getInstitutionNumber()), requirement);
					for(int j=0;j<deliveryResult.size();j++)
						searchResult.add(deliveryResult.get(j));	
				}
				for(int i=0;i<searchResultMediumCenter.size();i++){
					ArrayList<DeliveryPO> deliveryResult=searchDelivery.searchDelivery(URLHelper.getDeliveryURL(searchResultMediumCenter.get(i).getInstitutionNumber()), requirement);
					for(int j=0;j<deliveryResult.size();j++)
						searchResult.add(deliveryResult.get(j));	
				}
				
				if(!searchResult.isEmpty()){
					System.out.println("not found");
					return UpdateState.NOTFOUND;
				}
				else{
					DeliveryPO temp=new DeliveryPO((DeliveryVO)receipt,SystemLog.getInstitutionId());
					temp.setApproved(true);
					result=updateService.update(temp);
					
				}
			}
			
			
			//entrucking
			if(receipt instanceof EntruckingVO){
				EntruckingVO entrucking=(EntruckingVO) receipt;
				SearchEntruckingService searchEntrucking=(SearchEntruckingService) Naming.lookup(RMIHelper.SEARCH_ENTRUCKING_IMPL);
				requirement.add("date='"+entrucking.getDate()+"'");
				ArrayList<EntruckingPO> searchResult=new ArrayList<EntruckingPO>();
				for(int i=0;i<searchResultBusinesslobby.size();i++){
					ArrayList<EntruckingPO> entruckingResult=searchEntrucking.searchEntrucking(URLHelper.getEntruckingURL(searchResultBusinesslobby.get(i).getInstitutionNumber()), requirement);
					for(int j=0;j<entruckingResult.size();j++)
						searchResult.add(entruckingResult.get(j));	
				}
				for(int i=0;i<searchResultMediumCenter.size();i++){
					ArrayList<EntruckingPO> entruckingResult=searchEntrucking.searchEntrucking(URLHelper.getEntruckingURL(searchResultMediumCenter.get(i).getInstitutionNumber()), requirement);
					for(int j=0;j<entruckingResult.size();j++)
						searchResult.add(entruckingResult.get(j));	
				}
				
				if(!searchResult.isEmpty()){
					System.out.println("not found");
					return UpdateState.NOTFOUND;
				}
				else{
					EntruckingPO temp=new EntruckingPO((EntruckingVO)receipt, SystemLog.getInstitutionId());
					temp.setApproved(true);;
					result=updateService.update(temp);
					
				}
			}
			
			//gathering
			if(receipt instanceof GatheringVO){
				GatheringVO gathering=(GatheringVO) receipt;
				SearchGatheringService searchGathering=(SearchGatheringService) Naming.lookup(RMIHelper.SEARCH_GATHERING_IMPL);
				requirement.add("date='"+gathering.getDate()+"'");
				ArrayList<GatheringPO> searchResult=new ArrayList<GatheringPO>();
				for(int i=0;i<searchResultBusinesslobby.size();i++){
					ArrayList<GatheringPO> gatheringResult=searchGathering.searchGathering(URLHelper.getGatheringURL(searchResultBusinesslobby.get(i).getInstitutionNumber()), requirement);
					for(int j=0;j<gatheringResult.size();j++)
						searchResult.add(gatheringResult.get(j));
				}
				
				if(!searchResult.isEmpty()){
					System.out.println("not found");
					return UpdateState.NOTFOUND;
				}
				else{
					GatheringPO temp=new GatheringPO((GatheringVO)receipt,SystemLog.getInstitutionId());
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
				requirement.add("barCode='"+removal.getBarCode()+"'");
				ArrayList<RemovalPO> searchResult=new ArrayList<RemovalPO>();
				for(int i=0;i<searchResultReponsitory.size();i++){
					ArrayList<RemovalPO> removalResult=searchRemoval.searchRemoval(URLHelper.getRemovalURL(searchResultReponsitory.get(i).getInstitutionNumber()), requirement);
					for(int j=0;j<removalResult.size();j++){
						searchResult.add(removalResult.get(j));
					}
				}
				
				if(!searchResult.isEmpty()){
					System.out.println("not found");
					return UpdateState.NOTFOUND;
				}
				else{
					RemovalPO temp=new RemovalPO((RemovalVO)receipt,SystemLog.getInstitutionId());
					temp.setApproved(true);
					result=updateService.update(temp);
					
				}
				
			}
			
			
			//storage
			if(receipt instanceof StorageVO){
				StorageVO storage=(StorageVO) receipt;
				SearchStorageService searchStorage=(SearchStorageService) Naming.lookup(RMIHelper.SEARCH_STORAGE_IMPL);
				requirement.add("barCode='"+storage.getBarCode()+"'");
				ArrayList<StoragePO> searchResult=new ArrayList<StoragePO>();
				for(int i=0;i<searchResultReponsitory.size();i++){
					ArrayList<StoragePO> storageResult=searchStorage.searchStorage(URLHelper.getStorageURL(searchResultReponsitory.get(i).getInstitutionNumber()), requirement);
					for(int j=0;j<storageResult.size();j++)
						searchResult.add(storageResult.get(j));
				}
				
				if(!searchResult.isEmpty()){
					System.out.println("not found");
					return UpdateState.NOTFOUND;
				}
				else{
					StoragePO temp=new StoragePO((StorageVO)receipt,SystemLog.getInstitutionId());
					temp.setApproved(true);
					result=updateService.update(temp);
					
				}
			}
			
		
			//transfer
			if(receipt instanceof TransferVO){
				TransferVO transfer=(TransferVO) receipt;
				SearchTransferService searchTransfer=(SearchTransferService) Naming.lookup(RMIHelper.SEARCH_TRANSFER_IMPL);
				requirement.add("date='"+transfer.getDate()+"'");
				ArrayList<TransferPO> searchResult=new ArrayList<TransferPO>();
				for(int i=0;i<searchResultMediumCenter.size();i++){
					ArrayList<TransferPO> transferResult=searchTransfer.searchTransfer(URLHelper.getTransferURL(searchResultMediumCenter.get(i).getInstitutionNumber()), requirement);
					for(int j=0;j<transferResult.size();j++)
						searchResult.add(transferResult.get(j));
				}

				if(!searchResult.isEmpty()){
					System.out.println("not found");
					return UpdateState.NOTFOUND;
				}
				else{
					TransferPO temp=new TransferPO((TransferVO)receipt,SystemLog.getInstitutionId());
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

	@Override
	public ArrayList<VO> showReceipt() {
		// TODO Auto-generated method stub
		ArrayList<VO> result=new ArrayList<VO>();
		
		try {
			SearchArrivalService searchArrival=(SearchArrivalService) Naming.lookup(RMIHelper.SEARCH_ARRIVAL_IMPL);
			SearchBalanceService searchBalance=(SearchBalanceService) Naming.lookup(RMIHelper.SEARCH_BALANCE_IMPL);
			SearchCostService searchCost=(SearchCostService) Naming.lookup(RMIHelper.SEARCH_COST_IMPL);
			SearchDeliveryService searchDelivery=(SearchDeliveryService) Naming.lookup(RMIHelper.SEARCH_DELIVERY_SERVICE);
			SearchEntruckingService searchEntrucking=(SearchEntruckingService) Naming.lookup(RMIHelper.SEARCH_ENTRUCKING_IMPL);
			SearchGatheringService searchGathering=(SearchGatheringService) Naming.lookup(RMIHelper.SEARCH_GATHERING_IMPL);
			SearchRemovalService searchRemoval=(SearchRemovalService) Naming.lookup(RMIHelper.SEARCH_REMOVAL_IMPL);
			SearchStorageService searchStorage=(SearchStorageService) Naming.lookup(RMIHelper.SEARCH_STORAGE_IMPL);
			SearchTransferService searchTransfer=(SearchTransferService) Naming.lookup(RMIHelper.SEARCH_TRANSFER_IMPL);
			
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("isApproved='"+false+"'");
			
			ArrayList<String> requirementBusinesslobby=new ArrayList<String>();
			requirementBusinesslobby.add("institution_type='BusinessLobby'");
			
			ArrayList<String> requirementReponsitory=new ArrayList<String>();
			requirementReponsitory.add("institution_type='Reponsitory'");
			
			ArrayList<String> requirementMediumCenter=new ArrayList<String>();
			requirementMediumCenter.add("institution_type='Mediuncenter'");
			
			SearchInstitutionInfoService searchInstitution=(SearchInstitutionInfoService) Naming.lookup(RMIHelper.SEARCH_INSTITUTION_IMPL);
			ArrayList<InstitutionPO> searchResultBusinesslobby=searchInstitution.searchInstitutionInfo(requirementBusinesslobby);
			ArrayList<InstitutionPO> searchResultReponsitory=searchInstitution.searchInstitutionInfo(requirementReponsitory);
			ArrayList<InstitutionPO> searchResultMediumCenter=searchInstitution.searchInstitutionInfo(requirementMediumCenter);
			
			//arrival
			for(int i=0;i<searchResultBusinesslobby.size();i++){
				ArrayList<ArrivalPO> arrivalResult=searchArrival.searchArrival(URLHelper.getArrivalURL(searchResultBusinesslobby.get(i).getInstitutionNumber()), requirement);
				if(!arrivalResult.isEmpty()){
					for(int j=0;j<arrivalResult.size();j++){
						ArrivalVO temp=new ArrivalVO(arrivalResult.get(j));
						result.add(temp);
					}
				}
			}
			for(int i=0;i<searchResultMediumCenter.size();i++){
				ArrayList<ArrivalPO> arrivalResult=searchArrival.searchArrival(URLHelper.getArrivalURL(searchResultMediumCenter.get(i).getInstitutionNumber()), requirement);
				if(!arrivalResult.isEmpty()){
					for(int j=0;j<arrivalResult.size();j++){
						ArrivalVO temp=new ArrivalVO(arrivalResult.get(j));
						result.add(temp);
					}
				}
			}
			
			
			//Balance
			for(int i=0;i<searchResultReponsitory.size();i++){
				ArrayList<BalancePO> balanceResult=searchBalance.searchBalannce(URLHelper.getBalanceURL(searchResultReponsitory.get(i).getInstitutionNumber()), requirement);
				if(!balanceResult.isEmpty()){
					for(int j=0;j<balanceResult.size();j++){
						BalanceVO temp=new BalanceVO(balanceResult.get(j));
						result.add(temp);
					}
				}
			}
			
			//Cost
			ArrayList<CostPO> costResult=searchCost.searchCost(requirement);
			if(!costResult.isEmpty()){
				for(int i=0;i<costResult.size();i++){
					CostVO temp=new CostVO(costResult.get(i));
					result.add(temp);
				}
			}
			
			//Delivery
			for(int i=0;i<searchResultBusinesslobby.size();i++){
				ArrayList<DeliveryPO> deliveryResult=searchDelivery.searchDelivery(URLHelper.getDeliveryURL(searchResultBusinesslobby.get(i).getInstitutionNumber()), requirement);
				if(!deliveryResult.isEmpty()){
					for(int j=0;j<deliveryResult.size();j++){
						DeliveryVO temp=new DeliveryVO(deliveryResult.get(j));
						result.add(temp);
					}
				}
			}
			
			//Entrucking
			for(int i=0;i<searchResultBusinesslobby.size();i++){
				ArrayList<EntruckingPO> entruckingResult=searchEntrucking.searchEntrucking(URLHelper.getEntruckingURL(searchResultBusinesslobby.get(i).getInstitutionNumber()), requirement);
				if(!entruckingResult.isEmpty()){
					for(int j=0;j<entruckingResult.size();j++){
						EntruckingVO temp=new EntruckingVO(entruckingResult.get(j));
						result.add(temp);
					}
				}
			}
			for(int i=0;i<searchResultMediumCenter.size();i++){
				ArrayList<EntruckingPO> entruckingResult=searchEntrucking.searchEntrucking(URLHelper.getEntruckingURL(searchResultMediumCenter.get(i).getInstitutionNumber()), requirement);
				if(!entruckingResult.isEmpty()){
					for(int j=0;j<entruckingResult.size();j++){
						EntruckingVO temp=new EntruckingVO(entruckingResult.get(j));
						result.add(temp);
					}
				}
			}			
			
			
			//Gathering
			for(int i=0;i<searchResultBusinesslobby.size();i++){
				ArrayList<GatheringPO> gatheringResult=searchGathering.searchGathering(URLHelper.getGatheringURL(searchResultBusinesslobby.get(i).getInstitutionNumber()), requirement);
				if(!gatheringResult.isEmpty()){
					for(int j=0;j<gatheringResult.size();j++){
						GatheringVO temp=new GatheringVO(gatheringResult.get(j));
						result.add(temp);
					}
				}
			}
			
			
			//Removal
			for(int i=0;i<searchResultReponsitory.size();i++){
				ArrayList<RemovalPO> removalResult=searchRemoval.searchRemoval(URLHelper.getRemovalURL(searchResultReponsitory.get(i).getInstitutionNumber()), requirement);
				if(!removalResult.isEmpty()){
					for(int j=0;j<removalResult.size();j++){
						RemovalVO temp=new RemovalVO(removalResult.get(j));
						result.add(temp);
					}
				}
			}
			
			//storage
			for(int i=0;i<searchResultReponsitory.size();i++){
				ArrayList<StoragePO> storageResult=searchStorage.searchStorage(URLHelper.getStorageURL(searchResultReponsitory.get(i).getInstitutionNumber()), requirement);
				if(!storageResult.isEmpty()){
					for(int j=0;j<storageResult.size();j++){
						StorageVO temp=new StorageVO(storageResult.get(j));
						result.add(temp);
					}
				}
			}
			
			//trasfer
			for(int i=0;i<searchResultMediumCenter.size();i++){
				ArrayList<TransferPO> transferResult=searchTransfer.searchTransfer(URLHelper.getTransferURL(searchResultMediumCenter.get(i).getInstitutionNumber()), requirement);
				if(!transferResult.isEmpty()){
					for(int j=0;j<transferResult.size();j++){
						TransferVO temp=new TransferVO(transferResult.get(j));
						result.add(temp);
					}
				}
			}
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
		}
		return result;
	}

}
