package businesslogic.Service.Manage;

import dataservice.State.UpdateState;

public interface UpdatePaymentService {
	public UpdateState updatePayment (SalaryVO salary, String field, String value);
}
