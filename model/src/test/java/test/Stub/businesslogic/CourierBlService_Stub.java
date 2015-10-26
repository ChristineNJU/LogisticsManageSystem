package test.Stub.businesslogic;

import java.util.ArrayList;

import businesslogic.Service.Courier.AddLogisticsService;
import businesslogic.Service.Courier.GetAmountService;
import businesslogic.Service.Courier.GetCityService;
import businesslogic.Service.Courier.ReceiveConfirmService;
import businesslogic.State.LogisticsType;
import businesslogic.State.PackingCharge;
import businesslogic.VO.VO;
import data.State.AddState;
import data.State.UpdateState;

public class CourierBlService_Stub implements AddLogisticsService, GetAmountService, GetCityService, ReceiveConfirmService{
	/*-------------------------------------------
	 输入快递信息
	---------------------------------------------*/
	public AddState addLogistics(VO logistics_info){
		System.out.println("添加成功");
		AddState state=AddState.SUCCESS;
		return state;
		}
	/*-------------------------------------------
	更新收件信息
	---------------------------------------------*/
	public UpdateState receiveConfirm(VO logistics_info, String field, String value){
		System.out.println("更新成功");
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
		System.out.println("查询成功");
		ArrayList<String> list = new ArrayList<String>();
		list.add("南京");
		list.add("苏州");
		list.add("上海");
		return list;
		
	}
	
	
}
