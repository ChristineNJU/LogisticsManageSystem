package PO;

import State.StorageArea;
/**
 * 用来保存仓库的持久化数据格式
 * 
 * @author HermC
 * @version 1.0.0
 * */
public class WareHousePO extends PO {
	
	// ----- member variables ---------------------------------------
	private String bar_code = null;
	private String destination = null;
	private StorageArea area_code = null;
	private int row = 0;
	private int shelf = 0;
	private int position = 0;

	/**
	 * 直接创建仓库的持久化数据对象
	 * */
	public WareHousePO(String bar_code, String destination, StorageArea area_code, 
			int row, int shelf, int position, String DB_URL) {
		super(DB_URL);
		// TODO Auto-generated constructor stub
		this.bar_code = bar_code;
		this.destination = destination;
		this.area_code = area_code;
		this.row = row;
		this.shelf = shelf;
		this.position = position;
	}

	/**
	 * 获取条形码
	 * 
	 * @return 条形码String
	 * */
	public String getBar_code() {
		return bar_code;
	}

	/**
	 * 获取目的地
	 * 
	 * @return 目的地
	 * */
	public String getDestination() {
		return destination;
	}

	/**
	 * 获取存储区
	 * 
	 * @return 存储区StorageArea
	 * */
	public StorageArea getArea_code() {
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
		return null;
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "bar_code = '"+bar_code+"'";
	}

}
