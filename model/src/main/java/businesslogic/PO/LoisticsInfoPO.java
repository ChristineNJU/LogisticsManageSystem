package businesslogic.PO;

import java.util.ArrayList;

import businesslogic.State.LogisticsState;
import businesslogic.State.LogisticsType;
import businesslogic.State.PackingCharge;

public class LoisticsInfoPO extends PO {
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
	private String actual_recipient_name = null;
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
	private String send_date = null;						//发件日期
	private String receive_date = null;						//收件日期
	private String courier = null;							//快递员
	/*
	 * 历史轨迹
	 * */
	private ArrayList<String> history = new ArrayList<String>();
	
	public LoisticsInfoPO(String sender_name, String sender_address, String sender_organization,
							String sender_telephone, String sender_mobilephone,
						  String recipient_name, String recipient_address, String recipient_organization,
						  	String recipient_telephone, String recipient_mobilephone,
						  String bar_code, int original_number, double weight, double size, String internal_name,
						  LogisticsType type, PackingCharge pack, double total_cost, String starting, String destination,
						  String courier) {
		// TODO Auto-generated constructor stub
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
