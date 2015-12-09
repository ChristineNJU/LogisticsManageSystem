package VO;

import java.util.Date;

import PO.DriverInfoPO;

// TODO: Auto-generated Javadoc
/**
 * The Class DriverInfoVO.
 */
public class DriverInfoVO extends VO {

	/** The number. */
	private String number = null;
	
	/** The name. */
	private String name = null;
	
	/** The birthday. */
	private Date birthday = null;
	
	/** The id. */
	private String id = null;
	
	/** The mobilephone. */
	private String mobilephone = null;
	
	/** The sex. */
	private String sex = null;
	
	/** The attend time. */
	private int attendTime = 0;
	
	/**
	 * Instantiates a new driver info vo.
	 *
	 * @param number the number
	 * @param name the name
	 * @param birthday the birthday
	 * @param id the id
	 * @param mobilephone the mobilephone
	 * @param sex the sex
	 * @param attendTime the attend time
	 */
	public DriverInfoVO(String number,String name,Date birthday,String id,String mobilephone,String sex,int attendTime){
		this.number = number;
		this.name = name;
		this.birthday = birthday;
		this.id = id;
		this.mobilephone = mobilephone;
		this.sex = sex;
		this.attendTime = attendTime;
	}
	
	/**
	 * Instantiates a new driver info vo.
	 *
	 * @param po the po
	 */
	public DriverInfoVO(DriverInfoPO po) {
		this.number = po.getDriverNumber();
		this.name = po.getDriverName();
		this.birthday = po.getDriverBirthday();
		this.id = po.getDriverId();
		this.mobilephone = po.getDriverMobilephone();
		this.sex = po.getDriverSex();
		this.attendTime = po.getAttendTime();
	}
	
	/**
	 * Gets the number.
	 *
	 * @return the number
	 */
	public String getNumber(){
		return this.number;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Gets the birthday.
	 *
	 * @return the birthday
	 */
	public Date getBirthday(){
		return this.birthday;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId(){
		return this.id;
	}
	
	/**
	 * Gets the mobilephone.
	 *
	 * @return the mobilephone
	 */
	public String getMobilephone(){
		return this.mobilephone;
	}
	
	/**
	 * Gets the sex.
	 *
	 * @return the sex
	 */
	public String getSex(){
		return this.sex;
	}
	
	/**
	 * Gets the attend time.
	 *
	 * @return the attend time
	 */
	public int getAttendTime(){
		return this.attendTime;
	}
	
	/**
	 * Sets the number.
	 *
	 * @param number the new number
	 */
	public void setNumber(String number){
		this.number = number;
	}
	
	/**
	 * Sets the birthday.
	 *
	 * @param birthday the new birthday
	 */
	public void setBirthday(Date birthday){
		this.birthday = birthday;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id){
		this.id = id;
	}
	
	/**
	 * Sets the mobilephone.
	 *
	 * @param mobilephone the new mobilephone
	 */
	public void setMobilephone(String mobilephone){
		this.mobilephone = mobilephone;
	}
	
	/**
	 * Sets the sex.
	 *
	 * @param sex the new sex
	 */
	public void setSex(String sex){
		this.sex = sex;
	}
	
	/**
	 * Sets the attend time.
	 *
	 * @param attendTime the new attend time
	 */
	public void setAttendTime(int attendTime){
		this.attendTime = attendTime;
	}

}
