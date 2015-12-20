package VO;

import java.util.ArrayList;
import java.util.Date;

import PO.InstitutionStoragePO;
import PO.TransferPO;

// TODO: Auto-generated Javadoc
/**
 * The Class TransferVO.
 */
public class TransferVO extends VO {

	/** The date. */
	private Date date = null;
	
	/** The list id. */
	private String listId = null;
	
	/** The transfer id. */
	private String transferId = null;
	
	/** The departure. */
	private String departure = null;
	
	/** The destination. */
	private String destination = null;
	
	/** The container number. */
	private String containerNumber = null;
	
	/** The guard name. */
	private String guardName = null;
	
	/** The item id. */
	private ArrayList<String> itemId = null;
	
	/** The transfer charge. */
	private double transferCharge = 0;
	
	/**
	 * Instantiates a new transfer vo.
	 *
	 * @param date the date
	 * @param listId the list id
	 * @param transferId the transfer id
	 * @param departure the departure
	 * @param destination the destination
	 * @param containerNumber the container number
	 * @param guardName the guard name
	 * @param itemId the item id
	 * @param transferCharge the transfer charge
	 */
	public TransferVO(Date date,String listId,String transferId,String departure,String destination,
			String containerNumber,String guardName,ArrayList<String> itemId,double transferCharge){
		this.date = date;
		this.listId = listId;
		this.transferId = transferId;
		this.departure = departure;
		this.destination = destination;
		this.containerNumber = containerNumber;
		this.guardName = guardName;
		this.itemId = itemId;
		this.transferCharge = transferCharge;
	}
	
	/**
	 * Instantiates a new transfer vo.
	 *
	 * @param po the po
	 */
	public TransferVO(TransferPO po) {
		this.date = po.getDate();
		this.listId = po.getTranferNumber();
		this.transferId = po.getTransportID();
		this.departure = po.getStarting();
		this.destination = po.getDestination();
		this.containerNumber = po.getContainerNumber();
		this.guardName = po.getGuardName();
		this.itemId = po.getBarCodeList();
		this.transferCharge = po.getAmount();
	}
	/**
	 * Instantiates a new transfer vo.
	 *
	 * @param po the po
	 */
	public TransferVO(InstitutionStoragePO po){
		this.date=new Date();
		this.listId=po.getBar_code();
		
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
	 * Gets the list.
	 *
	 * @return the list
	 */
	public String getList(){
		return this.listId;
	}
	
	/**
	 * Gets the transfer id.
	 *
	 * @return the transfer id
	 */
	public String getTransferId(){
		return this.transferId;
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
	 * Gets the destination.
	 *
	 * @return the destination
	 */
	public String getDestination(){
		return this.destination;
	}
	
	/**
	 * Gets the arrival.
	 *
	 * @return the arrival
	 */
	public String getArrival(){
		return this.destination;
	}
	
	/**
	 * Gets the container number.
	 *
	 * @return the container number
	 */
	public String getContainerNumber(){
		return this.containerNumber;
	}
	
	/**
	 * Gets the guard name.
	 *
	 * @return the guard name
	 */
	public String getGuardName(){
		return this.guardName;
	}
	
	/**
	 * Gets the item id.
	 *
	 * @return the item id
	 */
	public ArrayList<String> getItemId(){
		return this.itemId;
	}
	
	/**
	 * Gets the transfer charge.
	 *
	 * @return the transfer charge
	 */
	public double getTransferCharge(){
		return this.transferCharge;
	}
}
