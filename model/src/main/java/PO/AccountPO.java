package PO;

import VO.AccountVO;
import businesslogic.URLHelper.URLHelper;

// TODO: Auto-generated Javadoc
/**
 * 银行账户的持久化对象.
 *
 * @author 尹子越
 * @version 1.0.0
 */
public class AccountPO extends PO {
	
	/** The account_id. */
	// ----- member variables ---------------------------------------
	private int account_id = 0;
	
	/** The account_name. */
	private String account_name = "";
	
	/** The amount. */
	private double amount = 0;
	
	/**
	 * 直接创建银行账户持久化对象.
	 *
	 * @param account_id the account_id
	 * @param account_name the account_name
	 * @param amount the amount
	 * @param DB_URL the db url
	 */
	public AccountPO(int account_id, String account_name, double amount, String DB_URL) {
		super(DB_URL);
		// TODO Auto-generated constructor stub
		this.account_id = account_id;
		this.account_name = account_name;
		this.amount = amount;
	}
	
	/**
	 * 通过AccountVO创建银行账户持久化对象.
	 *
	 * @param avo the avo
	 * @param ID the id
	 */
	public AccountPO(AccountVO avo,int ID){
		super(URLHelper.getAccountURL());
		this.account_id=ID;
		this.account_name=avo.getName();
		this.amount=avo.getMoney();
	}
	
	/*====================================================================================
	 * Public方法
	 * */
	
	/*------------------------------------------------------------------------------------
	 * 对AccountPO的数据进行读取
	 * */
	
	/**
	 * 获取账户编号.
	 *
	 * @return 账户编号
	 */
	public int getAccountID() {
		return account_id;
	}
	
	/**
	 * 获取账户名称.
	 *
	 * @return 账户名称
	 */
	public String getAccountName() {
		return account_name;
	}
	
	/**
	 * 获取账户金额.
	 *
	 * @return 账户金额
	 */
	public double getAmount() {
		return amount;
	}
	
	
	/*---------------------------------------------------------------
	 * 对AccountPO的某些信息进行更新
	 * */
	
	/**
	 * 更新账户名称.
	 *
	 * @param account_name 新账户名称
	 */
	public void setAccountName(String account_name) {
		this.account_name = account_name;
	}
	
	/**
	 * 更新账户金额.
	 *
	 * @param amount 新账户金额
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	} 
	

	/* (non-Javadoc)
	 * @see PO.PO#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result = "";
		
		result = result + account_id + ", ";
		result = result + "'" + account_name +"', ";
		result = result + amount + "";
		
		System.out.println(result);
		
		return result;
	}

	/* (non-Javadoc)
	 * @see PO.PO#getPrimaryKey()
	 */
	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "account_id = "+account_id+"";
	}

}
