package businesslogic.Mock.Manage;

import java.util.ArrayList;

import data.State.UpdateState;
import VO.SalaryVO;
import businesslogic.Impl.Manage.ManageSalary;
import data.State.*;

public class MockManageSalary extends ManageSalary{
	
	@Override
	public UpdateState updatePayment(SalaryVO salary, String field, String value) {
		// TODO Auto-generated method stub
		return UpdateState.SUCCESS;
	}

	@Override
	public ArrayList<SalaryVO> showSalary() {
		// TODO Auto-generated method stub
		return new ArrayList<SalaryVO>();
	}
}
