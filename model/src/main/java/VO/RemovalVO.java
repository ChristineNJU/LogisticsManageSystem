package VO;

import java.util.Date;

import PO.RemovalPO;
import State.TransferType;

public class RemovalVO extends VO {

	private String barCode = null;
	private Date outDate = null;
	private String destination = null;
	private TransferType transferWay = null;
	private String transferCode = null;
	
	public RemovalVO(String barCode,Date outDate,String destination,
			TransferType transferWay,String transferCode){
		this.barCode = barCode;
		this.outDate = outDate;
		this.destination = destination;
		this.transferWay = transferWay;
		this.transferCode = transferCode;
	}
	public RemovalVO(RemovalPO po) {
		this.barCode = po.getBarCode();
		this.outDate = po.getRemovalDate();
		this.destination = po.getDestination();
		this.transferCode = po.getTransferNumber();
		this.transferWay = po.getType();
	}
	
	
	public String getBarCode(){
		return this.barCode;
	}
	public Date getOutDate(){
		return this.outDate;
	}
	public String getDestination(){
		return this.destination;
	}
	public TransferType getTransferWay(){
		return this.transferWay;
	}
	public String getTransferCode(){
		return this.transferCode;
	}
	
}
