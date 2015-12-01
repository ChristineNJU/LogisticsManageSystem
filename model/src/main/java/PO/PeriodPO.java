package PO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 用来保存期初建账的持久化数据格式
 * 
 * @author HermC
 * @version 1.0.0
 * */
public class PeriodPO extends PO {

	// ----- member variables ---------------------------------------
	private Date date;
	private int institution_size = 0;
	private int staff_size = 0;
	private int car_size = 0;
	private int storage_size = 0;
	private ArrayList<AccountPO> account = new ArrayList<AccountPO>();
	
	/**
	 * 直接创建期初建账的持久化数据对象
	 * */
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
	/**
	 * 获取时间
	 * 
	 * @return 时间Date
	 * */
	public Date getDate() {
		return date;
	}
	
	/**
	 * 获取机构数量
	 * 
	 * @return 机构数量
	 * */
	public int getInstitutionSize() {
		return institution_size;
	}
	
	/**
	 * 获取人员数量
	 * 
	 * @return 人员数量
	 * */
	public int getStaffSize() {
		return staff_size;
	}
	
	/**
	 * 获取车辆数量
	 * 
	 * @return 车辆数量
	 * */
	public int getCarSize() {
		return car_size;
	}
	
	/**
	 * 获取库存数量
	 * 
	 * @return 库存数量
	 * */
	public int getStorageSize() {
		return storage_size;
	}
	
	/**
	 * 获取银行账户
	 * 
	 * @return 银行账户ArrayList<AccountPO>
	 * */
	public ArrayList<AccountPO> getAccount() {
		return account;
	}
	
	/*---------------------------------------------------------------
	 * 对PeriodPO的数据进行更新
	 * */
	/**
	 * 更新机构信息
	 * 
	 * @param institution_size 新机构信息
	 * */
	public void setInstitutionSize(int institution_size) {
		this.institution_size = institution_size;
	}
	
	/**
	 * 更新人员信息
	 * 
	 * @param staff_size 新人员信息
	 * */
	public void setStaffSize(int staff_size) {
		this.staff_size = staff_size;
	}
	
	/**
	 * 更新库存信息
	 * 
	 * @param storage_size 新库存信息
	 * */
	public void setStorageSize(int storage_size) {
		this.storage_size = storage_size;
	}
	
	/**
	 * 更新银行账户信息
	 * 
	 * @param account 新银行账户信息
	 * */
	public void setAccount(ArrayList<AccountPO> account) {
		this.account = account;
	}
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		String result = "";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		result = result + "'" + sdf.format(date) + "', ";
		result = result + institution_size + ", ";
		result = result + staff_size + ", ";
		result = result + car_size + ", ";
		result = result + storage_size + ", ";
		
		result = result + "'";
		for(int i=0;i<account.size();i++){
			if(i!=account.size()-1){
				result = result + account.get(i).getAccountID() + ",";				
			}else{
				result = result + account.get(i).getAccountID();
			}
		}
		result = result + "'";
		
		System.out.println(result);
		return result;
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return "date = '"+sdf.format(date)+"'";
	}

}
