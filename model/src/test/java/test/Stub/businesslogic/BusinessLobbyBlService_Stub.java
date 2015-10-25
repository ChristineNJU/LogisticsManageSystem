package test.Stub.businesslogic;
import java.util.ArrayList;

import data.State.*;
import businesslogic.State.*;
import businesslogic.VO.*;
public class BusinessLobbyBlService_Stub {
	/*-------------------------------------------
	 选择到达操作
	---------------------------------------------*/
	public AddState arrival(ArrayList<ArrivalVO> arrival){
		System.out.println("添加到达成功");
		AddState state=AddState.SUCCESS;
		return state;
	}
	/*-------------------------------------------
	 查询需要派的快递
	---------------------------------------------*/
	public ArrayList<String> getNeedGathering(){
		System.out.println("查询成功");
		ArrayList<String> list = new ArrayList<String>();
		list.add("1234512345");
		list.add("1234512346");
		list.add("1234512347");
		return list;
	}
	/*-------------------------------------------
	 确认派件单
	---------------------------------------------*/
	public AddState gathering(GatheringVO gathering){
		System.out.println("确认到达单成功");
		AddState state=AddState.SUCCESS;
		return state;
	}
	/*-------------------------------------------
	 查询需要装车的订单
	---------------------------------------------*/
	public ArrayList<String> getNeedEntrucking(){
		System.out.println("查询成功");
		ArrayList<String> list = new ArrayList<String>();
		list.add("1234512345");
		list.add("1234512346");
		list.add("1234512347");
		return list;
	}
	/*-------------------------------------------
	 装车
	---------------------------------------------*/
	public AddState entrucking(EntruckingVO entrucking){
		System.out.println("装车成功");
		AddState state=AddState.SUCCESS;
		return state;
	}
	/*-------------------------------------------
	 查询车辆信息
	---------------------------------------------*/
	public ArrayList<CarInfoVO> searchCar(String id){
		System.out.println("查询成功");
		ArrayList<CarInfoVO> list = new ArrayList<CarInfoVO>();
		CarInfoVO car1=new CarInfoVO("025000000","苏A00000",2016);
		CarInfoVO car2=new CarInfoVO("025000001","苏A00001",2016);
		list.add(car1);
		list.add(car2);
		return list;
	}
	/*-------------------------------------------
	 修改车辆信息
	---------------------------------------------*/
	public UpdateState updateCar(CarInfoVO car, String field, String value){
		System.out.println("修改成功");
		UpdateState state=UpdateState.SUCCESS;
		return state;
	}
	/*-------------------------------------------
	 添加车辆信息
	---------------------------------------------*/
	public AddState addCar(CarInfoVO car){
		System.out.println("添加成功");
		AddState state=AddState.SUCCESS;
		return state;
	}
	/*-------------------------------------------
	 删除车辆
	---------------------------------------------*/
	public DeleteState deleteCar(CarInfoVO car){
		System.out.println("删除成功");
		DeleteState state=DeleteState.SUCCESS;
		return state;
	}
	/*-------------------------------------------
	 查询司机信息
	---------------------------------------------*/
	public ArrayList<DriverInfoVO> searchDriver (String id){
		System.out.println("查询成功");
		ArrayList<DriverInfoVO> list = new ArrayList<DriverInfoVO>();
		DriverInfoVO driver1=new DriverInfoVO("025000000","尹子越","2016-1-1","320586201601013456","1234512345123","男",2017);
		DriverInfoVO driver2=new DriverInfoVO("025000000","尹越子","2016-1-1","320586201601013456","1234512345123","男",2017);
		list.add(driver1);
		list.add(driver2);
		return list;
	}
	/*-------------------------------------------
	 修改司机信息
	---------------------------------------------*/
	public UpdateState updateDriver (DriverInfoVO driver, String field, String value){
	System.out.println("修改成功");
	UpdateState state=UpdateState.SUCCESS;
	return state;
	}
	/*-------------------------------------------
	 添加司机信息
	---------------------------------------------*/
	public AddState AddDriver (DriverInfoVO driver){
		System.out.println("添加成功");
		AddState state=AddState.SUCCESS;
		return state;	
	}
	/*-------------------------------------------
	 删除司机
	---------------------------------------------*/
	public DeleteState deleteDriver(DriverInfoVO driver){
		System.out.println("删除成功");
		DeleteState state=DeleteState.SUCCESS;
		return state;
	}
}