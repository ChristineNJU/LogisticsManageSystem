package businesslogic.VO;

import businesslogic.State.StorageArea;

public class StockTakingVO extends VO {
	private String barCode = null;
	private String storageDate = null;
	private String destination = null;
	private StorageArea areaCode = null;
	private int row = 0;
	private int shelf = 0;
	private int position = 0;
	
	public StockTakingVO(String barCode, String storageDate, String destnation, StorageArea areaCode, 
			int row, int shelf, int position) {
		this.barCode = barCode;
		this.storageDate = storageDate;
		this.destination = destnation;
		this.areaCode = areaCode;
		this.row = row;
		this.shelf = shelf;
		this.position = position;
	}
	
	public String getBarCode(){
		return this.barCode;
	}
	public String getStorageDate(){
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
