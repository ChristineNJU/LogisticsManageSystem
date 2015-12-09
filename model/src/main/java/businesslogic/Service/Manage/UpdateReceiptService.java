package businesslogic.Service.Manage;

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

// TODO: Auto-generated Javadoc
/**
 * The Interface UpdateReceiptService.
 */
public interface UpdateReceiptService {
	
	/**
	 * Update receipt.
	 *
	 * @param receipt the receipt
	 * @return the update state
	 */
	public UpdateState updateReceipt(VO receipt);
	
	/**
	 * 更新arrival.
	 *
	 * @param arrival the arrival
	 * @return the update state
	 */
	public UpdateState updateArrival(ArrivalVO arrival);
	
	/**
	 * 更新balance.
	 *
	 * @param balance the balance
	 * @return the update state
	 */
	public UpdateState updateBalance(BalanceVO balance);
	
	/**
	 * 更新cost.
	 *
	 * @param cost the cost
	 * @return the update state
	 */
	public UpdateState updateCost(CostVO cost);
	
	/**
	 * 更新delivery .
	 *
	 * @param delivery the delivery
	 * @return the update state
	 */
	public UpdateState updateDelivery(DeliveryVO delivery);
	
	/**
	 * 更新entrucking.
	 *
	 * @param entrucking the entrucking
	 * @return the update state
	 */
	public UpdateState updateEntrucking(EntruckingVO entrucking);
	
	/**
	 * 更新gathering.
	 *
	 * @param gathering the gathering
	 * @return the update state
	 */
	public UpdateState updateGathering(GatheringVO gathering);
	
	/**
	 * 更新removal.
	 *
	 * @param removal the removal
	 * @return the update state
	 */
	public UpdateState updateRemoval(RemovalVO removal);
	
	
	/**
	 * 更新storage.
	 *
	 * @param storage the storage
	 * @return the update state
	 */
	public UpdateState updateStorage(StorageVO storage);
	
	
	/**
	 * 更新transfer.
	 *
	 * @param transfer the transfer
	 * @return the update state
	 */
	public UpdateState updateTransfer(TransferVO transfer);
	
}
