package businesslogic.VO;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.PO.DeliveryPO;

/*========================================================================================
 * 用来在界面层显示的派件信息
 * */
public class DeliveryVO extends VO {

	private Date arrivalDate = null;
	private ArrayList<String> barCodeList = null;
	private String people = null;
	
	public DeliveryVO(Date arrivalDate,ArrayList<String> id,String people){
		this.arrivalDate = arrivalDate;
		this.barCodeList = id;
		this.people = people;
	}
	public DeliveryVO(DeliveryPO po) {
		this.arrivalDate = po.getDate();
		this.barCodeList = po.getBarCodeList();
		this.people = po.getCourier();
	}
	
	public Date getArrivalDate(){
		return this.arrivalDate;
	}
	
	public ArrayList<String> getBarCodeList(){
		return barCodeList;
	}
	
	public String getPeople(){
		return people;
	}

	public void setArrivalDate(Date date){
		this.arrivalDate = date;
	}
	public void setBarCode(ArrayList<String> barCodeList){
		this.barCodeList = barCodeList;
	}
	public void setpeople(String people){
		this.people = people;
	}
	
}
