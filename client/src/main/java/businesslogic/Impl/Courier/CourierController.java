package businesslogic.Impl.Courier;

import java.util.ArrayList;

import State.AddState;
import State.LogisticsType;
import State.PackingCharge;
import State.UpdateState;
import VO.VO;
import businesslogic.Service.Courier.CourierService;
import businesslogic.SystemLog.SystemLog;

public class CourierController implements CourierService{
	
	
	
	@Override
	public UpdateState receiveConfirm(VO logistics_info) {
		// TODO Auto-generated method stub
		
		CourierImpl courier=new CourierImpl();
		UpdateState state = courier.receiveConfirm(logistics_info);
		if(state==UpdateState.SUCCESS){
			SystemLog.addLog("更新收件信息");
		}
		return state;
		
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
		AddState state = courier.addLogistics(logistics_info);
		if(state==AddState.SUCCESS){
			SystemLog.addLog("添加快递信息");
		}
		return state;
	}

	@Override
	public double getDayLength(String starting, String destination) {
		// TODO Auto-generated method stub
		CourierImpl courier=new CourierImpl();
		
		return 0;
	}
	
}
