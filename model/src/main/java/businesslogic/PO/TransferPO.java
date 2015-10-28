package businesslogic.PO;

import java.util.ArrayList;
import java.util.Date;

/*======================================================================
 * 用来保存中转单的持久化数据格式
 * */

public class TransferPO extends PO {
	
	private Date date = null;
	private String transfer_number = null;
	private String transport_id = null;
	private String starting = null;
	private String destination = null;
	private String container_number = null;
	private String guard_name = null;
	private ArrayList<String> bar_code_list = new ArrayList<String>();
	private double amount = 0;
	private boolean isApproved = false;
	
	public TransferPO(Date date, String transfer_number, String transport_id, String starting, String destination,
			String container_number, String guard_name, ArrayList<String> bar_code_list, double amount, 
			String DB_URL) {
		super(DB_URL);
		// TODO Auto-generated constructor stub
		this.date = date;
		this.transfer_number = transfer_number;
		this.transport_id = transport_id;
		this.starting = starting;
		this.destination = destination;
		this.container_number = container_number;
		this.guard_name = guard_name;
		this.bar_code_list = bar_code_list;
		this.amount = amount;	
	}

	/*====================================================================================
	 * Public方法
	 * */
	
	/*------------------------------------------------------------------------------------
	 * 对TransferPO的数据进行读取
	 * */
	
	/*
	 * 获取装车日期
	 * 返回Date
	 * */
	public Date getDate() {
		return date;
	}
	/*
	 * 获取获取中转单
	 * 返回String
	 * */
	public String getTranferNumber() {
		return transfer_number;
	}
	/*
	 * 获取交通工具班次号
	 * 返回String
	 * */
	public String getTransportID() {
		return transport_id;
	}
	/*
	 * 获取出发地
	 * 返回String
	 * */
	public String getStarting() {
		return starting;
	}
	/*
	 * 获取到达地
	 * 返回String
	 * */
	public String getDestination() {
		return destination;
	}
	/*
	 * 获取货柜号
	 * 返回String
	 * */
	public String getContainerNumber() {
		return container_number;
	}
	/*
	 * 获取监装员
	 * 返回String
	 * */
	public String getGuardName() {
		return guard_name;
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
	 * 对TransferPO的某些信息进行更新
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
