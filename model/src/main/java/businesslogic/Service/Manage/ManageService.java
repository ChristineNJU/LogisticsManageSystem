package businesslogic.Service.Manage;

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
/**
 * 总经理业务的接口
 * 
 * @author 张晨剑
 * @version 1.0.0
 * */
public interface ManageService {
	
	/**
	 * 添加常量
	 * 
	 * @param constant ConstVO
	 * @return 添加状态
	 * */
	public AddState addConst(ConstVO constant);
	
	/**
	 * 添加机构
	 * 
	 * @param institution InstitutionVO
	 * @return 添加状态
	 * */
	public AddState addInstitution (InstitutionVO institution);
	
	/**
	 * 添加人员
	 * 
	 * @param constant ConstVO
	 * @return 添加状态
	 * */
	public AddState addStaff (StaffVO staff);
	
	/**
	 * 删除机构
	 * 
	 * @param insitiution InstitutionVO
	 * @return 删除状态
	 * */
	public DeleteState deleteInstitution (InstitutionVO insitiution);
	
	/**
	 * 删除人员
	 * 
	 * @param staff StaffVO
	 * @return 删除状态
	 * */
	public DeleteState DeleteStaff (StaffVO staff);
	
	/**
	 * 查询成本收益
	 * 
	 * @param time_end 截止时间
	 * @return BenefitVO
	 * */
	public BenefitVO searchBenefit(String time_end);
	public ArrayList<CostVO> searchCost(String time_start, String time_end);
	public ArrayList<GatheringVO> searchGathering(String date, String businesslobby);
	public ArrayList<InstitutionVO> searchInstitution (String id);
	public ArrayList<StaffVO> searchStaff (String id);
	public ArrayList<ConstVO> showConst();
	public ArrayList<VO> showReceipt();
	public ArrayList<SalaryVO> showSalary();
	public UpdateState updateConst(ConstVO constant);
	public UpdateState UpdateInstitution (InstitutionVO institution);
	public UpdateState updatePayment (SalaryVO salary);
	public UpdateState updateReceipt(VO receipt);
	public UpdateState updateStaff (StaffVO staff);
	
}
