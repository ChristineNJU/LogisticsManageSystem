package businesslogic.PO;

import java.io.Serializable;

public abstract class PO implements Serializable {

	protected String DB_LA;
	
	public abstract String toString();
	
	public void setLA(String LA) {
		this.DB_LA = LA;
	}
	public String getLA() {
		return DB_LA;
	}
}