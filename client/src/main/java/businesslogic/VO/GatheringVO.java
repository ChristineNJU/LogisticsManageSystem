package businesslogic.VO;

public class GatheringVO extends VO {

	private String date = null;
	private double money = 0;
	private String name = null;
	private String id = null;
	
	public GatheringVO(String date,double money,String name,String id){
		this.date = date;
		this.money = money;
		this.name = name;
		this.id = id;
	}
	
	public String getDate(){
		return date;
	}
	public double getMoney(){
		return money;
	}
	public String getName(){
		return name;
	}
	public String id(){
		return id;
	}
	
}
