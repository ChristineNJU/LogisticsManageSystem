package businesslogic.Impl.Courier;

import java.util.ArrayList;

import data.State.AddState;
import data.State.UpdateState;
import businesslogic.Service.Courier.AddLogisticsService;
import businesslogic.Service.Courier.GetAmountService;
import businesslogic.Service.Courier.GetCityService;
import businesslogic.Service.Courier.ReceiveConfirmService;
import businesslogic.State.LogisticsType;
import businesslogic.State.PackingCharge;
import businesslogic.VO.VO;

public class CourierImpl implements AddLogisticsService,GetAmountService,GetCityService,ReceiveConfirmService{

	@Override
	public UpdateState receiveConfirm(VO logistics_info, String field,
			String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getCity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getAmount(String starting, String destination,
			LogisticsType type, PackingCharge charge, double weight,
			double height) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AddState addLogistics(VO logistics_info) {
		// TODO Auto-generated method stub
		return null;
	}

}
