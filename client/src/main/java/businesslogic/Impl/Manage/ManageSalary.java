package businesslogic.Impl.Manage;

import java.util.ArrayList;

import data.State.UpdateState;
import businesslogic.Service.Manage.ShowSalaryService;
import businesslogic.Service.Manage.UpdatePaymentService;
import businesslogic.VO.SalaryVO;

public class ManageSalary implements ShowSalaryService,UpdatePaymentService{

	@Override
	public UpdateState updatePayment(SalaryVO salary, String field, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<SalaryVO> showSalary() {
		// TODO Auto-generated method stub
		return null;
	}

}