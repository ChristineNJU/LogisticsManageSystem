package PO;

import java.util.Date;

import businesslogic.State.StorageArea;

public class BalancePO extends PO {

	private String bar_code = null;
	private Date storage_date = null;
	private String destination = null;
	private StorageArea old_area = null;
	private int old_row = 0;
	private int old_shelf = 0;
	private int old_position = 0;
	private StorageArea new_area = null;
	private int new_row = 0;
	private int new_shelf = 0;
	private int new_position = 0;
	private boolean isApproved = false;
	
	public BalancePO(String bar_code, Date storage_date, String destination, StorageArea old_area, 
			int old_row, int old_shelf, int old_position, StorageArea new_area, int new_row, int new_shelf,
			int new_position, String DB_URL) {
		super(DB_URL);
		// TODO Auto-generated constructor stub
		this.bar_code = bar_code;
		this.storage_date = storage_date;
		this.destination = destination;
		this.old_area = old_area;
		this.old_row = old_row;
		this.old_shelf = old_shelf;
		this.old_position = old_position;
		this.new_area = new_area;
		this.new_row = new_row;
		this.new_shelf = new_shelf;
		this.new_position = new_position;
	}
	
	/*====================================================================================
	 * Public方法
	 * */
	
	/*------------------------------------------------------------------------------------
	 * 对BalancePO的数据进行读取
	 * */
	
	/*
	 * 获取订单条形码
	 * 返回String
	 * */
	public String getBarCode() {
		return bar_code;
	}
	/*
	 * 获取入库日期
	 * 返回Date
	 * */
	public Date getStorageDate() {
		return storage_date;
	}
	/*
	 * 获取到达地
	 * 返回String
	 * */
	public String getDestination() {
		return destination;
	}
	/*
	 * 获取原来的区号
	 * 返回StorageArea
	 * */
	public StorageArea getOldArea() {
		return old_area;
	}
	/*
	 * 获取原来的排号
	 * 返回int
	 * */
	public int getOldRow() {
		return old_row;
	}
	/*
	 * 获取原来的架号
	 * 返回int
	 * */
	public int getOldShelf() {
		return old_shelf;
	}
	/*
	 * 获取原来的位号
	 * 返回int
	 * */
	public int getOldPosition() {
		return old_position;
	}
	/*
	 * 获取新区号
	 * 返回StorageArea
	 * */
	public StorageArea getNewArea() {
		return new_area;
	}
	/*
	 * 获取新排号
	 * 返回int
	 * */
	public int getNewRow() {
		return new_row;
	}
	/*
	 * 获取新架号
	 * 返回int
	 * */
	public int getNewShelf() {
		return new_shelf;
	}
	/*
	 * 获取新位号
	 * 返回int
	 * */
	public int getNewPosition() {
		return new_position;
	}
	/*
	 * 获取审批状态
	 * 返回boolean
	 * */
	public boolean isApproved() {
		return isApproved;
	}
	
	
	/*---------------------------------------------------------------
	 * 对BalancePO的某些信息进行更新
	 * */
	
	/*
	 * 更新审批状态
	 * */
	public void setApproved(boolean isAppproved) {
		this.isApproved = isAppproved;
	} 
	
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
