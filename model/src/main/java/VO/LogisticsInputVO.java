package VO;

import java.util.Date;

import PO.LogisticsInfoPO;
import businesslogic.State.LogisticsState;
import businesslogic.State.LogisticsType;
import businesslogic.State.PackingCharge;

public class LogisticsInputVO extends VO {
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
	private String courier = null;			
	
	public LogisticsInputVO(String sender_name, String sender_address, String sender_organization,
			String sender_telephone, String sender_mobilephone,
		  String recipient_name, String recipient_address, String recipient_organization,
		  	String recipient_telephone, String recipient_mobilephone,
		  String bar_code, int original_number, double weight, double size, String internal_name,
		  LogisticsType type, PackingCharge pack, double total_cost, String starting, String destination,
		  Date send_date, Date receive_date, String courier,
		  String DB_URL) {
		
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
	
	public LogisticsInputVO(LogisticsInfoPO po) {
		this.sender_name = po.getSenderName();
		this.sender_address = po.getSenderAddress();
		this.sender_organization = po.getSenderOrganization();
		this.sender_telephone = po.getSenderTelephone();
		this.sender_mobilephone = po.getSenderMobilephone();
		
		this.recipient_name = po.getRecipientName();
		this.recipient_address = po.getRecipientAddress();
		this.recipient_organization = po.getRecipientOrganization();
		this.recipient_telephone = po.getRecipientTelephone();
		this.recipient_mobilephone = po.getRecipientMobilephone();
		
		this.bar_code = po.getBarCode();
		this.original_number = po.getOriginalNumber();
		this.weight = po.getWeight();
		this.size = po.getSize();
		this.internal_name = po.getInternalName();
		this.type = po.getType();
		this.pack = po.getPack();
		this.total_cost = po.getTotalCost();
		this.starting = po.getStarting();
		this.destination = po.getDestination();
		this.send_date = po.getSendDate();
		this.courier = po.getCourier();
	}
	
	public String getSender_name() {
		return sender_name;
	}

	public String getSender_address() {
		return sender_address;
	}

	public String getSender_organization() {
		return sender_organization;
	}

	public String getSender_telephone() {
		return sender_telephone;
	}

	public String getSender_mobilephone() {
		return sender_mobilephone;
	}

	public String getRecipient_name() {
		return recipient_name;
	}

	public String getRecipient_address() {
		return recipient_address;
	}

	public String getRecipient_organization() {
		return recipient_organization;
	}

	public String getRecipient_telephone() {
		return recipient_telephone;
	}

	public String getRecipient_mobilephone() {
		return recipient_mobilephone;
	}

	public String getActual_recipient_name() {
		return actual_recipient_name;
	}

	public String getBar_code() {
		return bar_code;
	}

	public int getOriginal_number() {
		return original_number;
	}

	public double getWeight() {
		return weight;
	}

	public double getSize() {
		return size;
	}

	public String getInternal_name() {
		return internal_name;
	}

	public LogisticsType getType() {
		return type;
	}

	public PackingCharge getPack() {
		return pack;
	}

	public double getTotal_cost() {
		return total_cost;
	}

	public String getStarting() {
		return starting;
	}

	public String getDestination() {
		return destination;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public LogisticsState getState() {
		return state;
	}

	public boolean isReceived() {
		return isReceived;
	}

	public Date getSend_date() {
		return send_date;
	}

	public Date getReceive_date() {
		return receive_date;
	}

	public String getCourier() {
		return courier;
	}
	
}
