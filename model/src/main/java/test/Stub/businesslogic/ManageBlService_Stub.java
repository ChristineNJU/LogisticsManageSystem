package test.Stub.businesslogic;

import java.rmi.RemoteException;
import java.util.ArrayList;

import test.Stub.data.AddService_Stub;
import test.Stub.data.DeleteService_Stub;
import test.Stub.data.SearchService_Stub;
import test.Stub.data.UpdateService_Stub;
import data.State.*;
import businesslogic.PO.BenefitPO;
import businesslogic.PO.ConstPO;
import businesslogic.PO.CostPO;
import businesslogic.PO.GatheringPO;
import businesslogic.PO.InstitutionPO;
import businesslogic.PO.SalaryPO;
import businesslogic.PO.UserPO;
import businesslogic.Service.Finance.SearchCostService;
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
import businesslogic.VO.UserVO;
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
		ArrayList<String> list0=new ArrayList<String>();
		list0.add(null);
	
		ArrayList<VO> list=new ArrayList<VO>();
		ArrayList<GatheringPO> listpo;
		try {
			listpo = new SearchService_Stub().searchGathering(null, list0);
		
		for(int i=0;i<listpo.size();i++){
			GatheringVO vo=new GatheringVO(listpo.get(i));
			list.add(vo);
			
		}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/*-------------------------------------------
	 修改单据
	---------------------------------------------*/
	public UpdateState updateReceipt(VO receipt) {
		
		System.out.println("修改成功");
		ConstPO constpo=new ConstPO(null,1,null);
		try {
			System.out.println("Update_Stub"+new UpdateService_Stub().update(constpo, null,null));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UpdateState state=UpdateState.SUCCESS;
		return state;
		
	}
	/*-------------------------------------------
	 添加常量
	---------------------------------------------*/
	public AddState addConst (ConstVO c ){
		System.out.println("添加成功");
		ConstPO constpo=new ConstPO(c.getName(),c.getValue(),null);
		
		try {
			System.out.println("Add_Stub"+new AddService_Stub().add(constpo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AddState state=AddState.SUCCESS;
		return state;	
	}
	/*-------------------------------------------
	 修改常量
	---------------------------------------------*/
	public UpdateState updateConst (ConstVO c, String field, String value){
		System.out.println("修改成功");
		ConstPO constpo=new ConstPO(c.getName(),c.getValue(),null);
		try {
			System.out.println("Update_Stub"+new UpdateService_Stub().update(constpo, field, value));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UpdateState state=UpdateState.SUCCESS;
		return state;
	}
	/*-------------------------------------------
	 查看常量
	---------------------------------------------*/
	public ArrayList<ConstVO> showConst(){

		ConstVO vo1=new ConstVO("上海到南京的距离（km）",300);
		ConstVO vo2=new ConstVO("南京到上海的距离（km）",300);

		ArrayList<ConstVO> list=new ArrayList<ConstVO>();
		ArrayList<ConstPO> listpo;
		try {
			listpo = new SearchService_Stub().searchConst(null);
		
		for(int i=0;i<listpo.size();i++){
			ConstVO user=new ConstVO(listpo.get(i).getName(),listpo.get(i).getValue());
			list.add(user);
			
		}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/*-------------------------------------------
	 查看入款单
	---------------------------------------------*/
	public ArrayList<CostVO> searchCost(String start_time, String end_time){
		System.out.println("查看成功");
		ArrayList<String> list0=new ArrayList<String>();
		list0.add(start_time);
		list0.add(end_time);
		ArrayList<CostVO> list=new ArrayList<CostVO>();
		ArrayList<CostPO> listpo;
		try {
			listpo = new SearchService_Stub().searchCost(list0);
		
		for(int i=0;i<listpo.size();i++){
			CostVO user=new CostVO(listpo.get(i));
			list.add(user);
			
		}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	/*-------------------------------------------
	 查看出款单
	---------------------------------------------*/
	public ArrayList<GatheringVO> searchGathering(String date, String businesslobby){
		System.out.println("查看成功");
		ArrayList<String> list0=new ArrayList<String>();
		list0.add(date);
		list0.add(businesslobby);
		ArrayList<GatheringVO> list=new ArrayList<GatheringVO>();
		ArrayList<GatheringPO> listpo;
		try {
			listpo = new SearchService_Stub().searchGathering(null, list0);
		
		for(int i=0;i<listpo.size();i++){
			GatheringVO vo=new GatheringVO(listpo.get(i));
			list.add(vo);
			
		}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/*-------------------------------------------
	 查看成本收益表
	---------------------------------------------*/
	public BenefitVO searchBenefit(String time_end){
		System.out.println("查看成功");
		ArrayList<String> list0=new ArrayList<String>();
		
		list0.add(time_end);
		try {
			ArrayList<BenefitPO> listpo=new SearchService_Stub().searchBenefit(list0);
			BenefitVO vo=new BenefitVO(listpo.get(1));
			
			return vo;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
		
	}
	/*-------------------------------------------
	查询人员
	---------------------------------------------*/
	public ArrayList<StaffVO> searchStaff (String id){
		System.out.println("查看成功");
		ArrayList<String> list0=new ArrayList<String>();
		list0.add(id);
	
		ArrayList<StaffVO> list=new ArrayList<StaffVO>();
		ArrayList<UserPO> listpo;
		try {
			listpo = new SearchService_Stub().searchUser(list0);
		
		for(int i=0;i<listpo.size();i++){
			StaffVO vo=new StaffVO(listpo.get(i).getName(),null,1,null,null,null);
			list.add(vo);
			
		}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/*-------------------------------------------
	更新人员
	---------------------------------------------*/
	public UpdateState updateStaff (StaffVO staff, String field, String value){
		System.out.println("修改成功");
		UserPO userpo=new UserPO(staff.getSystemId(), staff.getName(),null, null, null, value);
		try {
			System.out.println("Update_Stub"+new UpdateService_Stub().update(userpo, field, value));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UpdateState state=UpdateState.SUCCESS;
		return state;
	}
	/*-------------------------------------------
	新增人员
	---------------------------------------------*/
	public AddState addStaff (StaffVO staff){
		System.out.println("添加成功");
		UserPO userpo=new UserPO(staff.getSystemId(), staff.getName(),null, null, null, null);
		try {
			System.out.println("Add_Stub"+new AddService_Stub().add(userpo) );
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AddState state=AddState.SUCCESS;
		return state;	
	}
	/*-------------------------------------------
	删除人员
	---------------------------------------------*/
	public DeleteState DeleteStaff (String id){
		System.out.println("删除成功");
		UserPO userpo=new UserPO(id, null,null, null, null, null);
		try {
			System.out.println("Delete_Stub"+new DeleteService_Stub().delete(userpo) );
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DeleteState state=DeleteState.SUCCESS;
		return state;	
	}
	/*-------------------------------------------
	查询机构
	---------------------------------------------*/
	public ArrayList<InstitutionVO> searchInstitution (String id){
		System.out.println("查看成功");
		ArrayList<String> list0=new ArrayList<String>();
		list0.add(id);
	
		ArrayList<InstitutionVO> list=new ArrayList<InstitutionVO>();
		ArrayList<InstitutionPO> listpo;
		try {
			listpo = new SearchService_Stub().searchInstitutionInfo(list0);
		
		for(int i=0;i<listpo.size();i++){
			InstitutionVO vo=new InstitutionVO(null,listpo.get(i).getCity(),listpo.get(i).getInstitutionNumber());
			list.add(vo);
			
		}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/*-------------------------------------------
	修改机构
	---------------------------------------------*/
	public UpdateState UpdateInstitution (InstitutionVO institution, String field,String value){
		System.out.println("修改成功");
		InstitutionPO userpo=new InstitutionPO(null, institution.getCity(), institution.getCode(), null);
		try {
			System.out.println("Update_Stub"+new UpdateService_Stub().update(userpo, field, value));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UpdateState state=UpdateState.SUCCESS;
		return state;
	}
	/*-------------------------------------------
	新增机构
	---------------------------------------------*/
	public AddState addInstitution (InstitutionVO insititution){
		System.out.println("添加成功");
		InstitutionPO userpo=new InstitutionPO(null, insititution.getCity(), insititution.getCode(), null);
		try {
			System.out.println("Add_Stub"+new AddService_Stub().add(userpo) );
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AddState state=AddState.SUCCESS;
		return state;	
	}
	/*-------------------------------------------
	删除机构
	---------------------------------------------*/
	public DeleteState deleteInstitution (InstitutionVO insitiution){
		System.out.println("删除成功");
		InstitutionPO userpo=new InstitutionPO(null, insitiution.getCity(), insitiution.getCode(), null);
		try {
			System.out.println("Delete_Stub"+new DeleteService_Stub().delete(userpo) );
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DeleteState state=DeleteState.SUCCESS;
		return state;	
	}
	/*-------------------------------------------
	查看薪水
	---------------------------------------------*/
	public ArrayList<SalaryVO> showSalary(){
		System.out.println("查看成功");
		ArrayList<String> list0=new ArrayList<String>();
		list0.add(null);
	
		ArrayList<SalaryVO> list=new ArrayList<SalaryVO>();
		ArrayList<SalaryPO> listpo;
		try {
			listpo = new SearchService_Stub().searchSalary(list0);
		
		for(int i=0;i<listpo.size();i++){
			SalaryVO vo=new SalaryVO(null,listpo.get(i).getSalary(),null);
			list.add(vo);
			
		}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/*-------------------------------------------
	调整薪水策略
	---------------------------------------------*/
	public UpdateState updatePayment (SalaryVO salary, String field, String value){
		System.out.println("修改成功");
		SalaryPO userpo=new SalaryPO(null, 0, null, value);
		try {
			System.out.println("Update_Stub"+new UpdateService_Stub().update(userpo, field, value));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UpdateState state=UpdateState.SUCCESS;
		return state;
	}
	
	
	
	
}
