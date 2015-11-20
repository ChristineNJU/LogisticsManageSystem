package VO;

import PO.AccountPO;

public class AccountVO extends VO {

	private int id=0;
	private String name = null;
	private double money = 0;
	
	public AccountVO(String name,double money){
		this.name = name;
		this.money = money;
	}
	
	public AccountVO(AccountPO po) {
		this.name = po.getAccountName();
		this.money = po.getAmount();
		this.id=po.getAccountID();
	}
	
	public String getName(){
		return this.name;
	}
	public double getMoney(){
		return this.money;
	}
	public int getID(){
		return this.id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public void setMoney(double money){
		this.money = money;
	}
	public void setID(int ID){
		this.id=ID;
	}
}
