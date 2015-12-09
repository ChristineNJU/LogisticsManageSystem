package VO;

import java.util.Date;

import PO.ArrivalPO;
import State.LogisticsState;

// TODO: Auto-generated Javadoc
/**
 * The Class ArrivalVO.
 */
public class ArrivalVO extends VO {

	/** The bar code. */
	private String barCode = null;
	
	/** The date. */
	private Date date = null;
	
	/** The list id. */
	private String listId = null;
	
	/** The departure. */
	private String departure = null;
	
	/** The item state. */
	private LogisticsState itemState = null;
	
	
	/**
	 * Instantiates a new arrival vo.
	 *
	 * @param barCode the bar code
	 * @param date the date
	 * @param listId the list id
	 * @param departure the departure
	 * @param itemState the item state
	 */
	public ArrivalVO(String barCode,Date date,String listId,String departure,
			LogisticsState itemState){
		this.barCode = barCode;
		this.date = date;
		this.listId = listId;
		this.departure = departure;
		this.itemState = itemState;
	}
	
	/**
	 * Instantiates a new arrival vo.
	 *
	 * @param po the po
	 */
	public ArrivalVO(ArrivalPO po) {
		this.date = po.getArrivalDate();
		this.barCode=po.getBarCode();
		this.listId = po.getTransferNumber();
		this.departure = po.getStarting();
		this.itemState = po.getState();
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
	 * Gets the list id.
	 *
	 * @return the list id
	 */
	public String getListId(){
		return this.listId;
	}
	
	/**
	 * Gets the departure.
	 *
	 * @return the departure
	 */
	public String getDeparture(){
		return this.departure;
	}
	
	/**
	 * Gets the logistics state.
	 *
	 * @return the logistics state
	 */
	public LogisticsState getLogisticsState(){
		return this.itemState;
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
	 * Sets the list id.
	 *
	 * @param listId the new list id
	 */
	public void setListId(String listId){
		this.listId = listId;
	}
	
	/**
	 * Sets the departure.
	 *
	 * @param departure the new departure
	 */
	public void setDeparture(String departure){
		this.departure = departure;
	}
	
	/**
	 * Sets the item state.
	 *
	 * @param itemState the new item state
	 */
	public void setItemState(LogisticsState itemState){
		this.itemState = itemState;
	}
	
}
