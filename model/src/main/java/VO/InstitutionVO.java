package VO;

import PO.InstitutionPO;
import businesslogic.State.InstitutionType;


public class InstitutionVO extends VO {

	private String name = null;
	private InstitutionType type = null;
	private String city = null;
	private String code = null;
	
	public InstitutionVO(String name, InstitutionType type,String city,String code){
		this.name = name;
		this.type = type;
		this.city = city;
		this.code = code;
	}
	public InstitutionVO(InstitutionPO po) {
		this.name = po.getInstitutionName();
		this.type = po.getInstitutionType();
		this.city = po.getCity();
		this.code = po.getInstitutionNumber();
	}

	public String getName() {
		return this.name;
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
