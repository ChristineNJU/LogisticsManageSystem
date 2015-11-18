package businesslogic.Service.Reponsitory;

import java.util.ArrayList;

import State.AddState;
import State.OutputState;
import State.StorageState;
import VO.RemovalVO;
import VO.StockTakingVO;
import VO.StorageVO;
import VO.VO;

public interface ReponsitoryService {
	
	public boolean alarm();
	public AddState balance();
	public ArrayList<String> getNeedRemoval();
	public String getNeedStorage();
	public AddState removal(ArrayList<RemovalVO> re);
	public ArrayList<VO> see(String time_start, String time_end);
	public AddState stockTakingConfirm();
	public OutputState stockTakingExcel();
	public ArrayList<StockTakingVO> stockTaking();
	public StorageState storage(ArrayList<StorageVO> storage);
	
}
