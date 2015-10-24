package businesslogic.PO;

import java.util.ArrayList;

import businesslogic.State.UserRole;

public class UserPO extends PO {
	private String id;
	private String password;
	private String name;
	private UserRole role;
	
	private ArrayList<String> Ins_DB_URL;
	
	public UserPO(String id, String password, String name, UserRole role,
					String DB_LA, ArrayList<String> Ins_DB_URL, String DB_URL) {
		super(DB_URL);
		this.id = id;
		this.password = password;
		this.name = name;
		this.role = role;
		
		super.DB_URL = DB_LA;
		this.Ins_DB_URL = Ins_DB_URL;
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

	public ArrayList<String> getInsDBURL() {
		return Ins_DB_URL;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "'"+id+"', '"+password+"', '"+name+"', '"+"'";
	}
}
