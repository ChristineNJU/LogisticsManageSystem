package VO;

import java.util.ArrayList;
import java.util.Date;

import PO.DeliveryPO;
import PO.InstitutionStoragePO;

// TODO: Auto-generated Javadoc
/**
 * The Class DeliveryVO.
 */
/*========================================================================================
 * 用来在界面层显示的派件信息
 * */
public class DeliveryVO extends VO {

	/** The arrival date. */
	private Date arrivalDate = null;
	
	/** The bar code list. */
	private ArrayList<String> barCodeList = null;
	
	/** The people. */
	private String people = null;
	
	/**
	 * Instantiates a new delivery vo.
	 *
	 * @param arrivalDate the arrival date
	 * @param id the id
	 * @param people the people
	 */
	public DeliveryVO(Date arrivalDate,ArrayList<String> id,String people){
		this.arrivalDate = arrivalDate;
		this.barCodeList = id;
		this.people = people;
	}
	
	/**
	 * Instantiates a new delivery vo.
	 *
	 * @param po the po
	 */
	public DeliveryVO(DeliveryPO po) {
		this.arrivalDate = po.getDate();
		this.barCodeList = po.getBarCodeList();
		this.people = po.getCourier();
	}
	/**
	 * Instantiates a new delivery vo.
	 *
	 * @param po the po
	 */
	public DeliveryVO(InstitutionStoragePO po){
		this.arrivalDate = new Date();
		this.barCodeList.add(po.getBar_code());
		
	}
	/**
	 * Gets the arrival date.
	 *
	 * @return the arrival date
	 */
	public Date getArrivalDate(){
		return this.arrivalDate;
	}
	
	/**
	 * Gets the bar code list.
	 *
	 * @return the bar code list
	 */
	public ArrayList<String> getBarCodeList(){
		return barCodeList;
	}
	
	/**
	 * Gets the people.
	 *
	 * @return the people
	 */
	public String getPeople(){
		return people;
	}

	/**
	 * Sets the arrival date.
	 *
	 * @param date the new arrival date
	 */
	public void setArrivalDate(Date date){
		this.arrivalDate = date;
	}
	
	/**
	 * Sets the bar code.
	 *
	 * @param barCodeList the new bar code
	 */
	public void setBarCode(ArrayList<String> barCodeList){
		this.barCodeList = barCodeList;
	}
	
	/**
	 * Sets the people.
	 *
	 * @param people the new people
	 */
	public void setpeople(String people){
		this.people = people;
	}
	
}
