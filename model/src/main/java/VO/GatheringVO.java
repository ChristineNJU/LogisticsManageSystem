package VO;

import java.util.ArrayList;
import java.util.Date;

import PO.GatheringPO;
import PO.GatheringStoragePO;

// TODO: Auto-generated Javadoc
/**
 * The Class GatheringVO.
 */
public class GatheringVO extends VO {

	/** The date. */
	private Date date = null;
	
	/** The money. */
	private double money = 0;
	
	/** The name. */
	private String name = null;
	
	/** The bar code list. */
	private ArrayList<String> barCodeList = new ArrayList<String>();
	
	/**
	 * Instantiates a new gathering vo.
	 *
	 * @param date the date
	 * @param money the money
	 * @param name the name
	 * @param barCodeList the bar code list
	 */
	public GatheringVO(Date date,double money,String name,ArrayList<String> barCodeList){
		this.date = date;
		this.money = money;
		this.name = name;
		this.barCodeList = barCodeList;
	}
	
	/**
	 * Instantiates a new gathering vo.
	 *
	 * @param po the po
	 */
	public GatheringVO(GatheringPO po) {
		this.date = po.getDate();
		this.money = po.getAmount();
		this.name = po.getCourier();
		this.barCodeList = po.getBarCodeList();
	}
	/**
	 * Instantiates a new gathering vo.
	 *
	 * @param po the po
	 */
	public GatheringVO(GatheringStoragePO po){
		this.date=new Date();
		this.money=po.getAmount();
		this.barCodeList.add(po.getBar_code());
		this.name=po.getCourier();
	}
	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate(){
		return date;
	}
	
	/**
	 * Gets the money.
	 *
	 * @return the money
	 */
	public double getMoney(){
		return money;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Id.
	 *
	 * @return the array list
	 */
	public ArrayList<String> id(){
		return barCodeList;
	}
	
}
