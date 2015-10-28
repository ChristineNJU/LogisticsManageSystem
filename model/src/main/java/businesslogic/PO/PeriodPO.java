package businesslogic.PO;

import java.util.ArrayList;
import java.util.Date;

public class PeriodPO extends PO {

	private Date date = null;
	private int institution_size = 0;
	private int staff_size = 0;
	private int car_size = 0;
	private int storage_size = 0;
	private ArrayList<AccountPO> account = new ArrayList<AccountPO>();
	
	public PeriodPO(Date date, int institution_size, int staff_size, int car_size, int storage_size, 
			ArrayList<AccountPO> account, String DB_URL) {
		super(DB_URL);
		// TODO Auto-generated constructor stub
		this.date = date;
		this.institution_size = institution_size;
		this.staff_size = staff_size;
		this.car_size = car_size;
		this.storage_size = storage_size;
		this.account = account;
	}
	
	/*===============================================================
	 * Public方法
	 * */
	
	/*---------------------------------------------------------------
	 * 对PeriodPO的数据进行读取
	 * */
	/*
	 * 获取时间
	 * 返回Date
	 * */
	public Date getDate() {
		return date;
	}
	/*
	 * 获取机构数量
	 * 返回int
	 * */
	public int getInstitutionSize() {
		return institution_size;
	}
	/*
	 * 获取人员数量
	 * 返回int
	 * */
	public int getStaffSize() {
		return staff_size;
	}
	/*
	 * 获取车辆数量
	 * 返回int
	 * */
	public int getCarSize() {
		return car_size;
	}
	/*
	 * 获取库存数量
	 * 返回int
	 * */
	public int getStorageSize() {
		return storage_size;
	}
	/*
	 * 获取银行账户
	 * 返回ArrayList<AccountPO>
	 * */
	public ArrayList<AccountPO> getAccount() {
		return account;
	}
	
	/*---------------------------------------------------------------
	 * 对PeriodPO的数据进行更新
	 * */
	/*
	 * 更新机构信息
	 * */
	public void setInstitutionSize(int institution_size) {
		this.institution_size = institution_size;
	}
	/*
	 * 更新人员信息
	 * */
	public void setStaffSize(int staff_size) {
		this.staff_size = staff_size;
	}
	/*
	 * 更新库存信息
	 * */
	public void setStorageSize(int storage_size) {
		this.storage_size = storage_size;
	}
	/*
	 * 更新银行账户信息
	 * */
	public void setAccount(ArrayList<AccountPO> account) {
		this.account = account;
	}
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
