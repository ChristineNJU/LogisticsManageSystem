package businesslogic.PO;

public class DistancePO extends PO {

	private String starting = null;
	private String destination = null;
	private double distance = 0;
	
	public DistancePO(String starting, String destination, double distance, String DB_URL) {
		super(DB_URL);
		// TODO Auto-generated constructor stub
		this.starting = starting;
		this.destination = destination;
		this.distance = distance;
	}
	
	/*===============================================================
	 * Public方法
	 * */
	
	/*---------------------------------------------------------------
	 * 对DistancePO的数据进行读取
	 * */
	/*
	 * 
	 * */

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
