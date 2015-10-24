package businesslogic.PO;

import businesslogic.State.StorageArea;

/*========================================================================================
 * 用来保存库存盘点的持久化数据格式
 * */

public class StockTakingPO extends PO {
	
	private String bar_code = null;
	private String storage_date = null;
	private String destination = null;
	private StorageArea area_code = null;
	private int row = 0;
	private int shelf = 0;
	private int position = 0;
	private boolean isApproved = false;
	
	public StockTakingPO(String bar_code, String storage_date, String destnation, StorageArea area_code, 
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

	/*====================================================================================
	 * Public方法
	 * */
	
	/*------------------------------------------------------------------------------------
	 * 对StockingTakingPO的数据进行读取
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
	 * 返回String
	 * */
	public String getDate() {
		return storage_date;
	}
	/*
	 * 获取
	 * */
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
