package businesslogic.VO;

/*========================================================================================
 * 用来在界面层显示的派件信息
 * */
public class DeliveryVO extends VO {

	private String arrivalDate = null;
	private String id = null;
	private String people = null;
	
	public DeliveryVO(String arrivalDate,String id,String people){
		this.arrivalDate = arrivalDate;
		this.id = id;
		this.people = people;
	}
	
	public String getArrivalDate(){
		return this.arrivalDate;
	}
	
	public String getId(){
		return id;
	}
	
	public String getPeople(){
		return people;
	}
}
