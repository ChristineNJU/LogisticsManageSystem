package PO;

import State.StorageArea;

public class WareHousePO extends PO {
	
	private String bar_code = null;
	private String destination = null;
	private StorageArea area_code = null;
	private int row = 0;
	private int shelf = 0;
	private int position = 0;

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

	public String getBar_code() {
		return bar_code;
	}

	public String getDestination() {
		return destination;
	}

	public StorageArea getArea_code() {
		return area_code;
	}

	public int getRow() {
		return row;
	}

	public int getShelf() {
		return shelf;
	}

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
