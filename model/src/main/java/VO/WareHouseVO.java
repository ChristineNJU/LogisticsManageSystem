package VO;

import PO.WareHousePO;
import State.StorageArea;

// TODO: Auto-generated Javadoc
/**
 * The Class WareHouseVO.
 */
public class WareHouseVO {
	
	/** The bar_code. */
	private String bar_code = "";
	
	/** The destination. */
	private String destination = "";
	
	/** The area_code. */
	private StorageArea area_code = null;
	
	/** The row. */
	private int row = 0;
	
	/** The shelf. */
	private int shelf = 0;
	
	/** The position. */
	private int position = 0;
	
	/**
	 * Instantiates a new ware house vo.
	 *
	 * @param po the po
	 */
	public WareHouseVO(WareHousePO po) {
		this.bar_code = po.getBar_code();
		this.destination = po.getDestination();
		this.area_code = po.getArea_code();
		this.row = po.getRow();
		this.shelf = po.getShelf();
		this.position = po.getPosition();
	}
	
	/**
	 * Instantiates a new ware house vo.
	 *
	 * @param bar_code the bar_code
	 * @param destination the destination
	 * @param area the area
	 * @param row the row
	 * @param shelf the shelf
	 * @param positoin the positoin
	 */
	public WareHouseVO(String bar_code, String destination, StorageArea area, 
			int row, int shelf, int positoin) {
		this.bar_code = bar_code;
		this.destination = destination;
		this.area_code = area;
		this.row = row;
		this.shelf = shelf;
		this.position = positoin;
	}

	/**
	 * Gets the bar_code.
	 *
	 * @return the bar_code
	 */
	public String getBar_code() {
		return bar_code;
	}

	/**
	 * Gets the destination.
	 *
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * Gets the area_code.
	 *
	 * @return the area_code
	 */
	public StorageArea getArea_code() {
		return area_code;
	}

	/**
	 * Gets the row.
	 *
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Gets the shelf.
	 *
	 * @return the shelf
	 */
	public int getShelf() {
		return shelf;
	}

	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}
	
	
}
