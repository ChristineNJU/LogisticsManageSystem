package VO;

import java.util.Date;

import PO.StockTakingPO;
import State.StorageArea;

public class StockTakingVO extends VO {
	private String barCode = null;
	private Date storageDate = null;
	private String destination = null;
	private StorageArea areaCode = null;
	private int row = 0;
	private int shelf = 0;
	private int position = 0;
	
	public StockTakingVO(String barCode, Date storageDate, String destnation, StorageArea areaCode, 
			int row, int shelf, int position) {
		this.barCode = barCode;
		this.storageDate = storageDate;
		this.destination = destnation;
		this.areaCode = areaCode;
		this.row = row;
		this.shelf = shelf;
		this.position = position;
	}
	public StockTakingVO(StockTakingPO po) {
		this.barCode = po.getBarCode();
		this.storageDate = po.getDate();
		this.destination = po.getDestination();
		this.areaCode = po.getAreaCode();
		this.row = po.getRow();
		this.shelf = po.getShelf();
		this.position = po.getPosition();
	}
	
	public String getBarCode(){
		return this.barCode;
	}
	public Date getStorageDate(){
		return this.storageDate;
	}
	public String getDestination(){
		return this.destination;
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
	
}
