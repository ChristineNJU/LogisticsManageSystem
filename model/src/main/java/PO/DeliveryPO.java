package PO;

import java.util.ArrayList;
import java.util.Date;

/*========================================================================================
 * 用来保存派送信息的持久化数据格式
 * */

public class DeliveryPO extends PO {

	private Date date = null;
	private ArrayList<String> bar_code_list = new ArrayList<String>();	
	private String courier = null;
	private boolean isApproved = false;
	
	public DeliveryPO(Date date, ArrayList<String> bar_code_list, String courier, String DB_URL) {
		super(DB_URL);
		this.date = date;
		this.bar_code_list = bar_code_list;
		this.courier = courier;
	}
	
	/*=====================================================================================
	 * Public方法
	 * */
	
	/*-------------------------------------------------------------------------------------
	 * 对DeliveryPO的数据进行读取
	 * */
	
	/*
	 * 获取到达日期
	 * 返回Date
	 * */
	public Date getDate() {
		return date;
	}
	/*
	 * 获取托运订单条形码号
	 * 返回ArrayList<String>
	 * */
	public ArrayList<String> getBarCodeList() {
		return bar_code_list;
	}
	/*
	 * 获取派件员
	 * 返回String
	 * */
	public String getCourier() {
		return courier;
	}
	/*
	 * 获取审批状态
	 * 返回boolean
	 * */
	public boolean isApproved() {
		return isApproved;
	}
	
	
	/*--------------------------------------------------------------
	 * 对DeliveryPO的某些信息进行更新
	 * */
	
	/*
	 * 更新审批状态
	 * */
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
	/*------------------------------------------------------------------
	 * 对数据的格式化
	 * */
	
	/*
	 * 形成数据库格式
	 * 返回String
	 * */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
