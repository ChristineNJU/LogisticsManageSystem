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
import businesslogic.Service.Manage.AddConstService;
import businesslogic.Service.Manage.AddInstitutionService;
import businesslogic.Service.Manage.AddStaffService;
import businesslogic.Service.Manage.DeleteInstitutionService;
import businesslogic.Service.Manage.DeleteStaffService;
import businesslogic.Service.Manage.ManageService;
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

public class ManageController implements ManageService{

	@Override
	public DeleteState DeleteStaff(String id) {
		// TODO Auto-generated method stub
		ManageStaff manageStaff=new ManageStaff();
		return manageStaff.DeleteStaff(id);
	}

	@Override
	public ArrayList<StaffVO> searchStaff(String id) {
		// TODO Auto-generated method stub
		ManageStaff manageStaff=new ManageStaff();
		return manageStaff.searchStaff(id);
	}

	@Override
	public UpdateState updateStaff(StaffVO staff, String field, String value) {
		// TODO Auto-generated method stub
		ManageStaff manageStaff=new ManageStaff();
		return manageStaff.updateStaff(staff, field, value);
	}

	@Override
	public AddState addStaff(StaffVO staff) {
		// TODO Auto-generated method stub
		ManageStaff manageStaff=new ManageStaff();
		return manageStaff.addStaff(staff);
	}

	@Override
	public UpdateState updatePayment(SalaryVO salary, String field, String value) {
		// TODO Auto-generated method stub
		ManageSalary manageSalary=new ManageSalary();
		return manageSalary.updatePayment(salary, field, value);
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
		return manageReceipt.updateReceipt(receipt);
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
		return manageInstitution.deleteInstitution(insitiution);
	}

	@Override
	public UpdateState UpdateInstitution(InstitutionVO institution,
			String field, String value) {
		// TODO Auto-generated method stub
		ManageInstitution manageInstitution=new ManageInstitution();
		return manageInstitution.UpdateInstitution(institution, field, value);
	}
	
	@Override
	public AddState addInstitution(InstitutionVO institution) {
		// TODO Auto-generated method stub
		ManageInstitution manageInstitution=new ManageInstitution();
		return manageInstitution.addInstitution(institution);
	}

	@Override
	public UpdateState updateConst(ConstVO constant, String field, String value) {
		// TODO Auto-generated method stub
		ManageConst manageConst=new ManageConst();
		return manageConst.updateConst(constant, field, value);
		
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
		return manageConst.addConst(constant);
	}

	
	

}
