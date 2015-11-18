package VO;

import java.util.Date;

import PO.LogPO;

public class LogVO extends VO{
	
	private Date time = null;
	private String operation = null;
	private String operator = null;
	
	public LogVO(Date time, String operation, String operator){
		this.time = time;
		this.operation = operation;
		this.operator = operator;
	}
	public LogVO(LogPO po) {
		this.time = po.getTime();
		this.operation = po.getOperation();
		this.operator = po.getOperator();
	}
	
	public Date getTime() {
		return time;
	}
	
	public String getOperation() {
		return operation;
	}
	
	public String getOperator() {
		return operator;
	}
	
	public void setTime(Date time){
		this.time=time;
	}
	
	public void setOperation(String operation){
		this.operation=operation;
	}
	
	public void setOperator(String operator){
		this.operator=operator;
	}

}
