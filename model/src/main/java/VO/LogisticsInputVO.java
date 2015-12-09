package VO;

import java.util.Date;

import PO.LogisticsInfoPO;
import State.LogisticsState;
import State.LogisticsType;
import State.PackingCharge;

// TODO: Auto-generated Javadoc
/**
 * The Class LogisticsInputVO.
 */
public class LogisticsInputVO extends VO {
	
	/** The sender_name. */
	/*
	 * 寄件人信息
	 * */
	private String sender_name = null;
	
	/** The sender_address. */
	private String sender_address = null;
	
	/** The sender_organization. */
	private String sender_organization = null;
	
	/** The sender_telephone. */
	private String sender_telephone = null;
	
	/** The sender_mobilephone. */
	private String sender_mobilephone = null;
	
	/** The recipient_name. */
	/*
	 * 收件人信息
	 * */
	private String recipient_name = null;
	
	/** The recipient_address. */
	private String recipient_address = null;
	
	/** The recipient_organization. */
	private String recipient_organization = null;
	
	/** The recipient_telephone. */
	private String recipient_telephone = null;
	
	/** The recipient_mobilephone. */
	private String recipient_mobilephone = null;
	
	/** The actual_recipient_name. */
	private String actual_recipient_name = null;			//实际收件人
	
	/** The bar_code. */
	/*
	 * 快递信息
	 * */
	private String bar_code = null;							//订单条形码
	
	/** The original_number. */
	private int original_number = 1;						//原件数
	
	/** The weight. */
	private double weight = 0;								//实际重量
	
	/** The size. */
	private double size = 0;								//体积
	
	/** The internal_name. */
	private String internal_name = null;					//内件品名
	
	/** The type. */
	private LogisticsType type = LogisticsType.STANDARD;	//快递类型
	
	/** The pack. */
	private PackingCharge pack = PackingCharge.COURISE_BAG;	//包装费
	
	/** The total_cost. */
	private double total_cost = 0;							//费用合计
	
	/** The starting. */
	private String starting = null;							//出发地
	
	/** The destination. */
	private String destination = null;						//到达地
	
	/** The is approved. */
	private boolean isApproved = false;						//审批状态
	
	/** The state. */
	private LogisticsState state = LogisticsState.INTACT;	//快递状态
	
	/** The is received. */
	private boolean isReceived = false;						//收件状态
	
	/** The send_date. */
	private Date send_date = null;							//发件日期
	
	/** The receive_date. */
	private Date receive_date = null;						//收件日期
	
	/** The courier. */
	private String courier = null;			
	
