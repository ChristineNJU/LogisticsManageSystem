package VO;

import java.util.ArrayList;

import PO.LogisticsInfoPO;

// TODO: Auto-generated Javadoc
/**
 * The Class LogisticsHistoryVO.
 */
public class LogisticsHistoryVO extends VO {

	/** The bar code. */
	private String barCode = null;	
	
	/** The history. */
	private ArrayList<String> history = new ArrayList<String>();
	
	/**
	 * Instantiates a new logistics history vo.
	 *
	 * @param barCode the bar code
	 * @param history the history
	 */
	public LogisticsHistoryVO(String barCode,ArrayList<String> history){
		this.barCode = barCode;
		this.history = history;
	}	
	
	/**
	 * Instantiates a new logistics history vo.
	 *
	 * @param po the po
	 */
	public LogisticsHistoryVO(LogisticsInfoPO po) {
		this.barCode = po.getBarCode();
		this.history = po.getHistory();
	}
	
	/**
	 * Gets the bar code.
	 *
	 * @return the bar code
	 */
	public String getBarCode(){
		return this.barCode;
	}
	
	/**
	 * Gets the history.
	 *
	 * @return the history
	 */
	public ArrayList<String> getHistory(){
		return this.history;
	}
	
	/**
	 * Adds the history.
	 *
	 * @param s the s
	 */
	public  void addHistory(String s){
		this.history.add(s);
	}
}
