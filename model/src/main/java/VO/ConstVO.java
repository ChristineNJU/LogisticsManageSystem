package VO;

import PO.ConstPO;

// TODO: Auto-generated Javadoc
/**
 * The Class ConstVO.
 */
public class ConstVO extends VO {

	/** The name. */
	private String name = null;
	
	/** The value. */
	private double value = 0;
	
	/**
	 * Instantiates a new const vo.
	 *
	 * @param name the name
	 * @param value the value
	 */
	public ConstVO(String name,double value){
		this.name = name;
		this.value = value;
	}
	
	/**
	 * Instantiates a new const vo.
	 *
	 * @param po the po
	 */
	public ConstVO(ConstPO po) {
		this.name = po.getName();
		this.value = po.getValue();
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public double getValue(){
		return this.value;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(double value){
		this.value = value;
	}
	
}
