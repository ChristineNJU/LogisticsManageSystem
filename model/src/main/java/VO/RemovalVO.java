package VO;

import java.util.Date;

import PO.RemovalPO;
import PO.StoragePO;
import State.TransferType;

// TODO: Auto-generated Javadoc
/**
 * The Class RemovalVO.
 */
public class RemovalVO extends VO {

	/** The bar code. */
	private String barCode = null;
	
	/** The out date. */
	private Date outDate = null;
	
	/** The destination. */
	private String destination = null;
	
	/** The transfer way. */
	private TransferType transferWay = null;
	
	/** The transfer code. */
	private String transferCode = null;
	
	/**
	 * Instantiates a new removal vo.
	 *
	 * @param barCode the bar code
	 * @param outDate the out date
	 * @param destination the destination
	 * @param transferWay the transfer way
	 * @param transferCode the transfer code
	 */
	public RemovalVO(String barCode,Date outDate,String destination,
			TransferType transferWay,String transferCode){
		this.barCode = barCode;
		this.outDate = outDate;
		this.destination = destination;
		this.transferWay = transferWay;
		this.transferCode = transferCode;
	}
	
	/**
	 * Instantiates a new removal vo.
	 *
	 * @param po the po
	 */
	public RemovalVO(RemovalPO po) {
		this.barCode = po.getBarCode();
		this.outDate = po.getRemovalDate();
		this.destination = po.getDestination();
		this.transferCode = po.getTransferNumber();
		this.transferWay = po.getType();
	}
	/
	
	
	/**
	 * Gets the bar code.
	 *
	 * @return the bar code
	 */
	public String getBarCode(){
		return this.barCode;
	}
	
	/**
	 * Gets the out date.
	 *
	 * @return the out date
	 */
	public Date getOutDate(){
		return this.outDate;
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
	 * Gets the transfer way.
	 *
	 * @return the transfer way
	 */
	public TransferType getTransferWay(){
		return this.transferWay;
	}
	
	/**
	 * Gets the transfer code.
	 *
	 * @return the transfer code
	 */
	public String getTransferCode(){
		return this.transferCode;
	}
	
}
