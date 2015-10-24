package businesslogic.Service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import businesslogic.State.LoginState;
import businesslogic.State.ResetState;

public interface UserBlService extends Remote{
	
	public LoginState login(String userName, String password) throws RemoteException;
	
	public ResetState reset(String userName, String password) throws RemoteException;

}
