package PO;

import java.text.SimpleDateFormat;
import java.util.Date;

import State.LogisticsState;
import State.StateSwitch;
import VO.ArrivalVO;
import businesslogic.URLHelper.URLHelper;

/**
 * 用来保存到达单的持久化数据格式
 * 
 * @author 尹子越
 * @version 1.0.0
 * */
public class ArrivalPO extends PO {

	// ----- member variables ---------------------------------------
	private String bar_code = "";
	private Date arrival_date;
	private String transfer_number = "";
	private String starting = "";
	private LogisticsState state;
	private boolean isApproved = false;
	
	/**
	 * 直接创建到达单的持久化数据对象
	 * */
	public ArrivalPO(String bar_code, Date arrival_date, String transfer_number, String starting,
			LogisticsState state, String DB_URL) {
		super(DB_URL);
		this.bar_code = bar_code;
		this.arrival_date = arrival_date;
		this.transfer_number = transfer_number;
		this.starting = starting;
		this.state = state;
	}
	
	/**
	 * 通过ArrivalVO创建到达单的持久化数据格式
	 * */
	public ArrivalPO(ArrivalVO arrival,String institutionID){
		super(URLHelper.getArrivalURL(institutionID));
		this.arrival_date=arrival.getDate();
		this.bar_code=arrival.getBarCode();
		this.transfer_number=arrival.getListId();
		this.state=arrival.getLogisticsState();
		this.starting=arrival.getDeparture();
		
	}
	
	/*====================================================================================
	 * Public方法
	 * */
	
	/*------------------------------------------------------------------------------------
	 * 对DriverInfoPO的数据进行读取
	 * */
	
	/**
	 * 获取订单信息
	 * 
	 * @return 订单信息String
	 * */
	public String getBarCode() {
		return bar_code;
	}
	/**
	 * 获取到达日期
	 * 
	 * @return 到达日期Date
	 * */
	public Date getArrivalDate() {
		return arrival_date;
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
	 * 获取出发地
	 * 
	 * @return 出发地String
	 * */
	public String getStarting() {
		return starting;
	}
	/**
	 * 获取货物状态
	 * 
	 * @return 货物状态LogisticsState
	 * */
	public LogisticsState getState() {
		return state;
	} 
	/**
	 * 获取审批状态
	 * 
	 * @return 审批状态boolean
	 * */
	public boolean isApproved() {
		return isApproved;
	}
	
	
	/*---------------------------------------------------------------
	 * 对ArrivalPO的某些信息进行更新
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
		
		result = result + "'" + bar_code + "', ";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		result = result + "'" + sdf.format(arrival_date) + "', ";
		
		result = result + "'" + transfer_number + "', ";
		result = result + "'" + starting + "', ";
		result = result + "'" + StateSwitch.switchToStr(state) + "', ";
		result = result + "'" + isApproved + "'";
		
		System.out.println(result);
		return result;
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "bar_code = '"+bar_code+"'";
	}
	
}
