package PO;

import businesslogic.State.SalaryType;
import businesslogic.State.UserRole;

public class SalaryPO extends PO {

	private UserRole staff = null;
	private double salary = 0;
	private SalaryType type = null;
	
	
	public SalaryPO(UserRole staff, double salary, SalaryType type, String DB_URL) {
		super(DB_URL);
		// TODO Auto-generated constructor stub
		this.staff = staff;
		this.salary = salary;
		this.type = type;
	}
	
	/*==================================================================
	 * Public方法
	 * */
	
	/*------------------------------------------------------------------
	 * 对SalaryPO的数据进行读取
	 * */
	/*
	 * 获取工作人员
	 * 返回UserRole
	 * */
	public UserRole getStaff() {
		return staff;
	}
	/*
	 * 获取薪水
	 * 返回double
	 * */
	public double getSalary() {
		return salary;
	}
	/*
	 * 获取薪水策略
	 * 返回SalaryType
	 * */
	public SalaryType getType() {
		return type;
	}
	
	
	/*--------------------------------------------------------------
	 * 对SalaryPO的某些信息进行更新
	 * */
	/*
	 * 更新薪水
	 * */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	/*
	 * 更新薪水策略
	 * */
	public void setType(SalaryType type) {
		this.type = type;
	}
	
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
