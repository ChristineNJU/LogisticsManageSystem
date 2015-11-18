package businesslogic.Service.Manage;

import State.UpdateState;
import VO.SalaryVO;

public interface UpdatePaymentService {
	public UpdateState updatePayment (SalaryVO salary, String field, String value);
}
