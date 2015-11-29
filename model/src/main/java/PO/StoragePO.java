package PO;

import java.text.SimpleDateFormat;
import java.util.Date;

import State.StateSwitch;
import State.StorageArea;
import VO.StorageVO;
import businesslogic.URLHelper.URLHelper;

/**
 * 用来保存入库信息的持久化数据格式
 * 
 * @author HermC
 * @version 1.0.0
 * */
public class StoragePO extends PO {
	
	// ----- member variables ---------------------------------------
	private String bar_code = "";
	private Date storage_date;
	private String destination = "";
	private StorageArea area_code;
	private int row = 0;
	private int shelf = 0;
	private int position = 0;
	private boolean isApproved = false;
	
	/**
	 * 直接创建入库信息的持久化数据对象
	 * */
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
	
	/**
	 * 通过StorageVO创建入库信息的持久化数据对象
	 * */
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
	
	/**
	 * 获取订单编号
	 * 
	 * @return 订单编号String
	 * */
	public String getBarCode() {
		return bar_code;
	}
	
	/**
	 * 获取入库日期
	 * 
	 * @return 入库日期Date
	 * */
	public Date getDate() {
		return storage_date;
	}
	
	/**
	 * 获取到达地
	 * 
	 * @return 到达地String
	 * */
	public String getDestination() {
		return destination;
	}
	
	/**
	 * 获取区号
	 * 
	 * @return 区号StorageArea
	 * */
	public StorageArea getAreaCode() {
		return area_code;
	}
	
	/**
	 * 获取排号
	 * 
	 * @return 排号
	 * */
	public int getRow() {
		return row;
	}
	
	/**
	 * 获取架号
	 * 
	 * @return 架号
	 * */
	public int getShelf() {
		return shelf;
	}
	
	/**
	 * 获取位号
	 * 
	 * @return 位号
	 * */
	public int getPosition() {
		return position;
	}
	
	/**
	 * 获取审批状态
	 * 
	 * @return 审批状态
	 * */
	public boolean isApproved() {
		return isApproved;
	}
	
	
	/*---------------------------------------------------------------
	 * 对StoragePO的某些信息进行更新
	 * */
	
	/**
	 * 更新审批状态
	 * 
	 * @param isApproved 新审批状态
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
