package businesslogic.Service.Courier;

import java.util.ArrayList;

import businesslogic.State.LogisticsType;
import businesslogic.State.PackingCharge;
import VO.VO;
import data.State.AddState;
import data.State.UpdateState;

public interface CourierService {
	
	public AddState addLogistics(VO logistics_info);
	public double getAmount(String starting, String destination, 
			LogisticsType type, PackingCharge charge, double weight, double height);
	public ArrayList<String> getCity();
	public UpdateState receiveConfirm(VO logistics_info, String field, String value);
}
