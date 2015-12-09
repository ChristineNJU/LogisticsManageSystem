package VO;

import java.util.Date;

import PO.LogPO;

// TODO: Auto-generated Javadoc
/**
 * The Class LogVO.
 */
public class LogVO extends VO{
	
	/** The time. */
	private Date time = null;
	
	/** The operation. */
	private String operation = null;
	
	/** The operator. */
	private String operator = null;
	
	/**
	 * Instantiates a new log vo.
	 *
	 * @param time the time
	 * @param operation the operation
	 * @param operator the operator
	 */
	public LogVO(Date time, String operation, String operator){
		this.time = time;
		this.operation = operation;
		this.operator = operator;
	}
	
	/**
	 * Instantiates a new log vo.
	 *
	 * @param po the po
	 */
	public LogVO(LogPO po) {
		this.time = po.getTime();
		this.operation = po.getOperation();
		this.operator = po.getOperator();
	}
	
	/**
	 * Gets the time.
	 *
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}
	
	/**
	 * Gets the operation.
	 *
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
	}
	
	/**
	 * Gets the operator.
	 *
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}
	
	/**
	 * Sets the time.
	 *
	 * @param time the new time
	 */
	public void setTime(Date time){
		this.time=time;
	}
	
	/**
	 * Sets the operation.
	 *
	 * @param operation the new operation
	 */
	public void setOperation(String operation){
		this.operation=operation;
	}
	
	/**
	 * Sets the operator.
	 *
	 * @param operator the new operator
	 */
	public void setOperator(String operator){
		this.operator=operator;
	}

}
