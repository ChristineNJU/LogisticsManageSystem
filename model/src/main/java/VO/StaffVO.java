package VO;

import PO.UserPO;
import State.InstitutionType;
import State.UserRole;

// TODO: Auto-generated Javadoc
/**
 * The Class StaffVO.
 */
public class StaffVO extends VO {

	/** The name. */
	private String name = "";
	
	/** The sex. */
	private String sex = "";
	
	/** The age. */
	private int age = 0;
	
	/** The institution. */
	private InstitutionType institution = null;
	
	/** The role. */
	private UserRole role =  null;
	
	/** The system id. */
	private String systemId = "";
	
	/** The city. */
	private String city="";
	
	/** The password. */
	private String password="";
	
	/**
	 * Instantiates a new staff vo.
	 *
	 * @param name the name
	 * @param sex the sex
	 * @param age the age
	 * @param institution the institution
	 * @param role the role
	 * @param systemId the system id
	 * @param city the city
	 * @param password the password
	 */
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
	
	/**
	 * Instantiates a new staff vo.
	 *
	 * @param po the po
	 */
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
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Gets the sex.
	 *
	 * @return the sex
	 */
	public String getSex(){
		return this.sex;
	}
	
	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public int getAge(){
		return this.age;
	}
	
	/**
	 * Gets the insitution.
	 *
	 * @return the insitution
	 */
	public InstitutionType getInsitution(){
		return this.institution;
	}
	
	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	public UserRole getPosition(){
		return this.role;
	}
	
	/**
	 * Gets the system id.
	 *
	 * @return the system id
	 */
	public String getSystemId(){
		return this.systemId;
	}
	
	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity(){
		return this.city;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword(){
		return this.password;
	}
}
