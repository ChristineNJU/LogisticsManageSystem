package PO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import VO.EntruckingVO;
import businesslogic.URLHelper.URLHelper;


/**
 * 用来保存装车单的持久化数据格式
 * 
 * @author 尹子越
 * @version 1.0.0
 * */
public class EntruckingPO extends PO {
	
	// ----- member variables ---------------------------------------
	private Date date;
	private String transfer_number = "";
	private String destination = "";
	private String car_number = "";
	private String guard_name = "";
	private String supercargo_name = "";
	private ArrayList<String> bar_code_list = new ArrayList<String>();
	private double amount = 0;
	private boolean isApproved = false;
	
	/**
	 * 直接创建装车单的持久化数据对象
	 * */
	public EntruckingPO(Date date, String transfer_number, String destination, String car_number,
			String guard_name, String supercargo_name, ArrayList<String> bar_code_list, double amount,
			String DB_URL) {
		super(DB_URL);
		// TODO Auto-generated constructor stub
		this.date = date;
		this.transfer_number = transfer_number;
		this.destination = destination;
		this.car_number = car_number;
		this.guard_name = guard_name;
		this.supercargo_name = supercargo_name;
		this.bar_code_list = bar_code_list;
		this.amount = amount;
	}
	
	/**
	 * 通过EntruckingVO创建装车单的持久化数据对象
	 * */
	public EntruckingPO(EntruckingVO entrucking, String institutionId) {
		// TODO Auto-generated constructor stub
		super(URLHelper.getEntruckingURL(institutionId));
		this.date = entrucking.getDate();
		this.transfer_number = entrucking.getInstitutioNumber();
		this.destination = entrucking.getDestination();
		this.car_number = entrucking.getCarNumber();
		this.guard_name = entrucking.getguardNumber();
		this.supercargo_name = entrucking.getSupercargoName();
		this.bar_code_list = entrucking.getBarCodeList();
		this.amount = entrucking.getAmount();
	}
	/*====================================================================================
	 * Public方法
	 * */
	
	/*------------------------------------------------------------------------------------
	 * 对EntruckingPO的数据进行读取
	 * */
	
	

	/**
	 * 获取装车日期
	 * 
	 * 
	 * @return 装车日期Date
	 * */
	public Date getDate() {
		return date;
	}
	
	/**
	 * 获取中转单编号
	 * 
	 * @return 中转单编号String
	 * */
	public String getTransferNumber() {
		return transfer_number;
	}
	
	/**
	 * 获取到达地
	 * 
	 * @return 到达地String
	 * */
	public String getDestination() {
		return destination;
	}
	
	/**
	 * 获取车辆代号
	 * 
	 * @return 车辆代号String
	 * */
	public String getCarNumber() {
		return car_number;
	}
	
	/**
	 * 获取监装员
	 * 
	 * @return 监装员String
	 * */
	public String getGuardName() {
		return guard_name;
	}
	
	/**
	 * 获取押运员
	 * 
	 * @return 押运员String
	 * */
	public String getSupercargoName() {
		return supercargo_name;
	}
	
	/**
	 * 获取所有订单编号
	 * 
	 * @return 所有订单编号ArrayList<String>
	 * */
	public ArrayList<String> getBarCodeList() {
		return bar_code_list;
	}
	
	/**
	 * 获取运费
	 * 
	 * @return 运费
	 * */
	public double getAmount() {
		return amount;
	}
	
	/**
	 * 获取审批状态
	 * 
	 * @return 审批状态
	 * */
	public boolean isApproved() {
		return isApproved;
	}
	
	
	/*---------------------------------------------------------------
	 * 对EntruckingPO的某些信息进行更新
	 * */
	
	/**
	 * 更新审批状态
	 * 
	 * @param isApproved 新审批状态
	 * */
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		String result = "";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		result = result + "'" + sdf.format(date) + "', ";
		
		result = result + "'" + transfer_number + "', ";
		result = result + "'" + destination + "', ";
		result = result + "'" + car_number + "', ";
		result = result + "'" + guard_name + "', ";
		result = result + "'" + supercargo_name + "', ";
		
		result = result + "'";
		for(int i=0;i<bar_code_list.size();i++){
			if(i!=bar_code_list.size()-1){
				result = result + bar_code_list.get(i) + ",";				
			}else{
				result = result + bar_code_list.get(i);
			}
		}
		result = result + "', ";
		
		result = result + amount + ", ";
		result = result + "'" + isApproved + "'";
		
		System.out.println(result);
		return result;
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "transfer_number = '"+transfer_number+"'";
	}
	
}
