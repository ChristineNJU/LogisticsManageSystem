package businesslogic.VO;

/*========================================================================================
 * 用来在界面层显示的派件信息
 * */
public class DeliveryVO extends VO {

	private String arrivalDate = null;
	private String barCode = null;
	private String people = null;
	
	public DeliveryVO(String arrivalDate,String id,String people){
		this.arrivalDate = arrivalDate;
		this.barCode = id;
		this.people = people;
	}
	
	public String getArrivalDate(){
		return this.arrivalDate;
	}
	
	public String getId(){
		return barCode;
	}
	
	public String getPeople(){
		return people;
	}

	public void setArrivalDate(String date){
		this.arrivalDate = date;
	}
	public void setBarCode(String barCode){
		this.barCode = barCode;
	}
	public void setpeople(String people){
		this.people = people;
	}
	
}
