package PO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import VO.BenefitVO;
import businesslogic.URLHelper.URLHelper;

public class BenefitPO extends PO {
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private int number = 0;
	private double income = 0;
	private double expend = 0;
	private double benefit = 0;
	private Date startDate;
	private Date endDate;
	
	public BenefitPO(int number, double income, double expend, String DB_URL,String start,String end) {
		super(DB_URL);
		// TODO Auto-generated constructor stub
		this.number = number;
		this.income = income;
		this.expend = expend;
		this.benefit = income - expend;
		try {
			startDate=sdf.parse(start);
			endDate=sdf.parse(end);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			startDate = null;
			endDate = null;
			System.out.println("时间对象创建失败");
//			e.printStackTrace();
		}
	}
	
	public BenefitPO(BenefitVO bvo, int number){
		super(URLHelper.getBenefitURL());
		this.income=bvo.getIncome();
		this.expend=bvo.getCost();
		this.benefit=bvo.getBenefit();
		this.startDate=bvo.getStartDate();
		this.endDate=bvo.getEndDate();
	}

	/*====================================================================================
	 * Public方法
	 * */
	
	/*------------------------------------------------------------------------------------
	 * 对BenefitPO的数据进行读取
	 * */
	
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
	
	public Date getStartDate(){
		return startDate;
	}
	
	public Date getEndDate(){
		return endDate;
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
	
	public void setStartDate(String startDate){
		try {
			this.startDate=sdf.parse(startDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setEndDate(String endDate){
		try{
			this.endDate=sdf.parse(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		String result = "";
		
		result = result + income + ", ";
		result = result + expend + ", ";
		result = result + benefit + ", ";
		
		result = result + "'" + sdf.format(startDate) + "', ";
		result = result + "'" + sdf.format(endDate) + "'";
		
		System.out.println(result);
		return result;
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "number = "+number;
	}
	

	
}
