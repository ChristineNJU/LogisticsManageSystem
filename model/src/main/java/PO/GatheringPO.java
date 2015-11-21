package PO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/*======================================================================
 * 用来保存收款信息的持久化数据格式
 * */

public class GatheringPO extends PO {
	
	private Date date = null;
	private double amount = 0;
	private String courier = null;
	private ArrayList<String> bar_code_list = new ArrayList<String>();
	private boolean isApproved = false;
	
	public GatheringPO(Date date, double amount, String courier, ArrayList<String> bar_code_list,
			String DB_URL) {
		super(DB_URL);
		this.date = date;
		this.amount = amount;
		this.courier = courier;
		this.bar_code_list = bar_code_list;
	}
	
	/*==================================================================
	 * Public方法
	 * */
	
	/*------------------------------------------------------------------
	 * 对GatheringPO的数据进行读取
	 * */
	
	/*
	 * 获取收款时间
	 * 返回Date
	 * */
	public Date getDate() {
		return date;
	}
	/*
	 * 获取收款金额
	 * 返回double
	 * */
	public double getAmount() {
		return amount;
	}
	/*
	 * 获取收件快递员
	 * 返回String
	 * */
	public String getCourier() {
		return courier;
	}
	/*
	 * 获取所有订单条形码
	 * 返回ArrayList<String>
	 * */
	public ArrayList<String> getBarCodeList() {
		return bar_code_list;
	}
	/*
	 * 获取审批状态
	 * 返回boolean
	 * */
	public boolean isApproved() {
		return isApproved;
	}
	
	/*--------------------------------------------------------------
	 * 对GatheringPO的某些信息进行更新
	 * */
	
	/*
	 * 更新审批状态
	 * */
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
	
	
	/*------------------------------------------------------------------
	 * 对数据的格式化
	 * */
	
	/*
	 * 形成数据库格式
	 * 返回String
	 * */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		return "date = '"+sdf.format(date)+"' AND courier = '"+courier+"'";
	}
	
}
