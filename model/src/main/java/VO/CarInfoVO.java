package VO;

import PO.CarInfoPO;

// TODO: Auto-generated Javadoc
/**
 * The Class CarInfoVO.
 */
/*==================================================================
 * 用来在界面层显示的车辆信息
 * */
public class CarInfoVO extends VO {

	/** The car number. */
	private String carNumber = null;
	
	/** The car license. */
	private String carLicense = null;
	
	/** The attend time. */
	private int attendTime = 0;
	
	/** The use time. */
	private int useTime = 0;

	/**
	 * Instantiates a new car info vo.
	 *
	 * @param car_number the car_number
	 * @param car_license the car_license
	 * @param attend_time the attend_time
	 */
	public CarInfoVO(String car_number,String car_license,int attend_time){
		this.carNumber = car_number;
		this.carLicense = car_license;
		this.attendTime = attend_time;
		useTime = 2015 - attend_time;
	}
	
	/**
	 * Instantiates a new car info vo.
	 *
	 * @param po the po
	 */
	public CarInfoVO(CarInfoPO po) {
		this.carNumber = po.getCarNumber();
		this.carLicense = po.getCarLicense();
		this.attendTime = po.getAttendTime();
		useTime = 2015 - attendTime;			//??????????
	}
	
	/**
	 * Gets the car number.
	 *
	 * @return the car number
	 */
	public String getCarNumber(){
		return carNumber;
	}
	
	/**
	 * Gets the car license.
	 *
	 * @return the car license
	 */
	public String getCarLicense(){
		return carLicense;
	}
	
	/**
	 * Gets the use time.
	 *
	 * @return the use time
	 */
	public int getUseTime(){
		return useTime;
	}
	
	/**
	 * Sets the car number.
	 *
	 * @param carNumber the new car number
	 */
	public void setCarNumber(String carNumber){
		this.carNumber = carNumber;
	}
	
	/**
	 * Sets the car license.
	 *
	 * @param carLicense the new car license
	 */
	public void setCarLicense(String carLicense){
		this.carLicense = carLicense;
	}
	
	/**
	 * Sets the attend time.
	 *
	 * @param time the new attend time
	 */
	public void setAttendTime(int time){
		this.attendTime = time;
	}
	
}
