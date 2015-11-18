package test.Driver.businesslogic;

import java.util.ArrayList;

import VO.*;
import test.Stub.businesslogic.ManageBlService_Stub;

public class Manage_Driver {
	public void drive(ManageBlService_Stub managebl){
		ArrayList<String> list0=new ArrayList<String>();
			list0.add("1234512345");
			list0.add("1234512346");
		
		ArrayList<VO> list1=new ArrayList<VO>();	
		list1=(managebl.showReceipt());

		System.out.println(managebl.updateReceipt(null));
		
		System.out.println(managebl.addConst(null));
	
		System.out.println(managebl.updateConst(null, null, null));
		
		ArrayList<ConstVO> list2=new ArrayList<ConstVO>();	
		list2=managebl.showConst();
		for(int i=0;i<list2.size();i++){
			System.out.println(list2.get(i).getName());
		}
		
		ArrayList<CostVO> list3=new ArrayList<CostVO>();	
		list3=managebl.searchCost(null, null);
		for(int i=0;i<list3.size();i++){
			System.out.println(list3.get(i).getType());
		}
		
		ArrayList<GatheringVO> list4=new ArrayList<GatheringVO>();	
		list4=managebl.searchGathering(null, null);
		for(int i=0;i<list4.size();i++){
			System.out.println(list4.get(i).getName());
		}
		
		System.out.println(managebl.searchBenefit(null).getIncome());
		
		ArrayList<StaffVO> list5=new ArrayList<StaffVO>();	
		list5=managebl.searchStaff(null);
		for(int i=0;i<list5.size();i++){
			System.out.println(list5.get(i).getName());
		}
		
		System.out.println(managebl.updateStaff(null, null, null));
		
		System.out.println(managebl.addStaff(null));
		
		System.out.println(managebl.DeleteStaff(null));
		
		ArrayList<InstitutionVO> list6=new ArrayList<InstitutionVO>();	
		list6=managebl.searchInstitution(null);
		for(int i=0;i<list6.size();i++){
			System.out.println(list6.get(i).getType());
		}
		
		System.out.println(managebl.UpdateInstitution(null, null, null));
		
		System.out.println(managebl.addInstitution(null));
		
		System.out.println(managebl.DeleteStaff(null));
		
		ArrayList<SalaryVO> list7=new ArrayList<SalaryVO>();	
		list7=managebl.showSalary();
		for(int i=0;i<list7.size();i++){
			System.out.println(list7.get(i).getRole());
		}
		
		System.out.println(managebl.updatePayment(null, null, null));
  }
  
}
