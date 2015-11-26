package businesslogic.Impl.Courier;

import java.util.ArrayList;

import State.AddState;
import State.LogisticsType;
import State.PackingCharge;
import State.UpdateState;
import VO.VO;
import businesslogic.Service.Courier.CourierService;

public class CourierController implements CourierService{
	
	
	
	@Override
	public UpdateState receiveConfirm(VO logistics_info) {
		// TODO Auto-generated method stub
		
		CourierImpl courier=new CourierImpl();
		return courier.receiveConfirm(logistics_info);
		
	}

	@Override
	public ArrayList<String> getCity() {
		// TODO Auto-generated method stub
		CourierImpl courier=new CourierImpl();
		return courier.getCity();
	}

	@Override
	public double getAmount(String starting, String destination,
			LogisticsType type, PackingCharge charge, double weight,
			double size) {
		// TODO Auto-generated method stub
		CourierImpl courier=new CourierImpl();
		return courier.getAmount(starting, destination, type, charge, weight, size);
	}

	@Override
	public AddState addLogistics(VO logistics_info) {
		// TODO Auto-generated method stub
		CourierImpl courier=new CourierImpl();
		return courier.addLogistics(logistics_info);
	}
	
}
