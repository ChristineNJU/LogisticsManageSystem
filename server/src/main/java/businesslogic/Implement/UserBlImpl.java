package businesslogic.Implement;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import businesslogic.Service.UserBlService;
import businesslogic.State.LoginState;
import businesslogic.State.ResetState;

public class UserBlImpl extends UnicastRemoteObject implements UserBlService{
	
	public UserBlImpl() throws RemoteException{
		super();
	}

	@Override
	public LoginState login(String userName, String password)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResetState reset(String userName, String password)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
