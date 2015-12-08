package businesslogic.Impl.Manage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.ArrivalPO;
import PO.BalancePO;
import PO.CostPO;
import PO.DeliveryPO;
import PO.EntruckingPO;
import PO.GatheringPO;
import PO.InstitutionPO;
import PO.RemovalPO;
import PO.StoragePO;
import PO.TransferPO;
import VO.ArrivalVO;
import VO.BalanceVO;
import VO.CostVO;
import VO.DeliveryVO;
import VO.EntruckingVO;
import VO.GatheringVO;
import VO.RemovalVO;
import VO.StorageVO;
import VO.TransferVO;
import businesslogic.Service.Manage.ShowReceiptService;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchArrivalService;
import data.Service.Search.SearchBalanceService;
import data.Service.Search.SearchCostService;
import data.Service.Search.SearchDeliveryService;
import data.Service.Search.SearchEntruckingService;
import data.Service.Search.SearchGatheringService;
import data.Service.Search.SearchInstitutionInfoService;
import data.Service.Search.SearchRemovalService;
import data.Service.Search.SearchStorageService;
import data.Service.Search.SearchTransferService;

public class ManageShowReceipt implements ShowReceiptService{
	
	
	/**
	 * show transfer
	 * @return ArrayList<TransferVO>
	 */
	
	@Override
	public ArrayList<TransferVO> showTransfer() {
		// TODO Auto-generated method stub
		ArrayList<TransferVO> result = new ArrayList<TransferVO>();
		
		try {
			SearchTransferService searchTransfer=(SearchTransferService) Naming.lookup(RMIHelper.SEARCH_TRANSFER_IMPL);
			
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("isApproved='"+false+"'");
			
			ArrayList<String> requirementMediumCenter=new ArrayList<String>();
			requirementMediumCenter.add("institution_type='Mediuncenter'");
			
			SearchInstitutionInfoService searchInstitution=(SearchInstitutionInfoService) Naming.lookup(RMIHelper.SEARCH_INSTITUTION_IMPL);
			ArrayList<InstitutionPO> searchResultMediumCenter=searchInstitution.searchInstitutionInfo(requirementMediumCenter);
			
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
			e.printStackTrace();
		}
		
		
		
		return result;
	}

