package PO;

import java.text.SimpleDateFormat;
import java.util.Date;

import State.StateSwitch;
import State.TransferType;
import VO.RemovalVO;
import businesslogic.URLHelper.URLHelper;
/**
 * 用来保存出库单的持久化数据格式
 * 
 * @author 尹子越
 * @version 1.0.0
 * */
public class RemovalPO extends PO {

	// ----- member variables ---------------------------------------
	private String bar_code = "";
	private Date removal_date;
	private String destination = "";
	private TransferType type;
	private String transfer_number = "";
	private boolean isApproved = false;
	
	/**
	 * 直接创建出库单的持久化数据对象
	 * */
	public RemovalPO(String bar_code, Date removal_date, String destination, TransferType type,
			String transfer_number, String DB_URL) {
		super(DB_URL);
		// TODO Auto-generated constructor stub
		this.bar_code = bar_code;
		this.removal_date = removal_date;
		this.destination = destination;
		this.type = type;
		this.transfer_number = transfer_number;
	}
	
	/**
	 * 通过RemovalVO创建出库单的持久化数据对象
	 * */
	public RemovalPO(RemovalVO removal,String institutionID){
		super(URLHelper.getRemovalURL(institutionID));
		this.bar_code=removal.getBarCode();
		this.removal_date=removal.getOutDate();
		this.destination=removal.getDestination();
		this.transfer_number=removal.getTransferCode();
		this.type=removal.getTransferWay();
	}

	/*====================================================================================
	 * Public方法
	 * */
	
	/*------------------------------------------------------------------------------------
	 * 对RemovalPO的数据进行读取
	 * */
	
	/**
	 * 获取订单条形码
	 * 
	 * @return 订单条形码String
	 * */
	public String getBarCode() {
		return bar_code;
	}
	
	/**
	 * 获取出库日期
	 * 
	 * @return 出库日期Date
	 * */
	public Date getRemovalDate() {
		return removal_date;
	}
	
	/**
	 * 获取目的地
	 * 
	 * @return 目的地String
	 * */
	public String getDestination() {
		return destination;
	}
	
	/**
	 * 获取装运形式
	 * 
	 * @return 装运形式TranferType
	 * */
	public TransferType getType() {
		return type;
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
	 * 获取审批状态
	 * 
	 * @return 审批状态
	 * */
	public boolean isApproved() {
		return isApproved;
	}
	
	
	/*---------------------------------------------------------------
	 * 对RemovalPO的某些信息进行更新
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
		result = result + "'" + sdf.format(removal_date) + "', ";
		result = result + "'" + destination + "', ";
		result = result + "'" + StateSwitch.switchToStr(type) + "', ";
		result = result + "'" + transfer_number + "', ";
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
