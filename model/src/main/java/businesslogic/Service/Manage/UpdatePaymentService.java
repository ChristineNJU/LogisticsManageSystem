package businesslogic.Service.Manage;

import State.UpdateState;
import VO.SalaryVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface UpdatePaymentService.
 */
public interface UpdatePaymentService {
	
	/**
	 * Update payment.
	 *
	 * @param salary the salary
	 * @return the update state
	 */
	public UpdateState updatePayment (SalaryVO salary);
}
