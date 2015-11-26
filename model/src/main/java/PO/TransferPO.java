package PO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.URLHelper.URLHelper;
import VO.TransferVO;

/*======================================================================
 * 用来保存中转单的持久化数据格式
 * */

public class TransferPO extends PO {
	
	private Date date = null;
	private String transfer_number = null;
	private String transport_id = null;
	private String starting = null;
	private String destination = null;
	private String container_number = null;
	private String guard_name = null;
	private ArrayList<String> bar_code_list = new ArrayList<String>();
	private double amount = 0;
	private boolean isApproved = false;
	
	public TransferPO(Date date, String transfer_number, String transport_id, String starting, String destination,
			String container_number, String guard_name, ArrayList<String> bar_code_list, double amount, 
			String DB_URL) {
		super(DB_URL);
		// TODO Auto-generated constructor stub
		this.date = date;
		this.transfer_number = transfer_number;
		this.transport_id = transport_id;
		this.starting = starting;
		this.destination = destination;
		this.container_number = container_number;
		this.guard_name = guard_name;
		this.bar_code_list = bar_code_list;
		this.amount = amount;	
	}
	public TransferPO(TransferVO transfer, String institutionId) {
		// TODO Auto-generated constructor stub
		super(URLHelper.getGatheringURL(institutionId));
		this.date=transfer.getDate();
		this.transfer_number=transfer.getList();
		this.transport_id=transfer.getTransferId();
		this.starting=transfer.getDeparture();
		this.destination=transfer.getDestination();
		this.container_number=transfer.getContainerNumber();
		this.guard_name=transfer.getGuardName();
		this.bar_code_list=transfer.getItemId();
		this.amount=transfer.getTransferCharge();
	}

	/*====================================================================================
	 * Public方法
	 * */
	
	/*------------------------------------------------------------------------------------
	 * 对TransferPO的数据进行读取
	 * */
	
	
	/*
	 * 获取装车日期
	 * 返回Date
	 * */
	public Date getDate() {
		return date;
	}
	/*
	 * 获取获取中转单
	 * 返回String
	 * */
	public String getTranferNumber() {
		return transfer_number;
	}
	/*
	 * 获取交通工具班次号
	 * 返回String
	 * */
	public String getTransportID() {
		return transport_id;
	}
	/*
	 * 获取出发地
	 * 返回String
	 * */
	public String getStarting() {
		return starting;
	}
	/*
	 * 获取到达地
	 * 返回String
	 * */
	public String getDestination() {
		return destination;
	}
	/*
	 * 获取货柜号
	 * 返回String
	 * */
	public String getContainerNumber() {
		return container_number;
	}
	/*
	 * 获取监装员
	 * 返回String
	 * */
	public String getGuardName() {
		return guard_name;
	}
	/*
	 * 获取所有订单编号
	 * 返回ArrayList<String>
	 * */
	public ArrayList<String> getBarCodeList() {
		return bar_code_list;
	}
	/*
	 * 获取运费
	 * 返回double
	 * */
	public double getAmount() {
		return amount;
	}
	/*
	 * 获取审批状态
	 * 返回boolean
	 * */
	public boolean isApproved() {
		return isApproved;
	}
	
	/*---------------------------------------------------------------
	 * 对TransferPO的某些信息进行更新
	 * */
	
	/*
	 * 更新审批状态
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
		result = result + "'" + transport_id + "', ";
		result = result + "'" + starting + "', ";
		result = result + "'" + destination + "', ";
		result = result + "'" + container_number + "', ";
		result = result + "'" + guard_name + "', ";
		
		result = result + "'";
		for(int i=0;i<bar_code_list.size();i++){
			if(i!=bar_code_list.size()-1){
				result = result + bar_code_list.get(i) + ",";				
			}else{
				result = result + bar_code_list.get(i) + "',";
			}
		}
		
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
