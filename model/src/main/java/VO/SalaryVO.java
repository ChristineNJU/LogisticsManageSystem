package VO;

import PO.SalaryPO;
import State.SalaryType;
import State.UserRole;

// TODO: Auto-generated Javadoc
/**
 * The Class SalaryVO.
 */
public class SalaryVO extends VO {

	/** The role. */
	private UserRole role = null;
	
	/** The salary. */
	private double salary = 0;
	
	/** The salary type. */
	private SalaryType salaryType = null;
	
	/**
	 * Instantiates a new salary vo.
	 *
	 * @param role the role
	 * @param salary the salary
	 * @param salaryType the salary type
	 */
	public SalaryVO(UserRole role,double salary,SalaryType salaryType){
		this.role = role;
		this.salary = salary;
		this.salaryType = salaryType;
	}
	
	/**
	 * Instantiates a new salary vo.
	 *
	 * @param po the po
	 */
	public SalaryVO(SalaryPO po) {
		this.role = po.getStaff();
		this.salary = po.getSalary();
		this.salaryType = po.getType();
	}
	
	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	public UserRole getRole(){
		return this.role;
	}
	
	/**
	 * Gets the salary.
	 *
	 * @return the salary
	 */
	public double getSalary(){
		return this.salary;
	}
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public SalaryType getType(){
		return this.salaryType;
	}
}
