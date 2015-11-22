package data.Service.Sundry;

import java.rmi.Remote;

public interface WareHouseService extends Remote {
	
	public int getAmount(String DB_URL);
}
