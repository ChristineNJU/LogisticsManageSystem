package PO;

import java.util.ArrayList;

import businesslogic.State.InstitutionType;

public class InstitutionPO extends PO {
	
	private String institution_name = null;
	private InstitutionType institution_type = null;
	private String city = null;
	private String institution_number = null;
	
	public InstitutionPO(String institution_name, InstitutionType institution_type, String city, String institution_number, 
			 String DB_URL) {
		super(DB_URL);
		// TODO Auto-generated constructor stub
		this.institution_name = institution_name;
		this.institution_type = institution_type;
		this.city = city;
		this.institution_number = institution_number;
	}
	
	/*===============================================================
	 * Public方法
	 * */
	
	/*---------------------------------------------------------------
	 * 对InstitutionPO的数据进行读取
	 * */
	/*
	 * 获取机构名称
	 * 返回String
	 * */
	public String getInstitutionName() {
		return institution_name;
	}
	/*
	 * 获取机构类型
	 * 返回InstitutionType
	 * */
	public InstitutionType getInstitutionType() {
		return institution_type;
	}
	/*
	 * 获取机构所在城市
	 * 返回String
	 * */
	public String getCity() {
		return city;
	}
	/*
	 * 获取机构编号
	 * 返回String
	 * */
	public String getInstitutionNumber() {
		return institution_number;
	}
	
	
	/*--------------------------------------------------------------
	 * 对InstitutionPO的某些信息进行更新
	 * */
	/*
	 * 更新机构名称
	 * */
	public void setInstitutionName(String institution_name) {
		this.institution_name = institution_name;
	}

	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
