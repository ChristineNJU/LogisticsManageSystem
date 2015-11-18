package VO;

import PO.SalaryPO;
import State.SalaryType;
import State.UserRole;

public class SalaryVO extends VO {

	private UserRole role = null;
	private double salary = 0;
	private SalaryType salaryType = null;
	
	public SalaryVO(UserRole role,double salary,SalaryType salaryType){
		this.role = role;
		this.salary = salary;
		this.salaryType = salaryType;
	}
	public SalaryVO(SalaryPO po) {
		this.role = po.getStaff();
		this.salary = po.getSalary();
		this.salaryType = po.getType();
	}
	
	public UserRole getRole(){
		return this.role;
	}
	public double getSalary(){
		return this.salary;
	}
	public SalaryType getType(){
		return this.salaryType;
	}
}
