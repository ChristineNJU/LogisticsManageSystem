package VO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import PO.CostPO;
import State.CostType;


// TODO: Auto-generated Javadoc
/**
 * The Class CostVO.
 */
public class CostVO extends VO {

	/** The sdf. */
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/** The date. */
	private Date date = null;
	
	/** The amount. */
	private double amount = 0;
	
	/** The payer. */
	private String payer = null;
	
	/** The payer account. */
	private String payerAccount = null;
	
	/** The cost type. */
	private CostType costType = null;
	
	/** The remark. */
	private String remark = null;
	
	/**
	 * Instantiates a new cost vo.
	 *
	 * @param date the date
	 * @param amount the amount
	 * @param payer the payer
	 * @param payerAccount the payer account
	 * @param costType the cost type
	 * @param remark the remark
	 */
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
	
	/**
	 * Instantiates a new cost vo.
	 *
	 * @param po the po
	 */
	public CostVO(CostPO po) {
		this.date = po.getCostDate();
		this.amount = po.getCostAmount();
		this.payer = po.getCostName();
		this.payerAccount = po.getAccountName();
		this.costType = po.getType();
		this.remark = po.getRemark();
	}
	
	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate(){
		return this.date;
	}
	
	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public double getAmount(){
		return this.amount;
	}
	
	/**
	 * Gets the payer.
	 *
	 * @return the payer
	 */
	public String getPayer(){
		return this.payer;
	}
	
	/**
	 * Gets the payer account.
	 *
	 * @return the payer account
	 */
	public String getPayerAccount(){
		return this.payerAccount;
	}
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public CostType getType(){
		return this.costType;
	}
	
	/**
	 * Gets the remark.
	 *
	 * @return the remark
	 */
	public String getRemark(){
		return this.remark;
	}
	
	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(String date){
		try {
			this.date = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets the amount.
	 *
	 * @param amount the new amount
	 */
	public void setAmount(double amount){
		this.amount = amount;
	}
	
	/**
	 * Sets the payer.
	 *
	 * @param payer the new payer
	 */
	public void setPayer(String payer){
		this.payer = payer;
	}
	
	/**
	 * Sets the payer account.
	 *
	 * @param payerAccount the new payer account
	 */
	public void setPayerAccount(String payerAccount){
		this.payerAccount = payerAccount;
	}
	
	/**
	 * Sets the cost type.
	 *
	 * @param costType the new cost type
	 */
	public void setCostType(CostType costType){
		this.costType = costType;
	}
	
	/**
	 * Sets the remark.
	 *
	 * @param remark the new remark
	 */
	public void setRemark(String remark){
		this.remark = remark;
	}

}
