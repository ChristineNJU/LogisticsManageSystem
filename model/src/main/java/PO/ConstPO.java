package PO;

import businesslogic.URLHelper.URLHelper;
import VO.ConstVO;

/**
 * 用来保存常量的持久化数据格式
 * 
 * @author HermC
 * @version 1.0.0
 * */
public class ConstPO extends PO {

	// ----- member variables ---------------------------------------
	private String name = "";
	private double value = 0;
	
	/**
	 * 直接创建常量的持久化数据格式
	 * */
	public ConstPO(String name, double value, String DB_URL) {
		super(DB_URL);
		// TODO Auto-generated constructor stub
		this.name = name;
		this.value = value;
	}
	
	/**
	 * 通过VO创建常量的持久化数据格式
	 * */
	public ConstPO(ConstVO constant){
		super(URLHelper.getConstURL());
		
		this.name=constant.getName();
		this.value=constant.getValue();
	}
	/*===============================================================
	 * Public方法
	 * */
	
	/*---------------------------------------------------------------
	 * 对ConstPO的数据进行读取
	 * */
	/**
	 * 获取常量名
	 * 
	 * @return 常量名String
	 * */
	public String getName() {
		return name;
	}
	
	/**
	 * 获取常量值
	 * 
	 * @return 常量值
	 * */
	public double getValue() {
		return value;
	}
	
	
	/*---------------------------------------------------------------
	 * 对ConstPO的数据进行更新
	 * */
	/**
	 * 更新常量值
	 * 
	 * @param value 新常量值
	 * */
	public void setValue(double value) {
		this.value = value;
	}
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		String result = "";
		
		result = result + "'" + name + "', ";
		result = result + value + "";
		
		System.out.println(result);
		return result;
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "name = '"+name+"'";
	}
	
}
