package businesslogic.VO;

public class StaffVO extends VO {

	private String name = null;
	private String sex = null;
	private int age = 0;
	private String institution = null;
	private String position =  null;
	private String systemId = null;
	
	public StaffVO(String name,String sex,int age,
			String institution,String position,String systemId){
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.institution = institution;
		this.position = position;
		this.systemId = systemId;
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
	public String getInsitution(){
		return this.institution;
	}
	public String getPosition(){
		return this.position;
	}
	public String getSystemId(){
		return this.systemId;
	}
	
}
