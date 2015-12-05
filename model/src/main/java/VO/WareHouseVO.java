package VO;

import PO.WareHousePO;
import State.StorageArea;

public class WareHouseVO {
	
	private String bar_code = "";
	private String destination = "";
	private StorageArea area_code = null;
	private int row = 0;
	private int shelf = 0;
	private int position = 0;
	
	public WareHouseVO(WareHousePO po) {
		this.bar_code = po.getBar_code();
		this.destination = po.getDestination();
		this.area_code = po.getArea_code();
		this.row = po.getRow();
		this.shelf = po.getShelf();
		this.position = po.getPosition();
	}
	
	public WareHouseVO(String bar_code, String destination, StorageArea area, 
			int row, int shelf, int positoin) {
		this.bar_code = bar_code;
		this.destination = destination;
		this.area_code = area;
		this.row = row;
		this.shelf = shelf;
		this.position = positoin;
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
	
	
}
