package businesslogic.PO;

public class AccountPO extends PO {

	private int account_id = 0;
	private String account_name = null;
	private double amount = 0;
	
	public AccountPO(int account_id, String account_name, double amount, String DB_URL) {
		super(DB_URL);
		// TODO Auto-generated constructor stub
		this.account_id = account_id;
		this.account_name = account_name;
		this.amount = amount;
	}
	
	/*====================================================================================
	 * Public方法
	 * */
	
	/*------------------------------------------------------------------------------------
	 * 对AccountPO的数据进行读取
	 * */
	
	/*
	 * 获取账户编号
	 * 返回int
	 * */
	public int getAccountID() {
		return account_id;
	}
	/*
	 * 获取账户名称
	 * 返回String
	 * */
	public String getAccountName() {
		return account_name;
	}
	/*
	 * 获取账户金额
	 * 返回double
	 * */
	public double getAmount() {
		return amount;
	}
	
	
	/*---------------------------------------------------------------
	 * 对AccountPO的某些信息进行更新
	 * */
	
	/*
	 * 更新账户名称
	 * */
	public void setAccountName(String account_name) {
		this.account_name = account_name;
	}
	/*
	 * 更新账户金额
	 * */
	public void setAmount(double amount) {
		this.amount = amount;
	} 
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
