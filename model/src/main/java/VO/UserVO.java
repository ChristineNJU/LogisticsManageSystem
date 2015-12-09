package VO;

import PO.UserPO;
import State.InstitutionType;
import State.UserRole;

// TODO: Auto-generated Javadoc
/**
 * The Class UserVO.
 */
public class UserVO extends VO {

	/** The id. */
	private String id = null;
	
	/** The name. */
	private String name = null;
	
	/** The role. */
	private UserRole role = null;
	
	/** The sex. */
	private String sex = null;
	
	/** The age. */
	private int age;
	
	/** The institution. */
	private InstitutionType institution;
	
	/** The city. */
	private String city;
	

	/**
	 * Instantiates a new user vo.
	 *
	 * @param id the id
	 * @param name the name
	 * @param role the role
	 * @param sex the sex
	 * @param age the age
	 * @param type the type
	 */
	public UserVO(String id,String name,UserRole role,String sex,int age,InstitutionType type){
		this.id = id;
		this.name = name;
		this.id = id;
		this.name = name;
		this.role = role;
		this.sex = sex;
		this.age = age;
		this.institution = type;
		
	}
	
	/**
	 * Instantiates a new user vo.
	 *
	 * @param id the id
	 * @param name the name
	 * @param role the role
	 */
	public UserVO(String id,String name,UserRole role){
		this.id = id;
		this.name = name;
		this.role = role;
	}
	
	/**
	 * Instantiates a new user vo.
	 *
	 * @param id the id
	 * @param name the name
	 * @param role the role
	 * @param sex the sex
	 * @param age the age
	 * @param institution the institution
	 * @param city the city
	 */
	public UserVO(String id,String name,UserRole role,String sex,int age, InstitutionType institution,String city){

		this.id = id;
		this.name = name;
		this.role = role;
		this.sex=sex;
		this.age=age;
		this.institution=institution;
		this.city=city;
	}
	
	/**
	 * Instantiates a new user vo.
	 *
	 * @param po the po
	 */
	public UserVO(UserPO po) {
		this.id = po.getID();
		this.name = po.getName();
		this.role = po.getRole();
		this.sex=po.getSex();
		this.age=po.getAge();
		this.institution=po.getInstitution();
		this.city=po.getCity();
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId(){
		return this.id;
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
	 * Gets the role.
	 *
	 * @return the role
	 */
	public UserRole getRole(){
		return this.role;
	}
	
	/**
	 * Gets the sex.
	 *
	 * @return the sex
	 */
	public String getSex() {
		// TODO Auto-generated method stub
		return this.sex;
	}
	
	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public int getAge() {
		// TODO Auto-generated method stub
		return this.age;
	}
	
	/**
	 * Gets the institution.
	 *
	 * @return the institution
	 */
	public InstitutionType getInstitution() {
		// TODO Auto-generated method stub
		return this.institution;
	}
	
	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		// TODO Auto-generated method stub
		return this.city;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id){
		this.id = id;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * Sets the role.
	 *
	 * @param role the new role
	 */
	public void setRole(UserRole role){
		this.role = role;
	}
	
	/**
	 * Sets the sex.
	 *
	 * @param sex the new sex
	 */
	public void setSex(String sex){
		this.sex=sex;
	}
	
	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(int age){
		this.age=age;
	}
	
	/**
	 * Sets the istitution.
	 *
	 * @param institution the new istitution
	 */
	public void setIstitution(InstitutionType institution){
		this.institution=institution;
	}
	
	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city){
		this.city=city;
	}
	
}
