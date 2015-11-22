package businesslogic.Impl.Manage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.ArrivalPO;
import State.UpdateState;
import VO.VO;
import businesslogic.Service.Manage.ShowReceiptService;
import businesslogic.Service.Manage.UpdateReceiptService;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchArrivalService;
import data.Service.Search.SearchBalanceService;
import data.Service.Search.SearchCostService;
import data.Service.Search.SearchDeliveryService;
import data.Service.Search.SearchEntruckingService;
import data.Service.Search.SearchGatheringService;
import data.Service.Search.SearchRemovalService;
import data.Service.Search.SearchStorageService;
import data.Service.Search.SearchTransferService;

public class ManageReceipt implements ShowReceiptService, UpdateReceiptService{

	@Override
	public UpdateState updateReceipt(VO receipt) {
		// TODO Auto-generated method stub
		return null;
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
			requirement.add("'isApproved='"+false);
			
			ArrayList<String> requirementInstitution=new ArrayList<String>();
			
			ArrayList<ArrivalPO> arrivalResult=searchArrival.searchArrival(URLHelper.getArrivalURL(institution_id), requirement);
			
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
