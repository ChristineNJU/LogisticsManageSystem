package PO;

import java.text.SimpleDateFormat;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class GatheringStoragePO.
 * 
 * @author 尹子越
 * @version 1.0.0
 */
public class GatheringStoragePO extends PO {
	
	/** The sdf. */
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/** The bar_code. */
	String bar_code = "";
	
	/** The amount. */
	double amount = 0;
	
	/** The courier. */
	String courier = "";
	
	/** The date. */
	Date date = null;
	
	/**
	 * Instantiates a new gathering storage po.
	 *
	 * @param bar_code the bar_code
	 * @param amount the amount
	 * @param courier the courier
	 * @param date the date
	 * @param DB_URL the db url
	 */
	public GatheringStoragePO(String bar_code, double amount, String courier, Date date, String DB_URL) {
		super(DB_URL);
		// TODO Auto-generated constructor stub
		this.bar_code = bar_code;
		this.amount = amount;
		this.courier = courier;
		this.date = date;
	}

	/**
	 * Gets the courier.
	 *
	 * @return the courier
	 */
	public String getCourier() {
		return courier;
	}

	/**
	 * Sets the courier.
	 *
	 * @param courier the new courier
	 */
	public void setCourier(String courier) {
		this.courier = courier;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(Date date) {
		this.date = date;
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
	 * Sets the bar_code.
	 *
	 * @param bar_code the new bar_code
	 */
	public void setBar_code(String bar_code) {
		this.bar_code = bar_code;
	}

	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount the new amount
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/* (non-Javadoc)
	 * @see PO.PO#toString()
	 */
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

	/* (non-Javadoc)
	 * @see PO.PO#getPrimaryKey()
	 */
	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "bar_code = '"+bar_code+"'";
	}

}
