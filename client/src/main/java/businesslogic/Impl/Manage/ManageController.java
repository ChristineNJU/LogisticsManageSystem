package businesslogic.Impl.Manage;

import java.util.ArrayList;

import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.BenefitVO;
import VO.ConstVO;
import VO.CostVO;
import VO.GatheringVO;
import VO.InstitutionVO;
import VO.SalaryVO;
import VO.StaffVO;
import VO.VO;
import businesslogic.Service.Manage.ManageService;
import businesslogic.SystemLog.SystemLog;

public class ManageController implements ManageService{

	@Override
	public DeleteState DeleteStaff(StaffVO staff) {
		// TODO Auto-generated method stub
		ManageStaff manageStaff=new ManageStaff();
		DeleteState state = manageStaff.DeleteStaff(staff);
		if(state==DeleteState.SUCCESS){
			SystemLog.addLog("删除员工信息");
		}
		return state;
	}

	@Override
	public ArrayList<StaffVO> searchStaff(String id) {
		// TODO Auto-generated method stub
		ManageStaff manageStaff=new ManageStaff();
		return manageStaff.searchStaff(id);
	}

	@Override
	public UpdateState updateStaff(StaffVO staff) {
		// TODO Auto-generated method stub
		ManageStaff manageStaff=new ManageStaff();
		UpdateState state = manageStaff.updateStaff(staff);
		if(state==UpdateState.SUCCESS){
			SystemLog.addLog("更新员工信息");
		}
		return state;
	}

	@Override
	public AddState addStaff(StaffVO staff) {
		// TODO Auto-generated method stub
		ManageStaff manageStaff=new ManageStaff();
		AddState state = manageStaff.addStaff(staff);
		if(state==AddState.SUCCESS){
			SystemLog.addLog("添加员工信息");
		}
		return state;
	}

	@Override
	public UpdateState updatePayment(SalaryVO salary) {
		// TODO Auto-generated method stub
		ManageSalary manageSalary=new ManageSalary();
		UpdateState state = manageSalary.updatePayment(salary);
		if(state==UpdateState.SUCCESS){
			SystemLog.addLog("更新出款信息");
		}
		return state;
	}

	@Override
	public ArrayList<SalaryVO> showSalary() {
		// TODO Auto-generated method stub
		ManageSalary manageSalary=new ManageSalary();
		return manageSalary.showSalary();
	}

	@Override
	public UpdateState updateReceipt(VO receipt) {
		// TODO Auto-generated method stub
		ManageReceipt manageReceipt=new ManageReceipt();
		UpdateState state = manageReceipt.updateReceipt(receipt);
		if(state==UpdateState.SUCCESS){
			SystemLog.addLog("更新单据信息");
		}
		return state;
	}

	@Override
	public ArrayList<VO> showReceipt() {
		// TODO Auto-generated method stub
		ManageReceipt manageReceipt=new ManageReceipt();
		return manageReceipt.showReceipt();
	}

	@Override
	public ArrayList<GatheringVO> searchGathering(String date,
			String businesslobby) {
		// TODO Auto-generated method stub
		ManageFinance manageFinance=new ManageFinance();
		return manageFinance.searchGathering(date, businesslobby);
	}

	@Override
	public ArrayList<CostVO> searchCost(String time_start, String time_end) {
		// TODO Auto-generated method stub
		ManageFinance manageFinance=new ManageFinance();
		return manageFinance.searchCost(time_start, time_end);
	}

	@Override
	public BenefitVO searchBenefit(String time_end) {
		// TODO Auto-generated method stub
		ManageFinance manageFinance=new ManageFinance();
		return manageFinance.searchBenefit(time_end);
	}

	@Override
	public ArrayList<InstitutionVO> searchInstitution(String id) {
		// TODO Auto-generated method stub
		ManageInstitution manageInstitution=new ManageInstitution();
		return manageInstitution.searchInstitution(id);
	}

	@Override
	public DeleteState deleteInstitution(InstitutionVO insitiution) {
		// TODO Auto-generated method stub
		ManageInstitution manageInstitution=new ManageInstitution();
		DeleteState state = manageInstitution.deleteInstitution(insitiution);
		if(state==DeleteState.SUCCESS){
			SystemLog.addLog("删除机构信息");
		}
		return state;
	}

	@Override
	public UpdateState UpdateInstitution(InstitutionVO institution) {
		// TODO Auto-generated method stub
		ManageInstitution manageInstitution=new ManageInstitution();
		UpdateState state = manageInstitution.UpdateInstitution(institution);
		if(state==UpdateState.SUCCESS){
			SystemLog.addLog("更新机构信息");
		}
		return state;
	}
	
	@Override
	public AddState addInstitution(InstitutionVO institution) {
		// TODO Auto-generated method stub
		ManageInstitution manageInstitution=new ManageInstitution();
		AddState state = manageInstitution.addInstitution(institution);
		if(state==AddState.SUCCESS){
			SystemLog.addLog("添加机构信息");
		}
		return state;
	}

	@Override
	public UpdateState updateConst(ConstVO constant) {
		// TODO Auto-generated method stub
		ManageConst manageConst=new ManageConst();
		UpdateState state = manageConst.updateConst(constant);
		if(state==UpdateState.SUCCESS){
			SystemLog.addLog("更新常量信息");
		}
		return state;
		
	}

	@Override
	public ArrayList<ConstVO> showConst() {
		// TODO Auto-generated method stub
		ManageConst manageConst=new ManageConst();
		return manageConst.showConst();
	}

	@Override
	public AddState addConst(ConstVO constant) {
		// TODO Auto-generated method stub
		ManageConst manageConst=new ManageConst();
		AddState state = manageConst.addConst(constant);
		if(state==AddState.SUCCESS){
			SystemLog.addLog("添加常量信息");
		}
		return state;
	}

	
	

}
