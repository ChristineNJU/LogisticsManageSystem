package businesslogic.Service.MediumCenter;

import java.util.ArrayList;

import VO.ArrivalVO;
import VO.EntruckingVO;
import VO.TransferVO;
import data.State.AddState;

public interface MCService {
	
	public AddState arrival(ArrayList<ArrivalVO> arrival);
	public AddState entrucking(EntruckingVO entrucking);
	public ArrayList<String> getNeedEntrucking();
	public ArrayList<String> getNeedTransfer();
	public AddState transfer(TransferVO transfer);
}
