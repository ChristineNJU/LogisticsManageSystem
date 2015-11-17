package businesslogic.Service.Manage;

import java.util.ArrayList;

import VO.BenefitVO;
import VO.ConstVO;
import VO.CostVO;
import VO.GatheringVO;
import VO.InstitutionVO;
import VO.SalaryVO;
import VO.StaffVO;
import VO.VO;
import data.State.AddState;
import data.State.DeleteState;
import data.State.UpdateState;

public interface ManageService {
	
	public AddState addConst(ConstVO constant);
	public AddState addInstitution (InstitutionVO institution);
	public AddState addStaff (StaffVO staff);
	public DeleteState deleteInstitution (InstitutionVO insitiution);
	public DeleteState DeleteStaff (String id);
	public BenefitVO searchBenefit(String time_end);
	public ArrayList<CostVO> searchCost(String time_start, String time_end);
	public ArrayList<GatheringVO> searchGathering(String date, String businesslobby);
	public ArrayList<InstitutionVO> searchInstitution (String id);
	public ArrayList<StaffVO> searchStaff (String id);
	public ArrayList<ConstVO> showConst();
	public ArrayList<VO> showReceipt();
	public ArrayList<SalaryVO> showSalary();
	public UpdateState updateConst(ConstVO constant, String field, String value);
	public UpdateState UpdateInstitution (InstitutionVO institution, String field,String value);
	public UpdateState updatePayment (SalaryVO salary, String field, String value);
	public UpdateState updateReceipt(VO receipt);
	public UpdateState updateStaff (StaffVO staff, String field, String value);
	
}
