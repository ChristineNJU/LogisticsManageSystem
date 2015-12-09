package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.BenefitPO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SearchBenefitService.
 *
 * @author 尹子越
 * @version 1.0.0
 */
public interface SearchBenefitService extends Remote {
	
	/**
	 * 从数据库中搜索BenefitPO.
	 *
	 * @param requirement the requirement
	 * @return BenefitPO的ArrayList
	 * @exception RemoteException 如果RMI链接断开
	 */
	public ArrayList<BenefitPO> searchBenefit(ArrayList<String> requirement) throws RemoteException;
}
