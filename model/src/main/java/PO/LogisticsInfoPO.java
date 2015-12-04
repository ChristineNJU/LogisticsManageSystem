package PO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.URLHelper.URLHelper;
import State.LogisticsState;
import State.LogisticsType;
import State.PackingCharge;
import State.StateSwitch;
import VO.LogisticsInputVO;

/**
 * 用来保存快递信息的持久化数据格式
 * 
 * @author HermC
 * @version 1.0.0
 * */
public class LogisticsInfoPO extends PO {
	
	// ----- member variables ---------------------------------------
	/*
	 * 寄件人信息
	 * */
	private String sender_name = "";
	private String sender_address = "";
	private String sender_organization = "";
	private String sender_telephone = "";
	private String sender_mobilephone = "";
	/*
	 * 收件人信息
	 * */
	private String recipient_name = "";
	private String recipient_address = "";
	private String recipient_organization = "";
	private String recipient_telephone = "";
	private String recipient_mobilephone = "";
	private String actual_recipient_name = "";			//实际收件人
	/*
	 * 快递信息
	 * */
	private String bar_code = "";							//订单条形码
	private int original_number = 1;						//原件数
	private double weight = 0;								//实际重量
	private double size = 0;								//体积
	private String internal_name ="";					//内件品名
	private LogisticsType type = LogisticsType.STANDARD;	//快递类型
	private PackingCharge pack = PackingCharge.COURISE_BAG;	//包装费
	private double total_cost = 0;							//费用合计
	private String starting = "";							//出发地
	private String destination = "";						//到达地
	private boolean isApproved = false;						//审批状态
	private LogisticsState state = LogisticsState.INTACT;	//快递状态
	private boolean isReceived = false;						//收件状态
	private Date send_date = new Date();							//发件日期
	private Date receive_date = new Date();						//收件日期
	private String courier = "";							//快递员
	/*
	 * 历史轨迹
	 * */
	private ArrayList<String> history = new ArrayList<String>();
	
	/**
	 * 直接创建快递的持久化数据对象
	 * */
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
	
	/**
	 * 通过LogisticsInputVO创建快递的持久化数据对象
	 * */
	public LogisticsInfoPO(LogisticsInputVO logisticsInfo){
		
		super(URLHelper.getLogisticsURL());
		this.sender_name=logisticsInfo.getSender_name();
		this.sender_address=logisticsInfo.getSender_address();
		this.sender_organization=logisticsInfo.getSender_organization();
		this.sender_telephone=logisticsInfo.getSender_telephone();
		this.sender_mobilephone=logisticsInfo.getSender_mobilephone();
		
		this.recipient_name=logisticsInfo.getRecipient_name();
		this.recipient_address=logisticsInfo.getRecipient_address();
		this.recipient_organization=logisticsInfo.getRecipient_organization();
		this.recipient_telephone=logisticsInfo.getRecipient_telephone();
		this.recipient_mobilephone=logisticsInfo.getRecipient_mobilephone();
		
		this.bar_code=logisticsInfo.getBar_code();
		this.original_number=logisticsInfo.getOriginal_number();
		this.weight=logisticsInfo.getWeight();
		this.size=logisticsInfo.getSize();
		this.internal_name=logisticsInfo.getInternal_name();
		this.type=logisticsInfo.getType();
		this.pack=logisticsInfo.getPack();
		this.total_cost=logisticsInfo.getTotal_cost();
		this.starting=logisticsInfo.getStarting();
		this.destination=logisticsInfo.getDestination();
		this.send_date=logisticsInfo.getSend_date();
		this.receive_date=logisticsInfo.getReceive_date();
		this.courier=logisticsInfo.getCourier();
	}
	
	/*==========================================================================
	 * Public方法
	 * */
	
	/*--------------------------------------------------------------------------
	 * 对LogisticsInfoPO的数据进行读取
	 * */
	
	/**
	 * 获取寄件人姓名
	 * 
	 * @return 寄件人姓名String
	 * */
	public String getSenderName() {
		return sender_name;
	}
	
	/**
	 * 获取寄件人地址
	 * 
	 * @return 寄件人地址String
	 * */
	public String getSenderAddress() {
		return sender_address;
	}
	
	/**
	 * 获取寄件人单位
	 * 
	 * @return 寄件人单位String
	 * */
	public String getSenderOrganization() {
		return sender_organization;
	}
	
	/**
	 * 获取寄件人电话
	 * 
	 * @return 寄件人电话String
	 * */
	public String getSenderTelephone() {
		return sender_telephone;
	}
	
	/**
	 * 获取寄件人手机
	 * 
	 * @return 寄件人手机String
	 * */
	public String getSenderMobilephone() {
		return sender_mobilephone;
	}
	
	/**
	 * 获取收件人姓名
	 * 
	 * @return 收件人姓名String
	 * */
	public String getRecipientName() {
		return recipient_name;
	}
	
	/**
	 * 获取收件人地址
	 * 
	 * @return 收件人地址String
	 * */
	public String getRecipientAddress() {
		return recipient_address;
	}
	
	/**
	 * 获取收件人单位
	 * 
	 * @return 收件人单位String
	 * */
	public String getRecipientOrganization() {
		return recipient_organization;
	}
	
	/**
	 * 获取收件人电话
	 * 
	 * @return 收件人电话String
	 * */
	public String getRecipientTelephone() {
		return recipient_telephone;
	}
	
	/**
	 * 获取收件人手机
	 * 
	 * @return 收件人手机String
	 * */
	public String getRecipientMobilephone() {
		return recipient_mobilephone;
	}
	
