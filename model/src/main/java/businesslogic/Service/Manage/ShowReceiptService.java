package businesslogic.Service.Manage;

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

// TODO: Auto-generated Javadoc
/**
 * The Interface ShowReceiptService.
 */
public interface ShowReceiptService {

	/**
	 * 显示未评审ArrivalVO.
	 *
	 * @return ArrayList<ArrivalVO>
	 */
	public ArrayList<ArrivalVO> showArrival();
	
	/**
	 * 显示未评审BalanceVO.
	 *
	 * @return ArrayList<ArrivalVO>
	 */
	public ArrayList<BalanceVO> showBalance();
	
	/**
	 * 显示未评审CostVO.
	 *
	 * @return ArrayList<CostVO>
	 */
	public ArrayList<CostVO> showCost();
	
	/**
	 * 显示未评审DeliveryVO.
	 *
	 * @return ArrayList<DeliveryVO>
	 */
	public ArrayList<DeliveryVO> showDelivery();
	
	/**
	 * 显示未评审EntruckingVO.
	 *
	 * @return ArrayList<EntruckingVO>
	 */
	public ArrayList<EntruckingVO> showEntrucking();
	
	/**
	 * 显示未评审GatheringVO.
	 *
	 * @return ArrayList<GatheringVO>
	 */
	public ArrayList<GatheringVO> showGathering();
	
	/**
	 * 显示未评审RemovalVO.
	 *
	 * @return ArrayList<RemovalVO>
	 */
	public ArrayList<RemovalVO> showRemoval();
	
	/**
	 * 显示未评审StorageVO.
	 *
	 * @return ArrayList<StorageVO>
	 */
	public ArrayList<StorageVO> showStorage();
	
	/**
	 * 显示未评审TransferVO.
	 *
	 * @return ArrayList<TransferVO>
	 */
	public ArrayList<TransferVO> showTransfer();
	
	
}
