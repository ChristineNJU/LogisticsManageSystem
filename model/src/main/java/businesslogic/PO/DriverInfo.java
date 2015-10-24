package businesslogic.PO;

/*========================================================================================
 * 用来保存司机信息的持久化数据格式
 * */

public class DriverInfo extends PO {
	
	private String driver_number = null;
	private String driver_name = null;
	private String driver_birthday = null;
	private String driver_id = null;
	private String driver_mobilephone = null;
	private String driver_sex = null;
	private int attend_time = 0;
	
	public DriverInfo(String driver_number, String driver_name, String driver_birthday, String driver_id,
			String driver_mobilephone, String driver_sex, int attend_time, String DB_URL) {
		super(DB_URL);
		this.driver_number = driver_number;
		this.driver_name = driver_name;
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
	public void setDriverBirthday(String driver_birthday) {
		this.driver_birthday = driver_birthday;
	}
	/*
	 * 
	 * */
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
