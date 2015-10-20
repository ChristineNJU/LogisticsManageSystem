package businesslogic.PO;

import java.util.ArrayList;

import businesslogic.State.UserRole;

public class UserPO extends PO {
	private String id;
	private String password;
	private String name;
	private UserRole role;
	
	private ArrayList<String> Ins_DB_LA;
	
	public UserPO(String id, String password, String name, UserRole role,
					String DB_LA, ArrayList<String> Ins_DB_LA) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.role = role;
		
		super.DB_LA = DB_LA;
		this.Ins_DB_LA = Ins_DB_LA;
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
	public UserRole getRole() {
		return role;
	}

	public ArrayList<String> getInsDBLA() {
		return Ins_DB_LA;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "'"+id+"', '"+password+"', '"+name+"', '"+"'";
	}
}
