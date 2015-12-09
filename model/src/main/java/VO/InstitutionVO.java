package VO;

import PO.InstitutionPO;
import State.InstitutionType;


// TODO: Auto-generated Javadoc
/**
 * The Class InstitutionVO.
 */
public class InstitutionVO extends VO {

	/** The name. */
	private String name = null;
	
	/** The type. */
	private InstitutionType type = null;
	
	/** The city. */
	private String city = null;
	
	/** The code. */
	private String code = null;
	
	/**
	 * Instantiates a new institution vo.
	 *
	 * @param name the name
	 * @param type the type
	 * @param city the city
	 * @param code the code
	 */
	public InstitutionVO(String name, InstitutionType type,String city,String code){
		this.name = name;
		this.type = type;
		this.city = city;
		this.code = code;
	}
	
	/**
	 * Instantiates a new institution vo.
	 *
	 * @param po the po
	 */
	public InstitutionVO(InstitutionPO po) {
		this.name = po.getInstitutionName();
		this.type = po.getInstitutionType();
		this.city = po.getCity();
		this.code = po.getInstitutionNumber();
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public InstitutionType getType(){
		return this.type;
	}
	
	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity(){
		return this.city;
	}
	
	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode(){
		return this.code;
	}
	
	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(InstitutionType type){
		this.type = type;
	}
	
	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city){
		this.city = city;
	}
}
