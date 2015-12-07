package businesslogic.Impl.Manage;

import java.util.ArrayList;

import VO.ArrivalVO;
import VO.BalanceVO;
import VO.CostVO;
import VO.DeliveryVO;
import VO.EntruckingVO;
import VO.GatheringVO;
import VO.RemovalVO;
import VO.StorageVO;
import VO.TransferVO;
import businesslogic.Service.Manage.ShowArrivalService;
import businesslogic.Service.Manage.ShowBalanceService;
import businesslogic.Service.Manage.ShowCostService;
import businesslogic.Service.Manage.ShowDeliveryService;
import businesslogic.Service.Manage.ShowEntruckingService;
import businesslogic.Service.Manage.ShowGatheringService;
import businesslogic.Service.Manage.ShowRemovalService;
import businesslogic.Service.Manage.ShowStorageService;
import businesslogic.Service.Manage.ShowTransferService;

public class ManageShowReceipt implements ShowArrivalService,ShowBalanceService,ShowCostService,
											ShowDeliveryService,ShowEntruckingService,ShowGatheringService,
											ShowRemovalService,ShowStorageService,ShowTransferService{

	@Override
	public ArrayList<TransferVO> showTransfer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<StorageVO> showStorage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<RemovalVO> showRemoval() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<GatheringVO> showGathering() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<EntruckingVO> showEntrucking() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DeliveryVO> showDelivery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CostVO> showCost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BalanceVO> showBalance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ArrivalVO> showArrival() {
		// TODO Auto-generated method stub
		return null;
	}

}
