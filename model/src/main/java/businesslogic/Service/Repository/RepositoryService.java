package businesslogic.Service.Repository;

import java.util.ArrayList;

import PO.WareHousePO;
import State.AddState;
import State.OutputState;
import State.StorageState;
import VO.BalanceVO;
import VO.RemovalVO;
import VO.StockTakingVO;
import VO.StorageVO;
import VO.VO;

// TODO: Auto-generated Javadoc
/**
 * 仓库管理接口.
 *
 * @author 张馨中
 * @version 1.0.0
 */
public interface RepositoryService {
	
	/**
	 * 库存报警.
	 *
	 * @return 是否报警
	 */
	public boolean alarm();
	
	/**
	 * 添加库存调整单.
	 *
	 * @param balance 调整信息VO
	 * @return 添加状态
	 */
	public AddState addBalance(ArrayList<BalanceVO> balance);
	
	/**
	 * 获取需要出库的快递.
	 *
	 * @param destination 去向
	 * @return RemovalVO的ArrayList
	 */
	public ArrayList<RemovalVO> getNeedRemoval(String destination);
	
	/**
	 * 获取需要入库的快递.
	 *
	 * @param destination 去向
	 * @return StorageVO的ArrayList
	 */
	public ArrayList<StorageVO> getNeedStorage(String destination);
	
	/**
	 * 添加出库单.
	 *
	 * @param re RemovalVO的ArrayList
	 * @return 返回添加状态
	 */
	public AddState addRemoval(ArrayList<RemovalVO> re);
	
	/**
	 * 获取出库单.
	 *
	 * @param time_start 起始时间
	 * @param time_end 截止时间
	 * @return RemovalVO的ArrayList
	 */
	public ArrayList<RemovalVO> seeRemoval(String time_start, String time_end);
	
	/**
	 * 获取入库单.
	 *
	 * @param time_start 起始时间
	 * @param time_end 截止时间
	 * @return StorageVO的ArrayList
	 */
	public ArrayList<StorageVO> seeStorage(String time_start, String time_end);
	
	/**
	 * 添加出库单.
	 *
	 * @param stockList StockTakingVO的ArrayList
	 * @return 返回添加状态
	 */
	public AddState stockTakingConfirm(ArrayList<StockTakingVO> stockList);
	
	/**
	 * 导出库存盘点表格.
	 *
	 * @param stockTaking the stock taking
	 * @return 返回导出状态
	 */
	public OutputState stockTakingExcel(ArrayList<StockTakingVO> stockTaking);
	
	/**
	 * 获取库存盘点信息.
	 *
	 * @return StockTakingVO的ArrayList
	 */
	public ArrayList<StockTakingVO> getStockTaking();
	
	/**
	 * 获取入库单.
	 *
	 * @param storage StorageVO的ArrayList
	 * @return 返回导出状态
	 */
	public StorageState storage(ArrayList<StorageVO> storage);
	
}
