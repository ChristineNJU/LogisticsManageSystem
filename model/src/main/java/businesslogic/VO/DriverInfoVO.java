package businesslogic.VO;

import java.util.Date;

import businesslogic.PO.DriverInfoPO;

public class DriverInfoVO extends VO {

	private String number = null;
	private String name = null;
	private Date birthday = null;
	private String id = null;
	private String mobilephone = null;
	private String sex = null;
	private int attendTime = 0;
	
	public DriverInfoVO(String number,String name,Date birthday,String id,String mobilephone,String sex,int attendTime){
		this.number = number;
		this.name = name;
		this.birthday = birthday;
		this.id = id;
		this.mobilephone = mobilephone;
		this.sex = sex;
		this.attendTime = attendTime;
	}
	public DriverInfoVO(DriverInfoPO po) {
		this.number = po.getDriverNumber();
		this.name = po.getDriverName();
		this.birthday = po.getDriverBirthday();
		this.id = po.getDriverId();
		this.mobilephone = po.getDriverMobilephone();
		this.sex = po.getDriverSex();
		this.attendTime = po.getAttendTime();
	}
	
	public String getNumber(){
		return this.number;
	}
	public String getName(){
		return this.name;
	}
	public Date getBirthday(){
		return this.birthday;
	}
	public String getId(){
		return this.id;
	}
	public String getMobilephone(){
		return this.mobilephone;
	}
	public String getSex(){
		return this.sex;
	}
	public int getAttendTime(){
		return this.attendTime;
	}
	
	public void setNumber(String number){
		this.number = number;
	}
	public void setBirthday(Date birthday){
		this.birthday = birthday;
	}
	public void setId(String id){
		this.id = id;
	}
	public void setMobilephone(String mobilephone){
		this.mobilephone = mobilephone;
	}
	public void setSex(String sex){
		this.sex = sex;
	}
	public void setAttendTime(int attendTime){
		this.attendTime = attendTime;
	}

}
