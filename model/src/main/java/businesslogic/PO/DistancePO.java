package businesslogic.PO;

public class DistancePO extends PO {

	private String city_1 = null;
	private String city_2 = null;
	private double distance = 0;
	
	public DistancePO(String city_1, String city_2, double distance, String DB_URL) {
		super(DB_URL);
		// TODO Auto-generated constructor stub
		this.city_1 = city_1;
		this.city_2 = city_2;
		this.distance = distance;
	}
	
	/*===============================================================
	 * Public方法
	 * */
	
	/*---------------------------------------------------------------
	 * 对DistancePO的数据进行读取
	 * */
	/*
	 * 获取城市1
	 * 返回String
	 * */
	public String getCity_1() {
		return city_1;
	}
	/*
	 * 获取城市2
	 * 返回String
	 * */
	public String getCity_2() {
		return city_2;
	}
	/*
	 * 获取距离
	 * 返回double
	 * */
	public double getDistance() {
		return distance;
	}
	
	/*---------------------------------------------------------------
	 * 对DistancePO的数据进行更新
	 * */
	/*
	 * 更新距离
	 * */
	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
