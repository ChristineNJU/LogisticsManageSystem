package VO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import PO.CostPO;
import State.CostType;


public class CostVO extends VO {

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private Date date = null;
	private double amount = 0;
	private String payer = null;
	private String payerAccount = null;
	private CostType costType = null;
	private String remark = null;
	
	public CostVO(String date,double amount,String payer,String payerAccount,
			CostType costType,String remark){
		try {
			this.date = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public Date getDate(){
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
		try {
			this.date = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
