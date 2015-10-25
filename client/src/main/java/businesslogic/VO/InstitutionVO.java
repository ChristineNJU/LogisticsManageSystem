package businesslogic.VO;

public class InstitutionVO extends VO {

	private String name = null;
	private String city = null;
	private String code = null;
	
	public InstitutionVO(String name,String city,String code){
		this.name = name;
		this.city = city;
		this.code = code;
	}
	
	public String getName(){
		return this.name;
	}
	public String getCity(){
		return this.city;
	}
	public String getCode(){
		return this.code;
	}
	
}
