package businesslogic.Impl.Manage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.SalaryPO;
import State.UpdateState;
import VO.SalaryVO;
import businesslogic.Service.Manage.ShowSalaryService;
import businesslogic.Service.Manage.UpdatePaymentService;
import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchSalaryService;
import data.Service.Update.UpdateService;

public class ManageSalary implements ShowSalaryService,UpdatePaymentService{

	@Override
	public UpdateState updatePayment(SalaryVO salary, String field, String value) {
		// TODO Auto-generated method stub
		UpdateState result=UpdateState.NOTFOUND;
		try {
			UpdateService updateService=(UpdateService) Naming.lookup(RMIHelper.UPDATE_IMPL);
			
			SearchSalaryService searchSalary=(SearchSalaryService) Naming.lookup(RMIHelper.SEARCH_SALARY_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("Salary_Type like '%%'");
			ArrayList<SalaryPO> searchResult=searchSalary.searchSalary(requirement);
			
			if(searchResult.isEmpty()){
				System.out.println("not found");
				return UpdateState.CONNECTERROR;
			}
			else{
				for(int i=0;i<searchResult.size();i++)
					result=updateService.update(searchResult.get(i), field, value);
			}
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			result=UpdateState.CONNECTERROR;
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public ArrayList<SalaryVO> showSalary() {
		// TODO Auto-generated method stub
		ArrayList<SalaryVO> result=new ArrayList<SalaryVO>();
		try {
			SearchSalaryService searchSalary=(SearchSalaryService) Naming.lookup(RMIHelper.SEARCH_SALARY_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("Salary_Name like '%%'");
			ArrayList<SalaryPO> searchResult=searchSalary.searchSalary(requirement);
			
			if(searchResult.isEmpty()){
				System.out.println("not found");
				return result;
				}
			else{
				for(int i=0;i<searchResult.size();i++){
					SalaryVO temp=new SalaryVO(searchResult.get(i));
					result.add(temp);
				}
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
		}
		
		return result;
	}

}
