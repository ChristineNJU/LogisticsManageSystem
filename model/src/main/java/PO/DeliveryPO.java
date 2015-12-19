package PO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.URLHelper.URLHelper;
import VO.DeliveryVO;

/**
 * 用来保存派送信息的持久化数据格式
 * 
 * @author 尹子越
 * @version 1.0.0
 * */

public class DeliveryPO extends PO {

	// ----- member variables ---------------------------------------
	private Date date;
	private ArrayList<String> bar_code_list = new ArrayList<String>();	
	private String courier = "";
	private boolean isApproved = false;
	
	/**
	 * 直接创建派送信息的持久化数据格式
	 * */
	public DeliveryPO(Date date, ArrayList<String> bar_code_list, String courier, String DB_URL) {
		super(DB_URL);
		this.date = date;
		this.bar_code_list = bar_code_list;
		this.courier = courier;
	}
	
	/**
	 * 通过DeliveryVO创建派送信息的持久化数据格式
	 * */
	public DeliveryPO(DeliveryVO delivery,String institution_id) {
		// TODO Auto-generated constructor stub
		super(URLHelper.getDeliveryURL(institution_id));
		this.date =delivery.getArrivalDate() ;
		this.bar_code_list = delivery.getBarCodeList();
		this.courier = delivery.getPeople();
	}
	/*=====================================================================================
	 * Public方法
	 * */
	
	/*-------------------------------------------------------------------------------------
	 * 对DeliveryPO的数据进行读取
	 * */
	
	

	/**
	 * 获取到达日期
	 * 
	 * @return 到达日期Date
	 * */
	public Date getDate() {
		return date;
	}
	
	/**
	 * 获取托运订单条形码号
	 * 
	 * @return 托运订单条形码号ArrayList<String>
	 * */
	public ArrayList<String> getBarCodeList() {
		return bar_code_list;
	}
	
	/**
	 * 获取派件员
	 * 
	 * @return 派件员String
	 * */
	public String getCourier() {
		return courier;
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
	 * 对DeliveryPO的某些信息进行更新
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
		
		result = result + "'";
		for(int i=0;i<bar_code_list.size();i++){
			if(i!=bar_code_list.size()-1){
				result = result + bar_code_list.get(i) + ",";				
			}else{
				result = result + bar_code_list.get(i);
			}
		}
		result = result + "', ";
		
		result = result + "'" + courier + "', ";
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
