
package PO;

import State.InstitutionType;
import State.StateSwitch;
import State.UserRole;
import VO.StaffVO;
import VO.UserVO;
import businesslogic.URLHelper.URLHelper;

/**
 * 用来保存用户信息的持久化数据格式
 * 
 * @author 尹子越
 * @version 1.0.0
 * */
public class UserPO extends PO {
	private String id;
	private String password;
	private String name;
	private String sex;
	private int age;
	private InstitutionType institution;
	private String city;
	private UserRole role;
		
	/**
	 * 直接创建用户信息的持久化数据对象
	 * */
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
	
	/**
	 * 通过StaffVO创建用户信息的持久化数据对象
	 * */
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
	
	/**
	 * 通过UserVO创建用户信息的持久化数据对象
	 * */
	public UserPO(UserVO user){
		super(URLHelper.getUserURL());
		this.id=user.getId();
		this.password=user.getId();//the default password is same as ID
		this.name=user.getName();
		this.sex=user.getSex();
		this.age=user.getAge();
		this.institution=user.getInstitution();
		this.city=user.getCity();
		this.role=user.getRole();
	}

	/**
	 * 获取用户姓名
	 * 
	 * @return 用户姓名String
	 * */
	public String getName() {
		return name;
	}
	
	/**
	 * 获取用户ID
	 * 
	 * @return 用户IDString
	 * */
	public String getID() {
		return id;
	}
	
	/**
	 * 获取密码
	 * 
	 * @return 密码String
	 * */
	public String getPassword() {
		return password;
	}
	
	/**
	 * 获取性别
	 * 
	 * @return 性别String
	 * */
	public String getSex() {
		return sex;
	}
	
	/**
	 * 获取年龄
	 * 
	 * @return 年龄
	 * */
	public int getAge() {
		return age;
	}
	
	/**
	 * 获取机构类型
	 * 
	 * @return 机构类型InstitutionType
	 * */
	public InstitutionType getInstitution() {
		return institution;
	}
	
	/**
	 * 获取城市
	 * 
	 * @return 城市String
	 * */
	public String getCity() {
		return city;
	}
	
	/**
	 * 获取职责
	 * 
	 * @return 职责String
	 * */
	public UserRole getRole() {
		return role;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		String result = "";
		
		result = result + "'" + id + "', ";
		result = result + "'" + password + "', ";
		result = result + "'" + name + "', ";
		result = result + "'" + sex + "', ";
		result = result + age + ", ";
		result = result + "'" + StateSwitch.switchToStr(institution) + "', ";
		result = result + "'" + city + "', ";
		result = result + "'" + StateSwitch.switchToStr(role) + "'";
		
		System.out.println(result);
		return result;
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "id = '"+id+"'";
	}
}
