package PO;

public class GatheringStoragePO extends PO {

	String bar_code = "";
	double amount = 0;
	
	public GatheringStoragePO(String bar_code, double amount, String DB_URL) {
		super(DB_URL);
		// TODO Auto-generated constructor stub
		this.bar_code = bar_code;
		this.amount = amount;
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
		
		System.out.println(result);
		
		return result;
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "bar_code = '"+bar_code+"'";
	}

}
