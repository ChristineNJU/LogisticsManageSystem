package businesslogic.PO;

import java.io.Serializable;

public abstract class PO implements Serializable {

	protected String DB_URL;
	
	public PO(String DB_URL) {
		this.DB_URL = DB_URL;
	}
	
	public abstract String toString();
	
	public void setURL(String URL) {
		this.DB_URL = URL;
	}
	public String getURL() {
		return DB_URL;
	}
}