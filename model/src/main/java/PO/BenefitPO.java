package PO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import VO.BenefitVO;
import businesslogic.URLHelper.URLHelper;

public class BenefitPO extends PO {
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	private int number = 0;
	private double income = 0;
	private double expend = 0;
	private double benefit = 0;
	private Date start_date=null;
	private Date end_date=null;
	
	public BenefitPO(int number, double income, double expend, String DB_URL,String start,String end) {
		super(DB_URL);
		// TODO Auto-generated constructor stub
		this.number = number;
		this.income = income;
		this.expend = expend;
		this.benefit = income - expend;
		try {
			start_date=sdf.parse(start);
			end_date=sdf.parse(end);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			start_date = null;
			end_date = null;
			System.out.println("时间对象创建失败");
//			e.printStackTrace();
		}
	}
	
	public BenefitPO(BenefitVO bvo, int number){
		super(URLHelper.getBenefitURL());
		this.number=number;
		this.income=bvo.getIncome();
		this.expend=bvo.getCost();
		this.benefit=bvo.getBenefit();
		this.start_date=bvo.getStartDate();
		this.end_date=bvo.getEndDate();
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
	
	public Date getStartDate(){
		return start_date;
	}
	
	public Date getEndDate(){
		return end_date;
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
			this.start_date=sdf.parse(startDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setEndDate(String endDate){
		try{
			this.end_date=sdf.parse(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "number = "+number;
	}
	

	
}
