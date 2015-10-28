package businesslogic.PO;

import java.util.ArrayList;
import java.util.Date;


/*========================================================================================
 * 用来保存装车单的持久化数据格式
 * */

public class EntruckingPO extends PO {
	
	private Date date = null;
	private String transfer_number = null;
	private String destination = null;
	private String car_number = null;
	private String guard_name = null;
	private String supercargo_name = null;
	private ArrayList<String> bar_code_list = new ArrayList<String>();
	private double amount = 0;
	private boolean isApproved = false;
	
	public EntruckingPO(Date date, String transfer_number, String destination, String car_number,
			String guard_name, String supercargo_name, ArrayList<String> bar_code_list, double amount,
			String DB_URL) {
		super(DB_URL);
		// TODO Auto-generated constructor stub
		this.date = date;
		this.transfer_number = transfer_number;
		this.destination = destination;
		this.car_number = car_number;
		this.guard_name = guard_name;
		this.supercargo_name = supercargo_name;
		this.bar_code_list = bar_code_list;
		this.amount = amount;
	}
	
	/*====================================================================================
	 * Public方法
	 * */
	
	/*------------------------------------------------------------------------------------
	 * 对EntruckingPO的数据进行读取
	 * */
	
	/*
	 * 获取装车日期
	 * 返回Date
	 * */
	public Date getDate() {
		return date;
	}
	/*
	 * 获取中转单编号
	 * 返回String
	 * */
	public String getTransferNumber() {
		return transfer_number;
	}
	/*
	 * 获取到达地
	 * 返回String
	 * */
	public String getDestination() {
		return destination;
	}
	/*
	 * 获取车辆代号
	 * 返回String
	 * */
	public String getCarNumber() {
		return car_number;
	}
	/*
	 * 获取监装员
	 * 返回String
	 * */
	public String getGuardName() {
		return guard_name;
	}
	/*
	 * 获取押运员
	 * 返回String
	 * */
	public String getSupercargoName() {
		return supercargo_name;
	}
	/*
	 * 获取所有订单编号
	 * 返回ArrayList<String>
	 * */
	public ArrayList<String> getBarCodeList() {
		return bar_code_list;
	}
	/*
	 * 获取运费
	 * 返回double
	 * */
	public double getAmount() {
		return amount;
	}
	/*
	 * 获取审批状态
	 * 返回boolean
	 * */
	public boolean isApproved() {
		return isApproved;
	}
	
	
	/*---------------------------------------------------------------
	 * 对EntruckingPO的某些信息进行更新
	 * */
	
	/*
	 * 更新审批状态
	 * */
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
