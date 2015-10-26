package businesslogic.VO;

import businesslogic.PO.ArrivalPO;
import businesslogic.State.LogisticsState;

public class ArrivalVO extends VO {

	private String date = null;
	private String listId = null;
	private String departure = null;
	private LogisticsState itemState = null;
	
	public ArrivalVO(String date,String listId,String departure,
			LogisticsState itemState){
		this.date = date;
		this.listId = listId;
		this.departure = departure;
		this.itemState = itemState;
	}
	public ArrivalVO(ArrivalPO po) {
		this.date = po.getArrivalDate();
		this.listId = po.getBarCode();
		this.departure = po.getStarting();
		this.itemState = po.getState();
	}
	
	public String getDate(){
		return this.date;
	}
	public String getListId(){
		return this.listId;
	}
	public String getDeparture(){
		return this.departure;
	}
	public LogisticsState getLogisticsState(){
		return this.itemState;
	}
	
	public void setDate(String date){
		this.date = date;
	}
	public void setListId(String listId){
		this.listId = listId;
	}
	public void setDeparture(String departure){
		this.departure = departure;
	}
	public void setItemState(LogisticsState itemState){
		this.itemState = itemState;
	}
	
}
