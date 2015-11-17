package VO;

import java.util.ArrayList;
import java.util.Date;

import PO.GatheringPO;

public class GatheringVO extends VO {

	private Date date = null;
	private double money = 0;
	private String name = null;
	private ArrayList<String> barCodeList = new ArrayList<String>();
	
	public GatheringVO(Date date,double money,String name,ArrayList<String> barCodeList){
		this.date = date;
		this.money = money;
		this.name = name;
		this.barCodeList = barCodeList;
	}
	public GatheringVO(GatheringPO po) {
		this.date = po.getDate();
		this.money = po.getAmount();
		this.name = po.getCourier();
		this.barCodeList = po.getBarCodeList();
	}
	
	public Date getDate(){
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
