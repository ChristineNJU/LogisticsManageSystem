package VO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import PO.BenefitPO;

// TODO: Auto-generated Javadoc
/**
 * The Class BenefitVO.
 */
public class BenefitVO extends VO {

	/** The income total. */
	private double incomeTotal = 0;
	
	/** The cost total. */
	private double costTotal = 0;
	
	/** The benefit total. */
	private double benefitTotal = 0;
	
	/** The sdf. */
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/** The Date. */
	private Date Date=null;
	
	/**
	 * Instantiates a new benefit vo.
	 *
	 * @param income the income
	 * @param cost the cost
	 * @param date the date
	 */
	public BenefitVO(double income,double cost,String date){
		this.incomeTotal = income;
		this.costTotal = cost;
		this.benefitTotal = income - cost;
		try {
			this.Date=(sdf.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Instantiates a new benefit vo.
	 *
	 * @param po the po
	 */
	public BenefitVO(BenefitPO po) {
		this.incomeTotal = po.getIncome();
		this.costTotal = po.getExpend();
		this.benefitTotal = po.getBenefit();
		this.Date=(po.getDate());
		
	}
	
	/**
	 * Gets the income.
	 *
	 * @return the income
	 */
	public double getIncome(){
		return this.incomeTotal;
	}
	
	/**
	 * Gets the cost.
	 *
	 * @return the cost
	 */
	public double getCost(){
		return this.costTotal;
	}
	
	/**
	 * Gets the benefit.
	 *
	 * @return the benefit
	 */
	public double getBenefit(){
		return this.benefitTotal;
	}
	
	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return Date;
	}

	
	/**
	 * Sets the income.
	 *
	 * @param income the new income
	 */
	public void setIncome(double income){
		this.incomeTotal = income;
	}
	
	/**
	 * Sets the cost.
	 *
	 * @param cost the new cost
	 */
	public void setCost(double cost){
		this.costTotal = cost;
	}
	
	/**
	 * Sets the date.
	 *
	 * @param Date the new date
	 */
	public void setDate(String Date) {
		try{
			this.Date=sdf.parse(Date);
		} catch (ParseException e){
			e.printStackTrace();
		}
	}
	
}
