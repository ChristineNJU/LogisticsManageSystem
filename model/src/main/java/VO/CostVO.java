package VO;

import PO.CostPO;
import businesslogic.State.CostType;


public class CostVO extends VO {

	private String date = null;
	private double amount = 0;
	private String payer = null;
	private String payerAccount = null;
	private CostType costType = null;
	private String remark = null;
	
	public CostVO(String date,double amount,String payer,String payerAccount,
			CostType costType,String remark){
		this.date = date;
		this.amount = amount;
		this.payer = payer;
		this.payerAccount = payerAccount;
		this.costType = costType;
		this.remark = remark;
	}
	public CostVO(CostPO po) {
		this.date = po.getCostDate();
		this.amount = po.getCostAmount();
		this.payer = po.getCostName();
		this.payerAccount = po.getAccountName();
		this.costType = po.getType();
		this.remark = po.getRemark();
	}
	
	public String getDate(){
		return this.date;
	}
	public double getAmount(){
		return this.amount;
	}
	public String getPayer(){
		return this.payer;
	}
	public String getPayerAccount(){
		return this.payerAccount;
	}
	public CostType getType(){
		return this.costType;
	}
	public String getRemark(){
		return this.remark;
	}
	
	public void setDate(String date){
		this.date = date;
	}
	public void setAmount(double amount){
		this.amount = amount;
	}
	public void setPayer(String payer){
		this.payer = payer;
	}
	public void setPayerAccount(String payerAccount){
		this.payerAccount = payerAccount;
	}
	public void setCostType(CostType costType){
		this.costType = costType;
	}
	public void setRemark(String remark){
		this.remark = remark;
	}

}
