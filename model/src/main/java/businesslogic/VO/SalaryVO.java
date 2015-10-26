package businesslogic.VO;

import businesslogic.PO.SalaryPO;
import businesslogic.State.SalaryType;

public class SalaryVO extends VO {

	private String name = null;
	private double salary = 0;
	private SalaryType salaryType = null;
	
	public SalaryVO(String name,double salary,SalaryType salaryType){
		this.name = name;
		this.salary = salary;
		this.salaryType = salaryType;
	}
}
	
	public String getName(){
		return this.name;
	}
	public double getSalary(){
		return this.salary;
	}
	public SalaryType getType(){
		return this.salaryType;
	}
}
