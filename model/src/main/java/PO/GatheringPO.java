package PO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.URLHelper.URLHelper;
import VO.GatheringVO;

/**
 * 用来保存收款信息的持久化数据格式
 * 
 * @author 尹子越
 * @version 1.0.0
 * */
public class GatheringPO extends PO {
	
	// ----- member variables ---------------------------------------
	private Date date;
	private double amount = 0;
	private String courier = "";
	private ArrayList<String> bar_code_list = new ArrayList<String>();
	private boolean isApproved = false;
	
	/**
	 * 直接创建收款信息的持久化数据对象
	 * */
	public GatheringPO(Date date, double amount, String courier, ArrayList<String> bar_code_list,
			String DB_URL) {
		super(DB_URL);
		this.date = date;
		this.amount = amount;
		this.courier = courier;
		this.bar_code_list = bar_code_list;
	}
	
	/**
	 * 通过GatheringVO创建收款信息的持久化数据对象
	 * */
	public GatheringPO(GatheringVO gathering, String institutionId) {
		// TODO Auto-generated constructor stub
		super(URLHelper.getGatheringURL(institutionId));
		this.date=gathering.getDate();
		this.amount=gathering.getMoney();
		this.courier=gathering.getName();
		this.bar_code_list=gathering.id();
	}
	/*==================================================================
	 * Public方法
	 * */
	
	/*------------------------------------------------------------------
	 * 对GatheringPO的数据进行读取
	 * */
	
	

	/**
	 * 获取收款时间
	 * 
	 * @return 收款时间Date
	 * */
	public Date getDate() {
		return date;
	}
	
	/**
	 * 获取收款金额
	 * 
	 * @return 收款金额
	 * */
	public double getAmount() {
		return amount;
	}
	
	/**
	 * 获取收件快递员
	 * 
	 * @return 收件快递员String
	 * */
	public String getCourier() {
		return courier;
	}
	
	/**
	 * 获取所有订单条形码
	 * 
	 * @return 所有订单条形码ArrayList<String>
	 * */
	public ArrayList<String> getBarCodeList() {
		return bar_code_list;
	}
	
	/**
	 * 获取审批状态
	 * 
	 * @return 审批状态
	 * */
	public boolean isApproved() {
		return isApproved;
	}
	
	/*--------------------------------------------------------------
	 * 对GatheringPO的某些信息进行更新
	 * */
	
	/**
	 * 更新审批状态
	 * 
	 * @param isApproved 新审批状态
	 * */
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
	
	
	/*------------------------------------------------------------------
	 * 对数据的格式化
	 * */
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		String result = "";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		result = result + "'" + sdf.format(date) + "', ";
		
		result = result + amount + ", ";
		result = result + "'" + courier + "', ";
		
		result = result + "'";
		for(int i=0;i<bar_code_list.size();i++){
			if(i!=bar_code_list.size()-1){
				result = result + bar_code_list.get(i) + ",";				
			}else{
				result = result + bar_code_list.get(i);
			}
		}
		result = result + "', ";
		
		result = result + "'" + isApproved + "'";
		
		System.out.println(result);
		return result;
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return "date = '"+sdf.format(date)+"' AND courier = '"+courier+"'";
	}
	
}
