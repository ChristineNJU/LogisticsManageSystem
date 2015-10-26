package businesslogic.VO;

import businesslogic.PO.UserPO;
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
	public UserVO(UserPO po) {
		this.id = po.getID();
		this.name = po.getName();
		this.role = po.getRole();
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
	
	public void setId(String id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setRole(UserRole role){
		this.role = role;
	}
}
