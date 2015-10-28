package businesslogic.VO;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.PO.EntruckingPO;

public class EntruckingVO extends VO {

	private Date date = null;
	private String institutionrNumber = null;
	private String destination = null;
	private String carNumber = null;
	private String guardName = null;
	private String supercargoName = null;
	private ArrayList<String> barCodeList = new ArrayList<String>();
	private double amount = 0;
	
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
	public EntruckingVO(EntruckingPO po) {
		this.date = po.getDate();
		this.institutionrNumber = po.getTransferNumber();
		this.destination = po.getDestination();
		this.guardName = po.getGuardName();
		this.supercargoName = po.getSupercargoName();
		this.barCodeList = po.getBarCodeList();
		this.amount = po.getAmount();
	}
	
	public Date getDate(){
		return this.date;
	}
	public String getInstitutioNumber(){
		return this.institutionrNumber;
	}
	public String getDestination(){
		return this.destination;
	}
	public String getCarNumber(){
		return this.carNumber;
	}
	public String getguardNumber(){
		return this.guardName;
	}
	public String getSupercargoName(){
		return this.supercargoName;
	}
	public ArrayList<String> getBarCodeList(){
		return this.barCodeList;
	}
	public double getAmount(){
		return this.amount;
	}
	
}
