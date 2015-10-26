package businesslogic.VO;

import java.util.ArrayList;

import businesslogic.PO.TransferPO;

public class TransferVO extends VO {

	private String date = null;
	private String listId = null;
	private String transferId = null;
	private String departure = null;
	private String destination = null;
	private String containerNumber = null;
	private String guardName = null;
	private ArrayList<String> itemId = null;
	private double transferCharge = 0;
	
	public TransferVO(String date,String listId,String transferId,String departure,String destination,
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
	public TransferVO(TransferPO po) {
		this.date = po.getDate();
		this.listId = po.getTranferNumber();
		this.departure = po.getStarting();
		this.destination = po.getDestination();
		this.containerNumber = po.getContainerNumber();
		this.guardName = po.getGuardName();
		this.itemId = po.getBarCodeList();
		this.transferCharge = po.getAmount();
	}
	
	public String getDate(){
		return this.date;
	}
	public String getList(){
		return this.listId;
	}
	public String getTransferId(){
		return this.transferId;
	}
	public String getDeparture(){
		return this.departure;
	}
	public String getArrival(){
		return this.destination;
	}
	public String getContainerNumber(){
		return this.containerNumber;
	}
	public String getGuardName(){
		return this.guardName;
	}
	public ArrayList<String> getItemId(){
		return this.itemId;
	}
	public double getTransferCharge(){
		return this.transferCharge;
	}
}
