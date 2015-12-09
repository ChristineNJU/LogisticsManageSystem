package VO;

import java.util.Date;

import PO.BalancePO;
import State.StorageArea;


// TODO: Auto-generated Javadoc
/**
 * The Class BalanceVO.
 */
public class BalanceVO extends VO {

	/** The bar code. */
	private String barCode = null;
	
	/** The date. */
	private Date date = null;
	
	/** The destination. */
	private String destination = null;
	
	/** The area before. */
	private StorageArea areaBefore = null;
	
	/** The row before. */
	private int rowBefore = 0;
	
	/** The shelf before. */
	private int shelfBefore = 0;
	
	/** The position before. */
	private int positionBefore = 0;
	
	/** The area code. */
	private StorageArea areaCode = null;
	
	/** The row. */
	private int row = 0;
	
	/** The shelf. */
	private int shelf = 0;
	
	/** The position. */
	private int position = 0;
	
	/**
	 * Instantiates a new balance vo.
	 *
	 * @param barCode the bar code
	 * @param date the date
	 * @param destination the destination
	 * @param areaBefore the area before
	 * @param rowBefore the row before
	 * @param shelfBefore the shelf before
	 * @param positionBefore the position before
	 * @param areaCode the area code
	 * @param row the row
	 * @param shelf the shelf
	 * @param position the position
	 */
	public BalanceVO(String barCode,Date date,String destination,
			StorageArea areaBefore,int rowBefore,int shelfBefore,int positionBefore,
			StorageArea areaCode,int row,int shelf,int position){
		this.barCode = barCode;
		this.date = date;
		this.destination = destination;
		this.areaBefore = areaBefore;
		this.rowBefore = rowBefore;
		this.shelfBefore = shelfBefore;
		this.positionBefore = positionBefore;
		this.areaCode = areaCode;
		this.row = row;
		this.shelf = shelf;
		this.position = position;
	}
	
	/**
	 * Instantiates a new balance vo.
	 *
	 * @param po the po
	 */
	public BalanceVO(BalancePO po) {
		this.barCode = po.getBarCode();
		this.date = po.getStorageDate();
		this.destination = po.getDestination();
		this.areaBefore = po.getOldArea();
		this.row = po.getOldRow();
		this.shelfBefore = po.getOldShelf();
		this.positionBefore = po.getOldPosition();
		this.areaCode = po.getNewArea();
		this.row = po.getNewRow();
		this.shelf = po.getNewShelf();
		this.position = po.getNewPosition();
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
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate(){
		return this.date;
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
	 * Gets the area before.
	 *
	 * @return the area before
	 */
	public StorageArea getAreaBefore(){
		return this.areaBefore;
	}
	
	/**
	 * Gets the row before.
	 *
	 * @return the row before
	 */
	public int getRowBefore(){
		return this.rowBefore;
	}
	
	/**
	 * Gets the shelf before.
	 *
	 * @return the shelf before
	 */
	public int getShelfBefore(){
		return this.shelfBefore;
	}
	
	/**
	 * Gets the position before.
	 *
	 * @return the position before
	 */
	public int getPositionBefore(){
		return this.positionBefore;
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
	
	/**
	 * Sets the bar code.
	 *
	 * @param barCode the new bar code
	 */
	public void setBarCode(String barCode){
		this.barCode = barCode;
	}
	
	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(Date date){
		this.date = date;
	}
	
	/**
	 * Sets the destination.
	 *
	 * @param destination the new destination
	 */
	public void setDestination(String destination){
		this.destination = destination;
	}
	
	/**
	 * Sets the area before.
	 *
	 * @param area the new area before
	 */
	public void setAreaBefore(StorageArea area){
		this.areaBefore = area;
	}
	
	/**
	 * Sets the row before.
	 *
	 * @param rowBefore the new row before
	 */
	public void setRowBefore(int rowBefore){
		this.rowBefore = rowBefore;
	}
	
	/**
	 * Sets the shelf before.
	 *
	 * @param shelfBefore the new shelf before
	 */
	public void setShelfBefore(int shelfBefore){
		this.shelfBefore = shelfBefore;
	}
	
	/**
	 * Sets the position before.
	 *
	 * @param positionBefore the new position before
	 */
	public void setPositionBefore(int positionBefore){
		this.positionBefore = positionBefore;
	}
	
	/**
	 * Sets the area code.
	 *
	 * @param area the new area code
	 */
	public void setAreaCode(StorageArea area){
		this.areaCode = area;
	}
	
	/**
	 * Sets the row.
	 *
	 * @param row the new row
	 */
	public void setRow(int row){
		this.row = row;
	}
	
	/**
	 * Sets the shelf.
	 *
	 * @param shelf the new shelf
	 */
	public void setShelf(int shelf){
		this.shelf = shelf;
	}
	
	/**
	 * Sets the position.
	 *
	 * @param position the new position
	 */
	public void setPosition(int position){
		this.position = position;
	}
	
}
