package businesslogic.VO;

/*==================================================================
 * 用来在界面层显示的车辆信息
 * */
public class CarInfoVO extends VO {

	private String carNumber = null;
	private String carLicense = null;
	private int attendTime = 0;
	private int useTime = 0;

	public CarInfoVO(String car_number,String car_license,int attend_time){
		this.carNumber = car_number;
		this.carLicense = car_license;
		this.attendTime = attend_time;
		useTime = 2015 - attend_time;
	}
	
	public String getCarNumber(){
		return carNumber;
	}
	
	public String getCarLicense(){
		return carLicense;
	}
	
	public int getUseTime(){
		return useTime;
	}
	
	public void setCarNumber(String carNumber){
		this.carNumber = carNumber;
	}
	
	public void setCarLicense(String carLicense){
		this.carLicense = carLicense;
	}
	
	public void setAttendTime(int time){
		this.attendTime = time;
	}
	
}
