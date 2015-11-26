package PO;

import java.util.Date;

import State.StorageArea;
import VO.StockTakingVO;
import businesslogic.URLHelper.URLHelper;

/*========================================================================================
 * 用来保存库存盘点的持久化数据格式
 * */

public class StockTakingPO extends PO {
	private String bar_code = null;
	private Date storage_date = null;
	private String destination = null;
	private StorageArea area_code = null;
	private int row = 0;
	private int shelf = 0;
	private int position = 0;
	
	public StockTakingPO(String bar_code, Date storage_date, String destnation, StorageArea area_code, 
			int row, int shelf, int position, String DB_URL) {
		super(DB_URL);
		
		this.bar_code = bar_code;
		this.storage_date = storage_date;
		this.destination = destnation;
		this.area_code = area_code;
		this.row = row;
		this.shelf = shelf;
		this.position = position;
	}
	
	public StockTakingPO(StockTakingVO stockTaking, String institutionID){
		super(URLHelper.getStockTakingURL(institutionID));
		this.bar_code=stockTaking.getBarCode();
		this.storage_date=stockTaking.getStorageDate();
		this.destination=stockTaking.getDestination();
		this.area_code=stockTaking.getAreaCode();
		this.row=stockTaking.getRow();
		this.shelf=stockTaking.getShelf();
		this.position=stockTaking.getPosition();
	}

	/*====================================================================================
	 * Public方法
	 * */
	
	/*------------------------------------------------------------------------------------
	 * 对StockTakingePO的数据进行读取
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

	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "bar_code = '"+bar_code+"'";
	}
}
