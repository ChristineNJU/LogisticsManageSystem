package businesslogic.VO;

import java.util.ArrayList;

public class LogisticsHistoryVO extends VO {

	private String barCode = null;	
	private ArrayList<String> history = new ArrayList<String>();
	
	public LogisticsHistoryVO(String barCode,ArrayList<String> history){
		this.barCode = barCode;
		this.history = history;
	}
	
	public String getBarCode(){
		return this.barCode;
	}
	
	public ArrayList<String> getHistory(){
		return this.history;
	}
}
