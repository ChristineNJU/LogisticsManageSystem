package businesslogic.PO;

import java.util.Date;


/*========================================================================================
 * 用来保存司机信息的持久化数据格式
 * */

public class DriverInfoPO extends PO {
	
	private String driver_number = null;
	private String driver_name = null;
	private Date driver_birthday = null;
	private String driver_id = null;
	private String driver_mobilephone = null;
	private String driver_sex = null;
	private int attend_time = 0;
	
	public DriverInfoPO(String driver_number, String driver_name, Date driver_birthday, String driver_id,
			String driver_mobilephone, String driver_sex, int attend_time, String DB_URL) {
		super(DB_URL);
		this.driver_number = driver_number;
		this.driver_name = driver_name;
		this.driver_birthday = driver_birthday;
		this.driver_mobilephone = driver_mobilephone;
		this.driver_id = driver_id;
		this.driver_sex = driver_sex;
		this.attend_time = attend_time;
	}
	
	/*=======================================================================================
	 * Public方法
	 * */
	
	/*---------------------------------------------------------------------------------------
	 * 对DriverInfoPO的数据进行读取
	 * */
	
	/*
	 * 获取司机编号
	 * 返回String
	 * */
	public String getDriverNumber() {
		return driver_number;
	}
	/*
	 * 获取司机姓名
	 * 返回String
	 * */
	public String getDriverName() {
		return driver_name;
	}
	/*
	 * 获取司机生日
	 * 返回Date
	 * */
	public Date getDriverBirthday() {
		return driver_birthday;
	}
	/*
	 * 获取司机手机
	 * 返回String
	 * */
	public String getDriverMobilephone() {
		return driver_mobilephone;
	}
	/*
	 * 获取司机身份证号
	 * 返回String
	 * */
	public String getDriverId() {
		return driver_id;
	}
	/*
	 * 获取司机性别
	 * 返回String
	 * */
	public String getDriverSex() {
		return driver_sex;
	}
	/*
	 * 获取司机驾驶证期限
	 * 返回int
	 * */
	public int getAttendTime() {
		return attend_time;
	}
	
	
	/*----------------------------------------------------------------------
	 * 对DriverInfoPO的某些信息进行更新
	 * */
	
	/*
	 * 更新司机编号
	 * */
	public void setDriverNumber(String driver_number) {
		this.driver_number = driver_number;
	}
	/*
	 * 更新司机姓名
	 * */
	public void setDriverName(String driver_name) {
		this.driver_name = driver_name;
	}
	/*
	 * 更新司机生日
	 * */
	public void setDriverBirthday(Date driver_birthday) {
		this.driver_birthday = driver_birthday;
	}
	/*
	 * 更新司机身份证号
	 * */
	public void setDriverId(String driver_id) {
		this.driver_id = driver_id;
	}
	/*
	 * 更新司机性别
	 * */
	public void setDriverSex(String sex) {
		this.driver_sex = sex;
	}
	/*
	 * 更新司机驾驶证期限
	 * */
	public void setAttendTime(int attend_time) {
		this.attend_time = attend_time;
	}
	
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
