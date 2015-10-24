package businesslogic.Service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InquiryBlService extends Remote{
	
	public VO getLogistics(String bar_code) throws RemoteException;
	

}
