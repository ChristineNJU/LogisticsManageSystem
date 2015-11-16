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

public class CourierController implements AddLogisticsService, GetAmountService, GetCityService, ReceiveConfirmService{
	
	
	
	@Override
	public UpdateState receiveConfirm(VO logistics_info, String field,
			String value) {
		// TODO Auto-generated method stub
		
		ReceiveConfirmImpl receiveConfirm=new ReceiveConfirmImpl();
		return receiveConfirm.receiveConfirm(logistics_info, field, value);
		
	}

	@Override
	public ArrayList<String> getCity() {
		// TODO Auto-generated method stub
		GetCityImpl getCity=new GetCityImpl();
		return getCity.getCity();
	}

	@Override
	public double getAmount(String starting, String destination,
			LogisticsType type, PackingCharge charge, double weight,
			double size) {
		// TODO Auto-generated method stub
		GetAmountImpl getAmount=new GetAmountImpl();
		return getAmount.getAmount(starting, destination, type, charge, weight, size);
	}

	@Override
	public AddState addLogistics(VO logistics_info) {
		// TODO Auto-generated method stub
		AddLogisticsImpl addLogistics=new AddLogisticsImpl();
		return addLogistics.addLogistics(logistics_info);
	}
	
}
