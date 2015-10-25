package test.Stub.businesslogic;

import java.util.ArrayList;

import data.State.*;
import businesslogic.Service.Manage.*;
import businesslogic.State.CostType;
import businesslogic.State.InstitutionType;
import businesslogic.State.SalaryType;
import businesslogic.VO.BenefitVO;
import businesslogic.VO.ConstVO;
import businesslogic.VO.CostVO;
import businesslogic.VO.GatheringVO;
import businesslogic.VO.InstitutionVO;
import businesslogic.VO.SalaryVO;
import businesslogic.VO.StaffVO;
import businesslogic.VO.VO;

public class ManageBlService_Stub implements AddConstService,AddInstitutionService,AddStaffService,
											DeleteInstitutionService,DeleteStaffService,SearchBenefitService,
											SearchCostService,SearchGatheringService,SearchInstitutionService,
											SearchStaffService,ShowConstService,ShowReceiptService,
											ShowSalaryService,UpdateConstService,UpdateInstitutionService,
											UpdatePaymentService,UpdateReceiptService,UpdateStaffService{
	/*-------------------------------------------
	 查看单据
	---------------------------------------------*/
	public ArrayList<VO> showReceipt(){
		System.out.println("查看成功");
		ArrayList<String> list0=null;
		list0.add("1234512345");
		list0.add("1234512346");
		VO vo1=new GatheringVO("2015-10-25",100,"车辆运费",list0);
		VO vo2=new GatheringVO("2015-10-25",100,"车辆运费",list0);
		ArrayList<VO> list=null;
		list.add( vo1);
		list.add( vo2);
		return list;
	}
	/*-------------------------------------------
	 修改单据
	---------------------------------------------*/
	public UpdateState updateReceipt(VO receipt) {
		// TODO Auto-generated method stub
		System.out.println("修改成功");
		UpdateState state=UpdateState.SUCCESS;
		return state;
		
	}
	/*-------------------------------------------
	 添加常量
	---------------------------------------------*/
	public AddState addConst (ConstVO c ){
		System.out.println("添加成功");
		AddState state=AddState.SUCCESS;
		return state;	
	}
	/*-------------------------------------------
	 修改常量
	---------------------------------------------*/
	public UpdateState updateConst (ConstVO c, String field, String value){
		System.out.println("修改成功");
		UpdateState state=UpdateState.SUCCESS;
		return state;
	}
	/*-------------------------------------------
	 查看常量
	---------------------------------------------*/
	public ArrayList<ConstVO> showConst(){
		ConstVO vo1=new ConstVO("上海到南京的距离（km）","300");
		ConstVO vo2=new ConstVO("南京到上海的距离（km）","300");
		ArrayList<ConstVO> list=null;
		list.add( vo1);
		list.add( vo2);
		return list;
	}
	/*-------------------------------------------
	 查看入款单
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
	 查看出款单
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
	 查看成本收益表
	---------------------------------------------*/
	public BenefitVO searchBenefit(String time_end){
		System.out.println("查看成功");
		BenefitVO vo=new  BenefitVO(20000,10000);
		return vo;
	}
	/*-------------------------------------------
	查询人员
	---------------------------------------------*/
	public ArrayList<StaffVO> searchStaff (String id){
		System.out.println("查看成功");
		StaffVO vo1=new StaffVO("刘钦","男",20,"南京鼓楼营业厅","营业厅","1234512345");
		StaffVO vo2=new StaffVO("刘钦","男",21,"南京鼓楼营业厅","营业厅","1234512346");
		ArrayList<StaffVO> list=null;
		list.add(vo1);
		list.add(vo2);
		return list;
	}
	/*-------------------------------------------
	更新人员
	---------------------------------------------*/
	public UpdateState updateStaff (StaffVO staff, String field, String value){
		System.out.println("修改成功");
		UpdateState state=UpdateState.SUCCESS;
		return state;
	}
	/*-------------------------------------------
	新增人员
	---------------------------------------------*/
	public AddState addStaff (StaffVO staff){
		System.out.println("添加成功");
		AddState state=AddState.SUCCESS;
		return state;	
	}
	/*-------------------------------------------
	删除人员
	---------------------------------------------*/
	public DeleteState DeleteStaff (String id){
		System.out.println("删除成功");
		DeleteState state=DeleteState.SUCCESS;
		return state;	
	}
	/*-------------------------------------------
	查询机构
	---------------------------------------------*/
	public ArrayList<InstitutionVO> searchInstitution (String id){
		System.out.println("查看成功");
		InstitutionVO vo1=new InstitutionVO(InstitutionType.BusinessLobby,"南京","0251000");
		InstitutionVO vo2=new InstitutionVO(InstitutionType.MediumCenter,"南京","025100");
		ArrayList<InstitutionVO> list=null;
		list.add(vo1);
		list.add(vo2);
		return list;
	}
	/*-------------------------------------------
	修改机构
	---------------------------------------------*/
	public UpdateState UpdateInstitution (InstitutionVO institution, String field,String value){
		System.out.println("修改成功");
		UpdateState state=UpdateState.SUCCESS;
		return state;
	}
	/*-------------------------------------------
	新增机构
	---------------------------------------------*/
	public AddState addInstitution (InstitutionVO insititution){
		System.out.println("添加成功");
		AddState state=AddState.SUCCESS;
		return state;	
	}
	/*-------------------------------------------
	删除机构
	---------------------------------------------*/
	public DeleteState deleteInstitution (InstitutionVO insitiution){
		System.out.println("删除成功");
		DeleteState state=DeleteState.SUCCESS;
		return state;	
	}
	/*-------------------------------------------
	查看薪水
	---------------------------------------------*/
	public ArrayList<SalaryVO> showSalary(){
		System.out.println("查看成功");
		SalaryVO vo1=new SalaryVO("王小明",2000,SalaryType.MONTH);
		SalaryVO vo2=new SalaryVO("王大明",2000,SalaryType.MONTH);
		ArrayList<SalaryVO> list=null;
		list.add(vo1);
		list.add(vo2);
		return list;
	}
	/*-------------------------------------------
	调整薪水策略
	---------------------------------------------*/
	public UpdateState updatePayment (SalaryVO salary, String field, String value){
		System.out.println("修改成功");
		UpdateState state=UpdateState.SUCCESS;
		return state;
	}
	
	
	
	
}
