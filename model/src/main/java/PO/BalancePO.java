package PO;

import java.text.SimpleDateFormat;
import java.util.Date;

import State.StateSwitch;
import State.StorageArea;
import VO.BalanceVO;
import businesslogic.URLHelper.URLHelper;

/**
 * 用来保存库存调整的持久化数据格式
 * 
 * @author 尹子越
 * @version 1.0.0
 * */
public class BalancePO extends PO {

	// ----- member variables ---------------------------------------
	private String bar_code = "";
	private Date storage_date;
	private String destination = "";
	private StorageArea old_area;
	private int old_row = 0;
	private int old_shelf = 0;
	private int old_position = 0;
	private StorageArea new_area;
	private int new_row = 0;
	private int new_shelf = 0;
	private int new_position = 0;
	private boolean isApproved = false;
	
	/**
	 * 直接创建库存调整持久化数据对象
	 * */
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
	
	/**
	 * 通过BalanceVO创建库存调整的持久化数据对象
	 * */
	public BalancePO(BalanceVO balance,String institutionID){
		super(URLHelper.getBalanceURL(institutionID));
		this.bar_code=balance.getBarCode();
		this.storage_date=balance.getDate();
		this.destination=balance.getDestination();
		this.old_area=balance.getAreaBefore();
		this.old_row=balance.getRowBefore();
		this.old_shelf=balance.getShelfBefore();
		this.old_position=balance.getPositionBefore();
		this.new_area=balance.getAreaCode();
		this.new_row=balance.getRow();
		this.new_shelf=balance.getShelf();
		this.new_position=balance.getPosition();
	}
	
	/*====================================================================================
	 * Public方法
	 * */
	
	/*------------------------------------------------------------------------------------
	 * 对BalancePO的数据进行读取
	 * */
	
	/**
	 * 获取订单条形码
	 * 
	 * @return 订单条形码String
	 * */
	public String getBarCode() {
		return bar_code;
	}
	/**
	 * 获取入库日期
	 * 
	 * @return 入库日期Date
	 * */
	public Date getStorageDate() {
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
	 * 获取原来的区号
	 * 
	 * @return 原来的区号StorageArea
	 * */
	public StorageArea getOldArea() {
		return old_area;
	}
	/**
	 * 获取原来的排号
	 * 
	 * @return 原来的排号
	 * */
	public int getOldRow() {
		return old_row;
	}
	/**
	 * 获取原来的架号
	 * 
	 * @return 原来的架号
	 * */
	public int getOldShelf() {
		return old_shelf;
	}
	/**
	 * 获取原来的位号
	 * 
	 * @return 原来的位号
	 * */
	public int getOldPosition() {
		return old_position;
	}
	/**
	 * 获取新区号
	 * 
	 * @return 新区号StorageArea
	 * */
	public StorageArea getNewArea() {
		return new_area;
	}
	/**
	 * 获取新排号
	 * 
	 * @return 新排号
	 * */
	public int getNewRow() {
		return new_row;
	}
	/**
	 * 获取新架号
	 * 
	 * @return 新架号
	 * */
	public int getNewShelf() {
		return new_shelf;
	}
	/**
	 * 获取新位号
	 * 
	 * @return 新排号
	 * */
	public int getNewPosition() {
		return new_position;
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
	 * 对BalancePO的某些信息进行更新
	 * */
	
	/**
	 * 更新审批状态
	 * 
	 * @param isAppproved 新审批状态
	 * */
	public void setApproved(boolean isAppproved) {
		this.isApproved = isAppproved;
	} 
	
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		String result = "";
		
		result = result + "'" + bar_code + "', ";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		result = result + "'" + sdf.format(storage_date) + "', ";
		
		result = result + "'" + destination + "', ";
		result = result + "'" + StateSwitch.switchToStr(old_area) + "', ";
		result = result + old_row + ", ";
		result = result + old_shelf + ", ";
		result = result + old_position + ", ";
		result = result + "'" + StateSwitch.switchToStr(new_area) + "', ";
		result = result + new_row + ", ";
		result = result + new_shelf + ", ";
		result = result + new_position + ", ";
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
