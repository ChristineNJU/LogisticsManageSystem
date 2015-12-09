package VO;

import java.util.Date;

import PO.StockTakingPO;
import State.StorageArea;

// TODO: Auto-generated Javadoc
/**
 * The Class StockTakingVO.
 */
public class StockTakingVO extends VO {
	
	/** The bar code. */
	private String barCode = null;
	
	/** The storage date. */
	private Date storageDate = null;
	
	/** The destination. */
	private String destination = null;
	
	/** The area code. */
	private StorageArea areaCode = null;
	
	/** The row. */
	private int row = 0;
	
	/** The shelf. */
	private int shelf = 0;
	
	/** The position. */
	private int position = 0;
	
	/**
	 * Instantiates a new stock taking vo.
	 *
	 * @param barCode the bar code
	 * @param storageDate the storage date
	 * @param destnation the destnation
	 * @param areaCode the area code
	 * @param row the row
	 * @param shelf the shelf
	 * @param position the position
	 */
	public StockTakingVO(String barCode, Date storageDate, String destnation, StorageArea areaCode, 
			int row, int shelf, int position) {
		this.barCode = barCode;
		this.storageDate = storageDate;
		this.destination = destnation;
		this.areaCode = areaCode;
		this.row = row;
		this.shelf = shelf;
		this.position = position;
	}
	
	/**
	 * Instantiates a new stock taking vo.
	 *
	 * @param po the po
	 */
	public StockTakingVO(StockTakingPO po) {
		this.barCode = po.getBarCode();
		this.storageDate = po.getDate();
		this.destination = po.getDestination();
		this.areaCode = po.getAreaCode();
		this.row = po.getRow();
		this.shelf = po.getShelf();
		this.position = po.getPosition();
	}
	
	/**
	 * Gets the bar code.
	 *
	 * @return the bar code
	 */
	public String getBarCode(){
		return this.barCode;
	}
	
	/**
	 * Gets the storage date.
	 *
	 * @return the storage date
	 */
	public Date getStorageDate(){
		return this.storageDate;
	}
	
	/**
	 * Gets the destination.
	 *
	 * @return the destination
	 */
	public String getDestination(){
		return this.destination;
	}
	
	/**
	 * Gets the area code.
	 *
	 * @return the area code
	 */
	public StorageArea getAreaCode(){
		return this.areaCode;
	}
	
	/**
	 * Gets the row.
	 *
	 * @return the row
	 */
	public int getRow(){
		return this.row;
	}
	
	/**
	 * Gets the shelf.
	 *
	 * @return the shelf
	 */
	public int getShelf(){
		return this.shelf;
	}
	
	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	public int getPosition(){
		return this.position;
	}
	
}
