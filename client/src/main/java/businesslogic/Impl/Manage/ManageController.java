package businesslogic.Impl.Manage;

import java.util.ArrayList;

import data.State.AddState;
import data.State.DeleteState;
import data.State.UpdateState;
import businesslogic.Service.Manage.AddInstitutionService;
import businesslogic.Service.Manage.AddStaffService;
import businesslogic.Service.Manage.DeleteInstitutionService;
import businesslogic.Service.Manage.DeleteStaffService;
import businesslogic.Service.Manage.SearchBenefitService;
import businesslogic.Service.Manage.SearchCostService;
import businesslogic.Service.Manage.SearchGatheringService;
import businesslogic.Service.Manage.SearchInstitutionService;
import businesslogic.Service.Manage.SearchStaffService;
import businesslogic.Service.Manage.ShowConstService;
import businesslogic.Service.Manage.ShowReceiptService;
import businesslogic.Service.Manage.ShowSalaryService;
import businesslogic.Service.Manage.UpdateConstService;
import businesslogic.Service.Manage.UpdateInstitutionService;
import businesslogic.Service.Manage.UpdatePaymentService;
import businesslogic.Service.Manage.UpdateReceiptService;
import businesslogic.Service.Manage.UpdateStaffService;
import businesslogic.VO.BenefitVO;
import businesslogic.VO.ConstVO;
import businesslogic.VO.CostVO;
import businesslogic.VO.GatheringVO;
import businesslogic.VO.InstitutionVO;
import businesslogic.VO.SalaryVO;
import businesslogic.VO.StaffVO;
import businesslogic.VO.VO;

public class ManageController implements ShowConstService,UpdateConstService,AddInstitutionService,
										UpdateInstitutionService,DeleteInstitutionService,SearchInstitutionService,
										SearchBenefitService, SearchCostService,SearchGatheringService ,
										ShowReceiptService, UpdateReceiptService,ShowSalaryService,
										UpdatePaymentService,AddStaffService,UpdateStaffService,
										SearchStaffService,DeleteStaffService{

	ManageConst manageConst=new ManageConst();
	ManageFinance manageFinance=new ManageFinance();
	ManageInstitution manageInstitution=new ManageInstitution();
	ManageReceipt manageReceipt=new ManageReceipt();
	ManageSalary manageSalary=new ManageSalary();
	ManageStaff manageStaff=new ManageStaff();
	
	@Override
	public DeleteState DeleteStaff(String id) {
		// TODO Auto-generated method stub
		return manageStaff.DeleteStaff(id);
	}

	@Override
	public ArrayList<StaffVO> searchStaff(String id) {
		// TODO Auto-generated method stub
		return manageStaff.searchStaff(id);
	}

	@Override
	public UpdateState updateStaff(StaffVO staff, String field, String value) {
		// TODO Auto-generated method stub
		return manageStaff.updateStaff(staff, field, value);
	}

	@Override
	public AddState addStaff(StaffVO staff) {
		// TODO Auto-generated method stub
		return manageStaff.addStaff(staff);
	}

	@Override
	public UpdateState updatePayment(SalaryVO salary, String field, String value) {
		// TODO Auto-generated method stub
		return manageSalary.updatePayment(salary, field, value);
	}

	@Override
	public ArrayList<SalaryVO> showSalary() {
		// TODO Auto-generated method stub
		return manageSalary.showSalary();
	}

	@Override
	public UpdateState updateReceipt(VO receipt) {
		// TODO Auto-generated method stub
		return manageReceipt.updateReceipt(receipt);
	}

	@Override
	public ArrayList<VO> showReceipt() {
		// TODO Auto-generated method stub
		return manageReceipt.showReceipt();
	}

	@Override
	public ArrayList<GatheringVO> searchGathering(String date,
			String businesslobby) {
		// TODO Auto-generated method stub
		return manageFinance.searchGathering(date, businesslobby);
	}

	@Override
	public ArrayList<CostVO> searchCost(String time_start, String time_end) {
		// TODO Auto-generated method stub
		return manageFinance.searchCost(time_start, time_end);
	}

	@Override
	public BenefitVO searchBenefit(String time_end) {
		// TODO Auto-generated method stub
		return manageFinance.searchBenefit(time_end);
	}

	@Override
	public ArrayList<InstitutionVO> searchInstitution(String id) {
		// TODO Auto-generated method stub
		return manageInstitution.searchInstitution(id);
	}

	@Override
	public DeleteState deleteInstitution(InstitutionVO insitiution) {
		// TODO Auto-generated method stub
		return manageInstitution.deleteInstitution(insitiution);
	}

	@Override
	public UpdateState UpdateInstitution(InstitutionVO institution,
			String field, String value) {
		// TODO Auto-generated method stub
		return manageInstitution.UpdateInstitution(institution, field, value);
	}

	@Override
	public UpdateState updateConst(ConstVO constant, String field, String value) {
		// TODO Auto-generated method stub
		return manageConst.updateConst(constant, field, value);
		
	}

	@Override
	public ArrayList<ConstVO> showConst() {
		// TODO Auto-generated method stub
		return manageConst.showConst();
	}

	@Override
	public AddState addInstitution(InstitutionVO institution) {
		// TODO Auto-generated method stub
		return manageInstitution.addInstitution(institution);
	}

}
