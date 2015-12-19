package PO;

import java.text.SimpleDateFormat;
import java.util.Date;

import State.StateSwitch;
import State.StorageArea;
import VO.StockTakingVO;
import businesslogic.URLHelper.URLHelper;

/**
 * 用来保存库存盘点的持久化数据格式
 * 
 * @author 尹子越
 * @version 1.0.0
 * */
public class StockTakingPO extends PO {
	
	// ----- member variables ---------------------------------------
	private String bar_code = "";
	private Date storage_date;
	private String destination = "";
	private StorageArea area_code;
	private int row = 0;
	private int shelf = 0;
	private int position = 0;
	
	/**
	 * 直接创建库存盘点的持久化数据对象
	 * */
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
	
	/**
	 * 通过StockTakingVO创建库存盘点的持久化数据对象
	 * */
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

	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		String result = "";
		
		result = result + "'" + bar_code + "', ";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		result = result + "'" + sdf.format(storage_date) + "', ";
		result = result + "'" + destination + "', ";
		result = result + "'" + StateSwitch.switchToStr(area_code) + "', ";
		result = result + row + "', ";
		result = result + shelf + "', ";
		result = result + position + "'";
		
		System.out.println(result);
		return result;
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "bar_code = '"+bar_code+"'";
	}
}
