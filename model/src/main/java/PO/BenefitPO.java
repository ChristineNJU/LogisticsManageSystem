package PO;

public class BenefitPO extends PO {
	
	private int number = 0;
	private double income = 0;
	private double expend = 0;
	private double benefit = 0;
	
	public BenefitPO(int number, double income, double expend, String DB_URL) {
		super(DB_URL);
		// TODO Auto-generated constructor stub
		this.number = number;
		this.income = income;
		this.expend = expend;
		this.benefit = income - benefit;
	}

	/*====================================================================================
	 * Public方法
	 * */
	
	/*------------------------------------------------------------------------------------
	 * 对BenefitPO的数据进行读取
	 * */
	
	/*
	 * 获取序号
	 * 返回int
	 * */
	public int getNumber() {
		return number;
	}
	/*
	 * 获取总收入
	 * 返回double
	 * */
	public double getIncome() {
		return income;
	}
	/*
	 * 获取总支出
	 * 返回double
	 * */
	public double getExpend() {
		return expend;
	}
	/*
	 * 获取总利润
	 * 返回double
	 * */
	public double getBenefit() {
		return benefit;
	}
	
	
	/*---------------------------------------------------------------
	 * 对BenefitPO的数据进行更新
	 * */
	
	/*
	 * 更新总收入
	 * */
	public void setIncome(double income) {
		this.income = income;
		benefit = income - expend;
	}
	/*
	 * 更新总支出
	 * */
	public void setExpend(double expend) {
		this.expend = expend;
		benefit = income - expend;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
