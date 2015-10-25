package businesslogic.PO;

import businesslogic.State.TransferType;

public class RemovalPO extends PO {

	private String bar_code = null;
	private String removal_date = null;
	private String destination = null;
	private TransferType type = null;
	private String transfer_number = null;
	private boolean isApproved = false;
	
	public RemovalPO(String bar_code, String removal_date, String destination, TransferType type,
			String transfer_number, String DB_URL) {
		super(DB_URL);
		// TODO Auto-generated constructor stub
		this.bar_code = bar_code;
		this.removal_date = removal_date;
		this.destination = destination;
		this.type = type;
		this.transfer_number = transfer_number;
	}

	/*====================================================================================
	 * Public方法
	 * */
	
	/*------------------------------------------------------------------------------------
	 * 对RemovalPO的数据进行读取
	 * */
	
	/*
	 * 获取订单条形码
	 * 返回String
	 * */
	public String getBarCode() {
		return bar_code;
	}
	/*
	 * 获取出库日期
	 * 返回String
	 * */
	public String getRemovalDate() {
		return removal_date;
	}
	/*
	 * 获取目的地
	 * 返回String
	 * */
	public String getDestination() {
		return destination;
	}
	/*
	 * 获取装运形式
	 * 返回TranferType
	 * */
	public TransferType getType() {
		return type;
	}
	/*
	 * 获取中转单编号
	 * 返回String
	 * */
	public String getTransferNumber() {
		return transfer_number;
	}
	/*
	 * 获取审批状态
	 * 返回boolean
	 * */
	public boolean isApproved() {
		return isApproved;
	}
	
	
	/*---------------------------------------------------------------
	 * 对RemovalPO的某些信息进行更新
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
