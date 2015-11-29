package PO;

import java.io.Serializable;

/**
 * 数据持久化信息的抽象父类
 * 
 * @author 尹子越
 * @version 1.0.0
 * */
public abstract class PO implements Serializable {

	// ----- member variables ---------------------------------------
	protected String DB_URL;
	
	public PO(String DB_URL) {
		this.DB_URL = DB_URL;
	}
	
	/**
	 * 持久化信息转换为数据库条目
	 * 
	 * @return 数据条目String
	 * */
	public abstract String toString();
	
	/**
	 * 获取持久化信息主键
	 * 
	 * @return 主键String
	 * */
	public abstract String getPrimaryKey();
	
	/**
	 * 更新数据库链接
	 * 
	 * @param URL 新数据库条目
	 * */
	public void setURL(String URL) {
		this.DB_URL = URL;
	}
	
	/**
	 * 获取数据库链接
	 * 
	 * @return 数据库链接String
	 * */
	public String getURL() {
		return DB_URL;
	}
}