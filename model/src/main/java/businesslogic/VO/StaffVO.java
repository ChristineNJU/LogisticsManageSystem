package businesslogic.VO;

import businesslogic.PO.UserPO;
import businesslogic.State.InstitutionType;

public class StaffVO extends VO {

	private String name = null;
	private String sex = null;
	private int age = 0;
	private InstitutionType institution = null;
	private String position =  null;
	private String systemId = null;
	
	public StaffVO(String name,String sex,int age,
			InstitutionType institution,String position,String systemId){
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.institution = institution;
		this.position = position;
		this.systemId = systemId;
	}
	public StaffVO(UserPO po) {
		this.name = po.getName();
		this.sex = po.getSex();
		this.age = po.getAge();
		this.institution = po.getInstitution();
		this.position = po.getCity();
		this.systemId = po.getID();
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
	public String getPosition(){
		return this.position;
	}
	public String getSystemId(){
		return this.systemId;
	}
	
}
