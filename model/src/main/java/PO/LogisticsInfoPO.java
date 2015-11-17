package PO;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.State.LogisticsState;
import businesslogic.State.LogisticsType;
import businesslogic.State.PackingCharge;

/*=================================================================================
 * 用来保存快递信息的持久化数据格式
 * */

public class LogisticsInfoPO extends PO {
	/*
	 * 寄件人信息
	 * */
	private String sender_name = null;
	private String sender_address = null;
	private String sender_organization = null;
	private String sender_telephone = null;
	private String sender_mobilephone = null;
	/*
	 * 收件人信息
	 * */
	private String recipient_name = null;
	private String recipient_address = null;
	private String recipient_organization = null;
	private String recipient_telephone = null;
	private String recipient_mobilephone = null;
	private String actual_recipient_name = null;			//实际收件人
	/*
	 * 快递信息
	 * */
	private String bar_code = null;							//订单条形码
	private int original_number = 1;						//原件数
	private double weight = 0;								//实际重量
	private double size = 0;								//体积
	private String internal_name = null;					//内件品名
	private LogisticsType type = LogisticsType.STANDARD;	//快递类型
	private PackingCharge pack = PackingCharge.COURISE_BAG;	//包装费
	private double total_cost = 0;							//费用合计
	private String starting = null;							//出发地
	private String destination = null;						//到达地
	private boolean isApproved = false;						//审批状态
	private LogisticsState state = LogisticsState.INTACT;	//快递状态
	private boolean isReceived = false;						//收件状态
	private Date send_date = null;							//发件日期
	private Date receive_date = null;						//收件日期
	private String courier = null;							//快递员
	/*
	 * 历史轨迹
	 * */
	private ArrayList<String> history = new ArrayList<String>();
	
	public LogisticsInfoPO(String sender_name, String sender_address, String sender_organization,
							String sender_telephone, String sender_mobilephone,
						  String recipient_name, String recipient_address, String recipient_organization,
						  	String recipient_telephone, String recipient_mobilephone,
						  String bar_code, int original_number, double weight, double size, String internal_name,
						  LogisticsType type, PackingCharge pack, double total_cost, String starting, String destination,
						  Date send_date, Date receive_date, String courier,
						  String DB_URL) {
		// TODO Auto-generated constructor stub
		super(DB_URL);
		this.sender_name = sender_name;
		this.sender_address = sender_address;
		this.sender_organization = sender_organization;
		this.sender_telephone = sender_telephone;
		this.sender_mobilephone = sender_mobilephone;
		
		this.recipient_name = recipient_name;
		this.recipient_address = recipient_address;
		this.recipient_organization = recipient_address;
		this.recipient_telephone = recipient_telephone;
		this.recipient_mobilephone = recipient_mobilephone;
		
		this.bar_code = bar_code;
		this.original_number = original_number;
		this.weight = weight;
		this.size = size;
		this.internal_name = internal_name;
		this.type = type;
		this.pack = pack;
		this.total_cost = total_cost;
		this.starting = starting;
		this.destination = destination;
		this.send_date = send_date;
		this.receive_date = receive_date;
		this.courier = courier;
	}
	
	/*==========================================================================
	 * Public方法
	 * */
	
	/*--------------------------------------------------------------------------
	 * 对LogisticsInfoPO的数据进行读取
	 * */
	
	/*
	 * 获取寄件人姓名
	 * 返回String
	 * */
	public String getSenderName() {
		return sender_name;
	}
	/*
	 * 获取寄件人地址
	 * 返回String
	 * */
	public String getSenderAddress() {
		return sender_address;
	}
	/*
	 * 获取寄件人单位
	 * 返回String
	 * */
	public String getSenderOrganization() {
		return sender_organization;
	}
	/*
	 * 获取寄件人电话
	 * 返回String
	 * */
	public String getSenderTelephone() {
		return sender_telephone;
	}
	/*
	 * 获取寄件人手机
	 * 返回String
	 * */
	public String getSenderMobilephone() {
		return sender_mobilephone;
	}
	
	/*
	 * 获取收件人姓名
	 * 返回String
	 * */
	public String getRecipientName() {
		return recipient_name;
	}
	/*
	 * 获取收件人地址
	 * 返回String
	 * */
	public String getRecipientAddress() {
		return recipient_address;
	}
	/*
	 * 获取收件人单位
	 * 返回String
	 * */
	public String getRecipientOrganization() {
		return recipient_organization;
	}
	/*
	 * 获取收件人电话
	 * 返回String
	 * */
	public String getRecipientTelephone() {
		return recipient_telephone;
	}
	/*
	 * 获取收件人手机
	 * 返回String
	 * */
	public String getRecipientMobilephone() {
		return recipient_mobilephone;
	}
	/*	
	 * 获取实际收件人姓名
	 * 返回String
	 * */
	public String getActualRecipientName() {
		return actual_recipient_name;
	}
	
	/*
	 * 获取条形码
	 * 返回String
	 * */
	public String getBarCode() {
		return bar_code;
	}
	/*
	 * 获取原件数
	 * 返回int
	 * */
	public int getOriginalNumber() {
		return original_number;
	}
	/*
	 * 获取实际重量
	 * 返回double
	 * */
	public double getWeight() {
		return weight;
	}
	/*
	 * 获取实际体积
	 * 返回double
	 * */
	public double getSize() {
		return size;
	}
	/*
	 * 获取内件品名
	 * 返回String
	 * */
	public String getInternalName() {
		return internal_name;
	}
	/*
	 * 获取快递类型
	 * 返回LogisticsType
	 * */
	public LogisticsType getType() {
		return type;
	}
	/*
	 * 获取包装费
	 * 返回PackingCharge
	 * */
	public PackingCharge getPack() {
		return pack;
	}
	/*
	 * 获取费用合计
	 * 返回double
	 * */
	public double getTotalCost() {
		return total_cost;
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
	 * 获取审批状态
	 * 返回boolean
	 * */
	public boolean isApproved() {
		return isApproved;
	}
	/*
	 * 获取快递状态
	 * 返回LogisticsState
	 * */
	public LogisticsState getState() {
		return state;
	}
	/*
	 * 获取收件状态
	 * 返回boolean
	 * */
	public boolean isReceived() {
		return isReceived;
	}
	/*
	 * 获取发件日期
	 * 返回Date
	 * */
	public Date getSendDate() {
		return send_date;
	}
	/*
	 * 获取收件日期
	 * 返回Date
	 * */
	public Date getReceiveDate() {
		return receive_date;
	}
	/*
	 * 获取收件员
	 * 返回String
	 * */
	public String getCourier() {
		return courier;
	}
	
	/*
	 * 获取历史轨迹
	 * 返回ArrayList<String>
	 * */
	public ArrayList<String> getHistory() {
		return history;
	}
	
	/*--------------------------------------------------------------------
	 * 对LogisticsInfoPO的某些数据进行更改 
	 * */
	
	/*
	 * 更新审批状态
	 * */
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	} 
	/*
	 * 更新收件状态
	 * */
	public void setReceived(boolean isReceived) {
		this.isReceived = isReceived;
	}
	/*
	 * 更新快递状态
	 * */
	public void setState(LogisticsState state) {
		this.state = state;
	}
	/*
	 * 更新收件日期
	 * */
	public void setReceiveDate(Date receive_date) {
		this.receive_date = receive_date;
	}
	/*
	 * 更新历史轨迹
	 * */
	public void addHistory(String node) {
		this.history.add(node);
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
