package businesslogic.VO;

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
