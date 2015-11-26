package PO;

import businesslogic.URLHelper.URLHelper;
import VO.CarInfoVO;

/*==================================================================
 * 用来保存车辆信息的持久化数据格式
 * */
public class CarInfoPO extends PO {

	private String car_number = null;
	private String car_license = null;
	private int attend_time = 0;
	
	public CarInfoPO(String car_number, String car_license, int attend_time, String DB_URL) {
		super(DB_URL);
		this.car_number = car_number;
		this.car_license = car_license;
		this.attend_time = attend_time;
	}
	
	public CarInfoPO(CarInfoVO car) {
		super(URLHelper.getCarInfoURL(car.getCarNumber().substring(0, car.getCarNumber().length()-3)));
		// TODO Auto-generated constructor stub
		this.car_number = car.getCarNumber();
		this.car_license = car.getCarLicense();
		this.attend_time = car.getUseTime();
	}
	/*===============================================================
	 * Public方法
	 * */
	
	/*---------------------------------------------------------------
	 * 对CarInfoPO的数据进行读取
	 * */
	
	

	/*
	 * 获取车辆代号
	 * 返回String
	 * */
	public String getCarNumber() {
		return car_number;
	}
	/*
	 * 获取车牌号
	 * 返回String
	 * */
	public String getCarLicense() {
		return car_license;
	}
	/*
	 * 获取服役时间
	 * 返回int
	 * */
	public int getAttendTime() {
		return attend_time;
	}
	
	/*---------------------------------------------------------------
	 * 对CarInfoPO的数据进行更新
	 * */
	
	/*
	 * 更新车辆代号
	 * */
	public void setCarNumber(String car_number) {
		this.car_number = car_number;
	}
	/*
	 * 更新车牌号
	 * */
	public void setCarLicense(String car_license) {
		this.car_license = car_license;
	}
	/*
	 * 更新服役时间
	 * */
	public void setAttendTime(int n) {
		this.attend_time = n;
	}
	
	
	/*------------------------------------------------------------------
	 * 对数据的格式化
	 * */
	
	/*
	 * 形成数据库格式
	 * 返回String
	 * */
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "car_number = '"+car_number+"'";
	}

}
