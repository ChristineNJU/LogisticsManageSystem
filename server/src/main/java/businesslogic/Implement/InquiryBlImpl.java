package businesslogic.Implement;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import businesslogic.Service.InquiryBlService;
import businesslogic.Service.VO;

public class InquiryBlImpl extends UnicastRemoteObject implements InquiryBlService{
	
	public InquiryBlImpl() throws RemoteException{
		super();
	}

	@Override
	public VO getLogistics(String bar_code) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
