package businesslogic.PO;

import java.util.ArrayList;

/*======================================================================
 * 用来保存中转单的持久化数据格式
 * */

public class TransferPO extends PO {
	
	private String date = null;
	private String transfer_number = null;
	private String transport_id = null;
	private String starting = null;
	private String destination = null;
	private String container_number = null;
	private String guard_name = null;
	private ArrayList<String> bar_code_list = new ArrayList<String>();
	private double cost = 0;
	private 
	
	public TransferPO(String DB_URL) {
		super(DB_URL);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
