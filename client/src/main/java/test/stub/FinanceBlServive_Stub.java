package test.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.State.AddState;
import dataservice.State.DeleteState;
import dataservice.State.UpdateState;
import businesslogic.PO.*;
import businesslogic.State.CostType;
import businesslogic.VO.*;

public class FinanceBlServive_Stub {
	/*-------------------------------------------
	 查看收款单
	---------------------------------------------*/
	public ArrayList<GatheringVO> searchGathering(String date, String businesslobby){
		System.out.println("查看成功");
		ArrayList<String> list0=null;
		list0.add("1234512345");
		list0.add("1234512346");
		GatheringVO vo1=new GatheringVO(date,100,"车辆运费",list0);
		GatheringVO vo2=new GatheringVO(date,100,"车辆运费",list0);
		ArrayList<GatheringVO> list=null;
		list.add(vo1);
		list.add(vo2);
		return list;
	}
	/*-------------------------------------------
	 生成出款单，保存状态
	---------------------------------------------*/
	public AddState addCost(CostVO cost){
		System.out.println("生成、保存成功");
		AddState state=AddState.SUCCESS;
		return state;
		}
	/*-------------------------------------------
	 显示装车单
	---------------------------------------------*/
	public ArrayList<EntruckingVO> getEntrucking(String time_start, String time_end){
		
		System.out.println("查看成功");
		ArrayList<String> list0=null;
		list0.add("1234512345");
		list0.add("1234512346");
		EntruckingVO vo1=new EntruckingVO("2015-10-25","215253","南京","苏A00000","1234512345","1234512345",list0,200);
		EntruckingVO vo2=new EntruckingVO("2015-10-25","215254","南京","苏A00001","1234512345","1234512345",list0,200);
		ArrayList<EntruckingVO> list=null;
		list.add(vo1);
		list.add(vo2);
		return list;
	}
	/*-------------------------------------------
	 显示中转单
	---------------------------------------------*/
	public ArrayList<TransferVO> getTransfer(String time_start, String time_end){
		System.out.println("查看成功");
		ArrayList<String> list0=null;
		list0.add("1234512345");
		list0.add("1234512346");
		TransferVO vo1=new TransferVO("2015-10-25","215253","215153","南京","上海","A00000","1234512345",list0,200);
		TransferVO vo2=new TransferVO("2015-10-25","215253","215153","南京","上海","A00000","1234512345",list0,200);
		ArrayList<TransferVO> list=null;
		list.add(vo1);
		list.add(vo2);
		return list;
		}
	/*-------------------------------------------
	 显示出款单
	---------------------------------------------*/
	public ArrayList<CostVO> searchCost(String start_time, String end_time){
	System.out.println("查看成功");
	ArrayList<String> list0=null;
	list0.add("1234512345");
	list0.add("1234512346");
	CostVO vo1=new CostVO("2015-10-25",100,"尹子越","12345",CostType.rent,"1234512345");
	CostVO vo2=new CostVO("2015-10-25",100,"张斯栋","12345",CostType.rent,"1234512345");
	ArrayList<CostVO> list=null;
	list.add(vo1);
	list.add(vo2);
	return list;
	}
	/*-------------------------------------------
	 将成本收益表加入数据库
	---------------------------------------------*/
	public AddState addBenefit(BenefitPO benefit){
		System.out.println("添加成功");
		AddState state=AddState.SUCCESS;
		return state;
	}
	/*-------------------------------------------
	 查看成本收益表
	---------------------------------------------*/
	public BenefitVO searchBenefit(String time_end){
		System.out.println("查看成功");
		BenefitVO vo=new  BenefitVO(20000,10000);
		return vo;
	}
	/*-------------------------------------------
	 返回账目单
	---------------------------------------------*/
	public ArrayList<AccountVO> searchAccount (String name){
		System.out.println("查看成功");
		AccountVO vo1=new AccountVO("吃饭",100);
		AccountVO vo2=new AccountVO("喝酒",100);
		ArrayList<AccountVO> list=null;
		list.add(vo1);
		list.add(vo2);
		return list;
	}
	/*-------------------------------------------
	将新用户信息加入数据库
	---------------------------------------------*/
	public AddState addAccount(AccountVO account){
		System.out.println("添加成功");
		AddState state=AddState.SUCCESS;
		return state;
	}
	/*-------------------------------------------
	将账目从数据库删除
	---------------------------------------------*/
	public DeleteState deleteAccount (AccountPO account) throws RemoteException{
		System.out.println("删除成功");
		DeleteState state=DeleteState.SUCCESS;
		return state;
	}
	/*-------------------------------------------
	更新数据库账目
	---------------------------------------------*/
	public UpdateState updateAccount (AccountPO account, String field, String value ){
		System.out.println("更新成功");
		UpdateState state=UpdateState.SUCCESS;
		return state;
	}
	/*-------------------------------------------
	查看日志
	---------------------------------------------*/
	public ArrayList<LogVO> getLog(String time_start, String time_end){
		System.out.println("查看成功");
		LogVO vo1=new LogVO("1234512345","刘钦",100);
		LogVO vo2=new LogVO("喝酒",100);
		ArrayList<LogVO> list=null;
		list.add(vo1);
		list.add(vo2);
		return list;
	}
	
}
