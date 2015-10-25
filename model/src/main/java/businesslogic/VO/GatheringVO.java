package businesslogic.VO;

import java.util.ArrayList;

public class GatheringVO extends VO {

	private String date = null;
	private double money = 0;
	private String name = null;
	private ArrayList<String> barCodeList = new ArrayList<String>();
	
	public GatheringVO(String date,double money,String name,ArrayList<String> barCodeList){
		this.date = date;
		this.money = money;
		this.name = name;
		this.barCodeList = barCodeList;
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
	public ArrayList<String> id(){
		return barCodeList;
	}
	
}
