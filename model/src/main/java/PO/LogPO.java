package PO;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogPO extends PO {

	private Date time;
	private String operation = "";
	private String operator = "";
	
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
		
		String result = "";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		result = result + "'" + sdf.format(time) + "', ";
		result = result + "'" + operation + "', ";
		result = result + "'" + operator + "'";
		return result;
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return "time = '"+sdf.format(time)+"'";
	}
	
}
