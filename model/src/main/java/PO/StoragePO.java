package PO;

import java.text.SimpleDateFormat;
import java.util.Date;

import State.StateSwitch;
import State.StorageArea;
import VO.StorageVO;
import businesslogic.URLHelper.URLHelper;

/*========================================================================================
 * 用来保存入库信息的持久化数据格式
 * */

public class StoragePO extends PO {
	
	private String bar_code = null;
	private Date storage_date = null;
	private String destination = null;
	private StorageArea area_code = null;
	private int row = 0;
	private int shelf = 0;
	private int position = 0;
	private boolean isApproved = false;
	
	public StoragePO(String bar_code, Date storage_date, String destination, StorageArea area_code, 
			int row, int shelf, int position, String DB_URL) {
		super(DB_URL);
		
		this.bar_code = bar_code;
		this.storage_date = storage_date;
		this.destination = destination;
		this.area_code = area_code;
		this.row = row;
		this.shelf = shelf;
		this.position = position;
	}
	
	public StoragePO(StorageVO storage, String institutionID){
		super(URLHelper.getStorageURL(institutionID));
		this.bar_code=storage.getBarCode();
		this.storage_date=storage.getStorageDate();
		this.destination=storage.getDestination();
		this.area_code=storage.getAreaCode();
		this.row=storage.getRow();
		this.shelf=storage.getShelf();
		this.position=storage.getPosition();
	}

	/*====================================================================================
	 * Public方法
	 * */
	
	/*------------------------------------------------------------------------------------
	 * 对StoragePO的数据进行读取
	 * */
	
	/*
	 * 获取订单编号
	 * 返回String
	 * */
	public String getBarCode() {
		return bar_code;
	}
	/*
	 * 获取入库日期
	 * 返回Date
	 * */
	public Date getDate() {
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
	 * 获取区号
	 * 返回StorageArea
	 * */
	public StorageArea getAreaCode() {
		return area_code;
	}
	/*
	 * 获取排号
	 * 返回int
	 * */
	public int getRow() {
		return row;
	}
	/*
	 * 获取架号
	 * 返回int
	 * */
	public int getShelf() {
		return shelf;
	}
	/*
	 * 获取位号
	 * 返回int
	 * */
	public int getPosition() {
		return position;
	}
	/*
	 * 获取审批状态
	 * 返回boolean
	 * */
	public boolean isApproved() {
		return isApproved;
	}
	
	
	/*---------------------------------------------------------------
	 * 对StoragePO的某些信息进行更新
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
		
		String result = "";
		
		result = result + "'" + bar_code + "', ";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		result = result + "'" + sdf.format(storage_date) + "', ";
		result = result + "'" + destination + "', ";
		result = result + "'" + StateSwitch.switchToStr(area_code) + "', ";
		result = result + row + ", ";
		result = result + shelf + ", ";
		result = result + position + ", ";
		result = result + "'" + isApproved + "'";
		
		System.out.println(result);
		return result;
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "bar_code = '"+bar_code+"'";
	}
	
	
}
