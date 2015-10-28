package businesslogic.VO;

import java.util.Date;

import businesslogic.PO.BalancePO;
import businesslogic.State.StorageArea;


public class BalanceVO extends VO {

	private String barCode = null;
	private Date date = null;
	private String destination = null;
	private StorageArea areaBefore = null;
	private int rowBefore = 0;
	private int shelfBefore = 0;
	private int positionBefore = 0;
	private StorageArea areaCode = null;
	private int row = 0;
	private int shelf = 0;
	private int position = 0;
	
	public BalanceVO(String barCode,Date date,String destination,
			StorageArea areaBefore,int rowBefore,int shelfBefore,int positionBefore,
			StorageArea areaCode,int row,int shelf,int position){
		this.barCode = barCode;
		this.date = date;
		this.destination = destination;
		this.areaBefore = areaBefore;
		this.rowBefore = rowBefore;
		this.shelfBefore = shelfBefore;
		this.positionBefore = positionBefore;
		this.areaCode = areaCode;
		this.row = row;
		this.shelf = shelf;
		this.position = position;
	}
	public BalanceVO(BalancePO po) {
		this.barCode = po.getBarCode();
		this.date = po.getStorageDate();
		this.destination = po.getDestination();
		this.areaBefore = po.getOldArea();
		this.row = po.getOldRow();
		this.shelfBefore = po.getOldShelf();
		this.positionBefore = po.getOldPosition();
		this.areaCode = po.getNewArea();
		this.row = po.getNewRow();
		this.shelf = po.getNewShelf();
		this.position = po.getNewPosition();
	}
	
	public String getBarCode(){
		return this.barCode;
	}
	public Date getDate(){
		return this.date;
	}
	public String getDestination(){
		return this.destination;
	}
	public StorageArea getAreaBefore(){
		return this.areaBefore;
	}
	public int getRowBefore(){
		return this.rowBefore;
	}
	public int getShelfBefore(){
		return this.shelfBefore;
	}
	public int getPositionBefore(){
		return this.positionBefore;
	}
	public StorageArea getAreaCode(){
		return this.areaCode;
	}
	public int getRow(){
		return this.row;
	}
	public int getShelf(){
		return this.shelf;
	}
	public int getPosition(){
		return this.position;
	}
	
	public void setBarCode(String barCode){
		this.barCode = barCode;
	}
	public void setDate(Date date){
		this.date = date;
	}
	public void setDestination(String destination){
		this.destination = destination;
	}
	public void setAreaBefore(StorageArea area){
		this.areaBefore = area;
	}
	public void setRowBefore(int rowBefore){
		this.rowBefore = rowBefore;
	}
	public void setShelfBefore(int shelfBefore){
		this.shelfBefore = shelfBefore;
	}
	public void setPositionBefore(int positionBefore){
		this.positionBefore = positionBefore;
	}
	public void setAreaCode(StorageArea area){
		this.areaCode = area;
	}
	public void setRow(int row){
		this.row = row;
	}
	public void setShelf(int shelf){
		this.shelf = shelf;
	}
	public void setPosition(int position){
		this.position = position;
	}
	
}
