package test.Stub.businesslogic;

import java.rmi.RemoteException;
import java.util.ArrayList;

import test.Stub.data.AddService_Stub;
import test.Stub.data.UpdateService_Stub;
import PO.LogisticsInfoPO;
import State.AddState;
import State.CodeState;
import State.LogisticsType;
import State.PackingCharge;
import State.UpdateState;
import VO.VO;
import businesslogic.Service.Courier.CourierService;

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
			System.out.println("Data_Stub "+new UpdateService_Stub().update(lvo));
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
	@Override
	public UpdateState receiveConfirm(VO logistics_info) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public double getDayLength(String starting, String destination) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public CodeState isLegal(String bar_code) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
