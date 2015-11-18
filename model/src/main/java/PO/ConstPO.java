package PO;

public class ConstPO extends PO {

	private String name = null;
	private double value = 0;
	
	
	public ConstPO(String name, double value, String DB_URL) {
		super(DB_URL);
		// TODO Auto-generated constructor stub
		this.name = name;
		this.value = value;
	}
	
	/*===============================================================
	 * Public方法
	 * */
	
	/*---------------------------------------------------------------
	 * 对ConstPO的数据进行读取
	 * */
	/*
	 * 获取常量名
	 * 返回String
	 * */
	public String getName() {
		return name;
	}
	/*
	 * 获取常量值
	 * 返回double
	 * */
	public double getValue() {
		return value;
	}
	
	
	/*---------------------------------------------------------------
	 * 对ConstPO的数据进行更新
	 * */
	/*
	 * 更新常量值
	 * */
	public void setValue(double value) {
		this.value = value;
	}
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
