package PO;

import java.text.SimpleDateFormat;
import java.util.Date;

import VO.DriverInfoVO;
import businesslogic.URLHelper.URLHelper;


/**
 * 用来保存司机信息的持久化数据格式
 * 
 * @author HermC
 * @version 1.0.0
 * */
public class DriverInfoPO extends PO {
	
	// ----- member variables ---------------------------------------
	private String driver_number = "";
	private String driver_name = "";
	private Date driver_birthday;
	private String driver_id = "";
	private String driver_mobilephone = "";
	private String driver_sex = "";
	private int attend_time = 0;

	/**
	 * 直接创建司机信息的持久化数据格式
	 * */
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
	
	/**
	 * 通过DriverInfoVO创建司机信息的持久化数据格式
	 * */
	public DriverInfoPO(DriverInfoVO driver){
		super(URLHelper.getDriverInfoURL(driver.getNumber().substring(0, driver.getNumber().length()-3)));
		this.driver_number=driver.getNumber();
		this.driver_name=driver.getName();
		this.driver_birthday=driver.getBirthday();
		this.driver_mobilephone=driver.getMobilephone();
		this.driver_id=driver.getId();
		this.driver_sex=driver.getSex();
		this.attend_time=driver.getAttendTime();	
		
	}
	
	/*=======================================================================================
	 * Public方法
	 * */
	
	/*---------------------------------------------------------------------------------------
	 * 对DriverInfoPO的数据进行读取
	 * */
	
	/**
	 * 获取司机编号
	 * 
	 * @return 司机编号String
	 * */
	public String getDriverNumber() {
		return driver_number;
	}
	
	/**
	 * 获取司机姓名
	 * 
	 * @return 司机姓名String
	 * */
	public String getDriverName() {
		return driver_name;
	}
	
	/**
	 * 获取司机生日
	 * 
	 * @return 司机生日Date
	 * */
	public Date getDriverBirthday() {
		return driver_birthday;
	}
	
	/**
	 * 获取司机手机
	 * 
	 * @return 司机手机String
	 * */
	public String getDriverMobilephone() {
		return driver_mobilephone;
	}
	
	/**
	 * 获取司机身份证号
	 * 
	 * @return 司机身份证号String
	 * */
	public String getDriverId() {
		return driver_id;
	}
	
	/**
	 * 获取司机性别
	 * 
	 * @return 司机性别String
	 * */
	public String getDriverSex() {
		return driver_sex;
	}
	
	/**
	 * 获取司机驾驶证期限
	 * 
	 * @return 司机驾驶证期限
	 * */
	public int getAttendTime() {
		return attend_time;
	}
	
	
	/*----------------------------------------------------------------------
	 * 对DriverInfoPO的某些信息进行更新
	 * */
	
	/**
	 * 更新司机编号
	 * 
	 * @param driver_number 新司机编号
	 * */
	public void setDriverNumber(String driver_number) {
		this.driver_number = driver_number;
	}
	
	/**
	 * 更新司机姓名
	 * 
	 * @param driver_name 新司机姓名
	 * */
	public void setDriverName(String driver_name) {
		this.driver_name = driver_name;
	}
	
	/**
	 * 更新司机生日
	 * 
	 * @param driver_birthday 新司机生日
	 * */
	public void setDriverBirthday(Date driver_birthday) {
		this.driver_birthday = driver_birthday;
	}
	
	/**
	 * 更新司机身份证号
	 * 
	 * @param driver_id 新司机身份证号
	 * */
	public void setDriverId(String driver_id) {
		this.driver_id = driver_id;
	}
	
	/**
	 * 更新司机性别
	 * 
	 * @param sex 新司机性别
	 * */
	public void setDriverSex(String sex) {
		this.driver_sex = sex;
	}
	
	/**
	 * 更新司机驾驶证期限
	 * 
	 * @param attend_time 新司机驾驶证期限
	 * */
	public void setAttendTime(int attend_time) {
		this.attend_time = attend_time;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		String result = "";
		
		result = result + "'" + driver_number + "', ";
		result = result + "'" + driver_name + "', ";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		result = result + "'" + sdf.format(driver_birthday) + "', ";
		
		result = result + "'" + driver_id + "', ";
		result = result + "'" + driver_mobilephone + "', ";
		result = result + "'" + driver_sex + "', ";
		result = result + attend_time + "";
		
		System.out.println(result);
		return result;
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "driver_number = '"+driver_number+"'";
	}
	
}