	/**
	 * Instantiates a new logistics input vo.
	 *
	 * @param sender_name the sender_name
	 * @param sender_address the sender_address
	 * @param sender_organization the sender_organization
	 * @param sender_telephone the sender_telephone
	 * @param sender_mobilephone the sender_mobilephone
	 * @param recipient_name the recipient_name
	 * @param recipient_address the recipient_address
	 * @param recipient_organization the recipient_organization
	 * @param recipient_telephone the recipient_telephone
	 * @param recipient_mobilephone the recipient_mobilephone
	 * @param bar_code the bar_code
	 * @param original_number the original_number
	 * @param weight the weight
	 * @param size the size
	 * @param internal_name the internal_name
	 * @param type the type
	 * @param pack the pack
	 * @param total_cost the total_cost
	 * @param starting the starting
	 * @param destination the destination
	 * @param send_date the send_date
	 * @param receive_date the receive_date
	 * @param courier the courier
	 */
	public LogisticsInputVO(String sender_name, String sender_address, String sender_organization,
			String sender_telephone, String sender_mobilephone,
		  String recipient_name, String recipient_address, String recipient_organization,
		  	String recipient_telephone, String recipient_mobilephone,
		  String bar_code, int original_number, double weight, double size, String internal_name,
		  LogisticsType type, PackingCharge pack, double total_cost, String starting, String destination,
		  Date send_date, Date receive_date, String courier) {
		
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
	 * Instantiates a new logistics input vo.
	 *
	 * @param po the po
	 */
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
	
	/**
	 * Gets the sender_name.
	 *
	 * @return the sender_name
	 */
	public String getSender_name() {
		return sender_name;
	}

	/**
	 * Gets the sender_address.
	 *
	 * @return the sender_address
	 */
	public String getSender_address() {
		return sender_address;
	}

	/**
	 * Gets the sender_organization.
	 *
	 * @return the sender_organization
	 */
	public String getSender_organization() {
		return sender_organization;
	}

	/**
	 * Gets the sender_telephone.
	 *
	 * @return the sender_telephone
	 */
	public String getSender_telephone() {
		return sender_telephone;
	}

	/**
	 * Gets the sender_mobilephone.
	 *
	 * @return the sender_mobilephone
	 */
	public String getSender_mobilephone() {
		return sender_mobilephone;
	}

	/**
	 * Gets the recipient_name.
	 *
	 * @return the recipient_name
	 */
	public String getRecipient_name() {
		return recipient_name;
	}

	/**
	 * Gets the recipient_address.
	 *
	 * @return the recipient_address
	 */
	public String getRecipient_address() {
		return recipient_address;
	}

	/**
	 * Gets the recipient_organization.
	 *
	 * @return the recipient_organization
	 */
	public String getRecipient_organization() {
		return recipient_organization;
	}

	/**
	 * Gets the recipient_telephone.
	 *
	 * @return the recipient_telephone
	 */
	public String getRecipient_telephone() {
		return recipient_telephone;
	}

	/**
	 * Gets the recipient_mobilephone.
	 *
	 * @return the recipient_mobilephone
	 */
	public String getRecipient_mobilephone() {
		return recipient_mobilephone;
	}
	
	/**
	 * Gets the actual_recipient_name.
	 *
	 * @return the actual_recipient_name
	 */
	public String getActual_recipient_name() {
		return actual_recipient_name;
	}

	/**
	 * Sets the actual_recipient_name.
	 *
	 * @param actual_recipient_name the new actual_recipient_name
	 */
	public void setActual_recipient_name(String actual_recipient_name) {
		this.actual_recipient_name = actual_recipient_name;
	}

	/**
	 * Gets the bar_code.
	 *
	 * @return the bar_code
	 */
	public String getBar_code() {
		return bar_code;
	}

	/**
	 * Gets the original_number.
	 *
	 * @return the original_number
	 */
	public int getOriginal_number() {
		return original_number;
	}

	/**
	 * Gets the weight.
	 *
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public double getSize() {
		return size;
	}

	/**
	 * Gets the internal_name.
	 *
	 * @return the internal_name
	 */
	public String getInternal_name() {
		return internal_name;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public LogisticsType getType() {
		return type;
	}

	/**
	 * Gets the pack.
	 *
	 * @return the pack
	 */
	public PackingCharge getPack() {
		return pack;
	}

	/**
	 * Gets the total_cost.
	 *
	 * @return the total_cost
	 */
	public double getTotal_cost() {
		return total_cost;
	}

	/**
	 * Gets the starting.
	 *
	 * @return the starting
	 */
	public String getStarting() {
		return starting;
	}

	/**
	 * Gets the destination.
	 *
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * Checks if is approved.
	 *
	 * @return true, if is approved
	 */
	public boolean isApproved() {
		return isApproved;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public LogisticsState getState() {
		return state;
	}

	/**
	 * Checks if is received.
	 *
	 * @return true, if is received
	 */
	public boolean isReceived() {
		return isReceived;
	}

	/**
	 * Gets the send_date.
	 *
	 * @return the send_date
	 */
	public Date getSend_date() {
		return send_date;
	}

	/**
	 * Gets the receive_date.
	 *
	 * @return the receive_date
	 */
	public Date getReceive_date() {
		return receive_date;
	}

	/**
	 * Gets the courier.
	 *
	 * @return the courier
	 */
	public String getCourier() {
		return courier;
	}
	
}
