package businesslogic.VO;

import businesslogic.State.UserRole;

public class UserVO extends VO {

	private String id = null;
	private String name = null;
	private UserRole role = null;
	
	public UserVO(String id,String name,UserRole role){
		this.id = id;
		this.name = name;
		this.role = role;
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
}
