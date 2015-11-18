package VO;

import PO.BenefitPO;

public class BenefitVO extends VO {

	private double incomeTotal = 0;
	private double costTotal = 0;
	private double benefitTotal = 0;
	
	public BenefitVO(double income,double cost){
		this.incomeTotal = income;
		this.costTotal = cost;
		this.benefitTotal = income - cost;
	}
	public BenefitVO(BenefitPO po) {
		this.incomeTotal = po.getIncome();
		this.costTotal = po.getExpend();
		this.benefitTotal = po.getBenefit();
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
	
	public void setIncome(double income){
		this.incomeTotal = income;
	}
	public void setCost(double cost){
		this.costTotal = cost;
	}
	
}
