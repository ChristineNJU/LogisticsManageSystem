package VO;

import java.util.ArrayList;
import java.util.Date;

import PO.EntruckingPO;
import PO.InstitutionStoragePO;
import PO.RemovalPO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntruckingVO.
 */
public class EntruckingVO extends VO {

	/** The date. */
	private Date date = null;
	
	/** The institutionr number. */
	private String institutionrNumber = null;
	
	/** The destination. */
	private String destination = null;
	
	/** The car number. */
	private String carNumber = null;
	
	/** The guard name. */
	private String guardName = null;
	
	/** The supercargo name. */
	private String supercargoName = null;
	
	/** The bar code list. */
	private ArrayList<String> barCodeList = new ArrayList<String>();
	
	/** The amount. */
	private double amount = 0;
	
	/**
	 * Instantiates a new entrucking vo.
	 *
	 * @param date the date
	 * @param transfer_number the transfer_number
	 * @param destination the destination
	 * @param car_number the car_number
	 * @param guard_name the guard_name
	 * @param supercargo_name the supercargo_name
	 * @param bar_code_list the bar_code_list
	 * @param amount the amount
	 */
	public EntruckingVO(Date date, String transfer_number, String destination, String car_number,
			String guard_name, String supercargo_name, ArrayList<String> bar_code_list, double amount) {
		this.date = date;
		this.institutionrNumber = transfer_number;
		this.destination = destination;
		this.carNumber = car_number;
		this.guardName = guard_name;
		this.supercargoName = supercargo_name;
		this.barCodeList = bar_code_list;
		this.amount = amount;
	}
	
	/**
	 * Instantiates a new entrucking vo.
	 *
	 * @param po the po
	 */
	public EntruckingVO(EntruckingPO po) {
		this.date = po.getDate();
		this.institutionrNumber = po.getTransferNumber();
		this.destination = po.getDestination();
		this.guardName = po.getGuardName();
		this.supercargoName = po.getSupercargoName();
		this.barCodeList = po.getBarCodeList();
		this.amount = po.getAmount();
	}
	/**
	 * Instantiates a new entrucking vo.
	 *
	 * @param po the po
	 */
	public EntruckingVO(InstitutionStoragePO po){
		this.date=new Date();
		this.barCodeList.add(po.getBar_code());
		
	}
	
	/**
	 * Instantiates a new entrucking vo.
	 *
	 * @param po the po
	 */
	public EntruckingVO(RemovalPO po){
		this.date=new Date();
		this.barCodeList.add(po.getBarCode());
	}
	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate(){
		return this.date;
	}
	
	/**
	 * Gets the institutio number.
	 *
	 * @return the institutio number
	 */
	public String getInstitutioNumber(){
		return this.institutionrNumber;
	}
	
	/**
	 * Gets the destination.
	 *
	 * @return the destination
	 */
	public String getDestination(){
		return this.destination;
	}
	
	/**
	 * Gets the car number.
	 *
	 * @return the car number
	 */
	public String getCarNumber(){
		return this.carNumber;
	}
	
	/**
	 * Gets the guard number.
	 *
	 * @return the guard number
	 */
	public String getguardNumber(){
		return this.guardName;
	}
	
	/**
	 * Gets the supercargo name.
	 *
	 * @return the supercargo name
	 */
	public String getSupercargoName(){
		return this.supercargoName;
	}
	
	/**
	 * Gets the bar code list.
	 *
	 * @return the bar code list
	 */
	public ArrayList<String> getBarCodeList(){
		return this.barCodeList;
	}
	
	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public double getAmount(){
		return this.amount;
	}
	
}
