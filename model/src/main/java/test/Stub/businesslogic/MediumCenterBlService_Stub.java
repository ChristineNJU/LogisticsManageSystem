package test.Stub.businesslogic;
import java.util.ArrayList;

import data.State.*;
import businesslogic.State.*;
import businesslogic.VO.*;
public class MediumCenterBlService_Stub {
	/*-------------------------------------------
	 快递到达
	---------------------------------------------*/
	public AddState arrival(ArrayList<ArrivalVO> list){
		System.out.println("到达成功");
		AddState state=AddState.SUCCESS;
		return state;
		//ArrivalVO arrive1=new ArrivalVO("2015-1-1","1234512345","南京",LogisticsState.INTACT);
		//ArrivalVO arrive2=new ArrivalVO("2015-1-1","1234512345","南京",LogisticsState.INTACT);
	}
	/*-------------------------------------------
	 查询需要装车的订单信息
	---------------------------------------------*/
	public ArrayList<String> getNeedEntrucking(){
		System.out.println("查询成功");
		ArrayList<String> list = null;
		list.add("1234512345");
		list.add("1234512346");
		list.add("1234512347");
		return list;
	}
	/*-------------------------------------------
	 装车操作
	---------------------------------------------*/
	public AddState entrucking(EntruckingVO entrucking){
		System.out.println("装车成功");
		AddState state=AddState.SUCCESS;
		return state;
	}
	/*-------------------------------------------
	 查询中转的订单
	---------------------------------------------*/
	public ArrayList<String> getNeedTransfer(){
		System.out.println("查询成功");
		ArrayList<String> list = null;
		list.add("1234512345");
		list.add("1234512346");
		list.add("1234512347");
		return list;
	}
	/*-------------------------------------------
	 中转操作
	---------------------------------------------*/
	public AddState transfer(TransferVO transfer){
		System.out.println("中转成功");
		AddState state=AddState.SUCCESS;
		return state;
	}
	
}
