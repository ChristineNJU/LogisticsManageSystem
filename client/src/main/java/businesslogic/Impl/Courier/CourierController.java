package businesslogic.Impl.Courier;

import java.util.ArrayList;

import State.AddState;
import State.CodeState;
import State.LogisticsType;
import State.PackingCharge;
import State.UpdateState;
import VO.VO;
import businesslogic.Service.Courier.CourierService;
import businesslogic.SystemLog.SystemLog;

// TODO: Auto-generated Javadoc
/**
 * The Class CourierController.
 */
public class CourierController implements CourierService{
	
	
	
	/* (non-Javadoc)
	 * @see businesslogic.Service.Courier.CourierService#receiveConfirm(VO.VO)
	 */
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

	/* (non-Javadoc)
	 * @see businesslogic.Service.Courier.CourierService#getCity()
	 */
	@Override
	public ArrayList<String> getCity() {
		// TODO Auto-generated method stub
		CourierImpl courier=new CourierImpl();
		return courier.getCity();
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Courier.CourierService#getAmount(java.lang.String, java.lang.String, State.LogisticsType, State.PackingCharge, double, double)
	 */
	@Override
	public double getAmount(String starting, String destination,
			LogisticsType type, PackingCharge charge, double weight,
			double size) {
		// TODO Auto-generated method stub
		CourierImpl courier=new CourierImpl();
		return courier.getAmount(starting, destination, type, charge, weight, size);
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Courier.CourierService#addLogistics(VO.VO)
	 */
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

	/* (non-Javadoc)
	 * @see businesslogic.Service.Courier.CourierService#getDayLength(java.lang.String, java.lang.String)
	 */
	@Override
	public double getDayLength(String starting, String destination) {
		// TODO Auto-generated method stub
		CourierImpl courier=new CourierImpl();
		return courier.getDayLength(starting, destination);
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Courier.CourierService#isLegal(java.lang.String)
	 */
	@Override
	public CodeState isLegal(String bar_code) {
		// TODO Auto-generated method stub
		CourierImpl courier=new CourierImpl();
		return courier.isLegal(bar_code);
	}
	
}
