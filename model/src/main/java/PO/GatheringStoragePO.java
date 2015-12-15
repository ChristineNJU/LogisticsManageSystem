package PO;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GatheringStoragePO extends PO {
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	String bar_code = "";
	double amount = 0;
	String courier = "";
	Date date = null;
	
	public GatheringStoragePO(String bar_code, double amount, String courier, Date date, String DB_URL) {
		super(DB_URL);
		// TODO Auto-generated constructor stub
		this.bar_code = bar_code;
		this.amount = amount;
		this.courier = courier;
		this.date = date;
	}

	public String getCourier() {
		return courier;
	}

	public void setCourier(String courier) {
		this.courier = courier;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getBar_code() {
		return bar_code;
	}

	public void setBar_code(String bar_code) {
		this.bar_code = bar_code;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		String result = "";
		
		result = result+"'"+bar_code+"', ";
		result = result+""+amount+"";
		result = result+"'"+courier+"', ";
		result = result+"'"+sdf.format(date)+"'";
		
		System.out.println(result);
		
		return result;
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "bar_code = '"+bar_code+"'";
	}

}
