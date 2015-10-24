package businesslogic.PO;

import java.util.ArrayList;


/*========================================================================================
 * 用来保存装车单的持久化数据格式
 * */

public class EntruckingPO extends PO {
	
	private String date = null;
	private String transfer_number = null;
	private String destination = null;
	private String car_number = null;
	private String guard_name = null;
	private String supercargo_name = null;
	private ArrayList<String> bar_code_list = new ArrayList<String>();
	private double amount = 0;
	private boolean isApproved = false;
	
	public EntruckingPO(String data, String transfer_number, String destination, String car_number,
			String guard_name, String supercargo_name, ArrayList<String> bar_code_list, double amount,
			String DB_URL) {
		super(DB_URL);
		// TODO Auto-generated constructor stub
		this.date = data;
		this.transfer_number = transfer_number;
		this.destination = destination;
		this.car_number = car_number;
		this.guard_name = guard_name;
		this.supercargo_name = supercargo_name;
		this.bar_code_list = bar_code_list;
		this.amount = amount;
		this.isApproved = isApproved;
	}
	
	/*====================================================================================
	 * Public方法
	 * */
	
	/*------------------------------------------------------------------------------------
	 * 对EntruckingPO的数据进行读取
	 * */
	
	/*
	 * 获取装车日期
	 * 返回String
	 * */
	public String getDate() {
		return date;
	}
	/*
	 * 获取中转单编号
	 * 返回String
	 * */
	public String getTransferNumber() {
		return transfer_number;
	}
	/*
	 * 获取到达地
	 * 返回String
	 * */
	public String getDestination() {
		return destination;
	}
	/*
	 * 获取车辆代号
	 * 返回String
	 * */
	public String getCarNumber() {
		return car_number;
	}
	/*
	 * 获取监装员
	 * 返回String
	 * */
	public String getGuardName() {
		return guard_name;
	}
	/*
	 * 获取押运员
	 * 返回String
	 * */
	public String get
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
