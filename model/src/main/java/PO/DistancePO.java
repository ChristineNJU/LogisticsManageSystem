package PO;

import VO.DistanceVO;

/**
 * 用来保存距离的持久化数据格式
 * 
 * @author 尹子越
 * @version 1.0.0
 * */
public class DistancePO extends PO {

	// ----- member variables ---------------------------------------
	private String city_1 = "";
	private String city_2 = "";
	private double distance = 0;
	private double time = 0;
	
	/**
	 * 直接创建距离的持久化数据格式
	 * */
	public DistancePO(String city_1, String city_2, double distance, double time, String DB_URL) {
		super(DB_URL);
		// TODO Auto-generated constructor stub
		this.city_1 = city_1;
		this.city_2 = city_2;
		this.distance = distance;
		this.time = time;
	}
	
	/**
	 * 通过DistanceVO创建距离的持久化数据格式
	 * */
	public DistancePO(DistanceVO d, double time, String DB_URL) {
		super(DB_URL);
		
		this.city_1 = d.getCity_1();
		this.city_2 = d.getCity_2();
		this.distance = d.getDistance();
		this.time = time;
	}
	
	/*===============================================================
	 * Public方法
	 * */
	
	/*---------------------------------------------------------------
	 * 对DistancePO的数据进行读取
	 * */
	/**
	 * 获取城市1
	 * 
	 * @return 城市1String
	 * */
	public String getCity_1() {
		return city_1;
	}
	
	/**
	 * 获取城市2
	 * 
	 * @return 城市2String
	 * */
	public String getCity_2() {
		return city_2;
	}
	
	/**
	 * 获取距离
	 * 
	 * @return 距离
	 * */
	public double getDistance() {
		return distance;
	}
	
	/**
	 * 获取时间
	 * 
	 * @return 时间
	 * */
	public double getTime() {
		return time;
	}
	
	/*---------------------------------------------------------------
	 * 对DistancePO的数据进行更新
	 * */
	/**
	 * 更新距离
	 * 
	 * @param distance 新距离
	 * */
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	/**
	 * 更新时间
	 * 
	 * @param time 新时间
	 * */
	public void setTime(double time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		String result = "";
		
		result = result + "'" + city_1 + "', ";
		result = result + "'" + city_2 + "', ";
		result = result + distance + ", ";
		result = result + time + "";
		
		System.out.println(result);
		return result;
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "city_1 = '"+city_1+"' AND city_2 = '"+city_2+"'";
	}
	
}
