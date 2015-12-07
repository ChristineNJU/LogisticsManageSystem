package businesslogic.Service.Manage;

import java.util.ArrayList;

import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.ArrivalVO;
import VO.BalanceVO;
import VO.BenefitVO;
import VO.ConstVO;
import VO.CostVO;
import VO.DeliveryVO;
import VO.DistanceVO;
import VO.EntruckingVO;
import VO.GatheringVO;
import VO.InstitutionVO;
import VO.RemovalVO;
import VO.SalaryVO;
import VO.StaffVO;
import VO.StorageVO;
import VO.TransferVO;
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
	
	/**
	 * 查询出款单
	 * 
	 * @param time_start 起始时间
	 * @param time_end 截止时间
	 * @return CostVO的ArrayList
	 * */
	public ArrayList<CostVO> searchCost(String time_start, String time_end);
	
	/**
	 * 查询收款单
	 * 
	 * @param date 收款日期
	 * @param businesslobby 营业厅
	 * @return GatheringVO的ArrayList
	 * */
	public ArrayList<GatheringVO> searchGathering(String date, String businesslobby);
	
	/**
	 * 查询机构信息
	 * 
	 * @param id 机构ID
	 * @return InstitutionVO的ArrayList
	 * */
	public ArrayList<InstitutionVO> searchInstitution (String id);
	
	/**
	 * 查询收款单
	 * 
	 * @param id 人员ID
	 * @return StaffVO的ArrayList
	 * */
	public ArrayList<StaffVO> searchStaff (String id);
	
	/**
	 * 查询常量
	 * 
	 * @return ConstVO的ArrayList
	 * */
	public ArrayList<ConstVO> showConst();
	
//	/**
//	 * 显示所有单据
//	 * 
//	 * @return VO的ArrayList
//	 * */
//	public ArrayList<VO> showReceipt();
//	
	/**
	 * 查询薪水信息
	 * 
	 * @return SalaryVO的ArrayList
	 * */
	public ArrayList<SalaryVO> showSalary();
	
	/**
	 * 更新常量
	 * 
	 * @param constant ConstVO
	 * @return 更新状态
	 * */
	public UpdateState updateConst(ConstVO constant);
	
	/**
	 * 更新机构
	 * 
	 * @param institution institutionVO
	 * @return 更新状态
	 * */
	public UpdateState UpdateInstitution (InstitutionVO institution);
	
	/**
	 * 更新薪水
	 * 
	 * @param salary SalaryVO
	 * @return 更新状态
	 * */
	public UpdateState updatePayment (SalaryVO salary);
	
	/**
	 * 更新单据
	 * 
	 * @param receipt VO
	 * @return 更新状态
	 * */
	public UpdateState updateReceipt(VO receipt);
	
	/**
	 * 更新人员
	 * 
	 * @param staff StaffVO
	 * @return 更新状态
	 * */
	public UpdateState updateStaff (StaffVO staff);
	
	/**
	 * 获取距离
	 * 
	 * @return DistanceVO的ArrayList
	 * */
	public ArrayList<DistanceVO> getDistance();
	
	/**
	 * 更新距离
	 * 
	 * @param distance 新距离
	 * @return 更新状态
	 * */
	public UpdateState updateDistance(DistanceVO distance);

	/**
	 * 显示未评审ArrivalVO
	 * @return ArrayList<ArrivalVO>
	 */
	public ArrayList<ArrivalVO> showArrival();
	
	/**
	 * 显示未评审BalanceVO
	 * @return ArrayList<ArrivalVO>
	 */
	public ArrayList<BalanceVO> showBalance();
	
	/**
	 * 显示未评审CostVO
	 * @return ArrayList<CostVO>
	 */
	public ArrayList<CostVO> showCost();
	
	/**
	 * 显示未评审DeliveryVO
	 * @return ArrayList<DeliveryVO>
	 */
	public ArrayList<DeliveryVO> showDelivery();
	
	/**
	 * 显示未评审EntruckingVO
	 * @return ArrayList<EntruckingVO>
	 */
	public ArrayList<EntruckingVO> showEntrucking();
	
	/**
	 * 显示未评审GatheringVO
	 * @return ArrayList<GatheringVO>
	 */
	public ArrayList<GatheringVO> showGathering();
	
	/**
	 * 显示未评审RemovalVO
	 * @return ArrayList<RemovalVO>
	 */
	public ArrayList<RemovalVO> showRemoval();
	
	/**
	 * 显示未评审StorageVO
	 * @return ArrayList<StorageVO>
	 */
	public ArrayList<StorageVO> showStorage();
	
	/**
	 * 显示未评审TransferVO
	 * @return ArrayList<TransferVO>
	 */
	public ArrayList<TransferVO> showTransfer();
	
	
}
