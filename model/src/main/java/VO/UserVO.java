package VO;

import PO.UserPO;
import State.InstitutionType;
import State.UserRole;

public class UserVO extends VO {

	private String id = null;
	private String name = null;
	private UserRole role = null;
	private String sex;
	private int age;
	private InstitutionType institution;
	private String city;
	
	public UserVO(String id,String name,UserRole role,String sex,int age, InstitutionType institution,String city){
		this.id = id;
		this.name = name;
		this.role = role;
		this.sex=sex;
		this.age=age;
		this.institution=institution;
		this.city=city;
	}
	public UserVO(UserPO po) {
		this.id = po.getID();
		this.name = po.getName();
		this.role = po.getRole();
		this.sex=po.getSex();
		this.age=po.getAge();
		this.institution=po.getInstitution();
		this.city=po.getCity();
	}
	public String getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	public UserRole getRole(){
		return this.role;
	}
	public String getSex() {
		// TODO Auto-generated method stub
		return this.sex;
	}
	public int getAge() {
		// TODO Auto-generated method stub
		return this.age;
	}
	public InstitutionType getInstitution() {
		// TODO Auto-generated method stub
		return this.institution;
	}
	public String getCity() {
		// TODO Auto-generated method stub
		return this.city;
	}
	
	public void setId(String id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setRole(UserRole role){
		this.role = role;
	}
	public void setSex(String sex){
		this.sex=sex;
	}
	public void setAge(int age){
		this.age=age;
	}
	public void setIstitution(InstitutionType institution){
		this.institution=institution;
	}
	public void setCity(String city){
		this.city=city;
	}
	
}
