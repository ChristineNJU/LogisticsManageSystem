package businesslogic.PO;

import java.util.Date;

public class LogPO extends PO {

	private Date time = null;
	private String operation = null;
	private String operator = null;
	
	public LogPO(Date time, String operation, String operator, String DB_URL) {
		super(DB_URL);
		// TODO Auto-generated constructor stub
		this.time = time;
		this.operation = operation;
		this.operator = operator;
	}
	
	/*===============================================================
	 * Public方法
	 * */
	
	/*---------------------------------------------------------------
	 * 对LogPO的数据进行读取
	 * */
	/*
	 * 获取操作时间
	 * 返回Date
	 * */
	public Date getTime() {
		return time;
	}
	/*
	 * 获取操作
	 * 返回String
	 * */
	public String getOperation() {
		return operation;
	}
	/*
	 * 获取操作员
	 * 返回String
	 * */
	public String getOperator() {
		return operator;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
