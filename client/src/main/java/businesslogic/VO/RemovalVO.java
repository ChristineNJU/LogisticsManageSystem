package businesslogic.VO;

public class RemovalVO extends VO {

	private String barCode = null;
	private String outDate = null;
	private String destination = null;
	private String transferWay = null;
	private String transferCode = null;
	
	public RemovalVO(String barCode,String outDate,String destination,
			String transferWay,String transferCode){
		this.barCode = barCode;
		this.outDate = outDate;
		this.destination = destination;
		this.transferWay = transferWay;
		this.transferCode = transferCode;
	}
	
	public String getBarCode(){
		return this.barCode;
	}
	public String getOutDate(){
		return this.outDate;
	}
	public String getDestination(){
		return this.destination;
	}
	public String getTransferWay(){
		return this.transferWay;
	}
	public String getTransferCode(){
		return this.transferCode;
	}
	
}
