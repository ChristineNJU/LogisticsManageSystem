package PO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import VO.BenefitVO;
import VO.CostVO;
import VO.GatheringVO;
import businesslogic.URLHelper.URLHelper;

public class BenefitPO extends PO {
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private double income = 0;
	private double expend = 0;
	private double benefit = 0;
	private Date date;
	
	public BenefitPO(double income, double expend, String DB_URL,String date) {
		super(DB_URL);
		// TODO Auto-generated constructor stub
		
		this.income = income;
		this.expend = expend;
		this.benefit = income - expend;
		try {
			this.date=sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			this.date = null;
			System.out.println("时间对象创建失败");
//			e.printStackTrace();
		}
	}
	
	public BenefitPO(BenefitVO bvo){
		super(URLHelper.getBenefitURL());
		this.income=bvo.getIncome();
		this.expend=bvo.getCost();
		this.benefit=bvo.getBenefit();
		this.date=bvo.getDate();
	}
	
	public BenefitPO(GatheringVO gathering,BenefitPO benefit) {
		super(URLHelper.getBenefitURL());
		// TODO Auto-generated constructor stub
		this.benefit=benefit.getBenefit()+gathering.getMoney();
		this.income=gathering.getMoney()+benefit.getIncome();
		this.expend=benefit.getExpend();
		this.date=gathering.getDate();
	}
	public BenefitPO(CostVO cost,BenefitPO benefit) {
		super(URLHelper.getBenefitURL());
		// TODO Auto-generated constructor stub
		this.benefit=benefit.getBenefit()-cost.getAmount();
		this.income=benefit.getIncome();
		this.expend=benefit.getExpend()+cost.getAmount();
		this.date=cost.getDate();
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
	
	public Date getDate(){
		return date;
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
	
	public void setDate(String startDate){
		try {
			this.date=sdf.parse(startDate);
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
		
		result = result + "'" + sdf.format(date) + "', ";
		System.out.println(result);
		return result;
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "date = "+date;
	}
	

	
}
