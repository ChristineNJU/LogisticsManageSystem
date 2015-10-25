package businesslogic.VO;

public class BenefitVO extends VO {

	private double incomeTotal = 0;
	private double costTotal = 0;
	private double benefitTotal = 0;
	
	public BenefitVO(double income,double cost,double benefit){
		this.incomeTotal = income;
		this.costTotal = cost;
		this.benefitTotal = income - cost;
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
