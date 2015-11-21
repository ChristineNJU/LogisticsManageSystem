package PO;

public class DistancePO extends PO {

	private String city_1 = null;
	private String city_2 = null;
	private double distance = 0;
	private double time = 0;
	
	public DistancePO(String city_1, String city_2, double distance, double time, String DB_URL) {
		super(DB_URL);
		// TODO Auto-generated constructor stub
		this.city_1 = city_1;
		this.city_2 = city_2;
		this.distance = distance;
		this.time = time;
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
	/*
	 * 获取时间
	 * 返回double
	 * */
	public double getTime() {
		return time;
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
	/*
	 * 更新时间
	 * */
	public void setTime(double time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "city_1 = '"+city_1+"' AND city_2 = '"+city_2+"'";
	}
	
}
