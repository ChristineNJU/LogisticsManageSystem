package VO;

import PO.UserPO;
import State.InstitutionType;
import State.UserRole;

public class StaffVO extends VO {

	private String name = "";
	private String sex = "";
	private int age = 0;
	private InstitutionType institution = null;
	private UserRole role =  null;
	private String systemId = "";
	private String city="";
	private String password="";
	
	public StaffVO(String name,String sex,int age,
			InstitutionType institution,UserRole role,String systemId,String city,String password){
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.institution = institution;
		this.role = role;
		this.systemId = systemId;
		this.city=city;
		this.password=password;
	}
	public StaffVO(UserPO po) {
		this.name = po.getName();
		this.sex = po.getSex();
		this.age = po.getAge();
		this.institution = po.getInstitution();
		this.role = po.getRole();
		this.systemId = po.getID();
		this.city=po.getCity();
		this.password=po.getPassword();
	} 
	
	public String getName(){
		return this.name;
	}
	public String getSex(){
		return this.sex;
	}
	public int getAge(){
		return this.age;
	}
	public InstitutionType getInsitution(){
		return this.institution;
	}
	public UserRole getPosition(){
		return this.role;
	}
	public String getSystemId(){
		return this.systemId;
	}
	public String getCity(){
		return this.city;
	}
	public String getPassword(){
		return this.password;
	}
}
