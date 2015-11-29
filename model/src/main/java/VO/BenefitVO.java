package VO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import PO.BenefitPO;

public class BenefitVO extends VO {

	private double incomeTotal = 0;
	private double costTotal = 0;
	private double benefitTotal = 0;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private Date Date=null;
	
	public BenefitVO(double income,double cost,String startDate){
		this.incomeTotal = income;
		this.costTotal = cost;
		this.benefitTotal = income - cost;
		try {
			this.Date=(sdf.parse(startDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public BenefitVO(BenefitPO po) {
		this.incomeTotal = po.getIncome();
		this.costTotal = po.getExpend();
		this.benefitTotal = po.getBenefit();
		this.Date=(po.getDate());
		
	}
	
	public double getIncome(){
		return this.incomeTotal;
	}
	public double getCost(){
		return this.costTotal;
	}
	public double getBenefit(){
		return this.benefitTotal;
	}
	public Date getDate() {
		return Date;
	}

	
	public void setIncome(double income){
		this.incomeTotal = income;
	}
	public void setCost(double cost){
		this.costTotal = cost;
	}
	
	public void setDate(String Date) {
		try{
			this.Date=sdf.parse(Date);
		} catch (ParseException e){
			e.printStackTrace();
		}
	}
	
}