	/**	
	 * 获取实际收件人姓名
	 * 
	 * @return 实际收件人姓名String
	 * */
	public String getActualRecipientName() {
		return actual_recipient_name;
	}
	
	/**
	 * 获取条形码
	 * 
	 * @return 条形码String
	 * */
	public String getBarCode() {
		return bar_code;
	}
	
	/**
	 * 获取原件数
	 * 
	 * @return 原件数
	 * */
	public int getOriginalNumber() {
		return original_number;
	}
	
	/**
	 * 获取实际重量
	 * 
	 * @return 实际重量
	 * */
	public double getWeight() {
		return weight;
	}
	
	/**
	 * 获取实际体积
	 * 
	 * @return 实际体积
	 * */
	public double getSize() {
		return size;
	}
	
	/**
	 * 获取内件品名
	 * 
	 * @return 内件品名String
	 * */
	public String getInternalName() {
		return internal_name;
	}
	
	/**
	 * 获取快递类型
	 * 
	 * @return 快递类型LogisticsType
	 * */
	public LogisticsType getType() {
		return type;
	}
	
	/**
	 * 获取包装费
	 * 
	 * @return 包装费PackingCharge
	 * */
	public PackingCharge getPack() {
		return pack;
	}
	
	/**
	 * 获取费用合计
	 * 
	 * @return 费用合计
	 * */
	public double getTotalCost() {
		return total_cost;
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
	 * 获取到达地
	 * 
	 * @return 到达地String
	 * */
	public String getDestination() {
		return destination;
	}
	
	/**
	 * 获取审批状态
	 * 
	 * @return 审批状态
	 * */
	public boolean isApproved() {
		return isApproved;
	}
	
	/**
	 * 获取快递状态
	 * 
	 * @return 快递状态LogisticsState
	 * */
	public LogisticsState getState() {
		return state;
	}
	
	/**
	 * 获取收件状态
	 * 
	 * @return 收件状态boolean
	 * */
	public boolean isReceived() {
		return isReceived;
	}
	
	/**
	 * 获取发件日期
	 * 
	 * @return 发件日期Date
	 * */
	public Date getSendDate() {
		return send_date;
	}
	
	/**
	 * 获取收件日期
	 * 
	 * @return 收件日期Date
	 * */
	public Date getReceiveDate() {
		return receive_date;
	}
	
	/**
	 * 获取收件员
	 * 
	 * @return 收件员String
	 * */
	public String getCourier() {
		return courier;
	}
	
	/**
	 * 获取历史轨迹
	 * 
	 * @return 历史轨迹ArrayList<String>
	 * */
	public ArrayList<String> getHistory() {
		return history;
	}
	
	/*--------------------------------------------------------------------
	 * 对LogisticsInfoPO的某些数据进行更改 
	 * */
	
	/**
	 * 更新审批状态
	 * 
	 * @param isApproved 新审批状态
	 * */
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	} 
	
	/**
	 * 更新收件状态
	 * 
	 * @param isReceived 新收件状态
	 * */
	public void setReceived(boolean isReceived) {
		this.isReceived = isReceived;
	}
	
	/**
	 * 更新快递状态
	 * 
	 * @param state 新快递状态
	 * */
	public void setState(LogisticsState state) {
		this.state = state;
	}
	
	/**
	 * 更新收件日期
	 * 
	 * @param receive_date 新收件日期
	 * */
	public void setReceiveDate(Date receive_date) {
		this.receive_date = receive_date;
	}
	
	/**
	 * 更新实际收件人
	 * 
	 * @param name 实际收件人
	 * */
	public void setActualRecipientName(String name) {
		this.actual_recipient_name = name;
	}
	
	/**
	 * 更新历史轨迹
	 * 
	 * @param node 新历史轨迹
	 * */
	public void addHistory(String node) {
		this.history.add(node);
	}

	/*------------------------------------------------------------------
	 * 对数据的格式化
	 * */
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		String result = "";
		
		result = result + "'" + bar_code + "', ";
		result = result + "'" + sender_name + "', ";
		result = result + "'" + sender_address + "', ";
		result = result + "'" + sender_organization + "', ";
		result = result + "'" + sender_telephone + "', ";
		result = result + "'" + sender_mobilephone + "', ";
		result = result + "'" + recipient_name + "', ";
		result = result + "'" + recipient_address + "', ";
		result = result + "'" + recipient_organization + "', ";
		result = result + "'" + recipient_telephone + "', ";
		result = result + "'" + recipient_mobilephone + "', ";
		result = result + "'" + actual_recipient_name + "', ";
		result = result + original_number + ", ";
		result = result + weight + ", ";
		result = result + size + ", ";
		result = result + "'" + internal_name + "', ";
		result = result + "'" + StateSwitch.switchToStr(type) + "', ";
		result = result + "'" + StateSwitch.switchToStr(pack) + "', ";
		result = result + total_cost + ", ";
		result = result + "'" + starting + "', ";
		result = result + "'" + destination + "', ";
		result = result + "'" + StateSwitch.switchToStr(state) + "', ";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		result = result + "'" + sdf.format(send_date) + "', ";
		result = result + "'" + sdf.format(receive_date) + "', ";
		result = result + "'" + courier + "', ";
		result = result + "'" + isApproved + "', ";
		result = result + "'" + isReceived + "', ";
		
		result = result + "'";
		for(int i=0;i<history.size();i++){
			if(i!=history.size()-1){
				result = result + history.get(i) + ">>";				
			}else{
				result = result + history.get(i);
			}
		}
		result = result + "'";
		
		System.out.println(result);
 		return result;
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "bar_code = '"+bar_code+"'";
	}
	
}
