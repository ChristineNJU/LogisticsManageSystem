package VO;

import PO.AccountPO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccountVO.
 */
public class AccountVO extends VO {

	
	/** The name. */
	private String name = null;
	
	/** The money. */
	private double money = 0;
	
	/**
	 * Instantiates a new account vo.
	 *
	 * @param name the name
	 * @param money the money
	 */
	public AccountVO(String name,double money){
		this.name = name;
		this.money = money;
	}
	
	/**
	 * Instantiates a new account vo.
	 *
	 * @param po the po
	 */
	public AccountVO(AccountPO po) {
		this.name = po.getAccountName();
		this.money = po.getAmount();
		
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
	 * Gets the money.
	 *
	 * @return the money
	 */
	public double getMoney(){
		return this.money;
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
	 * Sets the money.
	 *
	 * @param money the new money
	 */
	public void setMoney(double money){
		this.money = money;
	}

}
