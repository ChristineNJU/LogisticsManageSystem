package businesslogic.VO;

import businesslogic.State.InstitutionType;

public class InstitutionVO extends VO {

	private InstitutionType type = null;
	private String city = null;
	private String code = null;
	
	public InstitutionVO(InstitutionType type,String city,String code){
		this.type = type;
		this.city = city;
		this.code = code;
	}
	
	public InstitutionType getType(){
		return this.type;
	}
	public String getCity(){
		return this.city;
	}
	public String getCode(){
		return this.code;
	}
	
	public void setType(InstitutionType type){
		this.type = type;
	}
	public void setCity(String city){
		this.city = city;
	}
}
