package PO;

import businesslogic.URLHelper.URLHelper;
import State.InstitutionType;
import State.UserRole;
import VO.StaffVO;

public class UserPO extends PO {
	private String id;
	private String password;
	private String name;
	private String sex;
	private int age;
	private InstitutionType institution;
	private String city;
	private UserRole role;
		
	public UserPO(String id, String password, String name, String sex, int age, 
			InstitutionType institution, String city, UserRole role, String DB_URL) {
		super(DB_URL);
		this.id = id;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.institution = institution;
		this.city = city;
		this.role = role;		
	}
	
	public UserPO(StaffVO staff){
		super(URLHelper.getUserURL());
		this.id = staff.getSystemId();
		this.password = staff.getPassword();
		this.name = staff.getName();
		this.sex = staff.getSex();
		this.age = staff.getAge();
		this.institution = staff.getInsitution();
		this.city = staff.getCity();
		this.role = staff.getPosition();	
	}

	public String getName() {
		return name;
	}
	public String getID() {
		return id;
	}
	public String getPassword() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public int getAge() {
		return age;
	}
	public InstitutionType getInstitution() {
		return institution;
	}
	public String getCity() {
		return city;
	}
	public UserRole getRole() {
		return role;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "'"+id+"', '"+password+"', '"+name+"', '"+"'";
	}
}