	/**
	 * show storage
	 * @return ArrayList<StorageVO>
	 */
	@Override
	public ArrayList<StorageVO> showStorage() {
		// TODO Auto-generated method stub
		ArrayList<StorageVO> result = new ArrayList<StorageVO>();
		
		try {
			SearchStorageService searchStorage=(SearchStorageService) Naming.lookup(RMIHelper.SEARCH_STORAGE_IMPL);
		
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("isApproved='"+false+"'");
			
			ArrayList<String> requirementReponsitory=new ArrayList<String>();
			requirementReponsitory.add("institution_type='Reponsitory'");
			
			SearchInstitutionInfoService searchInstitution=(SearchInstitutionInfoService) Naming.lookup(RMIHelper.SEARCH_INSTITUTION_IMPL);
			ArrayList<InstitutionPO> searchResultReponsitory=searchInstitution.searchInstitutionInfo(requirementReponsitory);
			
			for(int i=0;i<searchResultReponsitory.size();i++){
				ArrayList<StoragePO> storageResult=searchStorage.searchStorage(URLHelper.getStorageURL(searchResultReponsitory.get(i).getInstitutionNumber()), requirement);
				if(!storageResult.isEmpty()){
					for(int j=0;j<storageResult.size();j++){
						StorageVO temp=new StorageVO(storageResult.get(j));
						result.add(temp);
					}
				}
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	/**
	 * show Removal
	 * @return ArrayList<RemovalVO>
	 */
	@Override
	public ArrayList<RemovalVO> showRemoval() {
		// TODO Auto-generated method stub
		ArrayList<RemovalVO> result = new ArrayList<RemovalVO>();
		try {
			SearchRemovalService searchRemoval=(SearchRemovalService) Naming.lookup(RMIHelper.SEARCH_REMOVAL_IMPL);
		
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("isApproved='"+false+"'");
			
			ArrayList<String> requirementReponsitory=new ArrayList<String>();
			requirementReponsitory.add("institution_type='Reponsitory'");
			
			SearchInstitutionInfoService searchInstitution=(SearchInstitutionInfoService) Naming.lookup(RMIHelper.SEARCH_INSTITUTION_IMPL);
			ArrayList<InstitutionPO> searchResultReponsitory=searchInstitution.searchInstitutionInfo(requirementReponsitory);
			
			for(int i=0;i<searchResultReponsitory.size();i++){
				ArrayList<RemovalPO> removalResult=searchRemoval.searchRemoval(URLHelper.getRemovalURL(searchResultReponsitory.get(i).getInstitutionNumber()), requirement);
				if(!removalResult.isEmpty()){
					for(int j=0;j<removalResult.size();j++){
						RemovalVO temp=new RemovalVO(removalResult.get(j));
						result.add(temp);
					}
				}
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	/**
	 * show gathering
	 * @return ArrayList<GatheringVO>
	 */
	@Override
	public ArrayList<GatheringVO> showGathering() {
		// TODO Auto-generated method stub
		ArrayList<GatheringVO> result = new ArrayList<GatheringVO>();
		
		try {
			SearchGatheringService searchGathering=(SearchGatheringService) Naming.lookup(RMIHelper.SEARCH_GATHERING_IMPL);
		
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("isApproved='"+false+"'");
			
			ArrayList<String> requirementBusinesslobby=new ArrayList<String>();
			requirementBusinesslobby.add("institution_type='BusinessLobby'");
			
			SearchInstitutionInfoService searchInstitution=(SearchInstitutionInfoService) Naming.lookup(RMIHelper.SEARCH_INSTITUTION_IMPL);
			ArrayList<InstitutionPO> searchResultBusinesslobby=searchInstitution.searchInstitutionInfo(requirementBusinesslobby);
			
			for(int i=0;i<searchResultBusinesslobby.size();i++){
				ArrayList<GatheringPO> gatheringResult=searchGathering.searchGathering(URLHelper.getGatheringURL(searchResultBusinesslobby.get(i).getInstitutionNumber()), requirement);
				if(!gatheringResult.isEmpty()){
					for(int j=0;j<gatheringResult.size();j++){
						GatheringVO temp=new GatheringVO(gatheringResult.get(j));
						result.add(temp);
					}
				}
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	/**
	 * show entrucking
	 * @return ArrayList<EntruckingVO>
	 */
	@Override
	public ArrayList<EntruckingVO> showEntrucking() {
		// TODO Auto-generated method stub
		ArrayList<EntruckingVO> result = new ArrayList<EntruckingVO>();
		
		try {
			SearchEntruckingService searchEntrucking=(SearchEntruckingService) Naming.lookup(RMIHelper.SEARCH_ENTRUCKING_IMPL);
			
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("isApproved='"+false+"'");
			
			ArrayList<String> requirementBusinesslobby=new ArrayList<String>();
			requirementBusinesslobby.add("institution_type='BusinessLobby'");
			
			ArrayList<String> requirementMediumCenter=new ArrayList<String>();
			requirementMediumCenter.add("institution_type='Mediuncenter'");		
		
			SearchInstitutionInfoService searchInstitution=(SearchInstitutionInfoService) Naming.lookup(RMIHelper.SEARCH_INSTITUTION_IMPL);
			ArrayList<InstitutionPO> searchResultBusinesslobby=searchInstitution.searchInstitutionInfo(requirementBusinesslobby);
			ArrayList<InstitutionPO> searchResultMediumCenter=searchInstitution.searchInstitutionInfo(requirementMediumCenter);
			
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
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	/**
	 * show delivery
	 * @return ArrayList<deliveryVO>
	 */
	@Override
	public ArrayList<DeliveryVO> showDelivery() {
		// TODO Auto-generated method stub
		ArrayList<DeliveryVO> result = new ArrayList<DeliveryVO>();
		
		try {
			SearchDeliveryService searchDelivery=(SearchDeliveryService) Naming.lookup(RMIHelper.SEARCH_DELIVERY_SERVICE);

			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("isApproved='"+false+"'");
			
			ArrayList<String> requirementBusinesslobby=new ArrayList<String>();
			requirementBusinesslobby.add("institution_type='BusinessLobby'");
			
			SearchInstitutionInfoService searchInstitution=(SearchInstitutionInfoService) Naming.lookup(RMIHelper.SEARCH_INSTITUTION_IMPL);
			ArrayList<InstitutionPO> searchResultBusinesslobby=searchInstitution.searchInstitutionInfo(requirementBusinesslobby);
			
			for(int i=0;i<searchResultBusinesslobby.size();i++){
				ArrayList<DeliveryPO> deliveryResult=searchDelivery.searchDelivery(URLHelper.getDeliveryURL(searchResultBusinesslobby.get(i).getInstitutionNumber()), requirement);
				if(!deliveryResult.isEmpty()){
					for(int j=0;j<deliveryResult.size();j++){
						DeliveryVO temp=new DeliveryVO(deliveryResult.get(j));
						result.add(temp);
					}
				}
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	/**
	 * show cost
	 * @return ArrayList<CostVO>
	 */
	@Override
	public ArrayList<CostVO> showCost() {
		// TODO Auto-generated method stub
		ArrayList<CostVO> result = new ArrayList<CostVO>();
	try {	
		SearchCostService searchCost=(SearchCostService) Naming.lookup(RMIHelper.SEARCH_COST_IMPL);
		
		ArrayList<String> requirement=new ArrayList<String>();
		requirement.add("isApproved='"+false+"'");
		
		
		ArrayList<CostPO> costResult = searchCost.searchCost(requirement);
			if(!costResult.isEmpty()){
				for(int i=0;i<costResult.size();i++){
					CostVO temp=new CostVO(costResult.get(i));
					result.add(temp);
			}
		}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	/**
	 * show balance
	 * @return ArrayList<BalanceVO>
	 */
	@Override
	public ArrayList<BalanceVO> showBalance() {
		// TODO Auto-generated method stub
		ArrayList<BalanceVO> result = new ArrayList<BalanceVO>();
		try {
			SearchBalanceService searchBalance=(SearchBalanceService) Naming.lookup(RMIHelper.SEARCH_BALANCE_IMPL);
		
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("isApproved='"+false+"'");
			
			ArrayList<String> requirementReponsitory=new ArrayList<String>();
			requirementReponsitory.add("institution_type='Reponsitory'");
			
			SearchInstitutionInfoService searchInstitution=(SearchInstitutionInfoService) Naming.lookup(RMIHelper.SEARCH_INSTITUTION_IMPL);
			ArrayList<InstitutionPO> searchResultReponsitory=searchInstitution.searchInstitutionInfo(requirementReponsitory);
			
			for(int i=0;i<searchResultReponsitory.size();i++){
				ArrayList<BalancePO> balanceResult=searchBalance.searchBalannce(URLHelper.getBalanceURL(searchResultReponsitory.get(i).getInstitutionNumber()), requirement);
				if(!balanceResult.isEmpty()){
					for(int j=0;j<balanceResult.size();j++){
						BalanceVO temp=new BalanceVO(balanceResult.get(j));
						result.add(temp);
					}
				}
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	
	/**
	 *show arrival
	 *@return ArrayList<ArrivalVO>
	 */
	@Override
	public ArrayList<ArrivalVO> showArrival() {
		// TODO Auto-generated method stub
		ArrayList<ArrivalVO> result = new ArrayList<ArrivalVO>();
		try {
			SearchArrivalService searchArrival=(SearchArrivalService) Naming.lookup(RMIHelper.SEARCH_ARRIVAL_IMPL);
		
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("isApproved='"+false+"'");
			
			ArrayList<String> requirementBusinesslobby=new ArrayList<String>();
			requirementBusinesslobby.add("institution_type='BusinessLobby'");
			
			ArrayList<String> requirementMediumCenter=new ArrayList<String>();
			requirementMediumCenter.add("institution_type='Mediuncenter'");
			
			SearchInstitutionInfoService searchInstitution=(SearchInstitutionInfoService) Naming.lookup(RMIHelper.SEARCH_INSTITUTION_IMPL);
			ArrayList<InstitutionPO> searchResultBusinesslobby=searchInstitution.searchInstitutionInfo(requirementBusinesslobby);
			ArrayList<InstitutionPO> searchResultMediumCenter=searchInstitution.searchInstitutionInfo(requirementMediumCenter);
			
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
			
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
