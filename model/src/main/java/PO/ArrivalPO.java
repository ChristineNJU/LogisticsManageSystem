package PO;

import java.util.Date;

import businesslogic.State.LogisticsState;

/*========================================================================================
 * 用来保存到达单的持久化数据格式
 * */

public class ArrivalPO extends PO {

	private String bar_code = null;
	private Date arrival_date = null;
	private String transfer_number = null;
	private String starting = null;
	private LogisticsState state = null;
	private boolean isApproved = false;
	
	public ArrivalPO(String bar_code, Date arrival_date, String transfer_number, String starting,
			LogisticsState state, String DB_URL) {
		super(DB_URL);
		this.bar_code = bar_code;
		this.arrival_date = arrival_date;
		this.transfer_number = transfer_number;
		this.starting = starting;
		this.state = state;
	}
	
	/*====================================================================================
	 * Public方法
	 * */
	
	/*------------------------------------------------------------------------------------
	 * 对DriverInfoPO的数据进行读取
	 * */
	
	/*
	 * 获取订单信息
	 * 返回String
	 * */
	public String getBarCode() {
		return bar_code;
	}
	/*
	 * 获取到达日期
	 * 返回Date
	 * */
	public Date getArrivalDate() {
		return arrival_date;
	}
	/*
	 * 获取中转单编号
	 * 返回String
	 * */
	public String getTransferNumber() {
		return transfer_number;
	}
	/*
	 * 获取出发地
	 * 返回String
	 * */
	public String getStarting() {
		return starting;
	}
	/*
	 * 获取货物状态
	 * 返回LogisticsState
	 * */
	public LogisticsState getState() {
		return state;
	} 
	/*
	 * 获取审批状态
	 * 返回boolean
	 * */
	public boolean isApproved() {
		return isApproved;
	}
	
	
	/*---------------------------------------------------------------
	 * 对ArrivalPO的某些信息进行更新
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
