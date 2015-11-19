package test.Stub.businesslogic;

import java.rmi.RemoteException;
import java.util.ArrayList;

import test.Stub.data.AddService_Stub;
import test.Stub.data.DeleteService_Stub;
import test.Stub.data.SearchService_Stub;
import test.Stub.data.UpdateService_Stub;
import PO.AccountPO;
import PO.BenefitPO;
import PO.CostPO;
import PO.EntruckingPO;
import PO.GatheringPO;
import PO.LogPO;
import PO.TransferPO;
import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.AccountVO;
import VO.BenefitVO;
import VO.CostVO;
import VO.EntruckingVO;
import VO.GatheringVO;
import VO.LogVO;
import VO.TransferVO;
import businesslogic.Service.Finance.FinanceService;

public class FinanceBlService_Stub implements FinanceService{
	/*-------------------------------------------
	 查看收款单
	---------------------------------------------*/
	public ArrayList<GatheringVO> searchGathering(String date, String businesslobby){
		System.out.println("Logic_Stub "+"查看成功");
		ArrayList<GatheringVO> list=new ArrayList<GatheringVO>();
		ArrayList<String> string=new ArrayList<String>();
		string.add(date+" "+businesslobby);
		try{
		ArrayList<GatheringPO> gathering=new SearchService_Stub().searchGathering(null, string); 
		for(int i=0;i<gathering.size();i++){
			GatheringVO gvo=new GatheringVO(gathering.get(i).getDate(),gathering.get(i).getAmount(), gathering.get(i).getCourier(),gathering.get(i).getBarCodeList());
			list.add(gvo);
		}
		} catch(RemoteException e){
			e.printStackTrace();
		}

		return list;
	}
	/*-------------------------------------------
	 生成出款单，保存状态
	---------------------------------------------*/
	public AddState addCost(CostVO cost){
		System.out.println("Logic_Stub "+"生成、保存成功");
		CostPO cpo=new CostPO(null, 0, null, null, null, null, null);
		try {
			System.out.println("Data_Stub"+new AddService_Stub().add(cpo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AddState state=AddState.SUCCESS;
		return state;
		}
	/*-------------------------------------------
	 显示装车单
	---------------------------------------------*/
	public ArrayList<EntruckingVO> getEntrucking(String time_start, String time_end){
		
		System.out.println("Logic_Stub "+"查看成功");
		/*ArrayList<String> list0=new ArrayList<String>();
		list0.add("1234512345");
		list0.add("1234512346");
		EntruckingVO vo1=new EntruckingVO("2015-10-25","215253","南京","苏A00000","1234512345","1234512345",list0,200);
		EntruckingVO vo2=new EntruckingVO("2015-10-25","215254","南京","苏A00001","1234512345","1234512345",list0,200);*/
		ArrayList<EntruckingVO> list=new ArrayList<EntruckingVO>();
		ArrayList<String> string=new ArrayList<String>();
		string.add(time_start+" "+time_end);
		try{
			ArrayList<EntruckingPO> cpo=new SearchService_Stub().searchEntrucking(null, string);
			for(int i=0;i<cpo.size();i++){
				EntruckingVO en=new EntruckingVO(cpo.get(i).getDate(), cpo.get(i).getCarNumber(), cpo.get(i).getDestination(), cpo.get(i).getGuardName(), cpo.get(i).getSupercargoName(), cpo.get(i).getTransferNumber(), cpo.get(i).getBarCodeList(), 0);
			    list.add(en);
			}
		} catch(RemoteException e){
			e.printStackTrace();
		}
		return list;
	}
	/*-------------------------------------------
	 显示中转单
	---------------------------------------------*/
	public ArrayList<TransferVO> getTransfer(String time_start, String time_end){
		System.out.println("Logic_Stub "+"查看成功");
		/*ArrayList<String> list0=new ArrayList<String>();
		list0.add("1234512345");
		list0.add("1234512346");
		TransferVO vo1=new TransferVO("2015-10-25","215253","215153","南京","上海","A00000","1234512345",list0,200);
		TransferVO vo2=new TransferVO("2015-10-25","215253","215153","南京","上海","A00000","1234512345",list0,200);*/
		ArrayList<String> requirement=new ArrayList<String>();
		ArrayList<TransferVO> list=new ArrayList<TransferVO>();
		
		requirement.add(time_start+" "+time_end);
		try{
			ArrayList<TransferPO> tpo=new SearchService_Stub().searchTransfer(null, requirement);
			for(int i=0;i<tpo.size();i++){
				TransferVO trans=new TransferVO(tpo.get(i).getDate(),tpo.get(i).getTranferNumber(),tpo.get(i).getTransportID(),tpo.get(i).getStarting(),tpo.get(i).getDestination(),tpo.get(i).getContainerNumber(),tpo.get(i).getGuardName(),tpo.get(i).getBarCodeList(),tpo.get(i).getAmount());
                list.add(trans);			
			}
		} catch(RemoteException e){
			e.printStackTrace();
		}
		
		return list;
		}
	/*-------------------------------------------
	 显示出款单
	---------------------------------------------*/
	public ArrayList<CostVO> searchCost(String start_time, String end_time){
	System.out.println("Logic_Stub "+"查看成功");

	/*ArrayList<String> list0=new ArrayList<String>();
	list0.add("1234512345");
	list0.add("1234512346");

	CostVO vo1=new CostVO("2015-10-25",100,"尹子越","12345",CostType.rent,"1234512345");
	CostVO vo2=new CostVO("2015-10-25",100,"张斯栋","12345",CostType.rent,"1234512345");*/
	ArrayList<CostVO> list=new ArrayList<CostVO>();
	ArrayList<String> requirement=new ArrayList<String>();
	requirement.add(start_time+" "+end_time);
	try{
		ArrayList<CostPO> cpo=new SearchService_Stub().searchCost(requirement);
		for(int i=0;i<cpo.size();i++){
			CostVO cost=new CostVO(cpo.get(i).getCostDate(),cpo.get(i).getCostAmount(),cpo.get(i).getCostName(),cpo.get(i).getAccountName(),cpo.get(i).getType(),null);
			list.add(cost);
		}
	} catch(RemoteException e){
		e.printStackTrace();
	}
	return list;
	}
	/*-------------------------------------------
	 将成本收益表加入数据库
	---------------------------------------------*/
	public AddState addBenefit(BenefitVO benefit){
		System.out.println("Logic_Stub "+"添加成功");
		BenefitPO bpo=new BenefitPO(0, 0, 0, null);
		try {
			System.out.println("Data_Stub"+" "+new AddService_Stub().add(bpo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AddState state=AddState.SUCCESS;
		return state;
	}
	/*-------------------------------------------
	 查看成本收益表
	---------------------------------------------*/
	public BenefitVO searchBenefit(String time_end){
		System.out.println("Logic_Stub "+"查看成功");
		ArrayList<BenefitVO> bvo=new ArrayList<BenefitVO>();
		ArrayList<String> requirement=new ArrayList<String>();
		requirement.add(time_end);
		try{
			ArrayList<BenefitPO> bpo=new SearchService_Stub().searchBenefit(requirement);
			for(int i=0;i<bpo.size();i++){
				BenefitVO bene=new BenefitVO(bpo.get(i).getIncome(),bpo.get(i).getExpend());
				bvo.add(bene);
			}
		}catch (RemoteException e){
			e.printStackTrace();
		}
		BenefitVO vo=bvo.get(0);
		return vo;
	}
	/*-------------------------------------------
	 返回账目单
	---------------------------------------------*/
	public ArrayList<AccountVO> searchAccount (String name){
		System.out.println("Logic_Stub "+"查看成功");
		ArrayList<AccountVO> list=new ArrayList<AccountVO>();
		ArrayList<String> requirement=new ArrayList<String>();
		requirement.add(name);
		try{
			ArrayList<AccountPO> apo=new SearchService_Stub().searchAccount(requirement);
			for(int i=0;i<apo.size();i++){
				AccountVO acc=new AccountVO(apo.get(i).getAccountName(),apo.get(i).getAmount());
				list.add(acc);
			}
			
		}catch(RemoteException e){
			e.printStackTrace();
		}
		
		return list;
	}
	/*-------------------------------------------
	将新用户信息加入数据库
	---------------------------------------------*/
	public AddState addAccount(AccountVO account){
		System.out.println("Logic_Stub "+"添加成功");
		AccountPO apo=new AccountPO(0, null, 0, null);
		try {
			System.out.println("Data_Stub "+new AddService_Stub().add(apo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AddState state=AddState.SUCCESS;
		return state;
	}
	/*-------------------------------------------
	将账目从数据库删除
	---------------------------------------------*/
	public DeleteState deleteAccount (AccountVO account){
		System.out.println("Logic_Stub "+"删除成功");
		AccountPO apo=new AccountPO(0, null, 0, null);
		try {
			System.out.println("Data_Stub "+new DeleteService_Stub().delete(apo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DeleteState state=DeleteState.SUCCESS;
		return state;
	}
	/*-------------------------------------------
	更新数据库账目
	---------------------------------------------*/
	public UpdateState updateAccount (AccountVO account, String field, String value ){
		System.out.println("Logic_Stub "+"更新成功");
		AccountPO apo=new AccountPO(0, null, 0, null);
		try {
			System.out.println("Data_Stub "+new UpdateService_Stub().update(apo,field,value));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UpdateState state=UpdateState.SUCCESS;
		return state;
	}
	/*-------------------------------------------
	查看日志
	---------------------------------------------*/
	public ArrayList<LogVO> getLog(String time_start, String time_end){
		System.out.println("Logic_Stub "+"查看成功");
		ArrayList<LogVO> list=new ArrayList<LogVO>();
		ArrayList<String> requirement=new ArrayList<String>();
		requirement.add(time_start+" "+time_end);
		try{
			ArrayList<LogPO> lpo=new SearchService_Stub().searchLog(requirement);
			for(int i=0;i<lpo.size();i++){
				LogVO log=new LogVO(lpo.get(i).getTime(),lpo.get(i).getOperation(),lpo.get(i).getOperator());
				list.add(log);
			}
			
		}catch (RemoteException e){
			e.printStackTrace();
		}
		return list;
	}

	
}
