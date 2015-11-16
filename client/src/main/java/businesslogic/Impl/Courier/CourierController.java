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
	
	AddLogisticsImpl addLogistics=new AddLogisticsImpl();
	GetAmountImpl getAmount=new GetAmountImpl();
	GetCityImpl getCity=new GetCityImpl();
	ReceiveConfirmImpl receiveConfirm=new ReceiveConfirmImpl();
	
	@Override
	public UpdateState receiveConfirm(VO logistics_info, String field,
			String value) {
		// TODO Auto-generated method stub
		
		return receiveConfirm.receiveConfirm(logistics_info, field, value);
		
	}

	@Override
	public ArrayList<String> getCity() {
		// TODO Auto-generated method stub
		return getCity.getCity();
	}

	@Override
	public double getAmount(String starting, String destination,
			LogisticsType type, PackingCharge charge, double weight,
			double size) {
		// TODO Auto-generated method stub
		return getAmount.getAmount(starting, destination, type, charge, weight, size);
	}

	@Override
	public AddState addLogistics(VO logistics_info) {
		// TODO Auto-generated method stub
		return addLogistics.addLogistics(logistics_info);
	}
	
}
