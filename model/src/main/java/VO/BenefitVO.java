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
	private Date startDate=null;
	private Date endDate=null;
	
	public BenefitVO(double income,double cost,String startDate,String endDate){
		this.incomeTotal = income;
		this.costTotal = cost;
		this.benefitTotal = income - cost;
		try {
			this.startDate=(sdf.parse(startDate));
			this.endDate=sdf.parse(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public BenefitVO(BenefitPO po) {
		this.incomeTotal = po.getIncome();
		this.costTotal = po.getExpend();
		this.benefitTotal = po.getBenefit();
		this.startDate=(po.getStartDate());
		this.endDate=po.getEndDate();
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
	public Date getStartDate() {
		return startDate;
	}
	public Date getEndDate(){
		return endDate;
	}
	
	public void setIncome(double income){
		this.incomeTotal = income;
	}
	public void setCost(double cost){
		this.costTotal = cost;
	}
	
	public void setStartDate(String startDate) {
		try{
			this.startDate=sdf.parse(startDate);
		} catch (ParseException e){
			e.printStackTrace();
		}
	}
	
	public void setEndDate(String endDate) {
		try{
			this.endDate=sdf.parse(endDate);
		} catch (ParseException e){
			e.printStackTrace();
		}
	}
	
}
