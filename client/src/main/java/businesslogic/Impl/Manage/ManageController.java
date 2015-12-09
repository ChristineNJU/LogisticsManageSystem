package businesslogic.Impl.Manage;

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
import businesslogic.Service.Manage.ManageService;
import businesslogic.SystemLog.SystemLog;

// TODO: Auto-generated Javadoc
/**
 * The Class ManageController.
 */
public class ManageController implements ManageService{

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.ManageService#DeleteStaff(VO.StaffVO)
	 */
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

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.ManageService#searchStaff(java.lang.String)
	 */
	@Override
	public ArrayList<StaffVO> searchStaff(String id) {
		// TODO Auto-generated method stub
		ManageStaff manageStaff=new ManageStaff();
		return manageStaff.searchStaff(id);
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.ManageService#updateStaff(VO.StaffVO)
	 */
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

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.ManageService#addStaff(VO.StaffVO)
	 */
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

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.ManageService#updatePayment(VO.SalaryVO)
	 */
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

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.ManageService#showSalary()
	 */
	@Override
	public ArrayList<SalaryVO> showSalary() {
		// TODO Auto-generated method stub
		ManageSalary manageSalary=new ManageSalary();
		return manageSalary.showSalary();
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.ManageService#updateReceipt(VO.VO)
	 */
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

//	@Override
//	public ArrayList<VO> showReceipt() {
//		// TODO Auto-generated method stub
//		ManageReceipt manageReceipt=new ManageReceipt();
//		return manageReceipt.showReceipt();
//	}

	/* (non-Javadoc)
 * @see businesslogic.Service.Manage.ManageService#searchGathering(java.lang.String, java.lang.String)
 */
@Override
	public ArrayList<GatheringVO> searchGathering(String date,
			String businesslobby) {
		// TODO Auto-generated method stub
		ManageFinance manageFinance=new ManageFinance();
		return manageFinance.searchGathering(date, businesslobby);
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.ManageService#searchCost(java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<CostVO> searchCost(String time_start, String time_end) {
		// TODO Auto-generated method stub
		ManageFinance manageFinance=new ManageFinance();
		return manageFinance.searchCost(time_start, time_end);
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.ManageService#searchBenefit(java.lang.String)
	 */
	@Override
	public BenefitVO searchBenefit(String time_end) {
		// TODO Auto-generated method stub
		ManageFinance manageFinance=new ManageFinance();
		return manageFinance.searchBenefit(time_end);
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.ManageService#searchInstitution(java.lang.String)
	 */
	@Override
	public ArrayList<InstitutionVO> searchInstitution(String id) {
		// TODO Auto-generated method stub
		ManageInstitution manageInstitution=new ManageInstitution();
		return manageInstitution.searchInstitution(id);
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.ManageService#deleteInstitution(VO.InstitutionVO)
	 */
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

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.ManageService#UpdateInstitution(VO.InstitutionVO)
	 */
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
	
	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.ManageService#addInstitution(VO.InstitutionVO)
	 */
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

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.ManageService#updateConst(VO.ConstVO)
	 */
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

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.ManageService#showConst()
	 */
	@Override
	public ArrayList<ConstVO> showConst() {
		// TODO Auto-generated method stub
		ManageConst manageConst=new ManageConst();
		return manageConst.showConst();
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.ManageService#addConst(VO.ConstVO)
	 */
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

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.ManageService#getDistance()
	 */
	@Override
	public ArrayList<DistanceVO> getDistance() {
		// TODO Auto-generated method stub
		ManageConst manageConst=new ManageConst();
		return manageConst.getDistance();
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.ManageService#updateDistance(VO.DistanceVO)
	 */
	@Override
	public UpdateState updateDistance(DistanceVO distance) {
		// TODO Auto-generated method stub
		ManageConst manageConst = new ManageConst();
		UpdateState state = manageConst.updateDistance(distance);
		if(state==UpdateState.SUCCESS){
			SystemLog.addLog("更新距离信息");
		}
		return state;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.ManageService#showArrival()
	 */
	@Override
	public ArrayList<ArrivalVO> showArrival() {
		// TODO Auto-generated method stub
		ManageShowReceipt manageShowReceipt = new ManageShowReceipt();
		ArrayList<ArrivalVO> result = manageShowReceipt.showArrival();
		return result;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.ManageService#showBalance()
	 */
	@Override
	public ArrayList<BalanceVO> showBalance() {
		// TODO Auto-generated method stub
		ManageShowReceipt manageShowReceipt = new ManageShowReceipt();
		ArrayList<BalanceVO> result = manageShowReceipt.showBalance();
		return result;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.ManageService#showCost()
	 */
	@Override
	public ArrayList<CostVO> showCost() {
		// TODO Auto-generated method stub
		ManageShowReceipt manageShowReceipt = new ManageShowReceipt();
		ArrayList<CostVO> result = manageShowReceipt.showCost();
		return result;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.ManageService#showDelivery()
	 */
	@Override
	public ArrayList<DeliveryVO> showDelivery() {
		// TODO Auto-generated method stub
		ManageShowReceipt manageShowReceipt = new ManageShowReceipt();
		ArrayList<DeliveryVO> result = manageShowReceipt.showDelivery();
		return result;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.ManageService#showEntrucking()
	 */
	@Override
	public ArrayList<EntruckingVO> showEntrucking() {
		// TODO Auto-generated method stub
		ManageShowReceipt manageShowReceipt = new ManageShowReceipt();
		ArrayList<EntruckingVO> result = manageShowReceipt.showEntrucking();
		return result;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.ManageService#showGathering()
	 */
	@Override
	public ArrayList<GatheringVO> showGathering() {
		// TODO Auto-generated method stub
		ManageShowReceipt manageShowReceipt = new ManageShowReceipt();
		ArrayList<GatheringVO> result = manageShowReceipt.showGathering();
		return result;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.ManageService#showRemoval()
	 */
	@Override
	public ArrayList<RemovalVO> showRemoval() {
		// TODO Auto-generated method stub
		ManageShowReceipt manageShowReceipt = new ManageShowReceipt();
		ArrayList<RemovalVO> result = manageShowReceipt.showRemoval();
		return result;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.ManageService#showStorage()
	 */
	@Override
	public ArrayList<StorageVO> showStorage() {
		// TODO Auto-generated method stub
		ManageShowReceipt manageShowReceipt = new ManageShowReceipt();
		ArrayList<StorageVO> result = manageShowReceipt.showStorage();
		return result;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.ManageService#showTransfer()
	 */
	@Override
	public ArrayList<TransferVO> showTransfer() {
		// TODO Auto-generated method stub
		ManageShowReceipt manageShowReceipt = new ManageShowReceipt();
		ArrayList<TransferVO> result = manageShowReceipt.showTransfer();
		return result;
	}

}
