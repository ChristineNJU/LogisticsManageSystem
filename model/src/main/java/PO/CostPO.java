package PO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import businesslogic.URLHelper.URLHelper;
import State.CostType;
import State.StateSwitch;
import VO.CostVO;

/**
 * 用来保存出款单的持久化数据格式
 * 
 * @author 尹子越
 * @version 1.0.0
 * */
public class CostPO extends PO {
	
	// ----- member variables ---------------------------------------
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private Date cost_date;
	private double cost_amount = 0;
	private String cost_name = "";
	private String account_name = "";
	private CostType type;
	private	String remark = "";
	private boolean isApproved = false;
	
	/**
	 * 直接创建出款单的持久化数据对象
	 * */
	public CostPO(String cost_date, double cost_amount, String cost_name, String account_name, 
			CostType type, String remark, String DB_URL) {
		super(DB_URL);
		// TODO Auto-generated constructor stub
		try {
			this.cost_date = sdf.parse(cost_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.cost_amount = cost_amount;
		this.cost_name = cost_name;
		this.account_name = account_name;
		this.type = type;
		this.remark = remark;
	}
	
	/**
	 * 通过CostVO创建出款单的持久化数据格式
	 * */
	public CostPO(CostVO cvo){
		super(URLHelper.getCostURL());
		this.account_name=cvo.getPayerAccount();
		this.cost_amount=cvo.getAmount();
		this.cost_date=cvo.getDate();
		this.cost_name=cvo.getPayer();
		this.remark=cvo.getRemark();
		this.type=cvo.getType();
		this.isApproved=false;
	}
	/*====================================================================================
	 * Public方法
	 * */
	
	/*------------------------------------------------------------------------------------
	 * 对CostPO的数据进行读取
	 * */
	/**
	 * 获取付款日期
	 * 
	 * @return 付款日期String
	 * */
	public Date getCostDate() {
		return cost_date;
	}
	
	/**
	 * 获取付款金额
	 * 
	 * @return 付款金额
	 * */
	public double getCostAmount() {
		return cost_amount;
	}
	
	/**
	 * 获取付款人
	 * 
	 * @return 付款人String
	 * */
	public String getCostName() {
		return cost_name;
	}
	
	/**
	 * 获取付款账号
	 * 
	 * @return 付款账号String
	 * */
	public String getAccountName() {
		return account_name;
	}
	
	/**
	 * 获取条目
	 * 
	 * @return 条目CostType
	 * */
	public CostType getType() {
		return type;
	}
	
	/**
	 * 获取备注
	 * 
	 * @return 备注String
	 * */
	public String getRemark() {
		return remark;
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
	 * 对AccountPO的某些信息进行更新
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
		
		result = result + "'" + sdf.format(cost_date) + "', ";
		result = result + cost_amount + ",";
		result = result + "'" + cost_name + "', ";
		result = result + "'" + account_name + "', ";
		result = result + "'" + StateSwitch.switchToStr(type) + "', ";
		result = result + "'" + remark + "', ";
		result = result + "'" + isApproved + "'";
		
		System.out.println(result);
		return result;
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return "cost_date = '"+sdf.format(cost_date)+"'";
	}
	
}
