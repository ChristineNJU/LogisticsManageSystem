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

public interface ReponsitoryService {
	
	public boolean alarm();
	public AddState addBalance(ArrayList<BalanceVO> balance);
	public ArrayList<RemovalVO> getNeedRemoval(String destination);
	public ArrayList<StorageVO> getNeedStorage(String destination);
	public AddState addRemoval(ArrayList<RemovalVO> re);
	public ArrayList<RemovalVO> seeRemoval(String time_start, String time_end);
	public ArrayList<StorageVO> seeStorage(String time_start, String time_end);
	public AddState stockTakingConfirm(ArrayList<StockTakingVO> stockList);
	public OutputState stockTakingExcel();
	public ArrayList<StockTakingVO> getStockTaking(ArrayList<WareHousePO> repository);
	public StorageState storage(ArrayList<StorageVO> storage);
	
}
