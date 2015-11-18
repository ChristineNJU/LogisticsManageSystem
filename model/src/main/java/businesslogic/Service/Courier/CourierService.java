package businesslogic.Service.Courier;

import java.util.ArrayList;

import State.AddState;
import State.LogisticsType;
import State.PackingCharge;
import State.UpdateState;
import VO.VO;

public interface CourierService {
	
	public AddState addLogistics(VO logistics_info);
	public double getAmount(String starting, String destination, 
			LogisticsType type, PackingCharge charge, double weight, double height);
	public ArrayList<String> getCity();
	public UpdateState receiveConfirm(VO logistics_info, String field, String value);
}
