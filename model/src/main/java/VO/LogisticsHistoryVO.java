package VO;

import java.util.ArrayList;

import PO.LogisticsInfoPO;

public class LogisticsHistoryVO extends VO {

	private String barCode = null;	
	private ArrayList<String> history = new ArrayList<String>();
	
	public LogisticsHistoryVO(String barCode,ArrayList<String> history){
		this.barCode = barCode;
		this.history = history;
	}	
	public LogisticsHistoryVO(LogisticsInfoPO po) {
		this.barCode = po.getBarCode();
		this.history = po.getHistory();
	}
	
	public String getBarCode(){
		return this.barCode;
	}
	
	public ArrayList<String> getHistory(){
		return this.history;
	}
	public  void addHistory(String s){
		this.history.add(s);
	}
}
