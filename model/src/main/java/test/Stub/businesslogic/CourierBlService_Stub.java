package test.Stub.businesslogic;

import java.rmi.RemoteException;
import java.util.ArrayList;

import test.Stub.data.AddService_Stub;
import test.Stub.data.UpdateService_Stub;
import PO.LogisticsInfoPO;
import State.AddState;
import State.LogisticsType;
import State.PackingCharge;
import State.UpdateState;
import VO.VO;
import businesslogic.Service.Courier.AddLogisticsService;
import businesslogic.Service.Courier.CourierService;
import businesslogic.Service.Courier.GetAmountService;
import businesslogic.Service.Courier.GetCityService;
import businesslogic.Service.Courier.ReceiveConfirmService;

public class CourierBlService_Stub implements CourierService{
	/*-------------------------------------------
	 输入快递信息
	---------------------------------------------*/
	public AddState addLogistics(VO logistics_info){
		System.out.println("Logic_Stub "+"添加成功");
		LogisticsInfoPO lvo=new LogisticsInfoPO(null, null, null, null, null, null, null, null, null, null,
				null, 0, 0, 0, null, null, null, 0, null, null, null, null, null, null);
		try {
			System.out.println("Data_Stub "+new AddService_Stub().add(lvo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AddState state=AddState.SUCCESS;
		return state;
		}
	/*-------------------------------------------
	更新收件信息
	---------------------------------------------*/
	public UpdateState receiveConfirm(VO logistics_info, String field, String value){
		System.out.println("Logic_Stub "+"更新成功");
		LogisticsInfoPO lvo=new LogisticsInfoPO(null, null, null, null, null, null, null, null, null, null,
				null, 0, 0, 0, null, null, null, 0, null, null, null, null, null, null);
		try {
			System.out.println("Data_Stub "+new UpdateService_Stub().update(lvo,field,value));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UpdateState state=UpdateState.SUCCESS;
		return state;
	}
	/*-------------------------------------------
	显示价格
	---------------------------------------------*/
	public double getAmount(String starting, String destination, LogisticsType type, PackingCharge charge, double weight, double height){
		return 123;
	}
	/*-------------------------------------------
	显示城市
	---------------------------------------------*/
	public ArrayList<String> getCity(){
		System.out.println("Logic_Stub "+"查询成功");
		ArrayList<String> list = new ArrayList<String>();
		list.add("南京");
		list.add("苏州");
		list.add("上海");
		return list;
		
	}
	
	
}
